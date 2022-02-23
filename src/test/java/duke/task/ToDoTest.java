package duke.task;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ToDoTest {

    @Test
    public void toDoTest1(){
        ToDo todo1 = new ToDo("Maths");
        ToDo todo2 = new ToDo("Shower");

        assertEquals("[T] [ ] Maths",todo1.toString());
        assertEquals("[T] [ ] Shower",todo2.toString());

    }
}
