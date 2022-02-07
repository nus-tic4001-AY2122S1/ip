package ip.duke;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TodoTest {
    @Test
    public void descTest() {
        Todo task = new Todo("return a book");
        assertEquals("return a book", task.getDescription());

    }

    @Test
    public void setIdTest() {
        Todo task = new Todo("read another book");
        assertEquals('T', task.getId());
    }

    @Test
    public void toFileStringTest() {
        Todo task = new Todo("borrow a book");
        task.setDone();
        assertEquals("T : 1 : borrow a book", task.toFileString());
    }

}
