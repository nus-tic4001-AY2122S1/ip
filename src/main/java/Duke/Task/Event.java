package Duke.Task;

public class Event extends Deadline{
    String symbol = "[E]";
    String startTime = "";
    String endTime = "";

    public Event(boolean isDone, String description, String endTime, String startTime) {
        super(isDone, description, endTime);
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Event() {
    }

    @Override
    public String getEndTime() {
        return endTime;
    }

    @Override
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString(){
        String doneSymbol = "[ ]";
        if(isDone){
            doneSymbol = "[x]";
        }
        String message = doneSymbol + ": " + symbol + " " +  description + " (from: " + startTime + " to " +  endTime + ")";
        return message;
    }

}
