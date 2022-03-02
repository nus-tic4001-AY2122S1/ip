package duke.command;

import duke.exception.NumArgsException;
import duke.parse.StringParser;
import duke.storage.TempTaskList;
import duke.task.Task;
import duke.task.Todo;
import duke.ui.Message;

public class TodoCreationCmd implements UndoableCommand {
    // Task is a Receiver Class in this Command
    private TempTaskList list;
    private Task task;

    public TodoCreationCmd(TempTaskList list) {
        this.list = list;
    }

    @Override
    public void run(String[] args) {
        String arg = StringParser.join(args);
        if (args.length == 0) {
            try {
                throw new NumArgsException();
            } catch (NumArgsException e) {
                Message.setBuffer(e.getMessage());
            }
        } else {
            list.add(new Todo(arg));
            Message.taskAdd(list);
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
