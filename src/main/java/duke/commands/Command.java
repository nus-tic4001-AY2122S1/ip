package main.java.duke.commands;

import main.java.duke.task.TaskList;


/**
 * Represents an executable command.
 */
public class Command {

    protected TaskList taskList;

    private int[] targetIndex;

    protected Command() {
    }

    public Command(int[] targetIndex) {
        this.setTargetIndex(targetIndex);
    }


    private void setTargetIndex(int[] targetIndex) {
        this.targetIndex = targetIndex;
    }
    public int[] getTargetIndex() {
        return targetIndex;
    }

    public void execute() {
    }

    /**
     * Supplies the data the command will operate on.
     */
    public void setData(TaskList taskList){
        this.taskList=taskList;
    }


}
