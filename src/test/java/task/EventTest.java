package task;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EventTest {
    @Test
    @DisplayName("Inserting Test Case 3 /by 2021-10-01 23:59")
    void testToString() {
        String dateTime = "2021-10-01 23:59";
        Event event = new Event("To complete Event task", dateTime);
        assertEquals("[E][✗]To complete Event task (at: 2021-10-01 23:59)", event.toString());
    }
}