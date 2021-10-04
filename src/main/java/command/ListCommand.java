package command;

import storage.Storage;
import taskList.TaskList;
import ui.Ui;

public class ListCommand extends Command{
    @Override
    public void execute(Storage storage, Ui ui, TaskList taskList)  {
        ui.printList(taskList.getSerializedList());
    }
}
