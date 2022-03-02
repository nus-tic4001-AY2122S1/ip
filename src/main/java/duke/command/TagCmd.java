package duke.command;

import duke.storage.TempTaskList;
import duke.ui.Message;

public class TagCmd implements Command {
    private TempTaskList list;

    public TagCmd (TempTaskList list) {
        this.list = list;
    }

    @Override
    public void run(String[] args) {
        try {
            int index = Integer.parseInt(args[0]) - 1;
            for (int i = 1; i < args.length; i++) {
                list.tagAt(index, args[i].toLowerCase());
            }
            Message.taskTagged(list, index);
        } catch (Exception e) {
            Message.setBuffer(Message.exceptionInvalidArgs());
        }
    }
}
