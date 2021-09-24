package duke.dukeParser;

import duke.dukeCommand.*;
import java.io.IOException;
import duke.dukeException.*;

public class DukeParser{
    public static Command parseInput(String userInput) throws DukeException{
        String[] input = null;
        input = userInput.split(" ",2);
        switch(input[0]){
            case "deadline":
                return new DeadlineCommand(input[1]);
            case "event":
                return new EventCommand(input[1]);
            case "todo":
                return new TodoCommand(input[1]);
            case "list":
                return new ListCommand("");
            case "delete":
                return new DeleteCommand(input[1]);
            case "done":
                return new DoneCommand(input[1]);
            case "bye":
                return new ByeCommand("");
            default:
                throw new DukeException("I'm sorry, but I don't know what that means :-(");
        }
    }
}