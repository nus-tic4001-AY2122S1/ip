package duke.exception;

import duke.ui.Message;

public class InvalidArgsException extends DukeException {
    public InvalidArgsException() {
        super();
    }

    @Override
    public String getMessage() {
        return Message.exceptionInvalidArgs();
    }
}
