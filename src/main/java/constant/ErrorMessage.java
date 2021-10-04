package constant;

/**
 * Constants for error messages
 */
public class ErrorMessage {
    public static final String EMPTY_TODO = "OOPS!!! The description of a todo cannot be empty.";
    public static final String EMPTY_DEADLINE = "OOPS!!! The description of a deadline cannot be empty.";
    public static final String EMPTY_EVENT = "OOPS!!! The description of a event cannot be empty.";
    public static final String EMPTY_TASK_NUMBER = "OOPS!!! The task number cannot be empty.";
    public static final String INVALID_TASK_NUMBER = "OOPS!!! The task number is invalid.";
    public static final String INVALID_DEADLINE = "OOPS!!! The deadline description is invalid, missing '/by'.";
    public static final String INVALID_EVENT = "OOPS!!! The event description is invalid, missing '/at'.";
    public static final String INVALID_COMMAND = "OOPS!!! I'm sorry, but I don't know what that means.";
    public static final String INVALID_DATA_FORMAT = "OOPS!!! I'm sorry, data from local file is in wrong format";
    public static final String ERROR_WRITING_FILE = "OOPS!!! I'm sorry, error occurred while saving data to file";
    public static final String ERROR_LOADING_FILE = "OOPS!!! I'm sorry, error occurred while loading data from file.";
    public static final String ERROR_FINDING_FILE = "Setting up new storage for you.";
}
