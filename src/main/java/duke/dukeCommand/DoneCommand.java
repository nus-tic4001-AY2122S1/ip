package duke.dukeCommand;
import duke.dukeUI.*;
import duke.dukeTaskList.*;
import duke.dukeStorage.*;
import duke.dukeException.*;
import duke.dukeUI.*;
import java.io.IOException;

public class DoneCommand extends Command{

    public DoneCommand(String input){
        super(input);
    }

    @Override
    public void execute(DukeTaskList taskList, DukeUI ui, DukeStorage storage) throws DukeException, IOException{
        try{
            DukeUI.donePrint();
            DukeStorage.doneFunction(Integer.valueOf(input.trim())-1);
            DukeStorage.changeIsDone(Integer.valueOf(input.trim())-1);
        }catch (IndexOutOfBoundsException e){
            throw new DukeException("☹ OOPS!!! Please enter an index.");
        }
        catch (NullPointerException e){
            throw new DukeException(" ☹ OOPS!!! The index you have key in dose not exist.");
        }catch(IOException e1){
            e1.printStackTrace();
        }

    }

}
