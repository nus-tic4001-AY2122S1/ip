package ui;

import taskclasses.Task;

class TaskDeletedMessage {
    private String taskType;
    private int remainingTaskListSize;
    private String taskDescription;
    private String taskStatus;
    private Task deletedTask;

    /**
     * The method to initialize TaskDeletedMessage
     * @param deletedTask deletedTask
     * @param remainingTaskListSize remaining task list size
     */
    TaskDeletedMessage(Task deletedTask, int remainingTaskListSize) {
        this.taskType = deletedTask.getType();
        this.remainingTaskListSize = remainingTaskListSize;
        this.taskDescription = deletedTask.getDescription();
        this.taskStatus = deletedTask.getStatusIcon();
        this.deletedTask = deletedTask;
    }

    /**
     * To print deleted message after task deleted successfully
     */
    String printTaskDeletedMessage() {

        String echoInfo = "";

        switch (taskType) {
        case "E":
            echoInfo = printDeletedEvent();
            break;
        case "D":
            echoInfo = printDeletedDeadline();
            break;
        case "T":
            echoInfo = printDeletedTodo();
            break;
        default:
            break;
        }

        return echoInfo;
    }

    /**
     * To print message after user deleted a deadline task successfully
     */
    private String printDeletedDeadline() {

        String dateTime = deletedTask.getDeadlineDateTimeString();
        String echoInfo = "";

        System.out.println("     Noted. I've removed this task:");
        System.out.println("       [" + taskType + "]["
                + taskStatus + "] "
                + taskDescription + "(by: " + dateTime + ")");
        System.out.println("     Now you have " + remainingTaskListSize + " task(s) in the list.");

        echoInfo = echoInfo
                + "     Noted. I've removed this task:\n"
                + "       [" + taskType + "]["
                + taskStatus + "] "
                + taskDescription + "(by: " + dateTime + ")\n"
                + "     Now you have "
                + remainingTaskListSize
                + " task(s) in the list.";

        return echoInfo;
    }

    /**
     * To print message after user deleted a event task successfully
     */
    private String printDeletedEvent() {
        String echoInfo = "";
        String dateTime = deletedTask.getStartingDateTime();

        System.out.println("     Noted. I've removed this task:");
        System.out.println("       [" + taskType + "]["
                + taskStatus + "] "
                + taskDescription
                + "(at: " + dateTime + ")");
        System.out.println("     Now you have " + remainingTaskListSize + " task(s) in the list.");

        echoInfo = echoInfo
                + "     Noted. I've removed this task:\n"
                + "       [" + taskType + "]["
                + taskStatus + "] "
                + taskDescription
                + "(at: " + dateTime + ")" + "\n"
                + "     Now you have "
                + remainingTaskListSize
                + " task(s) in the list.";

        return echoInfo;
    }

    /**
     * To print message after user deleted a todo task successfully
     */
    public String printDeletedTodo() {

        String echoInfo = "";

        System.out.println("     Noted. I've removed this task:");
        System.out.println("       [" + taskType + "][" + taskStatus + "] " + taskDescription);
        System.out.println("     Now you have " + remainingTaskListSize + " task(s) in the list.");

        echoInfo = echoInfo
                + "     Noted. I've removed this task:\n"
                + "       [" + taskType + "]["
                + taskStatus + "] "
                + taskDescription + "\n"
                + "     Now you have "
                + remainingTaskListSize
                + " task(s) in the list.";

        return echoInfo;
    }
}
