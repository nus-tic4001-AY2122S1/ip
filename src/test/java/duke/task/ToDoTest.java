package duke.task;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;



public class ToDoTest {
    @Test
    public void toDoTest1() {
        ToDo todo1 = new ToDo("Duke project");
        ToDo todo2 = new ToDo("Learn how to drive");
        ToDo todo3 = new ToDo("Learn Tennis");

        assertEquals("[T] [ ] Duke project", todo1.toString());
        assertEquals("[T] [ ] Learn how to drive", todo2.toString());
        assertEquals("[T] [ ] Learn Tennis", todo3.toString());

        todo2.editDone(true);
        assertEquals("[T] [X] Learn how to drive", todo2.toString());

    }


}
