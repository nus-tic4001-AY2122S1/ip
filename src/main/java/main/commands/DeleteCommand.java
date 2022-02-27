package main.commands;

import main.DukeException;
import main.UI;
import main.taskLists.Task;

import static main.Duke.Tasks;

public class DeleteCommand extends Command<Integer> {


    public DeleteCommand(Integer input) throws DukeException {

        // messy code
        if (input >= 1) {
            this.execute(input);
        } else {
            this.DeleteAll();
        }
    }


    public void DeleteAll() throws DukeException {

        try {
            Tasks.clear();
        } catch (Exception e) {
            UI.dukePrint("\tI can't delete something that does not exist. Maybe try 'list' to list current tasks?");
        }


    }


    @Override
    public void execute(Integer input) throws DukeException {

        try {
            Task t = Tasks.get(input - 1);
            Tasks.remove(input - 1);
            UI.deletedCommand(t);
        } catch (Exception e) {
            UI.dukePrint("\tI can't delete something that does not exist. Maybe try 'list' to list current tasks?");
        }


    }

}
