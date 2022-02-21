package duke.task;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;


public class TaskListTest {

    @Test
    public void taskListTest1() {

        ToDo t = new ToDo("Learn Java");
        TaskList tasks = new TaskList();
        tasks.addTask(t);

        assertEquals(1, tasks.getSize());
        assertEquals(t, tasks.getTask(0));
    }

    @Test
    public void taskListTest2() {

        LocalDate d1 = LocalDate.parse("2019-12-12");
        Event e = new Event("Learn Java", d1);
        TaskList tasks = new TaskList();
        tasks.clearAll();
        tasks.addTask(e);

        assertEquals(1, tasks.getSize());
        assertEquals(e, tasks.getTask(0));
        assertEquals(0, tasks.getTask(0).getTaskIndex());
    }
}
