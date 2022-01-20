import Duke.Task.*;
import Duke.exceptions.DukeEmptyListException;

public class Operations {

    TaskList database;

    public Operations(){}

    public void setDatabase(TaskList database) {
        this.database = database;
    }

    public TaskList getDatabase() {
        return database;
    }

    public void addToDatabase(Task task) {

        this.database.addTask(task);
    }

    public void addToDatabase(Todo todo) {
        this.database.addTask(todo);
    }

    public void addToDatabase(Event event) {
        this.database.addTask(event);
    }

    public void addToDatabase(Deadline deadline) {this.database.addTask(deadline);}

    public void deleteFromDatabase(int i) {
        this.database.deleteTask(i);
    }

    public void printDatabase() throws DukeEmptyListException {
        if (database.size() == 0){
            throw new DukeEmptyListException("List is empty. Please add items first.");
        }
        for(int i=0; i < database.size(); i++){
            System.out.println(i +  ": " + database.getTask(i));
        }
    }

    public Task getTask(int i){
        return database.getTask(i);
    }

    public void setDone(int i) {
        getTask(i).toggleDone();
    }
}
