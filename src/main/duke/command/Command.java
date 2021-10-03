package duke.command;

import duke.exception.DukeException;
import duke.storage.Storage;
import duke.task.TaskList;
import duke.ui.Ui;

/**
 * Base abstract class for Commands to inherit.
 */
public abstract class Command {

    protected boolean bExit = false;

    public boolean isExit(){
        return bExit;
    }

    /**
     * Abstract method for when command executes.
     * @param tasks     The current list of tasks
     * @param ui        Reference to the current UI
     * @param storage   Reference to current storage object we use to save/load from text file.
     * @throws DukeException
     */
    public abstract void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException;
}
