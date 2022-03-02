package duke.task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Event is a Task with datetime at property
 */
public class Event extends Task {
    private LocalDateTime from;
    private LocalDateTime till;

    /**
     * constructor
     * @param title
     * @param duration
     */
    public Event(String title, LocalDateTime[] duration) {
        super(title);
        this.from = duration[0];
        this.till = duration[1];
    }

    public LocalDateTime getStartTime() {
        return from;
    }
    public LocalDateTime getEndTime() {
        return till;
    }


    @Override
    public String toString() {
        return "[E]"
                + super.toString()
                + " (at: "
                + from.format(DateTimeFormatter.ofPattern("dd.MMM.yy HH:mm"))
                + " - "
                + till.format(DateTimeFormatter.ofPattern("HH:mm"))
                + ")";
    }
}
