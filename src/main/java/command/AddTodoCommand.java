package command;

import exception.EmptyException;
import basic.Storage;
import basic.TaskList;
import basic.Ui;
import task.Todo;

/**
 * Adds a todo task to the task list.
 */
public class AddTodoCommand extends Command {
    protected static Ui ui = new Ui();
    private String input;

    public AddTodoCommand(String input) {
        this.input = input;
    }

    /**
     * Executes AddTodoCommand.
     *
     * @param tasks   The tasks stored in an ArrayList.
     * @param ui      The User Interface (UI).
     * @param storage The storage to allow reading and storing of tasks from and to a txt file.
     * @throws EmptyException If an empty description is inputted.
     * @return
     */
    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage, TaskList deletedTasks, 
                            String exCommand) throws EmptyException  {
        input = input.toLowerCase();
        if (input.contains("todo")) {
            input = input.replace("todo", "");
        }
        if (!input.equals("") && !input.equals(" ")) {
            Todo todo = new Todo(input);
            tasks.addTask(todo);
            return ui.printTaskNum(tasks, todo);
        } else {
            throw new EmptyException("a todo");
        }
    }

}