package task;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DeadlineTest {
    @Test
    @DisplayName("Inserting Test Case 2 /by 2021-10-01 23:59")
    void testToString() {
        String dateTime = "2021-10-01 23:59";
        Deadline deadline = new Deadline("To complete Deadline task", dateTime);
        assertEquals("[D][✗]To complete Deadline task (by: 2021-10-01 23:59)", deadline.toString());
    }

}