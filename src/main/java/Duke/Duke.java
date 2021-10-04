package Duke;

import java.util.ArrayList;
import java.util.Scanner;

public class Duke {
    private Storage storage;
    private TaskList tasks;
    private UI ui;

    /*  Recommit due to wrong branch name
     *  Constructs Duke object.
     *  @param filePath Define file location.
     */
    public Duke(String filePath) {
        //Creates User interface
        ui = new UI();
        //Reading data from file stated in filepath
        storage = new Storage(filePath);
        try {
            tasks = new TaskList(storage.load());
        } catch (DukeException e) {
            ui.showLoadingError();
            tasks = new TaskList();
        }
    }
    /*
     *  This method shows the flow of 'Duke'.
     */
    public void run() {
        ui.showWelcome();
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                ui.showLine(); // show the divider line ("_______")
                Command c = Parser.parse(fullCommand);
                c.execute(tasks, ui, storage);
                isExit = c.isExit();
                storage.save(tasks.getTaskList());
            } catch (DukeException e) {
                ui.displayError(e.getMessage());
            } finally {
                ui.showLine();
            }
        }
    }
    /*
     *  This is the main method
     *  @param args Arguments.
     */
    public static void main(String[] args) {
        new Duke("data/tasks.txt").run();
    }
}
