package ip.duke;

import ip.duke.task.Task;

/**
 * Todo.java - a simple class for todo objects.
 * A subclass of Task
 *
 * @author Alvin Gwee
 * @version 1.0
 * @see Task
 */
public class Todo extends Task {
    /**
     * Constructor for class Todo
     * for a Todo object.
     *
     * @param description - A String value for task description.
     */
    public Todo(String description) {
        super(description);
        setId();
    }

    /**
     * Method gives the string representation
     * of the Todo object.
     *
     * @return A String value.
     */
    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setId() {
        this.id = 'T';
    }

    @Override
    public String toFileString() {
        return "T" + " # " + (isDone ? "1" : "0") + " # " + getDescription();
    }
}
