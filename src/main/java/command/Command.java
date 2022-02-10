package command;

import exception.DukeException;
import exception.EmptyException;
import basic.Storage;
import basic.TaskList;
import basic.Ui;

/**
 * Represents an executable command.
 */

public class Command {
    protected static Ui ui = new Ui();

    public boolean isExit() {
        return false;
    }

    /**
     * Executes Command.
     *  @param tasks   The tasks stored in an ArrayList.
     * @param ui      The User Interface (UI).
     * @param storage The storage to allow reading and storing of tasks from and to a txt file.
     * @return
     */
    public String execute(TaskList tasks, Ui ui, Storage storage, TaskList deletedTasks, 
                            String exCommand) throws DukeException, EmptyException  {
        throw new DukeException("OOPS!!! I'm sorry, but I don't know what that means.");
    }

}


