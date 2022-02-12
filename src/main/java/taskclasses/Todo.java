package taskclasses;

import dukedatetime.DateTimeDuke;

public class Todo extends Task {

    /**
     * default function with only the Todo task description
     * @param description the description of the Todo Task
     */
    public Todo (String description) {
        super(description);
        super.setType("T");
    }

    /**
     * default function with two parameter:
     * 1. description of the Todo Task
     * 2. taskStatus of the Todo Task
     * @param description The Todo Task's description
     * @param taskStatus The Todo Task's status
     */
    public Todo (String description, Boolean taskStatus) {
        super(description);
        super.setIsDone(taskStatus);
        super.setType("T");
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
     * To mark the status as done
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
     * To get the /by time of the Deadline task
     *
     * @return null
     */
    @Override
    public String getDeadlineDateTimeString() {
        return null;
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

    /**
     * To get the deadline time in DateTimeDuke format
     * @return null
     */
    @Override
    public DateTimeDuke getDeadlineTime() {
        return null;
    }

    /**
     * To get the starting time of event in DateTimeDuke format
     * @return null
     */
    @Override
    public DateTimeDuke getStartingTime() {
        return null;
    }

    /**
     * To get the ending time of event in DateTimeDuke format
     * @return null
     */
    @Override
    public DateTimeDuke getEndingTime() {
        return null;
    }
}
