package command;

import basic.Duke;
import basic.Storage;
import basic.TaskList;
import basic.Ui;
import task.Task;
import exception.DukeException;

/**
 * Undo the most recent create or delete command.
 */
public class UndoCommand extends Command {
    protected static Ui ui = new Ui();

    public UndoCommand() {
    }

    /**
     * Executes DeleteCommand.
     *  @param tasks   The tasks stored in an ArrayList.
     * @param ui      The User Interface (UI).
     * @param storage The storage to allow reading and storing of tasks from and to a txt file.
     */
    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage, TaskList deletedTasks, 
                            String exCommand) throws DukeException {
        if (exCommand.toLowerCase().contains("undo")) {
            throw new DukeException("Cannot undo an 'undo' command.\n");
        } else if (exCommand.toLowerCase().contains("list") || exCommand.toLowerCase().contains("find")) {
            return Duke.getResponse(exCommand);
        } else if (exCommand.toLowerCase().contains("done")) {
            return new MarkAsUndoneCommand(exCommand).execute(tasks, ui, storage, deletedTasks, exCommand);            
        } else if (exCommand.toLowerCase().contains("delete")) {
            Task undoTask = deletedTasks.returnTask(0);
            tasks.addTask(undoTask);
            deletedTasks.deleteTask(0);
            return ui.printTaskNum(tasks, undoTask);
        }  else if (exCommand.toLowerCase().contains("todo") || exCommand.toLowerCase().contains("event") 
                || exCommand.toLowerCase().contains("deadline")) {
            return new DeleteCommand("delete " + String.valueOf(tasks.sizeOfTask()))
                        .execute(tasks, ui, storage, deletedTasks, exCommand);
        } else {
            throw new DukeException("OOPS!!! I'm sorry, but I don't know what that means.");
        }
    }

}
