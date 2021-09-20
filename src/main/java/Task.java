import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Task {
    protected String description;
    protected Boolean mark = false;
    protected char toDo;
    protected String additionalDetails;
    protected LocalDateTime deadline;

    public Task(String description, boolean mark, char toDo, String additionalDetails, LocalDateTime deadline) {
        this.description = description;
        this.mark = mark;
        this.toDo = toDo;
        this.additionalDetails = additionalDetails;
        this.deadline = deadline;
    }

    public Task(String description, boolean mark, char toDo, String additionalDetails) {
        this.description = description;
        this.mark = mark;
        this.toDo = toDo;
        this.additionalDetails = additionalDetails;
    }

    public Task(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getMark() {
        return mark;
    }

    public String getMarkSymbol(){
        if(mark) {
            return ("X");
        }
        else {
            return ("");
        }
    }

    public void setMark(Boolean mark) {
        this.mark = mark;
    }

    public char getToDo() {
        return toDo;
    }

    public void setToDo(char toDo) {
        this.toDo = toDo;
    }

    public String getAdditionalDetails() {
        return additionalDetails;
    }

    public void setAdditionalDetails(String additionalDetails) {
        this.additionalDetails = additionalDetails;
    }

    public LocalDateTime getDeadline() { return deadline;}

    public void setDeadline(LocalDateTime deadline){ this.deadline = deadline;}
}
