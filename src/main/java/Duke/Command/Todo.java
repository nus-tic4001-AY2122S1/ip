package Duke.Command;

import Duke.Task.Tasks;

public class Todo extends Tasks {

    protected boolean isToDo;

    public Todo(String description) {
        super(description);
        isToDo = false;
    }


    public void setToDo() {
        this.isToDo = true;
    }

    /***
     *
     * @return Override the toString() method
     */
    @Override
    public String toString(){
        return "[T]" + description;
    }
}
