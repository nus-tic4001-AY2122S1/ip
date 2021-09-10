package tasklist;

public abstract class Task {

    protected String description;
    protected boolean isDone;

    /****
     *
     * @param description the task description that the user input
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /****
     *
     * @param description the task description that the user input
     * @param status check if the task has already marked as done
     */
    public Task(String description, boolean status) {
        this.description = description;
        this.isDone = status;
    }

    public String getStatusIcon() {
        return (isDone ? "X" : " "); // mark done task with X
    }

    public void markAsDone(){
        isDone = true;
        getStatusIcon();
    }

    public String toString() {
        return("[" + this.getStatusIcon() + "] " + description);
    }

    public String saveFormat(){
        if (this.isDone){
            return ("| 1 | " + this.description);
        }
        else {
            return ("| 0 | " + this.description);
        }
    }
}
