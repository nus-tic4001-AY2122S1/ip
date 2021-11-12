package duke.command;

import java.util.ArrayList;
import duke.task.Task;


/**
 * Deletes a task identified using it's index from the task list.
 */

public class DeleteCommand {
    private final int taskIndex;

    public DeleteCommand(String taskNumber) {
        this.taskIndex = this.parseTaskNumberToIndex(taskNumber);
        //Task.remove(taskIndex);
    }


    protected int parseTaskNumberToIndex(String taskNumber) {
        try {
            return Integer.parseInt(taskNumber) - 1;
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return 0;
    }
}


