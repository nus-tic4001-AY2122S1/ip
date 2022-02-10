package Duke.Command;

import Duke.Task.Tasks;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Deadline extends Tasks {
    protected boolean isDeadline;
    protected String by;

    /***
     *
     * @param description for deadline task description
     * @param by string enter by user after keyword /by
     */
    public Deadline(String description, String by) {
        super(description);
        this.by = by;
        isDeadline = false;
    }

    /***
     *
     * @return Override the toString() method
     */
    @Override
    public String toString() {

            String byDate = by.trim();
//            LocalDate d1 = LocalDate.parse(byDate);
//            byDate = d1.format(DateTimeFormatter.ofPattern("MMM dd yyyy"));
            return "[D]" + description+  "(by:" + byDate  + ")" ;
    }
}
