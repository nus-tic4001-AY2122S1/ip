import Duke.Task.Task;
import Duke.Task.TaskList;
import Duke.exceptions.DukeException;

import java.util.ArrayList;

public class Duke {
    public static void main(String[] args) throws DukeException {

        Operations operations = new Operations();
        Interactor interactor = new Interactor();
        TaskList taskList = new TaskList(new ArrayList<Task>());

        console.log('Test');
        
        operations.setDatabase(taskList);
        interactor.setOperations(operations);

        interactor.setExitKeyword("bye");
        interactor.setDoneKeyword("done");

        interactor.start();
    }
}
