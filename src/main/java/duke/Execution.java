package duke;

import duke.command.*;
import duke.exception.CommandException;

/**
 * Execute user command.
 * */
public class Execution {
    protected String fullCommand;
    protected String command;
    protected boolean isExit;

    /**
     * Create new command.
     * @param fullCommand user full command.
     * */
    public Execution(String fullCommand) {
        this.fullCommand = fullCommand;
        this.command = Parser.command(fullCommand);
        this.isExit = false;
    }

    private static void checkCommand(String command) throws CommandException {
        if (!(command.equals("todo") || command.equals("deadline") || command.equals("event")
                || command.equals("bye") || command.equals("list") || command.equals("done")
                || command.equals("delete") || command.equals("find"))) {
            throw new CommandException();
        }
    }

    /**
     * Execute new command.
     * @param taskList task list to be updated
     * */
    public void execute(TaskList taskList) {
        try {
            checkCommand(command);

            switch (command) {
            case "list":
                new ListCommand(fullCommand).run(taskList);
                break;
            case "done":
                new DoneCommand(fullCommand).run(taskList);
                break;
            case "todo":
                new AddTodoCommand(fullCommand).run(taskList);
                break;
            case "deadline":
                new AddDeadlineCommand(fullCommand).run(taskList);
                break;
            case "event":
                new AddEventCommand(fullCommand).run(taskList);
                break;
            case "delete":
                new DeleteCommand(fullCommand).run(taskList);
                break;
            case "find":
                new FindCommand(fullCommand).run(taskList);
                break;
            case "bye":
                new ByeCommand(fullCommand).run(taskList);
                isExit = true;
                break;
            }
        } catch (CommandException e) {
            System.out.println("OOPS!!! Pls key in the valid command");
        }
    }
}
