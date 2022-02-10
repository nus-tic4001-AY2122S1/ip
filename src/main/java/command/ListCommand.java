package command;

import exception.DukeException;
import basic.Storage;
import basic.TaskList;
import basic.Ui;


/**
 * Lists all tasks in the task list to the user.
 */
public class ListCommand extends Command {
    protected static Ui ui = new Ui();

    /**
     * Executes ListCommand.
     *  @param tasks   The tasks stored in an ArrayList.
     * @param ui      The User Interface (UI).
     * @param storage The storage to allow reading and storing of tasks from and to a txt file.
     * @return
     */
    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage, TaskList deletedTasks, 
                            String exCommand) throws DukeException {
        if (tasks.sizeOfTask() == 0) {
            throw new DukeException("☹ The list is empty.");
        }
        return ui.printTasks(tasks);
    }

}
