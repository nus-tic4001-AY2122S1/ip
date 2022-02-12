package duke.command;

import duke.Parser;
import duke.TaskList;
import duke.UI;
import duke.exception.DateFormatException;
import duke.exception.LackOfDateException;
import duke.exception.LackOfDescriptionException;

import java.util.Date;

public class AddDeadlineCommand extends Command {
    /**
     * Create new add-deadline command.
     * @param fullCommand user full command.
     * */
    public AddDeadlineCommand(String fullCommand) {
        super(fullCommand);
    }

    private static void checkDescription(String fullCommand) throws LackOfDescriptionException {
        if (fullCommand.trim().equals("deadline")) {
            throw new LackOfDescriptionException();
        }
    }

    private static void checkDate(String fullCommand, String description) throws LackOfDateException {
        if (fullCommand.equals("deadline " + description)
                || fullCommand.trim().equals("deadline " + description + " /by")) {
            throw new LackOfDateException();
        }
    }

    private static void checkDateFormat(Date by) throws DateFormatException {
        if (by == null) {
            throw new DateFormatException();
        }
    }

    /**
     * Method to execute add-deadline command.
     * @param taskList task list to be updated.
     * */
    public void run(TaskList taskList) {
        try {
            checkDescription(fullCommand);
            String description = Parser.description(fullCommand);
            checkDate(fullCommand, description);
            String date = Parser.date(fullCommand);
            Date by = Parser.convertDate(date);
            checkDateFormat(by);
            taskList.addDeadline(description, date, by);
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
