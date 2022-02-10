package command;

import exception.DukeException;
import basic.Storage;
import basic.TaskList;
import basic.Ui;

/**
 * Marks a task identified using it's index as done.
 */
public class MarkAsDoneCommand extends Command {
    protected static Ui ui = new Ui();
    private String input;

    public MarkAsDoneCommand(String input) {
        this.input = input;
    }

    /**
     * Executes MarkAsDoneCommand.
     *  @param tasks   The tasks stored in an ArrayList.
     * @param ui      The User Interface (UI).
     * @param storage The storage to allow reading and storing of tasks from and to a txt file.
     * @return
     */
    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage, TaskList deletedTasks, 
                            String exCommand) throws DukeException {
        String editedInput = input.toLowerCase().replace("done ", "");
        assert editedInput.replaceAll("[\\D]", "").equals(editedInput) : "wrong format key in numeric number instead";
        int num = 0;
        //replacing all the non digit elements
        num = Integer.parseInt(input.replaceAll("[\\D]", ""));
        if (num > 0 && num <= tasks.sizeOfTask()) {
            tasks.returnTask(num - 1).isDone = true;
            return ui.showDone(tasks.returnTask(num - 1));
        } else {
            throw new DukeException("☹ Item not found.");
        }
    }

}
