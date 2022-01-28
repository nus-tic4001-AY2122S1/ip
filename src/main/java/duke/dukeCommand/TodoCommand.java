package duke.dukeCommand;
import duke.dukeUI.*;
import duke.dukeTaskList.*;
import duke.dukeStorage.*;
import duke.dukeException.*;
import duke.dukeUI.*;
import duke.dukeTask.*;
import java.io.IOException;
import java.util.Date;

public class TodoCommand extends Command{

    private TodoCommand todo;

    public TodoCommand(String input){
        super(input);
    }

    @Override
    public void execute(DukeTaskList taskList, DukeUI ui, DukeStorage storage) throws DukeException, IOException{
        try{
            String[] userInput = null;
            userInput = input.split(" ",2);
            if(userInput[1].trim() != ""){
                DukeStorage.saveFunction(new Todo(userInput[1].trim()));
                DukeStorage.saveToFile("T",userInput[1].trim(),"");
            }
        }catch(IOException e1){
             e1.printStackTrace();
        }catch (IndexOutOfBoundsException e){
             throw new DukeException("The tasks list cannot be empty.");
        }
    }
}