package duke.task;

import duke.exception.DukeMissingDescException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class TaskTest {
    @Test
    public void SetDoneTest() throws DukeMissingDescException {
        Task t = new ToDo("Test Task.");
        t.setDone(false);
        assertEquals(false, t.isDone);
        t.setDone(true);
        assertEquals(true, t.isDone);
    }
    @Test
    public void SetDescriptionTest() throws DukeMissingDescException {
        String desc = "Test Task.";
        Task t = new ToDo(desc);
        desc = "Updated Description";
        t.setDescription(desc);
        assertEquals(desc, t.getDescription());
    }
}
