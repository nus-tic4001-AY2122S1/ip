package duke.command;

import duke.storage.Storage;
import duke.task.TaskList;
import duke.ui.Ui;

public class ListCommand extends Command {

    /**
     * Prints current list of Tasks.
     * @param tasks     The current list of tasks
     * @param ui        Reference to the current UI
     * @param storage   Reference to current storage object we use to save/load from text file.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        String s = tasks.printTasks();
        if(s.isEmpty()){
            System.out.println("No Tasks found!");
        }
    }
}
