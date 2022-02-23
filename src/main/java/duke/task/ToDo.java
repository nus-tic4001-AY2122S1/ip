package duke.task;

public class ToDo extends Task {
    public ToDo(String thingsToDo) {
        super(thingsToDo);
    }

    @Override
    public String toString() {
        return "[TD]" + super.toString();
    }
}
