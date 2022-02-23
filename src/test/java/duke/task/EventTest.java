package duke.task;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EventTest {

    @Test
    public void EventTest1() {

        string date = string.parse("2021-11-11");
        Event e1 = new Event("Learn Java", date);

        assertEquals("[E] [ ] Learn Java (at: Dec 12 2019)", e1.toString());

    }
}
