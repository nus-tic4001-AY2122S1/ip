package Duke.Command;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeadlineTest {


    @Test
    public void deadlineTest(){
        Deadline dealine = new Deadline("duke project","Sunday");
        assertEquals("[D]duke project(by:Sunday)",dealine.toString());
    }
}