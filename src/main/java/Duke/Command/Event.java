package Duke.Command;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

import Duke.Task.Tasks;

public class Event extends Tasks {

    protected boolean isEvent;
    protected String at;
    protected Date date_by;
    protected String atDate;
    SimpleDateFormat format1 = new SimpleDateFormat("dd-MMM-yy hh:mm a");


    /**
     *
     * @param description for Event task description
     * @param at string enter by user after keyword /at
     */
    public Event(String description, String at) {
        super(description);
        this.at = at;
        System.out.println("at"+ this.at);
        isEvent = false;
    }

    /***
     *
     * @return Override the toString() method
     */
    @Override
    public String toString(){
        try{
            atDate  = at.trim();
            int timeIndex = atDate.indexOf(" ");

            LocalDate d1 = LocalDate.parse(atDate);
            atDate = d1.format(DateTimeFormatter.ofPattern("MMM dd yyyy"));

            return "[E]" + description +  "(at:" + atDate + ")" ;

        } catch (DateTimeParseException e) {
//            Ui.dateTimeInvalidFormat();
        }
        return "[E]" + description +  "(at:" + at  + ")" ;
    }
}
