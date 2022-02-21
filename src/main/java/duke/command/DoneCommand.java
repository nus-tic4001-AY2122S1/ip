package duke.command;

import duke.dukeexception.DukeException;
import duke.storage.Storage;
import duke.task.Task;
import duke.task.TaskList;
import duke.ui.Ui;


/**
 * Command set a specific task as done
 */
public class DoneCommand extends Command {


    /**
     * Constructs the Done command
     * @param taskDes the command the user input
     */
    public DoneCommand(String taskDes) {
        super(taskDes);
    }

    /**
     * Set the Task isDone boolean to True
     * @param tasks
     * @param ui
     * @param storage
     * @throws DukeException
     */
    public CommandResult execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        if (tasks.getSize() <= 0) {
            throw new DukeException("Empty task list. Nothing to delete");
        }
        try {
            commandInstruction.substring(5);
        } catch (StringIndexOutOfBoundsException e) {
            throw new DukeException("Done command can't be empty");
        }
        try {
            int taskIndex = Integer.parseInt(commandInstruction.substring(5)) - 1;
            Task doneTask = tasks.getTask(taskIndex);
            if (doneTask.getIsDone()) {
                throw new DukeException("Tasks.Task is already done");
            }
            doneTask.editDone(true);
            String taskString = doneTask.toString();
            int getTaskIndex = doneTask.getTaskIndex() + 1;
            CommandResult commandResult = new CommandResult(Ui.doneMsg(taskString, getTaskIndex));
            storage.save(tasks);
            return commandResult;
        } catch (NumberFormatException e) {
            throw new DukeException("Please key in task number");
        }


    }



}
