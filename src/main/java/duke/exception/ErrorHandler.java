package duke.exception;

/**
 * error messages.
 */

public class ErrorHandler extends Exception {
    public ErrorHandler(String errorMessage) {
        super(errorMessage);
    }
}
