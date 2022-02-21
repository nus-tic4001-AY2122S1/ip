package duke.command;

import duke.dukeexception.DukeException;
import duke.storage.Storage;
import duke.task.TaskList;
import duke.ui.Ui;

/**
 * abstract class command
 */
public abstract class Command {
    protected String commandInstruction;

    /**
     * Constructs command
     */
    public Command() {

    }

    /**
     *Constructs command
     * @param commandInstruction will store the command that the user input
     */
    public Command(String commandInstruction) {
        this.commandInstruction = commandInstruction;
    }

    /**
     * Calling the function will execute the function of the individual command
     * @param tasks The task list will store the task
     * @param ui The Ui class which will help to display to the user
     * @param storage The Storage which will save the list of task to
     * @throws DukeException Any expected error
     */
    public CommandResult execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        throw new DukeException("Error for command execute!");
    }

    /**
     * This function will be default to false until exit or bye is called.
     * @return false to keep it looping for user input
     */
    public boolean isExit() {
        return false;
    }

}
