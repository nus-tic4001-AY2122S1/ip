package duke.task;

import duke.command.CheckCommand;
import duke.command.Command;
import duke.command.ExitCommand;
import duke.command.FindCommand;
import duke.command.ListCommand;
import duke.command.UpdateCommand;
import duke.exception.DukeException;
import duke.exception.DukeMissingDescException;
import duke.exception.DukeMissingParamException;
import duke.exception.DukeUnknownException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.Arrays;


/**
 *  deals with making sense of the user command
 */
public class Parser {

    /**
     * @param dt_str String representing LocalDateTime
     * @return A LocalDateTime object as closely corresponding to dt_str
     */
    public static LocalDateTime parseDateTimeStr(String dt_str) {
        //early exit.
        if (Parser.isValidISODateTimeStr(dt_str)) {
            return LocalDateTime.parse(dt_str);
        }
        LocalDateTime parsed_time;
        LocalTime time = null;
        LocalDate date = null;

        if (Parser.isValidISODateStr(dt_str)) {
            date = LocalDate.parse(dt_str);
        } else if (Parser.isValidISOTimeStr(dt_str)) {
            time = LocalTime.parse(dt_str);
        } else {  //do magic parsing...
            //2/12/2019 1800
            //dd/mm/yyyy tttt
            String[] temp = dt_str.split(" ");
            //First, if contains alphabets, it will have stuff like "Sunday", etc. If so, don't parse to datetime.
            for (String s : temp) {
                var charArr = s.toCharArray();
                for (char c : charArr) {
                    if (Character.isAlphabetic(c)) {
                        return null;
                    }
                }
            }

            if (temp[0].indexOf('/') != -1) {
                date = strToDate(temp[0], '/');
            }
            if (temp[0].indexOf('-') != -1) {
                date = strToDate(temp[0], '-');
            }
            if (temp.length > 1) {
                time = strToTime(temp[1]);
            } else if (date == null) {
                time = strToTime(temp[0]);
            }
        }
        parsed_time = LocalDateTime.of((date == null) ? LocalDate.now() : date, (time == null) ? LocalTime.MIDNIGHT : time);
        return parsed_time;
    }

    private static LocalDate strToDate(String s, char split) {
        String[] date_strs = s.split(String.valueOf(split));
        return LocalDate.of(Integer.parseInt(date_strs[2]), Integer.parseInt(date_strs[1]), Integer.parseInt(date_strs[0]));
    }

    private static LocalTime strToTime(String s) {
        LocalTime time;
        if (Parser.isValidISOTimeStr(s))
            time = LocalTime.parse(s);
        else {
            int hr, min;
            if (s.indexOf(':') != -1) {
                String[] time_strs = s.split(":");
                hr = Integer.parseInt(time_strs[0]);
                min = Integer.parseInt(time_strs[1]);
            } else {
                hr = Integer.parseInt(s.substring(0, 2));
                min = Integer.parseInt(s.substring(2));
            }
            time = LocalTime.of(hr, min);
        }
        return time;
    }
    //region validity checks for string parsing.

    private static boolean isValidISODateTimeStr(String s) {
        try {
            LocalDateTime.parse(s);
        } catch (DateTimeParseException e) {
            return false;
        }
        return true;
    }

    private static boolean isValidISODateStr(String s) {
        try {
            LocalDate.parse(s);
        } catch (DateTimeParseException e) {
            return false;
        }
        return true;
    }

    private static boolean isValidISOTimeStr(String s) {
        try {
            LocalTime.parse(s);
        } catch (DateTimeParseException e) {
            return false;
        }
        return true;
    }

    //endregion


    /**
     * @param inputStr raw String representing user's action
     * @return Command that program can execute.
     * @throws DukeUnknownException     if Parser is unable to understand inputStr
     * @throws DukeMissingDescException if Parser finds that action is missing a description
     */
    public static Command parseInput(String inputStr) throws DukeException {
        Command parsedCommand;
        String[] strings = inputStr.split("[\\s]+");
        String firstStr = strings[0].strip().toLowerCase();
        switch (firstStr) {
            case "bye":
            case "exit":
                parsedCommand = new ExitCommand();
                break;
            case "list":
                parsedCommand = new ListCommand();
                break;
            case "delete":
            case "done":
            case "edit":
                int pos = Integer.parseInt(strings[1]) - 1; //pos.minValue = 0, cannot be negative.
                if (pos < 0) {
                    throw new IndexOutOfBoundsException("invalid number detected, please input a number starting from 1.");
                }
                UpdateCommand.Operation op = UpdateCommand.Operation.valueOf(firstStr.substring(0, 1).toUpperCase() + firstStr.substring(1));
                parsedCommand = (!firstStr.equals("edit")) ? new UpdateCommand(op, pos) : new UpdateCommand(UpdateCommand.Operation.Edit, pos);
                break;
            case "check":
                if (strings.length > 1) {
                    parsedCommand = new CheckCommand(strings[1]);
                } else {
                    throw new DukeMissingParamException("check");
                }
                break;
            case "find":
                int startIndex = inputStr.indexOf(strings[0]) + strings[0].length();
                parsedCommand = new FindCommand(inputStr.substring(startIndex).strip());
                break;
            default:    //task processing.
                if (firstStr.isBlank() || firstStr.isEmpty())
                    throw new DukeUnknownException();
                parsedCommand = new UpdateCommand(UpdateCommand.Operation.Add, processTask(strings));
                break;
        }
        return parsedCommand;
    }

    private static Task processTask(String[] inputStrs) throws DukeUnknownException, DukeMissingDescException {
        String tempStr = "";
        Task createdTask;
        switch (inputStrs[0].toLowerCase()) {
            default:
                throw new DukeUnknownException();
            case "todo":
                for (int i = 1; i < inputStrs.length; i++) {
                    tempStr = tempStr.concat(String.format("%s ", inputStrs[i]));
                }
                createdTask = new ToDo(tempStr.stripTrailing()); //remove extra space added on last elem.
                break;
            case "deadline":
            case "event":
                createdTask = parseEventOrDeadline(inputStrs);
                break;
        }
        return createdTask;
    }

    private static Task parseEventOrDeadline(String[] inputStrs) throws DukeMissingDescException {
        String tempStr1 = "", tempStr2 = "";
        int delimiterIndex = Arrays.asList(inputStrs).indexOf((inputStrs[0].equals("event")) ? "/at" : "/by");
        for (int i = 1; i < delimiterIndex; i++) {
            tempStr1 = tempStr1.concat(String.format("%s ", inputStrs[i]));
        }
        for (int i = delimiterIndex + 1; i < inputStrs.length; i++) {
            tempStr2 = tempStr2.concat(String.format("%s ", inputStrs[i]));
        }
        tempStr1 = tempStr1.strip();
        tempStr2 = tempStr2.strip();
        return (inputStrs[0].equals("event")) ? new Event(tempStr1, tempStr2) : new Deadline(tempStr1, tempStr2);
    }
}
