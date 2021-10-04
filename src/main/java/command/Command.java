package command;

import storage.Storage;
import ui.Ui;
import taskList.TaskList;
import exception.ErrorHandler;

public abstract class Command {
    protected boolean isExit = false;

    /**
     * @return boolean to decide whether the program should be terminated
     */
    public boolean getIsExit() {return this.isExit;}

    protected void saveData(Storage storage, TaskList taskList) throws ErrorHandler {
        String [] data = taskList.getFileDataFormatList();
        storage.saveData(data);
    }

    public abstract void execute ( Storage storage, Ui ui, TaskList taskList) throws ErrorHandler;
}
