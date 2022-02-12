package parser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static parser.Parser.convertStringArrayToString;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import exceptions.DukeTaskInputException;

class ParserTestNew {

    @Test
    void toExtractDescription() throws DukeTaskInputException {
        Parser pp = new Parser();
        String testingCommand = "event project meeting /at 2021-12-31 11:00 -> 2021-12-31 12:00";

        String expectedResult = "2021-12-31 11:00 -> 2021-12-31 12:00";

        assertEquals(expectedResult, pp.toExtractDate(testingCommand.split(" ")));
    }

    /*@Test
    public void toExtractDescriptionTest() throws DukeTaskInputException {
        String testingCommand = "event project meeting /at 2021-12-31 11:00 -> 2021-12-31 12:00";
        String[] testingCommandString = testingCommand.split(" ");
        String expectedResult = "project meeting";

        assertEquals(expectedResult, toExtractDescription(testingCommandString));
    }*/

    @Test
    public void convertStringArrayToStringTest() {
        String testStr = "I am going to sleep";
        String[] strT = testStr.split(" ");
        ArrayList<String> bufferA = new ArrayList<String>();

        bufferA.addAll(Arrays.asList(strT).subList(1, strT.length));

        String expectedResult = "am going to sleep";

        assertEquals(expectedResult, convertStringArrayToString(bufferA));
    }
}
