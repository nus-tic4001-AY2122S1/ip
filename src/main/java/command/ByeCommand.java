package command;

import exception.ErrorHandler;
import storage.Storage;
import taskList.TaskList;
import ui.Ui;

public class ByeCommand extends Command{
    @Override
    public void execute(Storage storage, Ui ui, TaskList taskList) throws ErrorHandler {
        try{
            this.saveData(storage, taskList);
            this.isExit = true;
            ui.bye();
        } catch (ErrorHandler e) {
            throw new ErrorHandler("while exiting program: " + e.getMessage());
        }
    }
}
