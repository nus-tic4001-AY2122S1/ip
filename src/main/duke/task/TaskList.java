package duke.task;

import duke.exception.DukeException;
import duke.exception.DukeUnknownException;
import duke.storage.Storage;

import java.util.ArrayList;

/**
 * Class representative of List of Task with helper methods. contains the task list e.g., it has operations to add/delete tasks in the list.
 * Refer to More OOP.
 */
public class TaskList {
    private ArrayList<Task> tasks;

    public static String listTasks(ArrayList<Task> task_list) {
        String tasksStr = "";
        int i = 0;
        for (Task t : task_list) {
            tasksStr += String.format("%d: %s\n", ++i, t);
        }
        return tasksStr;
    }
    public String listTasks() {
        return listTasks(tasks);
    }
    public String printTasks() {
        String list = listTasks();
        System.out.print(list);
        return list;
    }

    /**
     * Parses the string passed over from the UpdateCommand (Add) and adds into the list.
     * @param s
     * @return True if successfully added, else False.
     * @throws DukeException
     */
    public boolean add(String s) throws DukeException {
        Task t;
        boolean done = true;
        String[] str_arr = s.split(" ");
        int startDescIndex = s.indexOf(String.format("[%c]", Task.CHECKMARK));  // done
        int lastDescIndex = s.length();
        if (startDescIndex == -1) {
            startDescIndex = s.indexOf(String.format("[%c]", Task.CROSSMARK));  //not done
            done = false;
        }
        switch (str_arr[1].charAt(1)) {
            case 'D':
                //1: [D][X] tic2002 (by: today)
                lastDescIndex = s.lastIndexOf(" (by: ");
                t = new Deadline(s.substring(startDescIndex + 4, lastDescIndex), s.substring(lastDescIndex + 6, s.length() - 1));
                break;
            case 'E':
                //2: [E][X] tp visit (at: today)
                lastDescIndex = s.lastIndexOf(" (at: ");
                t = new Event(s.substring(startDescIndex + 4, lastDescIndex), s.substring(lastDescIndex + 6, s.length() - 1));
                break;
            case 'T':
                //234: [T][X] awd
                t = new ToDo(s.substring(startDescIndex + 4, lastDescIndex));
                break;
            default:
                throw new DukeUnknownException();
        }
        t.setDone(done);
        return tasks.add(t);
    }

    public boolean add(Task t) {
        return tasks.add(t);
    }

    public Task remove(int i) {
        if (i < this.size())
            return tasks.remove(i);
        else throw new IndexOutOfBoundsException("Index out of bounds");
    }

    public Task get(int i) {
        return tasks.get(i);
    }

    public ArrayList<Task> find(String s) {
        ArrayList<Task> result = new ArrayList<>();
        for (Task t : tasks) {
            if (t.getDescription().toLowerCase().contains(s.toLowerCase())) {
                result.add(t);
            }
        }
        return result;
    }

    public void done(int i) {
        Task currTask = get(i);
        assert currTask != null;
        currTask.setDone(true);
    }

    public int size() {
        return tasks.size();
    }

    public void edit(int pos, Task t) {
        assert pos < tasks.size();
        tasks.set(pos, t);
    }

    public TaskList(Storage s) throws DukeException {
        tasks = new ArrayList<>();
        s.readSaveFile(this);
    }
}
