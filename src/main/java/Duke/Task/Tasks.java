package Duke.Task;

import java.util.ArrayList;
import java.util.Iterator;


public class Tasks {
    protected String description;
    protected boolean isDone;
    protected ArrayList<Task> addedList = new ArrayList<>();


    public Tasks(String description) {
        this.description = description;
        this.isDone = false;
    }

    /***
     * Get Status Icon when done or not done
     * @return done return ✓ else return ✘ symbols
     */
    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }


    /**
     * Mark the certain task is done
     * @param doneIndex the index to mark as done
     * @return string with task's status and description
     */
    public String markAsDone(int doneIndex) {
        this.isDone = true;
        return ("[" + getStatusIcon() + "]" + this.addedList.get(doneIndex).desc);
    }

    /**
     * Modify the status of task is done
     * @param doneIndex the index to add done for the task
     */
    public void addDone(int doneIndex) {
        int index = 0;

        Iterator itr = this.addedList.iterator();
        while (itr.hasNext()) {

            Task t = (Task)itr.next();
            if(doneIndex == index) {
                t.status = true;
            }
            ++index;
        }
    }


    /**
     * Get all the task list from system, iterate the added list, print at the UI
     * @param addedList input the latest added list
     */
    public void getList(ArrayList<Task> addedList) {
        int index1 = 0;

        this.addedList = addedList;

        System.out.println("-------------------------------");
        System.out.println("Here are the TaskPackage.Task in your list:");
        Iterator itr = addedList.iterator();
        while (itr.hasNext()){
            Task t = (Task)itr.next();
            System.out.println("    " + ++index1 + ". " + "[" + (t.status ? "\u2713" : "\u2718") + "]" + t.desc);
        }
        System.out.println("-------------------------------");
    }


    /**
     *
     * @return the number of the list
     */
    public int getNumOfList(){
        return this.addedList.toArray().length;
    }


    /**
     * Remove the certain task by removeTaskNumber
     * @param removeTaskNumber
     */
    public void removeTaskList(int removeTaskNumber) {

        System.out.println("-------------------------------");
        System.out.println("Noted. I've removed this task: ");
        System.out.println("    "+ "[" + (this.addedList.get(removeTaskNumber).status ? "\u2713" : "\u2718") + "]" + this.addedList.get(removeTaskNumber).desc);
        System.out.println("-------------------------------");
        this.addedList.remove(removeTaskNumber);
        System.out.println("Now you have "+this.addedList.toArray().length +" tasks in the list.");
    }

}


