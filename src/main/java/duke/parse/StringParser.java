package duke.parse;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.Todo;

/**
 * StringParser acts like a utility that offers methods
 * that parse strings for different purposes and outcomes
 * After parsing, it will fire the Property Change
 * So that listener could take action on the result
 */
public class StringParser {
    private String[] keyArgs;
    private PropertyChangeSupport support;

    public StringParser() {
        support = new PropertyChangeSupport(this);
    }

    /**
     * Get a String divide it as first word command key
     * the rest consider as arguments for the command
     * @param line
     */
    public void passToCaller(String line) {
        keyArgs = line.strip().split(" ");

        support.firePropertyChange("keyArgs", null, keyArgs);
    }

    /**
     * Take a String Array and remove the first element
     * @param xxs
     * @return String without the first element
     */
    public static String[] removeFirst(String[] xxs) {
        String[] xs = new String[xxs.length - 1];
        for (int i = 1; i < xxs.length; i++) {
            xs[i - 1] = xxs[i];
        }
        return xs;
    }

    /**
     * Join String array elements into one String
     * with whitespace in between
     * @param args
     * @return String
     */
    public static String join(String[] args) {
        String arg = "";
        for (String word : args) {
            arg += word + " ";
        }
        return arg.strip();
    }

    /**
     * this method used when starting the app
     * loading lines from file to initialize the TaskList
     * The dateTime format is based on the text (toString)
     * NOT the user input format
     * @param line
     * @return
     */
    public static Task stringToTask(String line) {
        String[] parts = line.split("]", 3);
        Boolean isDone = !parts[1].equals("[ ") ? true : false;

        Task res;
        String[] args;
        String title;

        switch (parts[0]) {
        case "[T":
            res = new Todo(parts[2].strip());
            break;
        case "[E":
            args = parts[2].strip().split("\\(at:");
            args[1] = args[1].replace(")", "");
            title = args[0].strip();
            var duration = StringParser.parseEvent(args);
            res = new Event(title, duration);
            break;
        case "[D":
            args = parts[2].split("\\(by:");
            args[1] = args[1].replace(")", "");
            title = args[0].strip();
            var by = StringParser.parseDL(args);
            res = new Deadline(title, by);
            break;
        default:
            throw new IllegalStateException("Unexpected value: " + parts[0]);
        }

        if (isDone) {
            res.markDone();
        }
        return res;
    }

    /**
     * parse the time duration for Event
     * @param args
     * @return duration
     */
    public static LocalDateTime[] parseEvent(String[] args) {
        // args[0]: title  args[1]: datetime
        String[] dateTime = args[1].strip().split(" ", 2);
        String date = dateTime[0].strip();
        String time = dateTime[1].strip();

        String from = time.split("-")[0];
        from = date + " " + from.strip();
        String till = time.split("-")[1];
        till = date + " " + till.strip();

        LocalDateTime fromT = null;
        LocalDateTime tillT = null;

        try {
            fromT = StringParser.getTime(from);
            tillT = StringParser.getTime(till);
        } catch (DateTimeParseException e) {
            throw e;
        }

        LocalDateTime[] duration = {fromT, tillT};
        return duration;
    }

    /**
     * parse the time by for Deadline
     * @param args
     * @return by
     */
    public static LocalDateTime parseDL(String[] args) {
        // args[0]: title  args[1]: datetime
        String dateTime = args[1].strip();
        LocalDateTime by = null;

        try {
            by = StringParser.getTime(dateTime);
        } catch (DateTimeParseException e) {
            throw e;
        }
        return by;
    }

    public static LocalDateTime getTime(String part) {
        DateTimeFormatter formatter;
        LocalDateTime time = null;

        try {
            formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm");
            time = LocalDateTime.parse(part, formatter);
            if (time != null) {
                return time;
            }
        } catch (DateTimeParseException e) {
            assert true;
        }
        try {
            formatter = DateTimeFormatter.ofPattern("dd.MMM.yy HH:mm");
            time = LocalDateTime.parse(part, formatter);
            if (time != null) {
                return time;
            }
        } catch (DateTimeParseException e) {
            assert true;
        }
        try {
            formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd Hmm");
            time = LocalDateTime.parse(part, formatter);
            if (time != null) {
                return time;
            }
        } catch (DateTimeParseException e) {
            assert true;
        }
        try {
            formatter = DateTimeFormatter.ofPattern("yyyy-M-d Hmm");
            time = LocalDateTime.parse(part, formatter);
            if (time != null) {
                return time;
            }
        } catch (DateTimeParseException e) {
            assert true;
        }
        try {
            formatter = DateTimeFormatter.ofPattern("yyyy-M-dd Hmm");
            time = LocalDateTime.parse(part, formatter);
            if (time != null) {
                return time;
            }
        } catch (DateTimeParseException e) {
            assert true;
        }
        try {
            formatter = DateTimeFormatter.ofPattern("yyyy-M-d H");
            time = LocalDateTime.parse(part, formatter);
            if (time != null) {
                return time;
            }
        } catch (DateTimeParseException e) {
            throw e;
        }

        return time;
    }

    public static ArrayList<String> getTags(String title) {
        ArrayList<String> all = new ArrayList<>();
        Pattern Tag = Pattern.compile(" :(.+):");
        Matcher m = Tag.matcher(title);
        while (m.find()) {
            all.add(m.group());
        }
        ArrayList<String> tagList = new ArrayList<>();
        if (all.size() == 0) {
            return null;
        }

        String[] tags = all.get(0).split(":");
        for (int i = 1; i < tags.length; i++) {
            tagList.add(tags[i].strip().toLowerCase());
        }
        return tagList;
    }

    public static Optional<HashSet<String>> getTagSet(String title) {
        ArrayList<String> tags = new ArrayList<>();
        HashSet<String> tagSet = new HashSet<>();
        tags = getTags(title);
        if (tags == null) {
            return Optional.empty();
        }

        for (String tag : tags) {
            tagSet.add(tag);
        }
        return Optional.of(tagSet);
    }

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }

    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        support.removePropertyChangeListener(pcl);
    }

}
