import duke.dukeUI.*;
import duke.dukeTaskList.*;
import duke.dukeStorage.*;
import duke.dukeException.*;
import duke.dukeUI.*;
import duke.dukeTask.*;
import duke.dukeCommand.*;
import duke.dukeParser.*;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.text.ParseException;

public class Duke{
    private DukeStorage storage;
    private DukeTaskList taskList;
    private DukeUI ui;

    public Duke(String filePath) {
        ui = new DukeUI();
        storage = new DukeStorage(filePath);
        taskList = new DukeTaskList();
    }

    public void run() {

        ui.welcomeMessage();
        try{
            storage.readFile();
        }catch(FileNotFoundException e){
            System.out.println(e);
        }catch(IOException e){
            System.out.println(e);
        }catch(ParseException e){
            System.out.println(e);
        }catch(DukeException e){
            System.out.println(e);
        }

        while (true) {
            try {
                String fullCommand = ui.readUserInput();
                Command c = DukeParser.parseInput(fullCommand);
                c.execute(taskList, ui, storage);
            }catch (Exception e) {
                ui.showError(e.getMessage());
            }
        }

    }

    public static void main(String[] args) {
        new Duke("/Users/joseph/Desktop/ip/src/main/java/taskList.txt").run();
    }
}