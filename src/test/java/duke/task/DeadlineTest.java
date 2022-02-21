package duke.task;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.Test;

public class DeadlineTest {

    @Test
    public void deadlinesTestA() {

        LocalDate d1 = LocalDate.parse("2019-12-12");
        LocalTime t1 = LocalTime.parse("10:00");
        Deadline dead1 = new Deadline("Phone bills", d1);
        Deadline dead2 = new Deadline("Duke", d1, t1);

        assertEquals("[D] [ ] Phone bills (by: Dec 12 2019)", dead1.toString());
        assertEquals("[D] [ ] Duke (by: Dec 12 2019 10:00 AM)", dead2.toString());
        assertEquals("Dec 12 2019", dead1.getDateTimeStringFormat());
        assertEquals("Dec 12 2019 10:00 AM", dead2.getDateTimeStringFormat());
        assertEquals("2019-12-12", dead1.getDateTimeString());
        assertEquals("2019-12-12 10:00", dead2.getDateTimeString());

    }
}
