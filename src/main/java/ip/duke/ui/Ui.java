package ip.duke.ui;

import java.util.stream.Stream;

import ip.duke.exceptions.DukeException;
import ip.duke.task.Task;
import ip.duke.tasklist.TaskList;

/**
 * Utility Class that provides console displays and messages output
 *
 * </P>Deals with user prompts, feedback and chat services.
 *
 * <P>The echoFind method shows a list of found items as a read-only display.
 *
 * @author Gwee Yeu Chai
 * @version 1.0
 * @since 2021-09-10
 */
public class Ui {
    public static void greet() {
        // Greeting screen display
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("Hello! I'm LisGenie");
        System.out.println("What can I do for you?");
    }

    // Bye/exit message
    public static void bye() {
        System.out.print("LisGenie : ");
        System.out.printf("Bye. Hope to see you again soon!%n");
    }

    // This method draws a horizontal line
    public static void drawALine() {
        System.out.print("          ");
        Stream.generate(() -> "_").limit(65).forEach(System.out::print);
        System.out.println();
    }

    public static void echoAdded(Task input) {
        System.out.print("LisGenie : ");
        System.out.println("Got it. I've added this task:");
        postUpdate(input);
    }

    public static void echoDelete(Task item) {
        System.out.print("LisGenie : ");
        System.out.println("Noted. I've removed this task:");
        postUpdate(item);
    }

    public static void echoDone(Task item) {
        System.out.print("LisGenie : ");
        System.out.println("Nice! I've marked this task as done:");
        System.out.printf("%13s", " ");
        System.out.printf("[%s] %s%n", item.getStatusIcon(), item);
    }

    public static void echoDukeErrorMsg(DukeException e) {
        System.out.println(e.getMessage());
    }

    public static void echoEmptyInput() {
        System.out.print("LisGenie : ");
        System.out.println("eh...Om! Empty string to skip here, O Master! Retry again?");
    }

    public static void echoList() {
        System.out.print("LisGenie : ");
        System.out.printf("Here are the tasks in your list:%n");

        int counter = 1;
        for (Task item : TaskList.getList()) {
            if (item != null) {
                System.out.printf("%12d.[%c][%s] %s%n", counter++, item.getId(), item.getStatusIcon(), item);
            }
        }
    }

    public static void echoFind(String word) {
        System.out.print("LisGenie : ");
        System.out.printf("Here are the matching tasks in your list:%n");

        int counter = 1;
        for (Task item : TaskList.getList()) {
            if (item != null && item.toString().toLowerCase().contains(word.toLowerCase())) {
                System.out.printf("%12d.[%c][%s] %s%n", counter++, item.getId(), item.getStatusIcon(), item);
            }
        }
    }

    public static void echoUserPrompt() {
        System.out.printf("%nMasterOm : ");
    }

    public static String echoNoAt() {
        return String.format("LisGenie : OOPS!!! O %s use: \"event <specify event> /at <datetime>\"", "event");
    }

    public static String echoNoBy() {
        return String.format("LisGenie : OOPS!!! O %s use: \"deadline <specify task> /by <datetime>\"", "deadline");
    }

    // This method informs user that no task description is entered
    public static String echoNoDesc(String task) {
        return String.format("LisGenie : OOPS!!! The description of a %s cannot be empty, Master?", task);
    }

    public static void echoNoEntries() {
        System.out.print("LisGenie : ");
        System.out.println("O! Task not in list, Master? Add a task? Retry?");
    }

    // This method informs the user an unknown or invalid input is entered
    public static void echoNonInput() {
        System.out.print("LisGenie : ");
        System.out.println("OOPS!!! I'm sorry, but I don't know what that means :-(| Master?");
    }

    public static String echoNoTaskNum(String task) {
        return String.format("LisGenie : O? Master, forgot to enter the Task number after '%s'?", task);
    }

    public static String echoNotNum(String task) {
        return String.format("LisGenie : O Master, use digit(s) only for Task number after '%s'! Om!", task);
    }

    public static void echoOffList(int idx) {
        System.out.print("LisGenie : ");
        System.out.println("Item position outside of list (1 - 100): " + (idx + 1) + " Omm??");
    }

    /**
     * Prints out the task details
     * post-execution, with current size of TASKS.
     *
     * @param input A Task object
     *              concerned.
     */
    public static void postUpdate(Task input) {
        System.out.printf("%13s", " ");
        System.out.printf("[%c][%s] %s%n", input.getId(), input.getStatusIcon(), input);

        int count = TaskList.listSize();
        System.out.printf("%11s", " ");
        System.out.printf("Now you have %d %s in the list.%n", count, count == 1 ? "task" : "tasks");
    }

    public static void showLoadingError(DukeException err) {
        System.out.println();
        System.out.println("         ***-----------------------------------------------------------------------------"
                + "-----------***");
        System.out.print("LisGenie : ");
        System.out.println(err.getMessage());
        System.out.printf("%11s", " ");
        System.out.println("File access error...starting with a blank database & a backup.txt file. Contact Admin"
                + " soon!");
        System.out.println("         ***-----------------------------------------------------------------------------"
                + "-----------***");
        System.out.println();
    }

    public static void showSizeFull() {
        System.out.println();
        System.out.print("           ");
        System.out.println(" *** VroOOm...oomMM! ALERT BEEP! BEEP! O Master!  ***");
        System.out.print("LisGenie : ");
        System.out.println("[@|@[ \"Optimum size of database records: ]@|@] -> 100 reached!");
        System.out.print("           ");
        System.out.println("        Delete some unused old records before proceeding O Master!\"");
    }

}
