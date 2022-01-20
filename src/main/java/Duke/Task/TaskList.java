package Duke.Task;

import java.util.ArrayList;
public class TaskList {

    private ArrayList<Task> tasks;

    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public boolean addTask(Task task){
        this.tasks.add(task);
        return true;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public Task getTask(int i){
        return tasks.get(i);
    }

    public void deleteTask(int i) {
        tasks.remove(i);
    }

    public String getTaskDescription(int i){
        return tasks.get(i).getDescription();

    }

    public int size() {
        return tasks.size();
    }
}
