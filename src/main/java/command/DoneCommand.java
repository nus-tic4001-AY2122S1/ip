package command;

import storage.Storage;
import tasklist.TaskList;
import ui.UI;

public class DoneCommand extends Command{
    String userInput;

    public DoneCommand(String userInput) {
        this.userInput = userInput;
    }

    @Override
    public String execute(TaskList tasks, UI ui, Storage storage) {
        return tasks.markedAsDone(userInput);
    }
}
