package task;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TodoTest {
    @Test
    @DisplayName("Inserting Test Case 1 ")
    void testToString() {
        Todo todo = new Todo("To complete Todo task");
        assertEquals("[T][✗]To complete Todo task", todo.toString());
    }

}