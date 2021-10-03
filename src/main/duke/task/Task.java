package duke.task;

import duke.exception.DukeMissingDescException;

/**
 * Abstract Task class cannot be directly instantiated, only subclasses can.
 */
public abstract class Task {
    protected boolean isDone;
    protected String description;
    public static final char CHECKMARK = '\u2713', CROSSMARK = '\u274C';

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Task(String description) throws DukeMissingDescException {
        setDescription(description);
        if(description.isEmpty() || description.isBlank())
            throw new DukeMissingDescException(getClass().getSimpleName().toLowerCase());
        setDone(false);
    }

    @Override
    public String toString() {
        return String.format("[%s] %s", (isDone) ? CHECKMARK : CROSSMARK, getDescription());
    }
}
