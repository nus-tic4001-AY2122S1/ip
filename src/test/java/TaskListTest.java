/*
import exceptions.DukeStorageError;
import org.junit.Test;
import taskclasses.*;

import java.util.Vector;

import static org.junit.Assert.assertEquals;

public class TaskListTest {
    @Test
    public void getTaskTest(){
        Vector<Task> testingV = new Vector<>();
        TaskList testingTaskList;

        Event testingEvent = new Event("project meeting", false, "2021-10-11 10:00 -> 2021-10-11 12:00");
        Deadline testingDeadline = new Deadline("return book", false, "2022-01-05 12:00");
        Todo testingTodo = new Todo("morning", false);

        testingV.add(testingDeadline);
        testingV.add(testingEvent);
        testingV.add(testingTodo);

        testingTaskList = new TaskList(testingV);


        assertEquals(testingDeadline, testingTaskList.getTask(0));
    }

    @Test
    public void getDateTimeTest() throws DukeStorageError {
        Vector<Task> testingV = new Vector<>();
        TaskList testingTaskList;

        Event testingEvent = new Event("project meeting", false, "2021-10-11 10:00 -> 2021-10-11 12:00");
        Deadline testingDeadline = new Deadline("return book", false, "2022-01-05 12:00");
        Todo testingTodo = new Todo("morning", false);

        testingV.add(testingDeadline);
        testingV.add(testingEvent);
        testingV.add(testingTodo);

        testingTaskList = new TaskList(testingV);

        String expectedResult = "2021-10-11 10:00 -> 2021-10-11 12:00";

        assertEquals(expectedResult, testingTaskList.getDateTime(1));
    }

    @Test
    public void toPrintEntireTaskList() throws DukeTaskInputException {
        Vector<Task> testingV = new Vector<>();
        TaskList testingTaskList;

        Event testingEvent = new Event("project meeting", false, "2021-10-11 10:00 -> 2021-10-11 12:00");
        Deadline testingDeadline = new Deadline("return book", false, "2022-01-05 12:00");
        Todo testingTodo = new Todo("morning", false);

        testingV.add(testingDeadline);
        testingV.add(testingEvent);
        testingV.add(testingTodo);

        testingTaskList = new TaskList(testingV);
        testingTaskList.deleteTask(1);
        int expectedResult = 2;

        assertEquals(expectedResult, testingTaskList.size());
    }
}
*/
