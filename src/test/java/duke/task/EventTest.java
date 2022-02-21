package duke.task;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.Test;


public class EventTest {
    @Test
    public void eventTestA() {

        LocalDate d1 = LocalDate.parse("2019-12-12");
        LocalTime t1 = LocalTime.parse("10:00");
        Event e1 = new Event("Learn Java", d1);
        Event e2 = new Event("Finals", d1, t1);

        assertEquals("[E] [ ] Learn Java (at: Dec 12 2019)", e1.toString());
        assertEquals("[E] [ ] Finals (at: Dec 12 2019 10:00 AM)", e2.toString());
        assertEquals("Dec 12 2019", e1.getDateTimeStringFormat());
        assertEquals("Dec 12 2019 10:00 AM", e2.getDateTimeStringFormat());
        assertEquals("2019-12-12", e1.getDateTimeString());
        assertEquals("2019-12-12 10:00", e2.getDateTimeString());

    }
}
