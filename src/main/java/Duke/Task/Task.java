package Duke.Task;

public abstract class Task {
    boolean isDone;
    String description;
    String symbol;

    public Task() {
    }

    public Task(boolean isDone, String description) {
        this.isDone = isDone;
        this.description = description;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public void toggleDone(){
        if (this.isDone){
            this.isDone = false;
        }
        else{this.isDone = true;}
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDone() {
        return isDone;
    }

    public String getDescription() {
        return description;
    }

    public String getFormattedString(){
        // prints a task in the "[x]: get milk" format
        String doneIndicator;
        if(this.isDone){
            doneIndicator = "x";
        }
        else{
            doneIndicator = " ";
        }
        return String.format("[%s]: %s", doneIndicator, this.getDescription());

    }

}
