package duke;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.time.Month;

import org.junit.jupiter.api.Test;

import duke.parse.StringParser;


public class DukeTest {
    @Test
    public void testParseEvent() {
        String line = "[E][ ] Event (at: 01.Jan.22 15:00 - 16:45)";
        String[] parts = line.split("]", 3);
        String[] args = parts[2].strip().split("\\(at:");
        args[1] = args[1].replace(")", "");

        LocalDateTime[] actual = StringParser.parseEvent(args);

        LocalDateTime from = LocalDateTime.of(2022,
                                              Month.JANUARY,
                                   01,
                                         15, 00);
        LocalDateTime till = LocalDateTime.of(2022,
                                               Month.JANUARY,
                                   01,
                                         16, 45);

        assertEquals(from, actual[0]);
        assertEquals(till, actual[1]);

    }

    @Test
    public void testGetTime() {
        String[] datetimes = {
            "2022-02-01 0900",
            "01.Feb.22 09:00",
            "2022-02-01 900",
            "2022-2-1 900",
            "2022-2-01 900",
            "2022-2-1 9"
        };

        LocalDateTime expected = LocalDateTime.of(2022,
                                                  Month.FEBRUARY,
                                       01,
                                             9, 00);

        for (String t : datetimes) {
            LocalDateTime actual = StringParser.getTime(t);
            assertEquals(expected, actual);
        }

    }

}
