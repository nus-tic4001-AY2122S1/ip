package duke;

import java.util.Scanner;

import duke.command.CommandCaller;
import duke.command.CommandFactory;
import duke.parse.StringParser;
import duke.storage.Storage;
import duke.storage.TempTaskList;
import duke.ui.Message;

/**
 * @author      Li Shihao
 * @since       2021 Aug
 */
public class Duke {
    private TempTaskList tasks = new TempTaskList();
    private Storage storage = new Storage();
    private CommandFactory commandFactory = new CommandFactory(tasks);
    private StringParser strParser = new StringParser();
    private CommandCaller commandCaller = new CommandCaller(commandFactory);
    /*
    bug fixed: DO NOT put scanner creation inside the loop,
    maintain only one scanner object
     */
    private Scanner in = new Scanner(System.in);

    /**
     * constrctor
     */
    public Duke() {
        tasks.addPropertyChangeListener(storage);
        strParser.addPropertyChangeListener(commandCaller);
        storage.listInit(tasks);
    }

    /**
     * supply string text to GUI
     * @param userInput
     * @return String
     */
    public String getResponse(String userInput) {
        switch(userInput.strip()) {
        case "bye":
            return "See ya!";
        case "list":
            return tasks.list();
        default:
            Message.setBuffer("");
            strParser.passToCaller(userInput);
            return Message.getBuffer();
        }

    }

}


