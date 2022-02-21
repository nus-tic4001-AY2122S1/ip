package duke.ui;

import java.util.Scanner;

import duke.task.Task;

/**
 * Represent the Ui which will take in Input from user and display Message for user to see
 */
public class Ui {

    /**
     * Welcome message to show to the user when starting up Duke
     */
    public static String showDukeWelcome() {
        String logo = "(\\ /)\n"
                    + "( . .)\n"
                    + "C(\")(\")\n";
        String message = "Hello from Duke!\n"
                + "Let me summon my magic bunny to help you! \n"
                + logo
                + "What can I do for you?\n";

        return message;
    }


    /**
     * Display the exit message to let user know that the program will end.
     */
    public static String showExit() {
        return "Bye. Hope to see you again soon!";
    }

    /**
     * Show the user when they need to input a command and read the user input
     * @return the command to the other class which will execute the command
     */
    public static String readCommand() {
        String line;
        Scanner in = new Scanner(System.in);
        System.out.print("Type something: ");
        line = in.nextLine();
        return line;
    }

    /**
     * Display the whole list of task to the user
     * @param task the task list
     */
    public static String showTaskInfo(Task task) {
        int taskNumber = task.getTaskIndex() + 1;
        return ("Task Number "
                + taskNumber
                + ": "
                + task.toString());
    }

    /**
     * Display the message of no matches
     */
    public static String showNoMatchFound() {
        return ("We couldn't find any matches.");
    }



    /**
     * Display to the user that the task he requested has been deleted
     * @param deletedTask The task that the user request to be deleted
     * @param numberOfTask The total number of task remaining in the list
     */
    public static String displayDeleteMsg(String deletedTask, int numberOfTask) {
        return ("I have deleted the following: \n"
                + deletedTask
                + "\n"
                + "Now you have "
                + numberOfTask
                + " tasks in the list.");
    }

    /**
     * Display to the user that task has been marked done
     * @param doneTask The task that the user request to be marked done
     * @param taskIndex The index/id of the task
     */
    public static String doneMsg(String doneTask, int taskIndex) {
        return ("Nice! I've marked this task as done: \n"
                + "Task Number "
                + taskIndex
                + ": "
                + doneTask);
    }

    /**
     * Display Message after an adding of Tasks and display the number of total Tasks
     * @param thatTask the task that has been added
     * @param numberOfTask the total number of task in the list
     */
    public static String displayAddMessage(String thatTask, int numberOfTask) {
        return ("Added: "
                + thatTask
                + "\n"
                + "Now you have "
                + numberOfTask
                + " tasks in the list.");
    }

    /**
     * Display Message after an adding of Tasks and display the number of total Tasks with duplicates
     * @param thatTask the task that has been added
     * @param numberOfTask the total number of task in the list
     * @param dups the total number of duplicate task in the list
     */
    public static String displayDuplicateAddMessage(String thatTask, int numberOfTask, int dups) {
        return ("Added: "
                + thatTask
                + "\n"
                + "Now you have "
                + numberOfTask
                + " tasks in the list.")
                + "\n"
                + "However, I noticed that you have another "
                + dups
                + " task with the same description. Could this be a duplicate?\n";
    }

    /**
     * Display the error message to user
     * @param errorMessage Error message from expected DukeException
     */
    public static String showError(String errorMessage) {
        return ("WE GOT AN ERROR: "
                + errorMessage);
    }

    /**
     * Show the error to the user when there is a problem with starting up the program
     */
    public static String showLoadingError() {
        return ("There are currently problem with loading the task, proceeding to create a new empty list");
    }


    /**
     * Display all the command available and how to use them
     */
    public static String displayListOfHelpFunction() {
        String everything = "";
        String head = ("List of command that Duke have: \n"
                + "(*Command are not case sensitive)\n"
                + "(**Words with double * are case sensitive)\n");
        everything += head;

        String hi = ("\"Hi\": Say hello to the bot\n"
                +
                "How to use: \n"
                +
                "Type Hi\n"
                +
                "E.g. Type something: Hi\n");
        everything += hi;

        String bye = ("\"Bye\" OR \"Exit\" OR \"Quit\": Say goodbye to the bot and close the program\n"
                +
                "How to use: \n"
                +
                "Type Bye\n"
                +
                "E.g. Type something: Bye\n");
        everything += bye;

        String todo = ("\"Todo\": Set a task that you want to do\n"
                +
                "How to use: \n"
                +
                "Type Todo (Your To Do Task)\n"
                +
                "E.g. Type something: Todo Get a pet\n");
        everything += todo;

        String event = ("\"Event\": Set a event task\n"
                +
                "How to use: \n"
                +
                "Type Event (Your event Task) /at (YYYY-MM-DD OR Monday-Sunday(Full spelling or First 3 letter)) "
                +
                "(Optional: hh:mm OR hhmm <24 Hours format>) \n"
                +
                "E.g. Type something: Event Countdown party /at 2019/12/31\n"
                +
                "Type something: Event Basketball /at Wed 18:00 \n");
        everything += event;

        String deadline = ("\"Deadline\": Set a deadline task\n"
                +
                "How to use: \n"
                +
                "Type Deadline (Your event Task) /by (YYYY-MM-DD OR Monday-Sunday(Full spelling or First 3 letter)) "
                +
                "(Optional: hh:mm OR hhmm <24 Hours format>)\n"
                +
                "E.g. Type something: Deadline Duke project /by 2019/11/17 2359 \n"
                +
                "Type something: Deadline Pay phone bills /by Sat\n");
        everything += deadline;

        String list = ("\"List\": Bring out the list of task\n"
                +
                "How to use: \n"
                +
                "Type List\n"
                +
                "E.g. Type something: list\n");
        everything += list;

        String find = ("\"Find\": Find a task with the word you want to find\n"
                +
                "How to use: \n"
                +
                "Type Find (The word**)\n"
                +
                "E.g. Type something: Find bill\n");
        everything += find;

        String done = ("\"Done\": Set a task to Done\n"
                +
                "How to use: \n"
                +
                "Type Done (Task Number)\n"
                +
                "E.g. Type something: Done 5\n");
        everything += done;

        String delete = ("\"Delete\": Delete a task(Be careful: Once you delete a task, it is gone forever. "
                +
                "And all other task number changes) \n"
                +
                "How to use: \n"
                +
                "Type Delete (Task Number)\n"
                +
                "E.g. Type something: Delete 5\n");
        everything += delete;

        String clearlist = ("\"Clearlist\": Clear and remove all the task in the task list\n"
                +
                "*Note: Clearlist will not save until you add another task, so if you want to undo your clear, "
                +
                "restart the program\n"
                +
                "How to use: \n"
                +
                "Type Clearlist\n"
                +
                "E.g. Type something: Clearlist\n");
        everything += clearlist;

        String help = ("\"Help\": Since you just used this, I'm sure I don't have to explain this...\n");
        everything += help;

        return everything;
    }

}
