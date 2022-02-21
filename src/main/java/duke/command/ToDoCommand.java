package duke.command;

import java.util.ArrayList;

import duke.dukeexception.DukeException;
import duke.storage.Storage;
import duke.task.Task;
import duke.task.TaskList;
import duke.task.TaskType;
import duke.task.ToDo;
import duke.ui.Ui;



/**
 * Command to Create a new ToDos task
 */
public class ToDoCommand extends Command {

    /**
     * Constructs the ToDo Command
     * @param taskDes the command the user input
     */
    public ToDoCommand(String taskDes) {
        super(taskDes);
    }


    /**
     * Execute the ToDo command to create the ToDos task
     * @param tasks the task list
     * @param ui the Ui
     * @param storage the Storage
     * @throws DukeException any expected error
     */
    public CommandResult execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        try {
            commandInstruction.substring(5);
        } catch (StringIndexOutOfBoundsException e) {
            throw new DukeException("Todo command can't be empty");
        }
        String taskDes = commandInstruction.substring(5);
        ToDo todo = new ToDo(taskDes);
        //Checking whether the task has been created as a ToDo before adding and saving
        assert todo.getTaskType() == TaskType.TODO;
        tasks.addTask(todo);
        CommandResult commandResult = duplicateDetector(taskDes, tasks, todo);
        storage.save(tasks);
        return commandResult;
    }

    private CommandResult duplicateDetector(String taskDes, TaskList tasks, Task task) {
        ArrayList<Task> tempTasksList = new ArrayList<>();
        for (int i = 0; i < tasks.getSize() - 1; i++) {
            Task currentTasksClass = tasks.getTask(i);
            String theStringTask = currentTasksClass.getTaskDescription();
            if (theStringTask.equalsIgnoreCase(taskDes)) {
                tempTasksList.add(currentTasksClass);
            }
        }
        if (tempTasksList.size() == 0) {
            return new CommandResult(Ui.displayAddMessage(task.toString(), tasks.getSize()));
        } else {
            String duplicate = Ui.displayDuplicateAddMessage(task.toString(),
                    tasks.getSize(), tempTasksList.size());
            for (int i = 0; i < tempTasksList.size(); i++) {
                duplicate += Ui.showTaskInfo(tempTasksList.get(i)) + "\n";
            }
            return new CommandResult(duplicate);
        }

    }


}
