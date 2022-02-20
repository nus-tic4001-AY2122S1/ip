package ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * Represents the Ui. It is meant to scan for new input and
 * print the various Strings.
 */
public class Ui {
    public String input;
    Scanner scan;
    List<String> messages;

    /**
     * This is the constructor for Ui. It initialises the scan and input objects.
     */

    public Ui() {

        this.input = "";
        scan = new Scanner(System.in);
        messages = new ArrayList<String>();
    }

    /**
     * This prints the intro logo of Duke.
     */
    public void printIntro() {
        String intro = "Hello from\n"
                + " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println(intro);
    }

    /**
     * This prints the dashed line used to separate printed lines/sections.
     */
    public void showLine() {
        System.out.println("___________________________________________________");
    }

    /**
     * This prints the farewell message when the user types "bye".
     */
    public void printBye() {
        System.out.println(System.lineSeparator() + "Bye. Hope to see you again soon!");
    }

    /**
     * This prints the request message for input from user and scans for the input.
     *
     * @return the input scanned from user
     */
    public String scanForInput() {
        System.out.println(System.lineSeparator() + "What can I do for you? For help, type \"/help\". ");
        return this.scan.nextLine();
    }

    /**
     * Print the error passage that is in parameters.
     *
     * @param errorMessage This is the error message that is received.
     */
    public void showError(String errorMessage) {
        System.out.println(errorMessage);
    }

    /**
     * This prints the specific loading error when the Task List
     * did not load from storage.
     */
    public void showLoadingError() {
        System.out.println("Did not load Task List from Filepath");
    }

    public void storeMessage(String message) {
        messages.add(message);
    }

    public void clearMessages() {
        messages.clear();
    }

    public String getMessages() {
        String reply = "";

        for (int i = 0; i < messages.size(); i++) {
            reply = reply + messages.get(i) + "\n";
        }
        return reply;
    }

}
