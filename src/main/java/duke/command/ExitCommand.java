package duke.command;

import duke.storage.Storage;
import duke.task.TaskList;
import duke.ui.Ui;


/**
 * Command to exit the program
 */
public class ExitCommand extends Command {

    /**
     * Constructs the bye and exit command
     */
    public ExitCommand() {
        super();
    }

    /**
     * Access the UI to show the exit message
     * @param tasks The task list will store the task
     * @param ui The Ui class which will help to display to the user
     * @param storage The Storage which will save the list of task to
     */
    public CommandResult execute(TaskList tasks, Ui ui, Storage storage) {

        return new CommandResult(ui.showExit(), Boolean.TRUE);
    }

    /**
     * Return the boolean true for it to exit the while loop
     * @return true
     */
    @Override
    public boolean isExit() {
        return true;
    }
}
