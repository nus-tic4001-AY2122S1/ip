package duke.parse;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class StringParserTest {
    @Test
    public void testGetTags() {
        String title = "ip due: tmr. :nus:4002: solo2:10min:";
        ArrayList<String> tags = StringParser.getTags(title);
        for (int i = 0; i < tags.size(); i++) {
            // System.out.println(tags[i].equals(""));
            switch (i) {
            case 0:
                assertEquals("nus", tags.get(i));
                break;
            case 1:
                assertEquals("4002", tags.get(i));
                break;
            case 2:
                assertEquals("solo2", tags.get(i));
                break;
            case 3:
                assertEquals("10min", tags.get(i));
                break;
            default:
                assert true;
            }
        }
    }
}
