package task;

public class Todo extends Task{
    public Todo(String description, boolean status) {
        super(description);
        this.setStatus(status);
    }

    /**
     * @return string which is in a readable format for printing to user
     */
    @Override
    public String toString() {
        return "[T]" +  "[" + this.getStatusIcon() + "] " + this.description;
    }

    /**
     * @return string which is in a specific format to save to local file
     */
    @Override
    public String toDataFormat() {
        String status = this.isDone ? "1" : "0";
        return "T"+ "|" + status + "|" + this.description;
    }
}
