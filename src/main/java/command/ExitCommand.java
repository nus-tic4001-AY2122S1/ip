package command;

import ui.UI;
import storage.Storage;
import tasklist.TaskList;

public class ExitCommand extends Command {

    /**
     * Writes to savefile, then prints goodbye message on console, finally flags for console to exit.
     */
    @Override
    public String execute(TaskList tasks, UI ui, Storage storage) {
        return ui.bye();
    }

    public ExitCommand() {
        bExit = true;
    }
}
