package taskclasses;

import java.util.Vector;

import exceptions.DukeStorageError;
import exceptions.DukeTaskInputException;

public class TaskList {

    private Vector<Task> list;

    /**
     * The method to initialize a TaskList
     *
     * @param taskList Vector list contain all the task which in Task format
     */
    public TaskList(Vector<Task> taskList) {
        list = taskList;
    }

    /**
     * The method to initialize a TaskList without any argument
     */
    public TaskList() {
        list = new Vector<>();
    }

    /**
     * The method to delete particular task from the task list
     *
     * @param taskIndex the index number of the task which is going to be deleted in the task list, not index in Vector
     * @throws DukeTaskInputException handles all the errors about user input
     */
    public void deleteTask(int taskIndex) throws DukeTaskInputException {
        if (list.isEmpty()) {
            throw new DukeTaskInputException("taskListEmpty");
        }

        list.remove(taskIndex);
    }

    /**
     * The method to add task into the main task list
     *
     * @param task task which is going to be added
     */
    public void addTask(Task task) {
        list.add(task);
    }

    /**
     * The method to get date time of the particular task in the main task list
     *
     * @param taskIndex the index of the task in the list
     * @return date time
     * @throws DukeStorageError handles all errors about storage
     */
    public String getDateTime(int taskIndex) throws DukeStorageError {
        Task task = list.get(taskIndex);

        String taskType = task.getType();

        switch (taskType) {
        case "E":
            return task.getStartingDateTime();
        case "D":
            return task.getDeadlineDateTimeString();
        default:
            break;
        }

        throw new DukeStorageError();
    }

    /**
     * The method to get particular task from the main task list
     *
     * @param index the index of the task
     * @return task
     */
    public Task getTask(int index) {
        return list.get(index);
    }

    /**
     * The method to print entire task list
     */
    public void toPrintEntireTaskList() {
        if (list.isEmpty()) {
            System.out.println("     Here is no task in your list.");
            return;
        }

        System.out.println("     Here are the task(s) in your list:");

        for (int i = 0; i < list.size(); i++) {
            int j = i + 1;
            Task task = list.get(i);

            System.out.print("     " + j + "."
                    + "[" + task.getType() + "]"
                    + "[" + task.getStatusIcon() + "] "
                    + task.getDescription());

            String taskType = task.getType();

            switch (taskType) {
            case "E":
                String eventStartingDateTime = task.getStartingDateTime();
                String eventEndingDateTime = task.getEndingDateTime();
                System.out.println(" (at: " + eventStartingDateTime + " ---> " + eventEndingDateTime + ")");

                break;
            case "D":
                String deadlineDateTime = task.getDeadlineDateTimeString();
                System.out.println(" (by: " + deadlineDateTime + ")");

                break;
            default:
                System.out.println("");
            }
        }
    }

    /**
     * The method to print entire task list
     *
     * @param taskList task list in TaskList type
     */
    public static String toPrintEntireTaskList(Vector<Task> taskList) {

        String echoInfo = "";

        if (taskList.isEmpty()) {
            //System.out.println("     Here is no task in your list.");
            return "     Here is no task in your list.";
        }

        //System.out.println("     Here are the task(s) in your list:");

        echoInfo = echoInfo
                + "     Here are the task(s) in your list:\n";

        for (int i = 0; i < taskList.size(); i++) {
            int j = i + 1;
            Task task = taskList.get(i);

            echoInfo = echoInfo
                    + "     " + j + "."
                    + "[" + task.getType() + "]"
                    + "[" + task.getStatusIcon() + "] "
                    + task.getDescription() + "\n";

            String taskType = task.getType();

            switch (taskType) {
            case "E":
                String eventStartingDateTime = task.getStartingDateTime();
                String eventEndingDateTime = task.getStartingDateTime();

                echoInfo = echoInfo
                        + " (at: " + eventStartingDateTime
                        + " ---> " + eventEndingDateTime + ")\n";
                break;
            case "D":
                String deadlineDateTime = task.getDeadlineDateTimeString();
                System.out.println(" (by: " + deadlineDateTime + ")");

                echoInfo = echoInfo
                        + " (by: " + deadlineDateTime + ")\n";

                break;
            default:
            }
        }

        return echoInfo;
    }

    /**
     * The method to print entire task list for GUI type
     */
    public String toPrintEntireTaskListGui() {
        if (list.isEmpty()) {

            return "     Here is no task in your list.";
        }

        String echoInfo = "     Here are the task(s) in your list:\n";

        for (int i = 0; i < list.size(); i++) {
            int j = i + 1;
            Task task = list.get(i);

            echoInfo = echoInfo
                    + "     " + j + "."
                    + "[" + task.getType() + "]"
                    + "[" + task.getStatusIcon() + "] "
                    + task.getDescription() + "\n";

            String taskType = task.getType();

            switch (taskType) {
            case "E":
                String eventStartingDateTime = task.getStartingDateTime();
                String eventEndingDateTime = task.getEndingDateTime();

                echoInfo = echoInfo
                        + " (at: " + eventStartingDateTime
                        + " ---> " + eventEndingDateTime + ")\n";

                break;
            case "D":
                String deadlineDateTime = task.getDeadlineDateTimeString();

                echoInfo = echoInfo
                        + " (by: " + deadlineDateTime + ")\n";

                break;
            default:
            }
        }

        return echoInfo;
    }

    /**
     * The method to get the size of the task list
     *
     * @return size in integer
     */
    public int size() {
        if (list.isEmpty()) {
            return 0;
        }

        return list.size();
    }

    /**
     * The method to check whether the task list is empty
     *
     * @return true (empty) / false (not empty)
     */
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * The method to geth Vector list in TaskList
     *
     * @return list
     */
    public Vector<Task> getVectorList() {
        return list;
    }
}
