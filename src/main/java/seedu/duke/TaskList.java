package seedu.duke;

import java.util.ArrayList;

public class TaskList {
    private static TaskList taskList = null;
    private static ArrayList<Task> todoList = new ArrayList<>();
    private TaskList() {}

    public static TaskList getInstance() {
        if (taskList == null) {
            taskList = new TaskList();
        }
        return taskList;
    }

    public ArrayList<Task> getList() {
        return todoList;
    }
}
