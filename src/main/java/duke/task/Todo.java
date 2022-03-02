package duke.task;

/**
 *  Todo is a Task with title only
 */
public class Todo extends Task {
    public Todo(String title) {
        super(title);
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

}

