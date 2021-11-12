package task;

public abstract class Task {
    protected String description;
    protected boolean Done;

    public Task(String description) {
        this.description = description;
        this.Done = false;
    }

    public String getStatus() {
        return (Done ? "X" : " ");
    }

    public void markAsDone(){
        Done = true;
    }

    public String getTask(){
        return description;
    }

    public String toString() {
        return " [" + this.getStatus() + "] " + this.getTask();
    }

}