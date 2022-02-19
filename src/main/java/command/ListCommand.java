package command;

import ui.UI;
import storage.Storage;
import tasklist.TaskList;


public class ListCommand extends Command {

    @Override
    public String execute(TaskList tasks, UI ui, Storage storage) {
        return tasks.list();
    }
}
