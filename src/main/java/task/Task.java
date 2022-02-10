package task;

/**
 * Represents a Task.
 */
public abstract class Task {
    public String description;
    public boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    private String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2717"); //return tick or X symbols
    }

    /**
     * Returns a formatted task.
     */
    public String toString() {
        return "[" + getStatusIcon() + "]" + description;
    }
}