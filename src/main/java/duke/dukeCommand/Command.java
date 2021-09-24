package duke.dukeCommand;
import duke.dukeUI.*;
import duke.dukeTaskList.*;
import duke.dukeStorage.*;
import duke.dukeException.*;
import duke.dukeUI.*;
import java.io.IOException;

public class Command{
    protected String input;

    public Command(String input){
        this.input = input;
    }

    public void execute(DukeTaskList taskList, DukeUI ui, DukeStorage storage) throws DukeException, IOException{
        throw new UnsupportedOperationException("This method is to be implemented by child classes");
    };
}
