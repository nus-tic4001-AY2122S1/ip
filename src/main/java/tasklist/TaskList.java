package tasklist;

import exceptions.*;
import storage.Storage;
import ui.UI;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class TaskList {
    private ArrayList<Task> taskList;

    public TaskList(Storage s) throws IOException {
        taskList = new ArrayList<>(100);
        s.loadFile(this);
    }

    public TaskList() {
        taskList = new ArrayList<>(100);
    }

    public boolean add(Task t) {
        return taskList.add(t);
    }

    /**
     * Outputs all the tasks
     */
    public String list() {
        String message = "";
        try {
            checkListEmpty(taskList);
            message = UI.printOutput(taskList);
        } catch (ListEmptyException e) {
            message = UI.printListEmpty();
        }

        return message;
    }

    /****
     * Formats and save tasks to file
     *
     * @throws FileNotFoundException if file can't be found
     */
    public String save(Storage s) throws FileNotFoundException {
        String message = "";
        String list = "";
        try {
            checkListEmpty(taskList);
            for (int i = 0; i < taskList.size(); i++) {
                list += taskList.get(i).saveFormat() + "\n";
            }
            s.writeToFile(list);
            message = UI.printTaskSaved();
        }catch  (ListEmptyException e) {
            message = UI.printListEmpty();
        }

        return message;
    }

    /****
     * Marks multiple tasks as done
     *
     * @param line the command that user input
     */
    public String markedAsDone(String line) {
        String message = "";
        try {
            checkListEmpty(taskList);
            String theStrIndex = line.substring(5);
            String[] theStrIndexArr = theStrIndex.split(",");
            int[] intArr = new int[theStrIndexArr.length];
            for (int i = 0; i < theStrIndexArr.length; i++) {
                String num = theStrIndexArr[i];
                intArr[i] = Integer.parseInt(num);
                checkIndexOutOfRange(taskList.size(), intArr[i]);
            }

            message += UI.printMarkedAsDone();

            for (int i = 0; i < intArr.length; i++) {
                Task t = taskList.get(intArr[i] - 1);
                t.markAsDone();
                message += t.toString() + "\n";
            }

        } catch (NumberFormatException e) {
            message = UI.printNumberFormatException();
        }
        catch (IndexOutOfRangeException e) {
            message = UI.printIndexOutOfRangeException();
        }
        catch  (ListEmptyException e) {
            message = UI.printListEmpty();
        }
        return message;
    }

    /****
     * Deletes tasks
     *
     * @param line the command that user input
     */
    public String deleteTask(String line) {
        String message = "";
        try {
            checkListEmpty(taskList);
            String theStrIndex = line.substring(7);
            String[] theStrIndexArr = theStrIndex.split(",");
            int[] intArr = new int[theStrIndexArr.length];

            for (int i = 0; i < theStrIndexArr.length; i++) {
                String num = theStrIndexArr[i];
                intArr[i] = Integer.parseInt(num);
                checkIndexOutOfRange(taskList.size(), intArr[i]);
            }

            message += UI.printRemoveTask();

            for (int i = 0; i < intArr.length; i++) {
                Task t = taskList.get(intArr[i]-(i+1));
                message += t.toString() + "\n";
                taskList.remove(intArr[i]-(i+1));
            }

            message += UI.printNumberOfTasks(taskList);

        } catch (NumberFormatException e) {
            message = UI.printNumberFormatException();
        } catch (IndexOutOfRangeException e) {
            message = UI.printIndexOutOfRangeException();
        } catch  (ListEmptyException e) {
            message = UI.printListEmpty();
        }
        return message;
    }

    /****
     * Searches date by task type using "on", "from", "between to"
     *
     * @param line the command that user input
     * @throws ParseException if date format is not dd MMM yyyy
     */
    public String searchDate(String line) throws ParseException {
        ArrayList<Task> foundTasks = new ArrayList<>();
        String[] str;
        String message = "";
        try {
            checkListEmpty(taskList);
            checkInvalidWordSearch(line);
            //e.g find EVENT on 12 oct 2019
            if (line.contains("on")) {
                str = line.split(" on ", 2);
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy");
                //Format string "12 oct 2019" to date
                Date date = dateFormat.parse(str[1]);
                //Get task type e.g event
                String taskType = str[0].substring(5).toLowerCase();

                //Loop taskList to check conditions for findDate
                for (int i = 0; i < taskList.size(); i++) {
                    if (taskList.get(i).findDate(date, taskType)) {
                        foundTasks.add(taskList.get(i));
                    }
                }
            }

            //e.g find EVENT from 12 oct 2019
            if (line.contains("from")) {
                str = line.split(" from ", 2);
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy");
                //Format string "12 oct 2019" to date
                Date date = dateFormat.parse(str[1]);
                String taskType = str[0].substring(5).toLowerCase();

                //Loop taskList to check conditions for findFromDateRange
                for (int i = 0; i < taskList.size(); i++) {
                    if (taskList.get(i).findFromDateRange(date, taskType)) {
                        foundTasks.add(taskList.get(i));
                    }
                }
            }

            //e.g find EVENT between 12 oct 2019 to 16 oct 2019
            if (line.contains("between") && line.contains("to")) {
                str = line.split(" between ", 2);
                //From: dateRange[0], To: dateRange[1]
                String[] dateRange = str[1].split(" to ", 2);
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy");
                //Format string "12 oct 2019" to date
                Date date1 = dateFormat.parse(dateRange[0]);
                Date date2 = dateFormat.parse(dateRange[1]);
                String taskType = str[0].substring(5).toLowerCase();

                //Loop taskList to check conditions for findBetweenDateRange
                for (int i = 0; i < taskList.size(); i++) {
                    if (taskList.get(i).findBetweenDateRange(date1, date2, taskType)) {
                        foundTasks.add(taskList.get(i));
                    }
                }
            }

            //e.g find all EVENTS
            if (line.contains("all")) {
                str = line.split(" ", 3);
                //e.g "events"
                String type = str[2].toLowerCase();

                //Loop taskList to check conditions for taskType
                for (int i = 0; i < taskList.size(); i++) {
                    if (taskList.get(i).taskType(type)) {
                        foundTasks.add(taskList.get(i));
                    }
                }
            }
            message = UI.printOutput((foundTasks));
        } catch (StringFormatException e) {
            message= UI.printStringFormatException();
        } catch (ListEmptyException e) {
            message = UI.printListEmpty();
        }

        return message;
    }

    /****
     * Adds new event tasks
     *
     * @param line the command that user input
     */
    public String event(String line) {
        String message = "";
        try {
            checkEmptyEventDescription(line.trim());
            //e.g event dinner /at 12 oct 2019
            if (line.contains("/at")) {
                //str[1] to get date - 12 oct 2019
                String[] str = line.split(" /at ", 2);
                //description[1] to get description - dinner
                String[] taskDescription = str[0].split(" ", 2);
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy");
                //Format date 12 Oct 2019, to string "12 Oct 2019"
                Date date = dateFormat.parse(str[1]);
                String strDate = dateFormat.format(date);
                Task t = new Event(taskDescription[1], strDate);
                taskList.add(t);
            } else {
                //e.g event dinner
                String taskDescription = line.substring(6);
                Task t = new Event(taskDescription, "Date not specified");
                taskList.add(t);
            }
            message = UI.printTask(taskList);
        } catch (EmptyEventDescriptionException e) {
            message = UI.printEmptyEventDescriptionException();
        } catch (ParseException e) {
            message = UI.printParseException();
        }
        return message;
    }

    /****
     * Adds new deadline tasks
     *
     * @param line the command that user input
     */
    public String deadline(String line) {
        String message = "";
        try {
            checkEmptyDeadlineDescription(line.trim());
            if (line.contains("/by")) {
                //str[1] to get date - 12 oct 2019
                String[] str = line.split(" /by ", 2);
                //description[1] to get description - duke
                String[] taskDescription = str[0].split(" ", 2);
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy");
                //Format date 12 Oct 2019, to string "12 Oct 2019"
                Date date = dateFormat.parse(str[1]);
                String strDate = dateFormat.format(date);
                Task t = new Deadline(taskDescription[1], strDate);
                taskList.add(t);
            } else {
                //e.g deadline duke
                String taskDescription = line.substring(9);
                Task t = new Deadline(taskDescription, "Date not specified");
                taskList.add(t);
            }
            message = UI.printTask(taskList);
        } catch (EmptyDeadlineDescriptionException e) {
            message = UI.printEmptyDeadlineDescriptionException();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return message;
    }

    /****
     * Adds new tasks
     *
     * @param line the command that user input
     */
    public String todo(String line) {
        String message = "";
        try {
            checkEmptyToDoDescription(line.trim());
            String taskDescription = line.substring(5);
            Task t = new ToDo(taskDescription);
            taskList.add(t);
            message = UI.printTask(taskList);
        } catch (EmptyToDoDescriptionException e){
            message = UI.printEmptyToDoDescriptionException();
        }
        return message;
    }

    /****
     * Users input invalid command
     *
     * @param line the command that user input
     */
    public String processInvalidTask(String line) {
        String message = "";
        try {
            checkEmpty(line);
            checkInvalidWord(line);
        } catch (EmptyException e) {
            message = UI.printEmptyException();
        } catch (StringFormatException e){
            message = UI.printStringFormatException();
        }

        return message;
    }

    /****
     * Checks user input out of range
     *
     * @param size the size of the taskList
     * @param number the task number that the user input
     * @throws IndexOutOfRangeException if the number is greater than the size of the taskList
     */
    static void checkIndexOutOfRange(int size,  int number) throws IndexOutOfRangeException {
        if (number > size || number < 0) {
            throw new IndexOutOfRangeException();
        }
    }

    /****
     * Checks list is empty
     *
     * @param taskList taskList arr that stores all tasks
     * @throws ListEmptyException if list is empty
     */
    static void checkListEmpty( ArrayList<Task> taskList) throws ListEmptyException {
        if (taskList.isEmpty()) {
            throw new ListEmptyException ();
        }
    }

    /****
     *
     * @param description the command that user input
     * @throws StringFormatException if description does not hit the if conditions
     */
    static void checkInvalidWordSearch(String description) throws StringFormatException {
        if ( ! (description.contains("on") || description.contains("from") || description.contains("all") || (description.contains("between") && description.contains("to")) )) {
            throw new StringFormatException ();
        }
    }

    /****
     * Checks user input empty event task description
     *
     * @param description the command that user input
     * @throws EmptyEventDescriptionException if description does not hit the if condition
     */
    static void checkEmptyEventDescription (String description) throws EmptyEventDescriptionException {
        if (description.equals("event")) {
            throw new EmptyEventDescriptionException();
        }
    }

    /****
     * Checks user input empty deadline description
     *
     * @param description the command that user input
     * @throws EmptyDeadlineDescriptionException if description does not hit the if condition
     */
    static void checkEmptyDeadlineDescription (String description) throws EmptyDeadlineDescriptionException {
        if (description.equals("deadline")) {
            throw new EmptyDeadlineDescriptionException();
        }
    }

    /****
     * Checks user input empty task description
     *
     * @param description the command that user input
     * @throws EmptyToDoDescriptionException if description does not hit the if condition
     */
    static void checkEmptyToDoDescription (String description) throws EmptyToDoDescriptionException {
        if (description.equals("todo")) {
            throw new EmptyToDoDescriptionException();
        }
    }

    /****
     * Checks user input is empty
     *
     * @param description the command that user input
     * @throws EmptyException if user did not input anything
     */
    static void checkEmpty(String description) throws EmptyException {
        if (description.isEmpty()){
            throw new EmptyException ();
        }
    }

    /****
     * Checks user input invalid word
     *
     * @param description the command that user input
     * @throws StringFormatException if description does not hit the if conditions
     */
    static void checkInvalidWord(String description) throws StringFormatException {
        if ( !( description.equals("bye") || description.equals("list")
                || description.equals("todo") || description.equals("event")
                || description.equals("deadline"))) {
            throw new StringFormatException ();
        }
    }


}
