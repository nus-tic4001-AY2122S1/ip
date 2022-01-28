package duke.dukeCommand;
import duke.dukeUI.*;
import duke.dukeTaskList.*;
import duke.dukeStorage.*;
import duke.dukeException.*;
import duke.dukeUI.*;
import java.io.IOException;

public class DeleteCommand extends Command{

    public DeleteCommand(String input){
        super(input);
    }

    @Override
    public void execute(DukeTaskList taskList, DukeUI ui, DukeStorage storage) throws DukeException, IOException{
        try{
            DukeStorage.deleteFunction(Integer.valueOf(input.trim())-1);
            DukeStorage.deleteFromFile(Integer.valueOf(input.trim())-1);
        }
        catch (NumberFormatException e){
            throw new DukeException("The task selected must be a numerical value.");
        }
        catch (IndexOutOfBoundsException e){
            throw new DukeException("The tasks list cannot be empty.");
        }
    }

    private int prepareIndex(String args){
        return Integer.parseInt(input.split(" ")[1])-1;
    }
}