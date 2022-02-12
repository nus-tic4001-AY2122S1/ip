package duke.command;

import duke.Parser;
import duke.TaskList;
import duke.UI;
import duke.exception.LackOfIndexException;
import duke.task.Task;

public class DeleteCommand extends Command {
    /**
     * Create new delete command.
     * @param fullCommand user full command.
     * */
    public DeleteCommand(String fullCommand) {
        super(fullCommand);
    }

    private static void checkElement(String fullCommand) throws LackOfIndexException {
        if (fullCommand.trim().equals("delete")) {
            throw new LackOfIndexException();
        }
    }

    /**
     * Method to execute delete command.
     * @param taskList task list to be updated
     * */
    public void run(TaskList taskList) {
        try {
            checkElement(fullCommand);
            int index = Parser.taskNumber(fullCommand);
            Task deletedTask = taskList.tasks.get(index);
            taskList.delete(index);
            UI.deleteMessage(deletedTask, taskList.size);
        } catch (LackOfIndexException e) {
            System.out.println("OOPS!!! Pls key in the number of the task");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("OOPS!!! The number of task is invalid");
        }
    }
}
