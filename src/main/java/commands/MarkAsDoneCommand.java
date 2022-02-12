package commands;

import exceptions.DukeTaskInputException;
import storage.Storage;
import taskclasses.TaskList;
import ui.Ui;

public class MarkAsDoneCommand extends Command {

    private int index;

    /**
     * The method to initialize MarkAsDoneCommand
     *
     * @param index the index of the task in the task list, not in the Task type Vector
     */
    public MarkAsDoneCommand(int index) {
        this.index = index - 1;
    }

    /**
     * The method to execute command
     *
     * @param taskList contain all the task
     * @param ui Ui class
     * @param storage Storage class
     * @throws DukeTaskInputException throw all errors about input command
     */
    @Override
    public String execute(TaskList taskList, Ui ui, Storage storage) throws DukeTaskInputException {

        int taskListSize = taskList.size();

        if (index >= taskListSize || index < 0) {
            throw new DukeTaskInputException("listIsEmpty");
        }

        String echoInfo = "";

        taskList.getTask(index).markAsDone();
        echoInfo = ui.printMarkAsDoneOutput(taskList.getTask(index));

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
