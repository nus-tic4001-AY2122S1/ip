package parser;

import java.time.DateTimeException;
import java.util.ArrayList;
import java.util.Arrays;

import commands.AddCommand;
import commands.Command;
import commands.DeleteCommand;
import commands.ExitCommand;
import commands.FindCommand;
import commands.ListCommand;
import commands.MarkAsDoneCommand;
import commands.Schedule;
import exceptions.DukeDateTimeError;
import exceptions.DukeTaskInputException;

public class Parser {

    /**
     * To extract task description information from user input
     *
     * @param inputWords all user input in String[] type
     * @return the description in String type
     * @throws DukeTaskInputException throw all input errors
     */
    public static String toExtractDescription(String[] inputWords) throws DukeTaskInputException {
        ArrayList<String> bufferA = new ArrayList<String>();

        /* If the input is to add todo task,
           then the length of the array must greater then 1 or there is no description
         */
        if (inputWords.length < 2) {
            throw new DukeTaskInputException("descriptionMissing");
        }

        switch (inputWords[0]) {
        case "todo":
            bufferA.addAll(Arrays.asList(inputWords).subList(1, inputWords.length));

            return convertStringArrayToString(bufferA);
        case "deadline":
            for (int n = inputWords.length - 1; n > 0; n--) {
                if (inputWords[n].equals("/by")) {
                    if (n == 1) {
                        throw new DukeTaskInputException("descriptionMissing");
                    }
                    if (n == inputWords.length - 1) {
                        throw new DukeTaskInputException("dukedatetime");
                    }

                    bufferA.addAll(Arrays.asList(inputWords).subList(1, n));

                    return convertStringArrayToString(bufferA);
                }
            }
            break;
        case "event":
            for (int n = inputWords.length - 1; n > 0; n--) {
                if (inputWords[n].equals("/at")) {
                    if (n == 1) {
                        throw new DukeTaskInputException("descriptionMissing");
                    }
                    if (n == inputWords.length - 1) {
                        throw new DukeTaskInputException("dukedatetime");
                    }

                    bufferA.addAll(Arrays.asList(inputWords).subList(1, n));

                    return convertStringArrayToString(bufferA);
                }
            }
            break;
        default:
            break;
        }

        throw new DukeTaskInputException("dukedatetime");
    }

    /**
     * To extract time/date information from user input
     *
     * @param inputWords all user input in String[] type
     * @return the time/date information in String type
     * @throws DukeTaskInputException Throw all input error
     */
    public static String toExtractDate(String[] inputWords) throws DukeTaskInputException {
        ArrayList<String> bufferA = new ArrayList<String>();

        /* If the input is to add todo task,
           then the length of the array must greater then 1 or there is no description */
        if (inputWords.length == 2) {
            throw new DukeTaskInputException("descriptionMissing");
        }

        switch (inputWords[0]) {
        case "todo":
            bufferA.addAll(Arrays.asList(inputWords).subList(1, inputWords.length));

            return convertStringArrayToString(bufferA);
        case "deadline":
            for (int n = inputWords.length - 1; n > 0; n--) {
                if (inputWords[n].equals("/by")) {
                    if (n == 1) {
                        throw new DukeTaskInputException("descriptionMissing");
                    }
                    if (n == inputWords.length - 1) {
                        throw new DukeTaskInputException("dukedatetime");
                    }

                    bufferA.addAll(Arrays.asList(inputWords).subList(n + 1, inputWords.length));

                    return convertStringArrayToString(bufferA);
                }
            }
            break;
        case "event":
            for (int n = inputWords.length - 1; n > 0; n--) {
                if (inputWords[n].equals("/at")) {
                    if (n == 1) {
                        throw new DukeTaskInputException("descriptionMissing");
                    }
                    if (n == inputWords.length - 1) {
                        throw new DukeTaskInputException("dukedatetime");
                    }

                    bufferA.addAll(Arrays.asList(inputWords).subList(n + 1, inputWords.length));

                    return convertStringArrayToString(bufferA);
                }
            }
            break;
        default:
            break;
        }

        throw new DukeTaskInputException("dukedatetime");
    }

    /**
     * To convert String[] to String type
     *
     * @param strArr String[] information
     * @return String[] information in String type
     */
    public static String convertStringArrayToString(ArrayList<String> strArr) {
        StringBuilder sb = new StringBuilder();
        for (String str : strArr) {
            sb.append(str).append(" ");
        }
        return sb.substring(0, sb.length() - 1);
    }

    /**
     * To check customer input String. If the input only has one word and not "list" and "bye".
     * This function will throw an error which will tell user that the input in incorrect and please try again;
     *
     * @param firstWord  The first word of the customer input which used to compare the condition;
     * @param inputWords The customer input which used to check length;
     * @throws DukeTaskInputException The error which the input is not correct.
     */
    private static void inputLengthChecking(String firstWord, String[] inputWords) throws DukeTaskInputException {
        if (!firstWord.equals("list")
                && !firstWord.equals("bye")
                && !firstWord.equals("help")
                && !firstWord.equals("update")
                && !firstWord.equals("search")
                && !firstWord.equals("datetype")
                && !firstWord.equals("timetype")
                && !firstWord.equals("find")
                && !firstWord.equals("todoafter")
                && !firstWord.equals("processing")
                && !firstWord.equals("delete")
                && !firstWord.equals("todo")
                && !firstWord.equals("event")
                && !firstWord.equals("deadline")
                && inputWords.length == 1) {
            throw new DukeTaskInputException("cannotUnderstand");
        }
    }

