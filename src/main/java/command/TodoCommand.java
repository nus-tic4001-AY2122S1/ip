package command;

import exception.ErrorHandler;
import storage.Storage;
import task.Todo;
import taskList.TaskList;
import ui.Ui;

public class TodoCommand extends Command{
    private String taskDescription;
    private boolean status;

    public TodoCommand(String taskDescription, boolean status)  {
        this.taskDescription = taskDescription;
        this.status = status;
    }

    @Override
    public void execute(Storage storage, Ui ui, TaskList taskList) throws ErrorHandler {
        Todo addedTodo = new Todo(this.taskDescription, this.status);
        taskList.addItem(addedTodo);

        this.saveData(storage, taskList);
        ui.printTask(addedTodo.toString(), taskList.getSize());
    }
}
