package commands;

import storage.Storage;
import taskclasses.TaskList;
import ui.Ui;

public class ListCommand extends Command {

    public ListCommand() {

    }

    /**
     * The method to execute command
     *
     * @param taskList contain all the task
     * @param ui Ui class
     * @param storage Storage class
     */
    @Override
    public String execute(TaskList taskList, Ui ui, Storage storage) {
        String echoInfo = "";

        //For GUI type
        echoInfo = taskList.toPrintEntireTaskListGui();

        return echoInfo;
    }

    /**
     * The method to let system know whether the command is to exit the Duke
     * @return return false, the program continue
     */
    @Override
    public boolean isExit() {
        return false;
    }
}
