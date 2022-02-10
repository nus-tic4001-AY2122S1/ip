package basic;

import task.Deadline;
import task.Event;
import task.Task;
import task.Todo;

import java.util.ArrayList;

/**
 * Contains Todo, Deadline and Event tasks
 * Parses each lines in duke.txt into tasks
 */
public class TaskList {
    /**
     * Constructs a new task list and initialises it with an empty ArrayList.
     */
    public ArrayList<Task> tasks = new ArrayList<Task>();

    /**
     * Checks if the task was marked as done.
     *
     * @param myString one task in the txt file
     * @return true if the tasks was marked as done, else return false
     */
    private boolean isDone(String myString) {
        return !myString.toLowerCase().contains("[✘]");
    }

    /**
     * Trims one task to get description.
     *
     * @param s one task in the txt file
     * @return string The description of the task
     */
    private String getDescription(String s) {
        int positionOfDes = s.indexOf("]");
        int startPosition;
        if (s.contains("(")) {
            startPosition = s.indexOf("(");
        } else {
            startPosition = s.length() + 1;
        }
        return s.substring(positionOfDes + 4, startPosition - 1);
    }

    /**
     * Create one Todo task.
     *
     * @param description the description of the task
     */
    private void createTodoTask(String description) {
        Todo oneTask = new Todo(description);
        addTask(oneTask);
    }

    /**
     * Create one Deadline task.
     *
     * @param s the full string of the task
     * @param description the description of the task
     */
    private void createDeadlineTask(String s, String description) {
        int positionOfDate = s.indexOf("by");
        int endPosition = s.indexOf(")");
        String dateString = s.substring(positionOfDate + 4, endPosition);
        Deadline oneTask = new Deadline(description, dateString);
        addTask(oneTask);
    }

    /**
     * Create one Event task.
     *
     * @param s the full string of the task
     * @param description the description of the task
     */
    private void createEventTask(String s, String description) {
        int positionOfDate = s.indexOf("at");
        int endPosition = s.indexOf(")");
        String dateString = s.substring(positionOfDate + 4, endPosition);
        Event oneTask = new Event(description,  dateString);
        addTask(oneTask);
    }

    /**
     * Converts all strings in the txt file to tasks.
     *
     * @param list task list in string form.
     */
    public TaskList(ArrayList<String> list) {
        for (String s : list) {
            String description = getDescription(s);
            if (s.contains("[T]")) {
                createTodoTask(description);
            } else if (s.contains("[D]")) {
                createDeadlineTask(s, description);
            } else {
                createEventTask(s, description);
            }
            if (isDone(s)) {
                returnTask(sizeOfTask() - 1).isDone = true;
            }
        }
    }

    ArrayList<Task> returnList() {
        return tasks;
    }

    /**
     * Returns the task from the specified index from the task list.
     *
     * @param num The index the task.
     * @return Task The task at the specified index.
     */
    public Task returnTask(int num) {
        return tasks.get(num);
    }

    /**
     * Adds a task to the task list.
     *
     * @param task1 The task that is required to be added to the task list.
     */
    public void addTask(Task task1) {        
        tasks.add(task1);
    }

    /**
     * Deletes a task from the task list.
     *
     * @param num The index of a task that is required to be removed from the task list.
     */
    public void deleteTask(int num) {
        tasks.remove(num);
    }

    /**
     * Returns the size of the current task list.
     *
     * @return int  The size of the current task list.
     */
    public int sizeOfTask() {
        return tasks.size();
    }

}
