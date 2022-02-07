package ip.duke.parser;

import ip.duke.exceptions.DukeException;
import ip.duke.tasklist.TaskList;
import ip.duke.ui.Ui;

// THis utility class provides for parsing user inputs to the various wanted tasks.
public class Parser {
    /**
     * This is the method which processes tasks and generates related dialogues.
     *
     * @param command Text input by user.
     * @return A boolean value.
     * @throws DukeException On input error.
     * @see DukeException
     */
    public static boolean hasTask(String command) throws DukeException {
        // Exit the program
        if (command.equals("bye")) {
            Ui.bye();
            return true;
        } else {
            // Parses user inputs to run the selected tasks errands
            String[] words = null;
            // Check if multiple words exist in input before splitting into a string array
            if (command.indexOf(" ") > 0) {
                words = command.split(" ", 2);
                command = words[0];
            }

            switch (command) {
            case "list":
                Ui.echoList();
                break;
            case "find":
                try {
                    Ui.echoFind(words[1].trim());
                } catch (NullPointerException | ArrayIndexOutOfBoundsException err) {
                    throw new DukeException(Ui.echoNoDesc("find"), err);
                }
                break;
            case "todo":
                try {
                    TaskList.addTodo(words[1].trim());
                } catch (NullPointerException | ArrayIndexOutOfBoundsException err) {
                    throw new DukeException(Ui.echoNoDesc("todo"), err);
                }
                break;
            case "deadline":
                try {
                    TaskList.addDeadline(words[1].trim());
                } catch (NullPointerException | ArrayIndexOutOfBoundsException err) {
                    throw new DukeException(Ui.echoNoBy(), err);
                }
                break;
            case "event":
                try {
                    TaskList.addEvent(words[1].trim());
                } catch (NullPointerException | ArrayIndexOutOfBoundsException err) {
                    throw new DukeException(Ui.echoNoAt(), err);
                }
                break;
            case "delete":
                try {
                    TaskList.doDelete(words[1]);
                } catch (NumberFormatException ex) {
                    throw new DukeException(Ui.echoNotNum("delete"), ex);
                } catch (NullPointerException | ArrayIndexOutOfBoundsException err) {
                    throw new DukeException(Ui.echoNoTaskNum("delete"), err);
                }
                break;
            case "done":
                try {
                    TaskList.doDone(words[1]);
                } catch (NumberFormatException ex) {
                    throw new DukeException(Ui.echoNotNum("done"), ex);
                } catch (NullPointerException | ArrayIndexOutOfBoundsException err) {
                    throw new DukeException(Ui.echoNoTaskNum("done"), err);
                }
                break;
            case "":
                break;
            default:
                Ui.echoNonInput();
                break;
            }
        }
        return false;
    }
}
