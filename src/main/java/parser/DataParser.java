package parser;

import constant.ErrorMessage;
import exception.ErrorHandler;


public class DataParser extends Parser{
    private String taskType;
    private boolean status;

    public  DataParser(String input) throws ErrorHandler {
        this.parseInput(input);
    }

    @Override
    protected void parseInput (String input) throws ErrorHandler {
        String [] data = input.split("\\|");
        if(data.length < 1) return;

        try {
            this.taskType = data[0];
            this.status = data[1].equals("1");
            this.content = data[2];

            if(this.taskType.equals("D")){
                this.by = data[3];
                return;
            }

            if(this.taskType.equals("E")) {
                this.at = data[3];
            }
        } catch (Exception e) {
            throw new ErrorHandler("In data parser, data is in wrong format");
        }
    }

    public String getTaskType() {return  this.taskType;}
    public boolean getStatus() { return this.status; }
}
