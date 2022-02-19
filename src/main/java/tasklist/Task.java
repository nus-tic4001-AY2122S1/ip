package tasklist;

import java.text.ParseException;
import java.util.Date;

public abstract class Task {

    protected String description;
    protected boolean isDone;

    /****
     *
     * @param description the task description that the user input
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /****
     *
     * @param description the task description that the user input
     * @param status check if the task has already marked as done
     */
    public Task(String description, boolean status) {
        this.description = description;
        this.isDone = status;
    }

    public String getStatusIcon() {
        return (isDone ? "X" : " "); // mark done task with X
    }

    public void markAsDone(){
        isDone = true;
        getStatusIcon();
    }

    public String toString() {
        return("[" + this.getStatusIcon() + "] " + description);
    }

    public String saveFormat(){
        if (this.isDone){
            return ("| 1 | " + this.description);
        }
        else {
            return ("| 0 | " + this.description);
        }
    }

    /****
     *
     * @param dateSearch the date that user input
     * @param taskType the task type of the object
     * @throws ParseException if date format is not dd MMM yyyy
     */
    public boolean findDate(Date dateSearch, String taskType) throws ParseException {
        return false;
    }

    /****
     *
     * @param dateSearch the date that user input
     * @param taskType the task type of the object
     * @throws ParseException if date format is not dd MMM yyyy
     */
    public boolean findFromDateRange(Date dateSearch, String taskType) throws ParseException {
        return false;
    }

    /****
     *
     * @param fromDate the start date that user input
     * @param endDate the end date that user input
     * @param taskType the task type of the object
     * @throws ParseException if date format is not dd MMM yyyy
     */
    public boolean findBetweenDateRange(Date fromDate, Date endDate, String taskType) throws ParseException {
        return false;
    }

    /****
     *
     * @param taskType the task type of the object
     */
    public boolean taskType(String taskType){
        return taskType.equals("task");
    }
}
