package taskclasses;

import dukedatetime.DateTimeDuke;
import exceptions.DukeDateTimeError;

public class Deadline extends Task {

    /**
     * The method to initialize Deadline task
     * ss
     * @param description description String type
     * @param taskStatus task initial status in Boolean type
     * @param dateTime date time information in String type
     */
    public Deadline (String description, Boolean taskStatus, String dateTime) throws DukeDateTimeError {
        super(description);
        super.isDone = taskStatus;
        super.type = "D";
        super.deadlineTime = new DateTimeDuke(dateTime);
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
    @Override
    public String getType() {

        return this.type;
    }

    /**
     * To get the deadline time in DateTimeDuke format
     * @return deadline datetime
     */
    @Override
    public DateTimeDuke getDeadlineTime() {
        return super.deadlineTime;
    }

    /**
     * To get the starting time of event in DateTimeDuke format
     * @return starting time
     */
    @Override
    public DateTimeDuke getStartingTime() {
        return null;
    }

    /**
     * To get the ending time of event in DateTimeDuke format
     * @return ending time
     */
    @Override
    public DateTimeDuke getEndingTime() {
        return null;
    }

    /**
     * To get the /by time of the Deadline task
     *
     * @return the time/date of the Deadline task
     */
    @Override
    public String getDeadlineDateTimeString() {
        DateTimeDuke deadlineDateTime = super.deadlineTime;

        return deadlineDateTime.convertToStringTypeI();
    }

    /**
     * To get staring date time in String format
     * @return null
     */
    @Override
    public String getStartingDateTime() {
        return null;
    }

    /**
     * To get ending date time in String format
     * @return null
     */
    @Override
    public String getEndingDateTime() {
        return null;
    }
}
