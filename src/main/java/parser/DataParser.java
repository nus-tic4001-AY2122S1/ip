package parser;

import command.*;
import constant.ErrorMessage;
import exception.ErrorHandler;
import task.Deadline;
import task.Event;
import task.Todo;

public class DataParser extends Parser{
    private String taskType;
    private boolean status;

    /**
     * @param input string which is read from a text file, in the format of 'D|1|return book|June 6th'
     * @throws ErrorHandler customized error
     */
    public Command parse (String input) throws ErrorHandler {
        String [] data = input.split("\\|");
        if(data.length < 1) throw new ErrorHandler(ErrorMessage.INVALID_DATA_FORMAT);

        try {
            this.taskType = data[0];
            this.status = data[1].equals("1");
            this.content = data[2];

            if(this.taskType.equals("D")){
                this.by = data[3];
                return new DataCommand(new Deadline(this.content, this.by, this.status));
            }

            if(this.taskType.equals("E")) {
                this.at = data[3];
                return new DataCommand(new Event(this.content, this.at, this.status));
            }

            return new DataCommand(new Todo(this.content, this.status));
        } catch (Exception e) {
            throw new ErrorHandler(ErrorMessage.INVALID_DATA_FORMAT);
        }
    }
}
