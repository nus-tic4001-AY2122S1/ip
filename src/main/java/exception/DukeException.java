package exception;

/**
 * Signals an error caused by missing task or unsupported command format.
 */
public class DukeException extends Exception {
    public DukeException(String message) {
        super(message);
    }
}
