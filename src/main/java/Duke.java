import duke.command.Command;
import duke.command.CommandResult;
import duke.dukeexception.DukeException;
import duke.parser.Parser;
import duke.storage.Storage;
import duke.task.TaskList;
import duke.ui.Ui;




/**
 * Create the Duke class to start of the program
 */
public class Duke {

    private static Duke duke;

    private Storage storage;
    private TaskList tasks;
    private Ui ui;


    private Duke() {

    };

    /**
     * Constructs the Duke class
     * @param filePath the filePath of the stored txt file
     */
    private Duke(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        try {
            tasks = new TaskList(storage.load());
        } catch (DukeException e) {
            ui.showError(e.getMessage());
            ui.showLoadingError();
            tasks = new TaskList();
        }
    }


    /**
     * Create instance of Duke
     *
     */
    public static Duke createInstance() {
        if (duke == null) {
            duke = new Duke("data/tasks.txt");
        }
        return duke; // Converting duke to Singleton Class to only have 1 Instance for easier retrieval
    }


    /**
     * Shared instance of Duke
     */
    public static Duke sharedInstance() {
        return duke;
    }



    /**
     * this function will run the Duke program
     */
    public CommandResult run(String input) {
        CommandResult commandResult;
        try {
            String fullCommand = input;

            Command c = Parser.parse(fullCommand);
            commandResult = c.execute(tasks, ui, storage);
        } catch (DukeException e) {
            commandResult = new CommandResult(e.getMessage());
        }

        return commandResult;
    }



    /**
     * Function to run duke and get response
     */
    String getResponse(String input) {
        CommandResult commandResult = run(input);

        return commandResult.getFeedbackToUser();
    }



}
