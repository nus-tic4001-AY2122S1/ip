package duke.command;

import duke.dukeexception.DukeException;
import duke.storage.Storage;
import duke.task.TaskList;
import duke.ui.Ui;

/**
 * Command to show the list of task the user has
 */
public class ListCommand extends Command {

    /**
     * Constructs the list command
     */
    public ListCommand() {

    }

    /**
     * Execute the list command to show all the task the user has
     * @param tasks the task list
     * @param ui the Ui
     * @param storage the Storage
     * @throws DukeException any expected error
     */
    public CommandResult execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        if (tasks.isEmpty()) {
            throw new DukeException("Empty task list");
        }
        String stringList = "";
        for (int i = 0; i < tasks.getSize(); i++) {
            stringList += ui.showTaskInfo(tasks.getTask(i)) + "\n";
        }
        return new CommandResult(stringList);

    }
}
