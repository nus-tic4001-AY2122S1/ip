package duke;

/*
 *  ListCommand.java
 *  Defines the 'List' action flow to list tasks.
 */
public class ListCommand extends Command{
    /*
     *  Constructs List Command object.
     */
    public ListCommand(){

    }

    /*
     * This method 'Executes' the command and
     *  display all tasks in the task list.
     * @param tasks Object of Task class.
     * @param ui Object of UI class - User Interface.
     * @param storage Object of Storage class.
     */
    @Override
    public String execute(TaskList tasks, UI ui, Storage storage) {
        String output = "\tHere are the tasks in your list:" + "\n";
        //print all tasks in task list
        for (int i = 1; i < tasks.getTaskSize() + 1; i++) {
            Task task = tasks.getTaskList().get(i - 1);
            output = output + "\t"+String.format(i + "." + task, task.getStatusIcon()) + "\n" ;
        }
        return output;
    }

    /*
     * Returns not to exit program.
     * @return false Command 'duke' not to exit
     * after list command.
     */
    @Override
    public boolean isExit() {
        return false;
    }
}
