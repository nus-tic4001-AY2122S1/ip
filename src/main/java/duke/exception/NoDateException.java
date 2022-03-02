package duke.exception;

import duke.ui.Message;

/**
 * This is an exception that triggered when
 * tasks like event and deadline does not
 * initiated correctly with date
 */
public class NoDateException extends DukeException {
    public NoDateException() {
        super();
    }

    @Override
    public String getMessage() {
        return Message.exceptionNoDate();
    }
}
