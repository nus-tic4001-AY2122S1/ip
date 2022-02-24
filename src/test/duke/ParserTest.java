package test.duke;

import main.duke.DukeException;
import main.duke.Parser;
import main.duke.Task;
import main.duke.TaskList;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParserTest {
    @Test
    public void addTodo() throws DukeException {
        ArrayList<Task> todoList = TaskList.getInstance().getList();
        Parser parser = new Parser();
        parser.addTodo("clean fish tank");
        assertEquals("[T][ ] clean fish tank", todoList.get(todoList.size()-1).toString());
    }
    @Test
    public void addDeadline() throws DukeException {
        ArrayList<Task> todoList = TaskList.getInstance().getList();
        Parser parser = new Parser();
        parser.addDeadline("eat breakfast",  "aug 6th");
        assertEquals("[D][ ] eat breakfast (by: aug 6th)", todoList.get(todoList.size()-1).toString());
    }
    @Test
    public void addEvent() throws DukeException {
        ArrayList<Task> todoList = TaskList.getInstance().getList();
        Parser parser = new Parser();
        parser.addEvent("watch movie", "aug 7th", "6pm");
        assertEquals("[E][ ] watch movie (at: aug 7th 6pm)", todoList.get(todoList.size()-1).toString());
    }
}
