package commands;

import exceptions.DukeDateTimeError;
import exceptions.DukeTaskInputException;
import storage.Storage;
import taskclasses.TaskList;
import ui.Ui;

public abstract class Command {

    Command() {

    }

    /**
     * The method to execute command
     *
     * @param taskList contain all the task
     * @param ui Ui class
     * @param storage Storage class
     * @throws DukeTaskInputException throw all errors about input command
     * @throws DukeDateTimeError throw all errors about date and time
     */
    public abstract String execute(TaskList taskList, Ui ui, Storage storage)
            throws DukeDateTimeError, DukeTaskInputException;

    /**
     * The method to let system know whether the command is to exit the Duke
     *
     * @return false / true. False means program continue. True means this command is used to exit Duke program
     */
    public abstract boolean isExit();
}
