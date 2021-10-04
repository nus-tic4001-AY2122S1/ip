package task;

public class Deadline extends Task{
    protected String by;

    public Deadline(String description, String by, boolean status) {
        super(description);
        this.by = by;
        this.setStatus(status);
    }

    @Override
    public String toString() {
        return "[D]" + "[" + this.getStatusIcon() + "] " + this.description + " (by: " + by + ")";
    }

    @Override
    public String toDataFormat() {
        String status = this.isDone ? "1" : "0";
        return "D"+ "|" + status + "|" + this.description + "|" +this.by;
    }
}
