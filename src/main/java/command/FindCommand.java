package command;

import exception.DukeException;
import storage.Storage;
import task.Task;
import task.TaskList;
import ui.Ui;

import java.util.ArrayList;

public class FindCommand extends Command {
    String search_str;
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        ArrayList<Task> search_res = tasks.find(search_str);
        ui.printFindResultsMsg(search_res);
    }

    public FindCommand(String search_str) {
        this.search_str = search_str;
    }
}
