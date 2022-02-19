package command;

import storage.Storage;
import tasklist.TaskList;
import ui.UI;

import java.text.ParseException;

public class FindCommand extends Command{
    String userInput;

    public FindCommand(String userInput) {
        this.userInput = userInput;
    }

    @Override
    public String execute(TaskList tasks, UI ui, Storage storage) throws ParseException {
        return tasks.searchDate(userInput);
    }
}
