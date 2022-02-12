package duke.command;

import duke.TaskList;

/**
 * Abstract class stores execution methods of respective commands.
 * */
public abstract class Command {
    protected String fullCommand;

    /**
     * Create new command.
     * @param fullCommand user full command.
     * */
    public Command(String fullCommand) {
        this.fullCommand = fullCommand;
    }

    /**
     * Abstract method to execute new command.
     * @param taskList task list to be updated
     * */
    public abstract void run(TaskList taskList);
}
