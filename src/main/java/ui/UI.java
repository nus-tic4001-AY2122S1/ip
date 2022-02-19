package ui;

import tasklist.Task;
import java.util.ArrayList;
import java.util.Scanner;

public class UI {
    private Scanner input;

    public UI() {
        input = new Scanner(System.in);

    }
    public static String printDuke() {
        String message = "";
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        message += "Hello from\n" + logo;
        message +="Hello! I'm Duke\n" + "What can I do for you?\n";
        return message;
    }

    /**
     * Reads user input
     */
    public String readCommand() {
        return input.nextLine();
    }

    public static String bye() {
        return ("Bye. Hope to see you again soon!");
    }

    public static String printAddedTask(ArrayList<Task> taskList) {
        return taskList.get(taskList.size() - 1).toString();
    }

    public static String printTask(ArrayList<Task> taskList) {
        String message="";

        message += "Got it. I've added this task: \n";
        message += printAddedTask(taskList) + "\n";
        message += printNumberOfTasks(taskList) + "\n";

        return message;

    }

    public static String printOutput(ArrayList<Task> taskList) {
        String message = "";
        message += "Here are the tasks in your list: \n";
        for (int i = 0; i < taskList.size(); i++) {
            message += (i + 1) + ". " + taskList.get(i).toString() + "\n";
        }
        return message;
    }

    public static String printListEmpty() {
        return "List is empty!";
    }

    public static String printNumberOfTasks( ArrayList<Task> taskList) {
        return "Now you have " + (taskList.size()) + " tasks in the list.";
    }

    public static String printMarkedAsDone() {
        return "Nice! I've marked this task(s) as done: \n";
    }

    public static String printRemoveTask() {
        return "Noted. I've removed this task: \n";
    }

    public static String printTaskSaved() {
        return "Tasks saved!";
    }

    public static String printParseException() {
        return "OOPS!!! Please enter DD MMM YYYY date format.";
    }

    public static String printEmptyException() {
        return "OOPS!!! The description cannot be empty.";
    }

    public static String printStringFormatException() {
        return "OOPS!!! I'm sorry, but I don't know what that means.";
    }

    public static String printEmptyToDoDescriptionException() {
        return "OOPS!!! The description of a todo cannot be empty.";
    }

    public static String printEmptyEventDescriptionException() {
        return "OOPS!!! The description of a event cannot be empty.";
    }

    public static String printEmptyDeadlineDescriptionException() {
        return "OOPS!!! The description of a deadline cannot be empty.";
    }

    public static String printNumberFormatException() {
        return "OOPS!!! I'm sorry, but I don't know what that means.";
    }

    public static String printIndexOutOfRangeException() {
        return "OOPS!!! Out of Range!";
    }

}