package ip.duke;

/**
 * Event.java - a simple class for event objects.
 * A subclass of Deadline
 *
 * @author Alvin Gwee
 * @version 1.0
 * @see Deadline
 */
public class Event extends Deadline {
    public Event(String description, String at) {
        super(description, at);
    }

    @Override
    public void setId() {
        this.id = 'E';
    }

    /**
     * Method gives the string representation
     * of the Event object.
     *
     * @return A String value.
     */
    @Override
    public String toString() {
        return String.format("%s (at: %s)", getDescription(), getBy());
    }

    @Override
    public String toFileString() {
        return super.toFileString().replaceFirst("D", "E");
    }
}
