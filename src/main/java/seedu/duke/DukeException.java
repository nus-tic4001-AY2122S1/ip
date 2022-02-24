package seedu.duke;

public class DukeException extends Exception {
    private String message;
    public DukeException(String message) {
        super(message);
        this.message = message;
    }

    public void printErrorMessage() {
        System.out.println("\t____________________________________________________________");
        System.out.println(message);
        System.out.println("\t____________________________________________________________");
    }
}
