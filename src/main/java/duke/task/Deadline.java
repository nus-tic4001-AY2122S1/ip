package duke.task;

public class Deadline extends Task {
    protected String taskdate;

    public Deadline(String description, String date) {
        super(description);
        this.taskdate = date;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + taskdate + ")";
    }
}
