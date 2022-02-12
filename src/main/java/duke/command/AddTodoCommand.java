package duke.command;

import duke.Parser;
import duke.TaskList;
import duke.UI;
import duke.exception.LackOfDescriptionException;

public class AddTodoCommand extends Command {
    /**
     * Create new add-todo command.
     * @param fullCommand user full command.
     * */
    public AddTodoCommand(String fullCommand) {
        super(fullCommand);
    }

    private static void checkDescription(String fullCommand) throws LackOfDescriptionException {
        if (fullCommand.trim().equals("todo")) {
            throw new LackOfDescriptionException();
        }
    }

    /**
     * Method to execute add-todo command.
     * @param taskList task list to be updated.
     * */
    public void run(TaskList taskList) {
        try {
            checkDescription(fullCommand);
            String description = Parser.description(fullCommand);
            taskList.addTodo(description);
            int size = taskList.size;
            UI.addMessage(taskList.tasks.get(size - 1), size);
        } catch (LackOfDescriptionException e) {
            System.out.println("OOPS!!! Pls key in the description for the task");
        }
    }
}
