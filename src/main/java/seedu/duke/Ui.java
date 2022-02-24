package seedu.duke;

import java.util.ArrayList;

public class Ui {
    private static ArrayList<Task> todoList = TaskList.getInstance().getList();

    public static void specifyValidNumber() {
        System.out.println("\t____________________________________________________________");
        System.out.println("\t☹ OOPS!!! Please specify a valid number.");
        System.out.println("\tNow you have " + todoList.size() + " tasks in the list.");
        System.out.println("\t____________________________________________________________");
    }

    public static void removedTask(String info) {
        System.out.println("\t____________________________________________________________");
        System.out.println("\tNoted. I've removed this task:");
        System.out.println("\t\t" + info);
        System.out.println("\tNow you have " + todoList.size() + " tasks in the list.");
        System.out.println("\t____________________________________________________________");
    }

    public static void updateTask(String info) {
        System.out.println("\t____________________________________________________________");
        System.out.println("\tNoted. I've updated this task:");
        System.out.println("\t\t" + info);
        System.out.println("\t____________________________________________________________");
    }

    public static void printList() {
        int i = 1;
        System.out.println("\t____________________________________________________________");
        System.out.println("\tHere are the tasks in your list:");
        for (Task item : todoList) {
            if (item != null) {
                System.out.println("\t" + i + "." + item.toString());
                i++;
            }
        }
        System.out.println("\t____________________________________________________________");
    }

    public static void searchList(String word) {
        int i = 1;
        System.out.println("\t____________________________________________________________");
        System.out.println("\tHere are the matching tasks in your list:");
        for (Task item : todoList) {
            if (item.description.toLowerCase().contains(word.toLowerCase())) {
                System.out.println("\t" + i + "." + item.toString());
            }
            i++;
        }
        System.out.println("\t____________________________________________________________");
    }

    public static void markAsDone(String info) {
        System.out.println("\t____________________________________________________________");
        System.out.println("\tNoted. I've marked the following task as done:");
        System.out.println("\t\t" + info);
        System.out.println("\t____________________________________________________________");
    }
}
