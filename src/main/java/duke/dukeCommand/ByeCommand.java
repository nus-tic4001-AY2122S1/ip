package duke.dukeCommand;
import duke.dukeUI.*;
import duke.dukeTaskList.*;
import duke.dukeStorage.*;
import duke.dukeException.*;
import duke.dukeUI.*;
public class ByeCommand extends Command{

    public ByeCommand(String input){
        super(input);
    }

    @Override
    public void execute(DukeTaskList taskList, DukeUI ui, DukeStorage storage) throws DukeException{
        ui.goodbyeMessage();
        System.exit(0);
    }
}