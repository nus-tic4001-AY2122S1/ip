package commands;

import java.util.Vector;

import exceptions.DukeTaskInputException;
import storage.Storage;
import taskclasses.Task;
import taskclasses.TaskList;
import ui.Ui;

public class FindCommand extends Command {

    private String keyword;

    /**
     * To initialize FindCommand
     *
     * @param keyword the keyword for find to search in the task list
     */
    public FindCommand (String keyword) {
        this.keyword = keyword;
    }

    /**
     * The method to execute command
     *
     * @param taskList contain all the task
     * @param ui Ui class
     * @param storage Storage class
     * @throws DukeTaskInputException throw all errors about input command
     */
    @Override
    public String execute(TaskList taskList, Ui ui, Storage storage) throws DukeTaskInputException {

        Vector<Task> list = taskList.getVectorList();
        Vector<Task> matchedTaskList = getMatchedTasks(list);

        String echoInfo = "";

        echoInfo = TaskList.toPrintEntireTaskList(matchedTaskList); // print all the matched task

        return echoInfo;

    }

    /**
     * The method to let system know whether the command is to exit the Duke
     * @return return false, the program continue
     */
    @Override
    public boolean isExit() {
        return false;
    }

    /**
     * The method to extract all the matched task in the taskList
     *
     * @param list the task list which contain all the tasks
     * @return the matched task(s)
     */
    private Vector<Task> getMatchedTasks (Vector<Task> list) {
        Vector<Task> matchedTaskList = new Vector<>();
        for (Task task: list) {
            String description = task.getDescription().toLowerCase();

            if (description.contains(keyword)) {
                matchedTaskList.add(task);
            }
        }

        return matchedTaskList;
    }
}
