package duke.task;

/**
 * The task class to store all the class
 */
public abstract class Task {
    protected String description;
    protected boolean isDone;
    protected TaskType taskType;
    protected int taskIndex;

    /**
     * Constructs the task class to store the task the user requested
     * @param description
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Return a Tick or X symbols
     * @return a Tick or X symbols
     */
    public String getStatusIcon() {
        return (isDone ? "X" : " "); // mark done task with X
    }

    /**
     * Edit the status of the task
     * @param isDone the new status of the task
     */
    public void editDone(Boolean isDone) {
        this.isDone = isDone;
    }

    /**
     * Return the task done status
     * @return the task done status
     */
    public boolean getIsDone() {
        return isDone;
    }

    /**
     * Set the task Index
     * @param i The task index of the task
     */
    public void setTaskIndex(int i) {
        taskIndex = i;
    }

    /**
     * Return the task index of the task
     * @return the task index
     */
    public int getTaskIndex() {
        return taskIndex;
    }


    /**
     * Return the task that the user set
     * @return the task that was store
     */
    public String getTaskDescription() {
        return description;
    }

    /**
     * Convert the task description with the done status icon
     * @return the task description with the done status icon
     */
    public String toString() {
        return " [" + this.getStatusIcon() + "] " + this.getTaskDescription();
    }

    /**
     * return the task type
     * @return the task type
     */
    public TaskType getTaskType() {
        return taskType;
    }

}
