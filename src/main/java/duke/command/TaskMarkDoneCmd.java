package duke.command;

import duke.storage.TempTaskList;
import duke.task.Task;
import duke.ui.Message;

/**
 * A Concrete Command in Command Pattern
 */
public class TaskMarkDoneCmd implements UndoableCommand {
    // Task is a Receiver Class in this Command
    private TempTaskList list;
    private Task task;

    public TaskMarkDoneCmd(TempTaskList list) {
        this.list = list;
    }

    @Override
    public void run(String[] args) {
        // list.stream().filter(e -> e)
        for (String arg : args) {
            try {
                int index = Integer.parseInt(arg) - 1;
                list.markDoneAt(index);
                Message.taskDone(list, index);
            } catch (Exception e) {
                Message.setBuffer(Message.exceptionInvalidArgs());
            }
        }
    }

    @Override
    public void undo() {
        task.markUnDone();
    }

    @Override
    public void redo() {

    }
}
