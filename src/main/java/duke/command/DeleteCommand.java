package duke.command;

import duke.dukeexception.DukeException;
import duke.storage.Storage;
import duke.task.TaskList;
import duke.ui.Ui;

/**
 * Command to delete a task
 */
public class DeleteCommand extends Command {


    /**
     * Constructs the delete command
     * @param commandInstruction will store the command that the user input
     */
    public DeleteCommand(String commandInstruction) {
        super(commandInstruction);
    }

    /**
     * Execute the removal of Task in the task list
     * @param tasks The task list will store the task
     * @param ui The Ui class which will help to display to the user
     * @param storage The Storage which will save the list of task to
     * @throws DukeException Any expected error
     */
    public CommandResult execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        if (tasks.getSize() <= 0) {
            throw new DukeException("Empty task list. Nothing to delete");
        }
        try {
            commandInstruction.substring(7);
        } catch (StringIndexOutOfBoundsException e) {
            throw new DukeException("Delete command can't be empty");
        }
        try {
            int taskIndex = Integer.parseInt(commandInstruction.substring(7)) - 1;
            String deletedTask = tasks.getTask(taskIndex).toString();
            tasks.remove(taskIndex);
            String deleteMsg = ui.displayDeleteMsg(deletedTask, tasks.getSize());
            storage.save(tasks);
            return new CommandResult(deleteMsg);
        } catch (NumberFormatException e) {
            throw new DukeException("Please key in task number");
        } catch (IndexOutOfBoundsException e) {
            throw new DukeException("Please key in task number that is in the list");
        }
    }


}
