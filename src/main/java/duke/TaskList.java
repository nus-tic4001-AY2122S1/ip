package duke;

import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.Todo;

import java.util.ArrayList;
import java.util.Date;

/**
 * Stores all tasks.
 * */
public class TaskList {
    public ArrayList<Task> tasks;
    public int size;

    /**
     * Creation of new TaskList.
     * @param tasks list to store all tasks.
     * */
    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
        this.size = tasks.size();
    }

    /**
     * Method to mark task as done.
     * @param index task index.
     * */
    public void done(int index) {
        tasks.get(index).markAsDone();
    }

    /**
     * Method to add Todo.
     * @param description task description.
     * */
    public void addTodo(String description) {
        Task task = new Todo(description);
        tasks.add(task);
        size++;
    }

    /**
     * Method to deal with add Deadline.
     * @param description task description.
     * @param date task date.
     * */
    public void addDeadline(String description, String date, Date by) {
        Task task = new Deadline(description, date, by);
        tasks.add(task);
        size++;
    }

    /**
     * Method to deal with add Event.
     * @param description task description.
     * @param date task date.
     * */
    public void addEvent(String description, String date, Date at) {
        Task task = new Event(description, date, at);
        tasks.add(task);
        size++;
    }

    /**
     * Method to deal with delete.
     * @param index task index.
     * */
    public void delete(int index) {
        tasks.remove(index);
        size--;
    }

    /**
     * Method to deal with find.
     * @param keyword keyword user want to find.
     * @param findResult list stores all the indexes of matched tasks.
     * */
    public void find(String keyword, ArrayList<Integer> findResult) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).toString().contains(keyword)) {
                findResult.add(i);
            }
        }
    }
}
