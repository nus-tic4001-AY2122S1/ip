package tasks;

import exceptions.DukeException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskListTest {

    @Test
    void getSize_success() throws DukeException {
        TaskList tasks = new TaskList();
        tasks.addTask("todo", "running", "");
        tasks.addTask("task", "jumping", "");
        tasks.addTask("event", "hopping", "home");
        tasks.addTask("deadline", "walking", "02/02/2020 10:10:10");
        assertEquals(4, tasks.getSize());
    }

}