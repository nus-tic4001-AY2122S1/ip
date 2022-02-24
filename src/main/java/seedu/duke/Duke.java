package seedu.duke;

import java.util.ArrayList;

public class Duke {
    private static ArrayList<Task> todoList = TaskList.getInstance().getList();

    private static void run() {
        Storage.loadData();
        Parser parser = new Parser();
        while (parser.isPending) {
            try {
                parser.scan();
                if (parser.isTask) {
                    System.out.println("\t____________________________________________________________");
                    System.out.println("\tGot it. I've added this task: ");
                    System.out.println("\t\t" + parser.getTask().toString());
                    System.out.println("\tNow you have " + todoList.size()
                        + (todoList.size() > 1 ? " tasks" : " task") + " in the list.");
                    System.out.println("\t____________________________________________________________");
                }
            } catch (DukeException e) {
                e.printErrorMessage();
            }
        }
    }

    /**
     * You should have your own function to generate a response to user input.
     * Replace this stub with your completed method.
     */
    String getResponse(String input) {
        Parser parser = new Parser();
        try {
            parser.getInput(input);
            return "Got it. I've added this task: " + parser.getTask().toString();
        } catch (DukeException e) {
            return e.getMessage();
        }
    }

    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        System.out.println("\t____________________________________________________________");
        System.out.println("\tHello! I'm Duke");
        System.out.println("\tWhat can I do for you?");
        System.out.println("\t____________________________________________________________");
        run();
        Storage.saveData();
        System.out.println("\t____________________________________________________________");
        System.out.println("\tBye. Hope to see you again soon!");
        System.out.println("\t____________________________________________________________");
    }

}
