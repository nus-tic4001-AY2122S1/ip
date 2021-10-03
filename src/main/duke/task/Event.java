package duke.task;

import duke.exception.DukeMissingDescException;

import java.time.LocalDateTime;

/**
 * Task with specific date of occurrence, can understand dates and times.
 * Refer to Level 8
 */
public class Event extends Task {
    private LocalDateTime start_endTime;
    private String raw_start_endTime;

    public String getRaw_start_endTime() {
        return raw_start_endTime;
    }

    /**
     * @return start_endTime if string was valid ISO DateTime, else null.
     */
    public LocalDateTime getStart_endTime() {
        return start_endTime;
    }

    /**
     * tries to set start_endTime if parsable.
     * @param start_endTime string passed in by user input
     */
    public void setStart_endTime(String start_endTime) {
        this.raw_start_endTime = start_endTime;
        this.start_endTime = Parser.parseDateTimeStr(start_endTime);
    }

    public Event(String description, String start_endTime) throws DukeMissingDescException {
        super(description);
        setStart_endTime(start_endTime);
    }

    @Override
    public String toString() {
        String dateStr = (getStart_endTime() != null) ? getStart_endTime().toString() : getRaw_start_endTime();
        return String.format("[E]%s (at: %s)", super.toString(), dateStr);
    }
}
