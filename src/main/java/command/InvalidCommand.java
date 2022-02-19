package command;

import storage.Storage;
import tasklist.TaskList;
import ui.UI;

public class InvalidCommand extends Command{
    String userInput;

    public InvalidCommand(String userInput) {
        this.userInput = userInput;
    }

    @Override
    public String execute(TaskList tasks, UI ui, Storage storage) {
        return tasks.processInvalidTask(userInput);
    }
}
