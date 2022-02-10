package task;

/**
 * Represents a Todo task.
*/
public class Todo extends Task {
    public Todo(String description) {
        super(description);
    }

    /**
     * Returns a formatted Todo task.
     */
    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

}