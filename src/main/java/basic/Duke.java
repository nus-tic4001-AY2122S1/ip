
package basic;

import command.Command;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/**
 * Runs basic.Duke program as long as isExit is false
 * Passes tasks entered by user to Storage class
 */
public class Duke extends Application {
    public static Ui ui;
    public static TaskList tasks;
    public static TaskList deletedTasks;
    public static String exCommand;
    public static Storage storage;
    private static String response;

    public Duke() throws FileNotFoundException, UnsupportedEncodingException {
        ui = new Ui();
        storage = new Storage();
        tasks = new TaskList(storage.load());
        deletedTasks = new TaskList(new ArrayList<String>());
    }

    @Override
    public void start(Stage stage) {

    }


    /**
     * You should have your own function to generate a response to user input.
     * Replace this stub with your completed method.
     */
    public static String getResponse(String input) {
        try {
            Command c = Parser.parse(input);
            response = c.execute(tasks, ui, storage, deletedTasks, exCommand);
            exCommand = input;
            storage.save(tasks.returnList());
            return " Duke: " + response;
        } catch (Exception e) {
            return " Duke: " + e.toString();
        }
    }

    private void run() throws FileNotFoundException, UnsupportedEncodingException {
        // storage.load();
    }

    /**
     * Runs Duke.
     */
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        new Duke().run();
    }
}
