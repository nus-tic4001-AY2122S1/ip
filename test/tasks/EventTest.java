package tasks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EventTest {
    @Test
    void testGetAt_success() {
        assertEquals("20 Feb 2000 10:10:10 to 23:12:30", new Event("running", "20/02/2000 10:10:10 to 23:12:30").getAt());
    }

    @Test
    void testToString_success() {
        assertEquals("[E][-] birthday dinner (at: 20 Feb 2000 11:11:11 to 20:20:20)", new Event("birthday dinner", "20/02/2000 11:11:11 to 20:20:20").toString());
    }
}