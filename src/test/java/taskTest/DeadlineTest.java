package taskTest;

import duke.Parser;
import duke.task.Deadline;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeadlineTest {
    Deadline deadline = new Deadline("return book", "20-10-2021", Parser.convertDate("20-10-2021"));

    @Test
    void getStatusIconTest() {
        assertEquals("\u2718", deadline.getStatusIcon());
    }

    @Test
    void toStringTest() {
        assertEquals("[D][\u2718] return book (by: 10月 20 2021)", deadline.toString());
    }

    @Test
    void save_toStringTest() {
        assertEquals("D | \u2718 | return book | 20-10-2021", deadline.save_toString());
    }
}
