package main.java.duke;

import main.java.duke.commands.Command;
import main.java.duke.commands.ExitCommand;
import main.java.duke.parser.Parser;
import main.java.duke.storage.Storage;
import main.java.duke.task.TaskList;
import main.java.duke.ui.Ui;

import main.java.duke.storage.Storage.StorageOperationException;
import main.java.duke.storage.Storage.InvalidStorageFilePathException;

import java.io.IOException;

public class Duke {


    private Ui ui;
    private Storage storage;
    private TaskList tasks;

    public Duke(String filePath) {
        ui = new Ui();
        try {
            storage = new Storage(filePath);
            tasks = new TaskList(storage.load());
        } catch (StorageOperationException | InvalidStorageFilePathException | IOException e) {
            ui.showLoadingError();
            tasks = new TaskList();
        }
    }
    public static void main(String[] args) {
        new Duke(System.getProperty("user.dir")+"/data/duke.txt").run();
    }

    public void run() {
        ui.showWelcome();
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                ui.showLine(); // show the divider line ("_______")
                Command c = new Parser().parse(fullCommand);
                c.setData(tasks);
                c.execute();
                storage.save(tasks);
                isExit = ExitCommand.isExit(c);
            } catch (Exception e) {
                ui.showError(e.getMessage());
            } finally {
                ui.showLine();
            }
        }
    }

}
