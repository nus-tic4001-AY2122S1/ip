package duke.command;

import java.time.format.DateTimeParseException;

import duke.exception.NoDateException;
import duke.exception.NumArgsException;
import duke.parse.StringParser;
import duke.storage.TempTaskList;
import duke.task.Deadline;
import duke.task.Task;
import duke.ui.Message;

/**
 * As a command, run() with arguments to
 * create a new deadline task
 */
public class DlCreationCmd implements UndoableCommand {
    // Task is a Receiver Class in this Command
    private TempTaskList list;
    private Task task;

    public DlCreationCmd(TempTaskList list) {
        this.list = list;
    }

    @Override
    public void run(String[] args) {
        String arg = StringParser.join(args);

        String[] parts = arg.split("/by");

        if (args.length == 0 || args.length == 1) {
            try {
                throw new NumArgsException();
            } catch (NumArgsException e) {
                Message.setBuffer(e.getMessage());
            }
        } else if (parts.length != 2) {
            try {
                throw new NoDateException();
            } catch (NoDateException e) {
                Message.setBuffer(e.getMessage());
            }
        } else {
            try {
                var title = parts[0].strip();
                var by = StringParser.parseDL(parts);
                Deadline dl = new Deadline(title, by);
                list.add(dl);
                Message.taskAdd(list);
            } catch (DateTimeParseException e) {
                Message.setBuffer("Event DateTime Format: /by YYYY-MM-DD HMM");
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
