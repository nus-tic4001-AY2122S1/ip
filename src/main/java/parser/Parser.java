package parser;

import command.*;

public class Parser {
    public static Command parse(String userInput) {
        Command parsedCommand;
        String[] theStrInputArr = userInput.split(" ");
        String firstKeyWord = theStrInputArr[0].toLowerCase();

        switch (firstKeyWord) {
            case "bye":
                parsedCommand = new ExitCommand();
                break;
            case "list":
                parsedCommand = new ListCommand();
                break;

            case "save":
                parsedCommand = new SaveCommand();
                break;

            case "done":
                parsedCommand = new DoneCommand(userInput);
                break;

            case "delete":
                parsedCommand = new DeleteCommand(userInput);
                break;

            case "find":
                parsedCommand = new FindCommand(userInput);
                break;

            case "event":
                parsedCommand = new AddEventCommand(userInput);
                break;

            case "deadline":
                parsedCommand = new AddDeadlineCommand(userInput);
                break;

            case "todo":
                parsedCommand = new AddTodoCommand(userInput);
                break;

            default:
                parsedCommand = new InvalidCommand(userInput);
                break;
        }
        return parsedCommand;
    }
}
