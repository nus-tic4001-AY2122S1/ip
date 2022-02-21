package duke.command;

import duke.dukeexception.DukeException;
import duke.storage.Storage;
import duke.task.TaskList;
import duke.ui.Ui;

/**
 * list of other etc commands
 */
public class OtherCommand extends Command {
    /**
     * Constructs the OtherCommands
     * @param taskDes
     */
    public OtherCommand(String taskDes) {
        super(taskDes);
    }

    /**
     * Execute the other commands: Hi, Help and Clearlist
     * @param tasks The list of task
     * @param ui The Ui
     * @param storage The storage
     * @throws DukeException any expected error
     */
    public CommandResult execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        switch(commandInstruction.toLowerCase()) {
        case "hi":
        case "hello":
        case "yo":
            return new CommandResult("Hello to you too! :)");

        case "help":
            return new CommandResult(ui.displayListOfHelpFunction());

        case "clearlist":
            tasks.clearAll();
            return new CommandResult("List of Tasks has all been cleared, you have an empty list now.");

        default:
            throw new DukeException("Shouldn't have error here");
        }

    }


}
