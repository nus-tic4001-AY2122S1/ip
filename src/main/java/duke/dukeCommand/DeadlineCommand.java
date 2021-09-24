package duke.dukeCommand;
import duke.dukeUI.*;
import duke.dukeTaskList.*;
import duke.dukeStorage.*;
import duke.dukeException.*;
import duke.dukeUI.*;
import duke.dukeTask.*;
import java.io.IOException;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DeadlineCommand extends Command{

    private DeadlineCommand deadline;
    private static SimpleDateFormat format = new SimpleDateFormat ("dd-MM-yyyy HH:mm:ss");

    public DeadlineCommand(String input){
        super(input);
    }

    public static Date convertDateTime(String deadline) throws ParseException, DukeException {

        Date date;
        try {
            date = format.parse(deadline);
            return date;
        } catch (ParseException e) {
            System.out.println("You have enter the wrong date format please use \"dd-MM-yyyy HH:mm:ss\" ");
            date = format.parse("00-00-0000 00:00:00");
            return date;
        }
    }

    @Override
    public void execute(DukeTaskList taskList, DukeUI ui, DukeStorage storage){
        try{

            System.out.println(input);

            //throw new DukeException("Index out of Bounds during deadline command");
            String description = input.trim().substring(0, input.trim().indexOf("/by")-1);
            String date = input.trim().substring(input.trim().indexOf("/by")+4, input.trim().length());
            Date saveDate = convertDateTime(date);
            Date allZero = convertDateTime("00-00-0000 00:00:00");
            if(saveDate.compareTo(allZero) == 1){
                DukeStorage.saveFunction(new Deadline(description, saveDate));
                DukeStorage.saveToFile("D",description,date);
            }
        }catch(IndexOutOfBoundsException e){
            System.out.println(e);
            //
        }catch(IOException e1){
            e1.printStackTrace();
        }catch(ParseException e){
            System.out.println("please enter the correct date format \"dd-MM-yyyy HH:mm:ss\" ");
            //throw new DukeException("☹ OOPS!!! Please check deadline command that you have key in is in correct format.");
        }catch(DukeException e){
            System.out.println(e);
        }
    }
}