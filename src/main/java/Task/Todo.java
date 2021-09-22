package Task;

import TaskPackage.Tasks;

public class Todo extends Tasks {

    protected boolean isToDo;

    public Todo(String description) {
        super(description);
        isToDo = false;
    }

    public void setToDo() {
        this.isToDo = true;
    }

    @Override
    public String toString(){
        return "[T]" + description;
    }
}
