package duke.command;

import duke.storage.Storage;
import duke.task.TaskList;
import duke.ui.Ui;

public class ExitCommand extends Command {

    /**
     * Writes to savefile, then prints goodbye message on console, finally flags for console to exit.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        storage.writeToSaveFile(tasks.listTasks());
        ui.printByeMsg();
    }

    public ExitCommand() {
        bExit = true;
    }
}
