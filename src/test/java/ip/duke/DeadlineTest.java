package ip.duke;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class DeadlineTest {
    @Test
    public void getByTest() {
        Deadline schedule = new Deadline("Finish Assignment", "2:30pm Fri");
        assertEquals("2:30pm Fri", schedule.getBy());
    }

    @Test
    public void setIdTest() {
        Deadline schedule = new Deadline("Return the book", "Monday");
        schedule.setId();
        assertEquals('D', schedule.getId());
    }

    @Test
    public void toStringTest() {
        Deadline schedule = new Deadline("Visit the Sport Centre", "Aug 2019");
        assertEquals("Visit the Sport Centre (by: Aug 2019)", schedule.toString());
    }
}
