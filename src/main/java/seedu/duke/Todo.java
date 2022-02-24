package seedu.duke;

public class Todo extends Task {
    public Todo(String description) throws DukeException {
        super(description);
    }

    public String update(String description) {
        this.description = description;
        return toString();
    }

    @Override
    public String toString() {
        return "[T]" + "[" + super.getStatusIcon() + "] " + super.description;
    }

    @Override
    public String getType() {
        return "T";
    }

    @Override
    public String toSave() {
        return getType() + " | " + (super.isDone ? "1" : "0") + " | " + super.description;
    }
}
