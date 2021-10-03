package duke.command;

import duke.exception.DukeException;
import duke.storage.Storage;
import duke.task.Task;
import duke.task.TaskList;
import duke.ui.Ui;

import java.util.ArrayList;

/**
 * Give users a way to find a task by searching for a keyword.
 * refer to Level-9.
 */
public class FindCommand extends Command {
    String search_str;

    /**
     * Goes through the list of tasks, and attempt to find the results.
     * @param tasks     The current list of tasks
     * @param ui        Reference to the current UI
     * @param storage   Reference to current storage object we use to save/load from text file.
     * @throws DukeException
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        ArrayList<Task> search_res = tasks.find(search_str);
        ui.printFindResultsMsg(search_res);
    }

    public FindCommand(String search_str) {
        this.search_str = search_str;
    }
}
