package exceptions;

public class DukeTaskInputException extends Exception {

    private static String errorType;

    /**
     * To initialize DukeTaskInputException
     * @param errorTypeInput the error type
     */
    public DukeTaskInputException(String errorTypeInput) {
        errorType = errorTypeInput;
    }

    /**
     * To get the error type
     *
     * @return the error type
     */
    public static String getErrorType() {
        return errorType;
    }
}
