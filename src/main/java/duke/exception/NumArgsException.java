package duke.exception;

import duke.ui.Message;

/**
 * Exception when a command does not get
 * correct number of arguments
 */
public class NumArgsException extends DukeException {
    public NumArgsException() {
        super();
    }

    @Override
    public String getMessage() {
        return Message.exceptionNumArgs();
    }
}
