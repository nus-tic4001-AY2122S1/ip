package duke.dukeTaskList;
import duke.dukeTask.*;
import java.util.ArrayList;

public class DukeTaskList{
    private static ArrayList<Task> taskList;

    public DukeTaskList() {
        taskList = new ArrayList<>();
    }

    public DukeTaskList(ArrayList<Task> tasks) {
        taskList = tasks;
    }

    public static void addList(Task task) {
        taskList.add(task);
    }

    public static Task deleteList(int task) {
        return taskList.remove(task);
    }

    public static int getSize() {
        return taskList.size();
    }

    public static Task getTask(int task) {
        return taskList.get(task);
    }

    public ArrayList<Task> getAllTasks(){
        return taskList;
    }
}