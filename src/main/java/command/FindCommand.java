package command;

import storage.Storage;
import taskList.TaskList;
import ui.Ui;

import java.util.ArrayList;

public class FindCommand extends Command{
    private String searchContent;

    public FindCommand(String searchContent)  {
        this.searchContent = searchContent;
    }

    @Override
    public void execute(Storage storage, Ui ui, TaskList taskList)  {
        ArrayList<String> filteredList = taskList.findTasks(this.searchContent);
        ui.printFoundList(filteredList);
    }
}
