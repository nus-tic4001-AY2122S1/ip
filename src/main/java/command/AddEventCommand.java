package command;

import exception.EmptyException;
import basic.Storage;
import basic.TaskList;
import basic.Ui;
import task.Event;

/**
 * Adds an event task to the task list.
 */
public class AddEventCommand extends Command {
    private String input;

    public AddEventCommand(String input) {
        this.input = input;
    }

    /**
     * Executes AddEventCommand.
     *
     * @param tasks   The tasks stored in an ArrayList.
     * @param ui      The User Interface (UI).
     * @param storage The storage to allow reading and storing of tasks from and to a txt file.
     * @throws EmptyException If an empty description is inputted.
     * @return
     */
    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage, TaskList deletedTasks, 
                            String exCommand) throws EmptyException {
        int position;
        input = input.toLowerCase();

        if (input.contains("event")) {
            input = input.replace("event", "");
        } else {
            input = input.replaceFirst("e", "");
        }
        if (input.contains("/at")) {
            position = input.indexOf("/at");
        } else {
            position = -1;
        }

        boolean isInputEmpty = input.substring(0, position - 1).equals("");
        boolean isInputEmptySpace = input.substring(0, position - 2).equals(" ");
        // Add task if command contains "/by" and descriptions
        if (position != -1 && (!isInputEmpty || !isInputEmptySpace)) {
            String date = input.substring(position + 4);
            input = input.substring(0, position - 1);
            Event event = new Event(input, date);
            tasks.addTask(event);
            return ui.printTaskNum(tasks, event);
        } else {
            throw new EmptyException("an event");
        }
    }

}


