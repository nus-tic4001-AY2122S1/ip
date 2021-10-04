package command;

import exception.ErrorHandler;
import storage.Storage;
import task.Deadline;
import taskList.TaskList;
import ui.Ui;

public class DeadlineCommand extends Command{
    private String taskDescription;
    private String by;
    boolean status;

    public DeadlineCommand(String taskDescription, String by, boolean status)  {
        this.taskDescription = taskDescription;
        this.by = by;
        this.status = status;
    }

    @Override
    public void execute(Storage storage, Ui ui, TaskList taskList) throws ErrorHandler {
        Deadline addedTodo = new Deadline(this.taskDescription, this.by, this.status);
        taskList.addItem(addedTodo);

        this.saveData(storage, taskList);
        ui.printTask(addedTodo.toString(), taskList.getSize());
    }
}
