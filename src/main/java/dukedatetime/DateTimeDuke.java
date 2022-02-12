package dukedatetime;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import exceptions.DukeDateTimeError;

/**
 * Deadline:
 *          YYYY-MM-DD Hour(0-23):Minute(0-59)
 *
 * Event:
 *          YYYY-MM-DD Hour(0-23):Minute(0-59) -> YYYY-MM-DD Hour(0-23):Minute(0-59)
 */

public class DateTimeDuke {

    private LocalDateTime localDateTime;

    /**
     * The method to initialize DateTimeDuke
     *
     * @param date the string contain year, month, day, hour, and minute. Format: yyyy-MM-dd HH:mm
     * @throws DukeDateTimeError the error about variable date String's input date format
     */
    public DateTimeDuke(String date) throws DukeDateTimeError {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            localDateTime = LocalDateTime.parse(date, formatter);
        } catch (DateTimeParseException e) {
            throw new DukeDateTimeError("inputFormatWrong");
        }
    }

    /**
     * The method to convert DateTimeDuke type to String in pattern: MMM d yyyy HH:mm
     *
     * @return DateTime information in String in MMM d yyyy HH:mm
     */
    public String convertToStringTypeI() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM d yyyy HH:mm");
        return localDateTime.format(formatter);
    }

    /**
     * The method to convert DateTimeDuke type to String in pattern: yyyy-MM-dd HH:mm
     *
     * @return DateTime information in String in MMM d yyyy HH:mm
     */
    public String convertToStringTypeII() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return localDateTime.format(formatter);
    }

    /**
     * The method to convert DateTimeDuke type to String in pattern: yyyy-MM-dd
     *
     * @return DateTime information in String in yyyy-MM-dd format
     */
    public String convertToStringType3() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return localDateTime.format(formatter);
    }
}