    /**
     * The method to extract task index from the user input for done and delete input
     *
     * @param inputWords user input int String[] type
     * @return task index
     * @throws DukeTaskInputException all error handler
     */
    private static int toExtractNumberForDoneAndDelete(String[] inputWords) throws DukeTaskInputException {
        if (inputWords.length == 2 && inputWords[1].matches("\\d+")) { // to check whether the char is integer
            int taskIndex;

            taskIndex = Integer.parseInt(inputWords[1]);

            return taskIndex;
        } else {
            throw new DukeTaskInputException("formatWrong");
        }
    }

    /**
     * The method to parse every input command
     * @param fullCommand the full input command by user
     * @return return the Command created accordingly
     * @throws DukeTaskInputException handles all the errors about the user input
     * @throws DukeDateTimeError the error about variable date String's input date format
     */
    public static Command parse(String fullCommand) throws DukeTaskInputException, DukeDateTimeError {

        String[] inputWords = fullCommand.split(" ");
        String firstWord = inputWords[0].toLowerCase();

        Parser.inputLengthChecking(firstWord, inputWords);

        switch (firstWord) {
        case "bye":
            return new ExitCommand();
        case "delete":
            return createDeleteCommand(inputWords);
        case "done":
            return createMarkAsDoneCommand(inputWords);
        case "list":
            return new ListCommand();
        case "todo":
        case "deadline":
        case "event":
            return createAddCommand(firstWord, inputWords);
        case "find":
            return new FindCommand(inputWords[1]);
        case "schedule":
            return new Schedule(inputWords[1]);
        default:
            break;
        }

        throw new DukeTaskInputException("commandCreateError");
    }

    /**
     * The method to create deleteCommand
     *
     * @param inputWords the user input in String[] format
     * @return return DeletedCommanded created according to the user input
     * @throws DukeTaskInputException handles all errors about the user input
     */
    private static DeleteCommand createDeleteCommand(String[] inputWords) throws DukeTaskInputException {
        int taskIndex = toExtractNumberForDoneAndDelete(inputWords);
        return new DeleteCommand(taskIndex);
    }

    /**
     * The method to create MarkAsDoneCommand
     *
     * @param inputWords the user input in String[] format
     * @return return MarkAsDoneCommand created according to the user input
     * @throws DukeTaskInputException handles all errors about the user input
     */
    private static MarkAsDoneCommand createMarkAsDoneCommand(String[] inputWords) throws DukeTaskInputException {
        int taskIndex = toExtractNumberForDoneAndDelete(inputWords);

        return new MarkAsDoneCommand(taskIndex);
    }

    /**
     * The method to create AddCommand
     *
     * @param inputWords the user input in String[] format
     * @return return AddCommand created according to the user input
     * @throws DukeTaskInputException handles all errors about the user input
     */
    private static AddCommand createAddCommand(String firstWord, String[] inputWords) throws DukeTaskInputException {
        return new AddCommand(firstWord, inputWords);
    }

    /**
     * The method to extract starting date time from user input
     *
     * @param input user input command in String format
     * @return starting date time in String format
     * @throws DukeDateTimeError handles all errors about DukeDateTime creation
     */
    public static String extractStartingDateTime(String input) throws DukeDateTimeError {
        String[] words = input.split(" ");
        ArrayList<String> buffer = new ArrayList<String>();

        for (int n = words.length - 1; n > 0; n--) {

            if (words[n].equals("->")) {

                if (n == 1) {
                    throw new DukeDateTimeError("dateFormatWrong");
                }

                buffer.addAll(Arrays.asList(words).subList(0, n));
                return convertStringArrayToString(buffer);
            }
        }

        throw new DateTimeException("dateFormatWrong");
    }

    /**
     * The method to extract ending date time from user input
     *
     * @param input user input command in String format
     * @return ending date time in String format
     * @throws DukeDateTimeError handles all errors about DukeDateTime creation
     */
    public static String extractEndingDateTime(String input) throws DukeDateTimeError {
        String[] words = input.split(" ");

        ArrayList<String> buffer = new ArrayList<String>();

        for (int n = words.length - 1; n > 0; n--) {
            if (words[n].equals("->")) {
                if (n == 1) {
                    throw new DukeDateTimeError("dateFormatWrong");
                }
                if (n == words.length - 1) {
                    throw new DateTimeException("dateFormatWrong");
                }

                buffer.addAll(Arrays.asList(words).subList(n + 1, words.length));

                return convertStringArrayToString(buffer);
            }
        }

        throw new DateTimeException("dateFormatWrong");
    }
}
