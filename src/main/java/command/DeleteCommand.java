package command;

import constant.ErrorMessage;
import exception.ErrorHandler;
import storage.Storage;
import taskList.TaskList;
import ui.Ui;

public class DeleteCommand extends Command{
    private int taskNumber;

    public DeleteCommand(String taskNumber) throws ErrorHandler{
        try {
            int index = Integer.parseInt(taskNumber);
            this.taskNumber = index;
        } catch (Exception e) {
            throw new ErrorHandler("while parsing task number :" + e.getMessage());
        }
    }

    @Override
    public void execute(Storage storage, Ui ui, TaskList taskList) throws ErrorHandler {
        if(this.taskNumber > 0 && this.taskNumber <= taskList.getSize()) {
            int deleteIndex = this.taskNumber-1;
            String deletedItem = taskList.getTask(deleteIndex).toString();
            taskList.removeItem(deleteIndex);
            this.saveData(storage, taskList);
            ui.printDeletedItem(deletedItem, taskList.getSize());
        } else {
            throw new ErrorHandler("In Command, " + ErrorMessage.INVALID_TASK_NUMBER);
        }
    }
}
