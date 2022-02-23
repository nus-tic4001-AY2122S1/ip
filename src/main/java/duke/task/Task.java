package duke.task;

public abstract class Task {
    protected String description;
    protected boolean done;

    public Task(String description) {
        this.description = description;
        this.done = false;
    }

    public String getStatus() {
        return (done ? "X" : " ");
    }

    public void markAsDone() {
        done = true;
    }

    public String getTask() {
        return description;
    }

    public String toString() {
        return " [" + this.getStatus() + "] " + this.getTask();
    }

}