package duke;

/*
 *  UpdateCommand.java
 *  Defines the 'update' action flow to update
 *  Date and Time of Event or Deadline Object.
 */

public class UpdateCommand extends Command {
    private int index;
    private String dateTime;

    /**
     * Constructs Update Command object with task index.
     * @param index Parsed task index.
     * @param dateTime Updated data and time
     */
    public UpdateCommand(int index,String dateTime) {
        this.index = index;
        this.dateTime = dateTime;
    }

    /*
     * This method 'Executes' the command and display message
     * after successfully updated date and time.
     * @param tasks Object of Task class.
     * @param ui Object of UI class - User Interface.
     * @param storage Object of Storage class.
     */
    @Override
    public String execute(TaskList tasks, UI ui, Storage storage) {
        //mark task as completed
        Task task = tasks.updateTask(index - 1,dateTime);
        //display successful message
        String output = "\tNice! I've updated this task:";
        output = output + "\t  " + task.toString();
        return null;
    }

    /*
     * Returns not to exit program.
     * @return false Command 'duke' not to exit
     * after done command.
     */
    @Override
    public boolean isExit() {
        return false;
    }
}