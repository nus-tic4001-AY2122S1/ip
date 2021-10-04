package parser;

import command.Command;
import exception.ErrorHandler;

public abstract class Parser {
    protected String content = "";
    protected String by = "";
    protected String at = "";

    public abstract Command parse(String userInput) throws ErrorHandler;
}
