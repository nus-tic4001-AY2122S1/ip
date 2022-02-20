package duke.command;

import java.time.LocalDate;

import duke.others.DukeException;
import duke.others.Messages;
import duke.storage.Storage;
import duke.task.TaskList;
import duke.ui.Ui;

/**
 * Display list of task based on a user input date.
 */
public class ViewByDateCommand extends Command {
    protected LocalDate date;

    /**
     * @param date user input date
     */
    public ViewByDateCommand(LocalDate date) {
        this.date = date;
    }

    /**
     * Filter and list tasks by date (based on user's input).
     *
     * @param tasks task list
     * @param ui text ui.
     * @param storage storage file.
     * @throws DukeException if task list is empty or there are no tasks with date equals to the user input date.
     */
    public String execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        String input = getListByDate(tasks, this.date);
        if (tasks.isEmpty() || input.length() == 0) {
            throw new DukeException(Messages.LIST_EMPTY);
        }
        input = Messages.LIST_HEADER + input;
        return input;
    }

    private String getListByDate(TaskList tasks, LocalDate date) {
        String input = "";
        for (int i = 0; i < tasks.size(); ++i) {
            if (tasks.get(i).getType().equals("T")) {
                continue;
            }
            if (tasks.get(i).getDate().equals(date)) {
                input = input.concat("\t" + (i + 1) + ". " + tasks.get(i).getStatusIconAndDesc() + "\n");
            }
        }
        return input;
    }
}
