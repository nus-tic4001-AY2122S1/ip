package basic;

import task.Task;

import java.util.Scanner;

/**
 * Text UI of the application.
 */
public class Ui {
    private void showLine() {
        System.out.println("___________________________________________");
    }

    /**
     * Generates and prints the welcome message upon the start of the application.
     */
    void showWelcome() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hellooooooo from\n" + logo);
        showLine();
        System.out.println("Hello! I'm Duke\nWhat can I do for you?");
        showLine();
    }

    /**
     * Prompts for the command and reads the text entered by the user.
     *
     * @return command (full line) entered by the user
     */
    String readCommand() {
        Scanner input = new Scanner(System.in);
        String myString = "";
        myString += input.nextLine();
        return myString;
    }

    /**
     * Displays the response when the program is exited.
    */
    public String showBye() {
        return "   Bye. Hope to see you again soon!";
    }

    /**
     * Displays the response when a task is marked as done.
    */
    public String showDone(Task task) {
        return "   " + "Nice! I've marked this task as done:" + "   " + task;
    }

    /**
     * Displays the response when a task is marked as undone.
    */
    public String showUndone(Task task) {
        return "   " + "I've marked this task as undone:" + "   " + task;
    }

    /**
     * Displays an empty line.
    */
    public void printEmptyLine() {
        System.out.println("\n");
    }

    /**
     * Displays the response when a task is added.
    */
    public String showAdded() {
        return "   " + "Got it. I've added this task:\n" + "   ";
    }

    /**
     * Shows a list of tasks to the user, formatted as an indexed list.
     */
    public String printTasks(TaskList tasks) {
        String response = "";
        for (int j = 1; j <= tasks.sizeOfTask(); j++) {
            response += "   " + j + ". " + tasks.returnTask(j - 1);
        }
        return response;
    }

    /**
     * Shows a list of tasks to the user, formatted as an indexed list.
     */
    public String printMatchingTask(Task tasks, int index) {
        return "   " + index + ". " + tasks.toString();
    }

    /**
     * Displays a number of tasks in the Tasklist.
    */
    public String printTaskNum(TaskList tasks, Task task) {
        return task + "\n   Now you have " + tasks.sizeOfTask() + " tasks in the list.\n";
    }

    /**
     * Displays the response when a task is deleted.
    */
    public String printDeleteCommand(Task task, int num) {
        return "   Noted. I've removed this task:\n   " + task + "\n   Now you have " 
                + num + " tasks in the list.";
    }

    /**
     * Displays the header of response when a find command is entered.
    */
    public String printMatching() {
        return "   Here are the matching tasks in your list:";
    }

    /**
     * Displays the exception message.
    */
    void printException(Exception e) {
        System.out.println(e.toString());
        printEmptyLine();
    }
}
