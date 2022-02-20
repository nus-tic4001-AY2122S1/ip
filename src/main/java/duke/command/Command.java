package duke.command;

import duke.task.TaskList;
import duke.ui.Ui;
import duke.others.DukeException;
import duke.storage.Storage;

import java.io.IOException;

/**
 * Represents an executable duke.command class to be inherited
 */
public class Command {
    /** Represents the status of the application. If True, application will be terminated */
    protected boolean isExit;

    public Command() {
        this.isExit = false;
    }

    public String execute(TaskList tasks, Ui ui, Storage storage) throws DukeException, IOException {
        return null;
    }

    /**
     * @return the termination status
     */
    public boolean isExit() {
        return this.isExit;
    }
}