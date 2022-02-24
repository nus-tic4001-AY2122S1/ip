package seedu.duke;

public class Deadline extends Task {
    protected String date;

    public Deadline(String description, String date) throws DukeException {
        super(description);
        this.date = date;
    }

    public String update(String description, String date) {
        this.description = description;
        this.date = date;
        return toString();
    }

    @Override
    public String toString() {
        return "[D]" + "[" + super.getStatusIcon() + "] " + super.description + " (by: " + date + ")";
    }

    @Override
    public String getType() {
        return "D";
    }

    @Override
    public String toSave() {
        return getType() + " | " + (super.isDone ? "1" : "0") + " | " + super.description + " | " + date;
    }
}
