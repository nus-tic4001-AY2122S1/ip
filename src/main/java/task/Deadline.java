package task;

public class Deadline extends Task {
    protected String taskDate;

    public Deadline(String description, String Date) {
        super(description);
        this.taskDate = Date;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + taskDate + ")";
    }
}
