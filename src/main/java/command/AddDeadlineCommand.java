package command;

import storage.Storage;
import tasklist.TaskList;
import ui.UI;

public class AddDeadlineCommand extends Command{
    String userInput;

    public AddDeadlineCommand(String userInput) {
        this.userInput = userInput;
    }

    @Override
    public String execute(TaskList tasks, UI ui, Storage storage) {
        return tasks.deadline(userInput);
    }
}
