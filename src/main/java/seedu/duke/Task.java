package seedu.duke;

public abstract class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) throws DukeException {
        if (description.isEmpty() || description.isBlank()) {
            throw new DukeException("\t☹ OOPS!!! The description of a todo cannot be empty.");
        } else {
            this.description = description;
            this.isDone = false;
        }
    }

    public String getStatusIcon() {
        return (isDone ? "X" : " "); // mark done task with X
    }

    public void markAsDone() {
        isDone = true;
    }

    public abstract String toString();
    public abstract String getType();
    public abstract String toSave();
}
