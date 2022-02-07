package ip.duke.exceptions;

public class DukeException extends Exception {
    public DukeException(String message, Throwable ignoredEx) {
        super(message);
    }
}
