package taskclasses;

import dukedatetime.DateTimeDuke;

public abstract class Task {
    String description;
    boolean isDone;
    String type;

    //For deadline task;
    DateTimeDuke deadlineTime;

    //For event task;
    DateTimeDuke startingTime;
    DateTimeDuke endingTime;

    Task(String description) {
        this.description = description;
        this.isDone = false;
        this.type = null;
        this.deadlineTime = null;
        this.startingTime = null;
        this.endingTime = null;
    }

    /**
     * To get the status icon of the task
     *
     * @return status icon of the task
     */
    public abstract String getStatusIcon(); //{ return (isDone ? "X" : " ");}

    /**
     * To get the description of the task
     *
     * @return the description of the task
     */
    public abstract String getDescription(); //{ return this.description; }

    /**
     * To get the status of the task
     */
    public abstract void markAsDone(); //{ this.isDone = true; }

    /**
     * To get the type of the task
     *
     * @return the type of the task
     */
    public abstract String getType(); //{ return this.type; }

    /**
     * To get the date/Time of the deadline task
     *
     * @return the type of the task
     */
    public abstract DateTimeDuke getDeadlineTime();

    /**
     * To get the date/time of the event task
     *
     * @return the type of the task
     */
    public abstract DateTimeDuke getStartingTime();

    /**
     * To get the date/time of the event task
     *
     * @return the type of the task
     */
    public abstract DateTimeDuke getEndingTime();

    /**
     * To get the /by time of the Deadline task
     *
     * @return the time/date of the Deadline task
     */
    public abstract String getDeadlineDateTimeString();

    /**
     * To get staring date time in String format
     * @return starting date time
     */
    public abstract String getStartingDateTime();

    /**
     * To get ending date time in String format
     * @return ending date time
     */
    public abstract String getEndingDateTime();

    /**
     * The function to set up Task description
     * @param description the Task's description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * The function to set up whether the task has done
     * @param isDone the task status
     */
    public void setIsDone(boolean isDone) {
        this.isDone = isDone;
    }

    /**
     * The function to set up the Task's type
     * @param type Task type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * The function to set up the Task's deadline Time;
     * @param deadlineTime the function's deadline Time;
     */
    public void setDeadlineTime(DateTimeDuke deadlineTime) {
        this.deadlineTime = deadlineTime;
    }

    /**
     * The function to set up the Task's starting time
     * @param startingTime the Task's starting time
     */
    public void setStartingTime(DateTimeDuke startingTime) {
        this.startingTime = startingTime;
    }

    /**
     * The function to set up the Task's ending time
     * @param endingTime The Task's ending time
     */
    public void setEndingTime(DateTimeDuke endingTime) {
        this.endingTime = endingTime;
    }

}
