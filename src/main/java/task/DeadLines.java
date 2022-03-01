package task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DeadLines extends Task {
    protected LocalDateTime dateAndTime;
    protected String stringDateTime;

    public DeadLines(String description, String details, boolean readFromFile) {
        super(description);
        String changedDate;
        int julianDate, day;
        DateTimeFormatter formatter;
        LocalDateTime formattedDate = null;
        details = details.trim();
        int daysToAdd = getDaysToAdd(details);
        if (readFromFile) {
            formatter = DateTimeFormatter.ofPattern("d MMM yyyy HHmm");
            formattedDate = LocalDateTime.parse(details, formatter);
        } else {
            if (daysToAdd < 0) {
                formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm");
                formattedDate = LocalDateTime.parse(details, formatter);
            } else {
                formattedDate = formattedDate.now();
                julianDate = formattedDate.getDayOfYear();
                day = julianDate % 7;
                daysToAdd = day - daysToAdd;
                if (daysToAdd == 0) {
                    daysToAdd = 7;
                } else if (daysToAdd < 0) {
                    daysToAdd = daysToAdd * -1;
                } else {
                    daysToAdd = 7 - daysToAdd;
                }
                formattedDate = formattedDate.plusDays(daysToAdd);
            }
        }
        changedDate = formattedDate.toString();
        this.dateAndTime = LocalDateTime.parse(changedDate);
        this.stringDateTime = dateAndTime.format(DateTimeFormatter.ofPattern("dd MMM yyyy HHmm"));
        this.type = 'D';
    }

    private int getDaysToAdd(String details) {
        details = details.toLowerCase();
        if (details.contains("mon")) {
            return 0;
        }
        if (details.contains("tues")) {
            return 1;
        }
        if (details.contains("wednes")) {
            return 2;
        }
        if (details.contains("thurs")) {
            return 3;
        }
        if (details.contains("fri")) {
            return 4;
        }
        if (details.contains("satur")) {
            return 5;
        }
        if (details.contains("sun")) {
            return 6;
        }
        return -1;
    }

    /**
     * Returns lateral location of the specified position.
     * If the position is unset, NaN is returned.
     *
     * @return The string version of the Date & Time
     */
    public String getDetails() {
        return "(by: " + this.stringDateTime + ")";
    }

    public LocalDateTime getDateTime() {
        return dateAndTime;
    }
}
