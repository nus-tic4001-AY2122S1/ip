package task;

public class Event extends Task {

    protected String taskDate;

    public Event(String description, String taskDate) {
        super(description);
        this.taskDate = taskDate;
    }

    @Override
    public String toString() {
        return "[X]" + super.toString() + " (@: " + taskDate + ")";
    }
}
