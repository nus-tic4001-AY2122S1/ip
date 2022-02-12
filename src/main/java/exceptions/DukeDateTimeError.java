package exceptions;

public class DukeDateTimeError extends Throwable {
    private String errorType;

    public DukeDateTimeError(String errorType) {
        this.errorType = errorType;
    }
}
