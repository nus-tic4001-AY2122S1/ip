package parser;

import command.*;
import constant.CommandKeyWords;
import constant.ErrorMessage;
import exception.ErrorHandler;

public class CommandParser extends Parser {
    private CommandKeyWords commandWord;

    @Override
    public Command parse(String userCommand) throws ErrorHandler {
        return this.parseCommand(userCommand);
    }

    /**
     * @param input is a string that user key in from the terminal
     * @throws ErrorHandler customized error
     * @return Command class
     */
    private Command parseCommand(String input) throws ErrorHandler {
        String[] result = input.split(" ", 2);

        this.commandWord =  CommandKeyWords.getEnum(result[0].toUpperCase());

        switch (commandWord) {
            case DEADLINE:
                if(result.length < 2) throw new ErrorHandler("In Parser, " + ErrorMessage.EMPTY_DEADLINE);
                String[] deadlineContent = result[1].split("/by", 2);
                this.content = deadlineContent[0].trim();

                if (deadlineContent.length < 2)
                    throw new ErrorHandler("In Parser, " + ErrorMessage.INVALID_DEADLINE);
                this.by = deadlineContent[1].trim();

                return new DeadlineCommand(this.content,this.by, false);
            case EVENT:
                if(result.length < 2) throw new ErrorHandler("In Parser, " + ErrorMessage.EMPTY_EVENT);

                String[] eventContent = result[1].split("/at", 2);
                this.content = eventContent[0].trim();

                if (eventContent.length < 2)
                    throw new ErrorHandler("In Parser, " + ErrorMessage.INVALID_EVENT);
                this.by = eventContent[1].trim();
                return new EventCommand(this.content, this.at,  false);
            case TODO:
                if(result.length < 2) throw new ErrorHandler("In Parser, " + ErrorMessage.EMPTY_TODO);
                this.content = result[1].trim();
                return new TodoCommand(this.content,  false);
            case DONE:
                if(result.length < 2) throw new ErrorHandler("In Parser, " + ErrorMessage.EMPTY_TASK_NUMBER);
                this.content = result[1].trim();

                return new DoneCommand(this.content);
            case DELETE:
                if(result.length < 2) throw new ErrorHandler("In Parser, " + ErrorMessage.EMPTY_TASK_NUMBER);
                this.content = result[1].trim();

                return new DeleteCommand(this.content);
            case LIST:
                return new ListCommand();
            case FIND:
                if(result.length < 2) throw new ErrorHandler("In Parser, " + ErrorMessage.EMPTY_TASK_NUMBER);
                this.content = result[1].trim();

                return new FindCommand(this.content);
            case BYE:
            default:
                return new ByeCommand();
        }
    }
}
