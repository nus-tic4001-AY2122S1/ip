package duke.command;

import duke.storage.Storage;
import duke.task.Deadline;
import duke.task.Event;
import duke.task.Parser;
import duke.task.Task;
import duke.task.TaskList;
import duke.ui.Ui;

import java.time.LocalDateTime;

/**
 * Check Command represents a user wanting to check the task list
 */
public class CheckCommand extends Command {
    private String raw_time;
    private LocalDateTime check_time;
    public String getCheck_time(){
        if(check_time != null){
            return check_time.toString();
        }
        else return raw_time;
    }
    /**
     * Checks TaskList for tasks that have a date, and print them if they are on the same date.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.printEventsOnDateMsg(getCheck_time());
        int count = 0;
        for (int i = 0; i < tasks.size(); i++) {
            Task curr = tasks.get(i);
            if (curr.getClass() == Event.class) {
                Event e = (Event) curr;
                LocalDateTime dateTime = e.getStart_endTime();
                if(dateTime != null){
                    if(dateTime.toLocalDate().isEqual(check_time.toLocalDate())){
                        ui.printTask(e);
                        count++;
                    }
                }
                else{
                    String dateTimeStr = e.getRaw_start_endTime();
                    if(dateTimeStr.equals(raw_time)){
                        ui.printTask(e);
                        count++;
                    }
                }

            }
            if (curr.getClass() == Deadline.class) {
                Deadline d = (Deadline) curr;
                //here we need to see if both can be converted to LocalDate.
                //Otherwise, just compare the strings.
                LocalDateTime deadline = d.getDeadline();
                if(deadline != null){
                    if(deadline.toLocalDate().isEqual(check_time.toLocalDate())){
                        ui.printTask(d);
                        count++;
                    }
                }
                else{
                    String deadlineStr = d.getRaw_deadline();
                    if(deadlineStr.equals(raw_time)){
                        ui.printTask(d);
                        count++;
                    }
                }
            }
        }
        if(count == 0){
            ui.printNoEventOnDateMsg();
        }
    }

    public CheckCommand(String time_str) {
        raw_time = time_str;
        check_time = Parser.parseDateTimeStr(time_str);
    }
}
