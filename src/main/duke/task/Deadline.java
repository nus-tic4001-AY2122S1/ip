package duke.task;

import duke.exception.DukeMissingDescException;

import java.time.LocalDateTime;

/**
 * Deadline can understand dates and times.
 * Refer to Level-8
 */
public class Deadline extends Task {
    private LocalDateTime deadline;
    private String raw_deadline;
    /**
     * @return DateTime representation of this Deadline object
     */
    public LocalDateTime getDeadline() {
        return deadline;
    }
    public String getRaw_deadline(){
        return raw_deadline;
    }
    /**
     * Sets or updates this object's deadline.
     * @param deadline
     */
    public void setDeadline(String deadline) {
        this.raw_deadline = deadline;
        this.deadline = Parser.parseDateTimeStr(deadline);
    }

    public Deadline(String description, String deadline) throws DukeMissingDescException {
        super(description);
        setDeadline(deadline);
    }

    @Override
    public String toString() {
        String dateString = (getDeadline() != null) ? getDeadline().toString() : getRaw_deadline();
        return String.format("[D]%s (by: %s)", super.toString(), dateString);
    }
}
