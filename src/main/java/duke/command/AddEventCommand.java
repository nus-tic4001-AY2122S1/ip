package duke.command;

import duke.Parser;
import duke.TaskList;
import duke.UI;
import duke.exception.DateFormatException;
import duke.exception.LackOfDateException;
import duke.exception.LackOfDescriptionException;

import java.util.Date;

public class AddEventCommand extends Command {
    /**
     * Create new add-event command.
     * @param fullCommand user full command.
     * */
    public AddEventCommand(String fullCommand) {
        super(fullCommand);
    }

    private static void checkDescription(String fullCommand) throws LackOfDescriptionException {
        if (fullCommand.trim().equals("event")) {
            throw new LackOfDescriptionException();
        }
    }

    private static void checkDate(String fullCommand, String description) throws LackOfDateException {
        if (fullCommand.equals("event " + description)
                || fullCommand.trim().equals("event " + description + " /at")) {
            throw new LackOfDateException();
        }
    }

    private static void checkDateFormat(Date at) throws DateFormatException {
        if (at == null) {
            throw new DateFormatException();
        }
    }

    /**
     * Method to execute add-event command.
     * @param taskList task list to be updated.
     * */
    public void run(TaskList taskList) {
        try {
            checkDescription(fullCommand);
            String description = Parser.description(fullCommand);
            checkDate(fullCommand, description);
            String date = Parser.date(fullCommand);
            Date at = Parser.convertDate(date);
            checkDateFormat(at);
            taskList.addEvent(description, date, at);
            int size = taskList.size;
            UI.addMessage(taskList.tasks.get(size - 1), size);
        } catch (LackOfDescriptionException e) {
            System.out.println("OOPS!!! Pls key in the description for the task");
        } catch (LackOfDateException e) {
            System.out.println("OOPS!!! Pls key in the date for the task");
        } catch (DateFormatException e) {
            System.out.println("Please use format dd-MM-yyyy for date");
        }
    }
}
