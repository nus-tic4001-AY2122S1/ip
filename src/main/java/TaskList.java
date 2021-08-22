import java.util.ArrayList;

public class TaskList {
    protected ArrayList<Task> taskList;

    public TaskList(ArrayList<Task> taskList){
        this.taskList = taskList;
    }

    public void addTaskCommand (String fullCommand) {
        String description = fullCommand;
        Task t = new Task(description);
        taskList.add(t);
        UI.addMessage(t.description);
    }
}
