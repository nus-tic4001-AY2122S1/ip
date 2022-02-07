package ip.duke;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Deadline.java - a simple class for deadline objects.
 * A subclass of Todo
 *
 * @author Alvin Gwee
 * @version 1.0
 * @see Todo
 */
public class Deadline extends Todo {
    private String by;

    public Deadline(String description, String by) {
        super(description);
        try {
            LocalDate date = LocalDate.parse(by, DateTimeFormatter.ofPattern("[yyyy-M-d][yyyy/M/d]"));
            this.by = date.format(DateTimeFormatter.ofPattern("MMM d yyyy"));

        } catch (DateTimeParseException err) {
            this.by = by;
        }
    }

    /**
     * Getter method for the private final field by.
     *
     * @return A String value.
     */
    public String getBy() {
        return by;
    }

    @Override
    public void setId() {
        this.id = 'D';
    }

    /**
     * Method gives the string representation
     * of the Deadline object.
     *
     * @return A String value.
     */
    @Override
    public String toString() {
        return String.format("%s (by: %s)", getDescription(), by);
    }

    @Override
    public String toFileString() {
        return super.toFileString().replaceFirst("T", "D") + " # " + by;
    }
}
