package command;

import ui.UI;
import storage.Storage;
import tasklist.TaskList;
import exceptions.DukeException;

import java.io.FileNotFoundException;
import java.text.ParseException;

public abstract class Command {

    protected boolean bExit = false;
    public boolean isExit(){
        return bExit;
    }
    public abstract String execute(TaskList tasks, UI ui, Storage storage) throws FileNotFoundException, ParseException;
}
