package Duke.Ui;

import java.util.Scanner;

public class Ui {
    public static String seperatorLine = "___________________________________________\n";
    public static String seperatorLine2 = "________________________________________\n";
    public static int task_count = 0;

    public static void showWelcome() {

        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        System.out.print(seperatorLine);
        System.out.println("Hello! I'm Duke\n"
                + "What can I do for you");
        System.out.println(seperatorLine);
    }

    public static Scanner readCommand(){

        Scanner input = new Scanner(System.in);
        return input;
    }

    /***
     * print out error when Duke can't regconize the task keywords
     */
    public static void keywordError() {
        System.out.println(" ☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
    }

    public static void byeMessage() {
        System.out.print(seperatorLine);
        System.out.println("       " + "Bye. Hope to see you again soon!");
        System.out.println(seperatorLine);
    }

    public static void todoError() {
        System.out.println("☹ OOPS!!! The description of a todo cannot be empty.");
    }

    public static void deadlineDateError() {
        System.out.println("☹ OOPS!!! The description of a deadline cannot be empty.");
    }

    public static void eventDateError() {
        System.out.println("☹ OOPS!!! The event description cannot be empty.");
    }

    public static void doneNumberEmptyError() {
        System.out.println("☹ OOPS!!! The number of a done cannot be empty.");
    }

    public static void doneNumberInvalid() {
        System.out.println("Please enter which integer after delete ");
    }

    public static void doneNumberStartFrom1() {
        System.out.println("Re-enter number start from 1");
    }

    public static void dateTimeInvalidFormat() {
        System.out.println("Or can enter the date format like yyyy-mm-dd (e.g., 2019-01-01) ");
    }

    public static void viewScheduleError() {
        System.out.println("☹ OOPS!!! Please enter specific date at least in month or date or year(e.g., Oct 10 2019).");
    }

    public static void deleteNumberOutOfList() {
        System.out.println("☹ OOPS!!! Only have "+task_count+ " in the list. Duke only can delete less than this number:" + task_count);
    }

}
