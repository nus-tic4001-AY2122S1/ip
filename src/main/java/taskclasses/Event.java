package taskclasses;

import dukedatetime.DateTimeDuke;
import exceptions.DukeDateTimeError;

public class Event extends Task {

    /**
     * The method to initial Event task
     * @param description task description
     * @param taskStatus task initial status
     * @param startingDateTime task starting date time
     * @param endingDateTime task ending date time
     */
    public Event (String description, Boolean taskStatus,
                  String startingDateTime, String endingDateTime) throws DukeDateTimeError {
        super(description);
        super.isDone = taskStatus;
        super.type = "E";
        super.startingTime = new DateTimeDuke(startingDateTime);
        super.endingTime = new DateTimeDuke(endingDateTime);
    }

    /**
     * To get the deadline time in DateTimeDuke format
     * @return deadline datetime
     */
    @Override
    public DateTimeDuke getDeadlineTime() {
        return null;
    }

    /**
     * To get the starting time of event in DateTimeDuke format
     * @return starting time
     */
    @Override
    public DateTimeDuke getStartingTime() {
        return super.startingTime;
    }

    /**
     * To get the ending time of event in DateTimeDuke format
     * @return ending time
     */
    @Override
    public DateTimeDuke getEndingTime() {
        return super.endingTime;
    }

    /**
     * To get the status icon of the task
     *
     * @return status icon of the task
     */
    public String getStatusIcon() {
        return (isDone ? "X" : " ");
    }

    /**
     * To get the description of the task
     *
     * @return the description of the task
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * To get the status of the task
     */
    public void markAsDone() {
        this.isDone = true;
    }

    /**
     * To get the type of the task
     *
     * @return the type of the task
     */
    public String getType() {
        return this.type;
    }

    /**
     * To get staring date time in String format
     * @return staring date time
     */
    @Override
    public String getStartingDateTime() {
        DateTimeDuke dateTimeDuke = super.startingTime;

        return dateTimeDuke.convertToStringTypeI();
    }

    /**
     * To get ending date time in String format
     * @return ending date time
     */
    @Override
    public String getEndingDateTime() {
        DateTimeDuke dateTimeDuke = super.endingTime;

        return dateTimeDuke.convertToStringTypeI();
    }

    /**
     * To get the /by time of the Deadline task
     *
     * @return null
     */
    @Override
    public String getDeadlineDateTimeString() {
        return null;
    }
}
