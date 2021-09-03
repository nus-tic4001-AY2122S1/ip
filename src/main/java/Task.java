abstract class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    abstract String getStatusIcon() {
        return "[" +(isDone ? "\u2713" : "\u2718")+"]" ; //return tick or X symbols
    }

    public String markAsDone() {
        this.isDone = true;
        return (getStatusIcon()); //return tick or X symbols
    }

    @Override
    public String toString(){
        return getStatusIcon() + " " + this.description;
    }
}