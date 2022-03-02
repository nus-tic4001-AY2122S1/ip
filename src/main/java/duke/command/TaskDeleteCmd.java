package duke.command;

import java.util.ArrayList;
import java.util.Comparator;

import duke.storage.TempTaskList;
import duke.task.Task;
import duke.ui.Message;

public class TaskDeleteCmd implements UndoableCommand {
    // Task is a Receiver Class in this Command
    private TempTaskList list;
    private Task task;

    public TaskDeleteCmd(TempTaskList list) {
        this.list = list;
    }

    @Override
    public void run(String[] args) {
        // list.stream().filter(e -> e)
        ArrayList<Integer> indexes = new ArrayList<>();
        ArrayList<String> deletedTasks = new ArrayList<>();

        for (String arg : args) {
            int index = Integer.parseInt(arg) - 1;
            indexes.add(index);
        }

        indexes.sort(Comparator.reverseOrder());

        for (Integer index : indexes) {
            try {
                task = list.get(index);
                deletedTasks.add(0, task.toString());
                list.removeAt(index);
            } catch (Exception e) {
                Message.setBuffer(Message.exceptionInvalidArgs());
            }
        }
        Message.taskDelete(deletedTasks);
        list.tellStats();
    }

    @Override
    public void undo() {
        task.markUnDone();
    }

    @Override
    public void redo() {

    }
}
