package duke.exception;

import duke.ui.Message;

public class UnknownCommandException extends DukeException {
    public UnknownCommandException() {
        super();
    }

    @Override
    public String getMessage() {
        return Message.exceptionUnknownCommand();
    }
}
