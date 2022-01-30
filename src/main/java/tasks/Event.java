package tasks;


import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * This represents the Event Class. It includes a String at.
 * at will represent the destination or "time" for the task. Anything that the user
 * wants to input for it.
 */

public class Event extends Task {
    protected LocalDateTime start;
    protected LocalTime end;

    /**
     * This is a constructor for the Event Class.
     *
     * @param description This describes the activity of the event.
     * @param at          This indicates the time period for the event.
     */
    public Event(String description, String at) {
        super(description);
        int indexOfTo = at.indexOf("to");
        try {
            this.start = LocalDateTime.parse(at.substring(0, indexOfTo).trim(), DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
            this.end = LocalTime.parse(at.substring(indexOfTo).replace("to", "").trim(), DateTimeFormatter.ofPattern("HH:mm:ss"));


        } catch (DateTimeParseException | StringIndexOutOfBoundsException e) {
            this.start = LocalDateTime.now();
            this.end = LocalTime.now();
            System.out.println("Invalid Date Time was set. It will be set to the current " +
                    "time. Format should be \"dd/MM/yyyy HH:mm:ss to HH:mm:ss\" ");
        } finally {
            if (start.toLocalTime().compareTo(end) > 0) {
                System.out.println("Notification: For the added event, start time is after end time. The event task will still be added.");
            }
        }
    }

    /**
     * This is a accessor for the object "at"
     *
     * @return the location of the event.
     */
    public String getAt() {
        return this.start.format(DateTimeFormatter.ofPattern("dd MMM yyyy HH:mm:ss")) + " to "
                + this.end.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }

    /**
     * This converts the Event Object to a String for printing.
     *
     * @return the Event written as a String
     */
    public String toString() {
        return "[E]" + super.toString() + " (at: " + getAt() + ")";
    }

    public void rescheduleAt(String at) {
        int indexOfTo = at.indexOf("to");
        try {
            this.start = LocalDateTime.parse(at.substring(0, indexOfTo).trim(), DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
            this.end = LocalTime.parse(at.substring(indexOfTo).replace("to", "").trim(), DateTimeFormatter.ofPattern("HH:mm:ss"));
        } catch (DateTimeParseException | StringIndexOutOfBoundsException e) {
            this.start = LocalDateTime.now();
            this.end = LocalTime.now();
            System.out.println("Invalid Date Time was set. It will be set to the current " +
                    "time. Format should be \"dd/MM/yyyy HH:mm:ss to HH:mm:ss\" ");
        } finally {
            if (start.toLocalTime().compareTo(end) > 0) {
                System.out.println("Notification: For the added event, start time is after end time. The event task will still be added.");
            }
        }
    }
}
