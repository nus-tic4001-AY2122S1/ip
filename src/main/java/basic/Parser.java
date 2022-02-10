package basic;

import command.AddDeadlineCommand;
import command.AddEventCommand;
import command.AddTodoCommand;
import command.Command;
import command.DeleteCommand;
import command.ExitCommand;
import command.FindCommand;
import command.ListCommand;
import command.MarkAsDoneCommand;
import command.UndoCommand;

/**
 * Parses user input.
 */
public class Parser {
    protected static Ui ui = new Ui();

    /**
     * Parses user input into command for execution.
     *
     * @param userInput full user input string
     * @return the command based on the user input
     */
    static Command parse(String userInput) {
        if (userInput.toLowerCase().equals("bye") || userInput.toLowerCase().equals("exit")) {
            return new ExitCommand();
        } else if (userInput.toLowerCase().equals("list")) {
            return new ListCommand();
        } else if (userInput.toLowerCase().contains("done")) {
            return new MarkAsDoneCommand(userInput);
        } else if (userInput.toLowerCase().contains("todo") && !userInput.toLowerCase().contains("event") 
                && !userInput.toLowerCase().contains("deadline")) {
            return new AddTodoCommand(userInput);
        } else if ((userInput.toLowerCase().substring(0,1).equals("d")  && !userInput.toLowerCase().contains("date") 
                && !userInput.toLowerCase().contains("delete")) || userInput.toLowerCase().contains("deadline") 
                && !userInput.toLowerCase().contains("event") && !userInput.toLowerCase().contains("todo")) {
            return new AddDeadlineCommand(userInput);
        } else if (userInput.toLowerCase().substring(0,1).equals("e") 
                || userInput.toLowerCase().contains("event") && !userInput.toLowerCase().contains("deadline") 
                && !userInput.toLowerCase().contains("todo")) {
            return new AddEventCommand(userInput);
        } else if (userInput.toLowerCase().contains("find")) {
            return new FindCommand(userInput);
        } else if (userInput.toLowerCase().contains("delete")) {
            return new DeleteCommand(userInput);
        } else if (userInput.toLowerCase().contains("undo")) {
            return new UndoCommand();
        } else {
            return new Command();
        }
    }

}
