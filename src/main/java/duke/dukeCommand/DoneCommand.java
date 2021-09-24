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
            String[] userInput = null;
            userInput = input.split(" ",2);
            if(userInput[1].trim() != ""){
                DukeStorage.doneFunction(Integer.valueOf(userInput[1].trim())-1);
                DukeUI.donePrint();
                DukeStorage.changeIsDone(Integer.valueOf(userInput[1].trim())-1);
            }
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
