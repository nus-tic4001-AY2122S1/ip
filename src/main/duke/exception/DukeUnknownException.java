package duke.exception;

public class DukeUnknownException extends DukeException {
    @Override
    public String getMessage() {
        return "OOPS!!! I'm sorry, but I don't know what that means :-(";
    }
}
