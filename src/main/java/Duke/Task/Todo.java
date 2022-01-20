package Duke.Task;

public class Todo extends Task{
    String description;
    String symbol = "[T]";

    public Todo() {
    }

    public Todo(boolean isDone, String description) {
        super(isDone, description);
    }

    public Todo(String description) {
        this.description = description;
    }

    @Override
    public String toString(){
        String doneSymbol = "[ ]";
        if(isDone){
            doneSymbol = "[x]";
        }
        String message = doneSymbol + ": " + symbol + " " +  description;
        return message;
    }
}
