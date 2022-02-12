package ui;

import java.util.Scanner;

import taskclasses.Deadline;
import taskclasses.Event;
import taskclasses.Task;
import taskclasses.Todo;

public class Ui {

    public Ui () {}

    /**
     * The greeting with some instruction in GUI
     */
    public static String showGreetingMessageGui() {
        /*String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";*/
        String logo = "";

        logo = " Hello! I'm Duke\n"
                + " What can I do for you?";

        return logo;
    }

    /**
     * The method to print the message just after task be deleted successfully
     * @param deletedTask task be deleted
     * @param taskListRemainingSize the task list size after deletion
     */
    public static String toPrintTaskDeletedMessage(Task deletedTask, int taskListRemainingSize) {
        TaskDeletedMessage taskDeletedMessage = new TaskDeletedMessage(deletedTask, taskListRemainingSize);
        String echoInfo = taskDeletedMessage.printTaskDeletedMessage();

        return echoInfo;
    }

    /**
     * Output after add Todo task into the list
     *
     * @param newTask the new task detected from user input and needs to be added to List, type is Todo
     * @param listQty the total quantity of task in the List after added current new task
     */
    public static String printTodoAddedOutput(Todo newTask, int listQty) {

        String echoInfo = "";

        echoInfo = echoInfo
                + "     Got it. I've added this task:\n"
                + "        [" + newTask.getType() + "]["
                + newTask.getStatusIcon() + "] "
                + newTask.getDescription() + "\n"
                + "     Now you have " + listQty
                + " tasks in the list.";

        return echoInfo;
    }

    /**
     * Output after add Deadline task into the list
     *
     * @param newTask the new task detected from user input and needs to be added to List, type is Deadline
     * @param listQty the total quantity of task in the List after added current new task
     */
    public static String printDeadlineAddedOutput(Deadline newTask, int listQty) {
        String echoInfo = "";

        echoInfo = echoInfo
                + "     Got it. I've added this task:\n"
                + "        [" + newTask.getType() + "]["
                + newTask.getStatusIcon() + "] "
                + newTask.getDescription()
                + " (by: " + newTask.getDeadlineDateTimeString() + ")\n"
                + "     Now you have " + listQty + " tasks in the list.";

        return echoInfo;
    }

    /**
     * Output after add Event task into the list
     *
     * @param newTask the new task detected from user input and needs to be added to List, type is Event
     * @param listQty the total quantity of task in the List after added current new task
     */
    public static String printEventAddedOutput(Event newTask, int listQty) {

        String echoInfo = "";

        echoInfo = echoInfo
                + "     Got it. I've added this task:\n"
                + "        [" + newTask.getType() + "]["
                + newTask.getStatusIcon() + "] "
                + newTask.getDescription()
                + " (by: " + newTask.getStartingDateTime() + ")\n"
                + "     Now you have " + listQty + " tasks in the list.";

        return echoInfo;
    }

    /**
     * Output after mark particular task status as done
     *
     * @param task the task which be marked as done
     */
    public static String printMarkAsDoneOutput(Task task) {

        String taskType = task.getType();
        String echoInfo = "";
        /*System.out.println("     Nice! I've marked this task as done:");
        System.out.print("       [" + task.getType() + "]["
                + task.getStatusIcon() + "] "
                + task.getDescription());*/

        echoInfo = echoInfo
                + "     Nice! I've marked this task as done:\n"
                + "       [" + task.getType() + "]["
                + task.getStatusIcon() + "] "
                + task.getDescription();

        switch (taskType) {
        case "E":
            String eventDateTime = task.getStartingDateTime();
            System.out.println(" (at: " + eventDateTime + ")");

            echoInfo = echoInfo
                    + " (at: " + eventDateTime + ")\n";

            break;
        case "D":
            String deadlineDateTime = task.getDeadlineDateTimeString();
            System.out.println(" (by: " + deadlineDateTime + ")");

            echoInfo = echoInfo
                    + " (by: " + deadlineDateTime + ")\n";

            break;
        default:
        }

        return echoInfo;
    }
}
