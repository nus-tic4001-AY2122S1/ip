package ip.duke.tasklist;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashSet;

import ip.duke.Deadline;
import ip.duke.Event;
import ip.duke.Todo;
import ip.duke.exceptions.DukeException;
import ip.duke.storage.Storage;
import ip.duke.task.Task;
import ip.duke.ui.Ui;

/**
 * This utility class provides an online database for tasks storage
 *
 * </P>Deals with admin and tasking operations on online database list.
 *
 * <P>Will also load from saved database file when LisGenie app starts.
 *
 * @author Gwee Yeu Chai
 * @version 1.0
 * @since 2021-09-10
 */
public class TaskList {
    // Collection preserves input sequence, gives constant time for add, update & remove operations
    private static final LinkedHashSet<Task> TASKS = new LinkedHashSet<>(105, (float) 1.0);

    public static int listSize() {
        return TASKS.size();
    }

    public static LinkedHashSet<Task> getList() {
        return TASKS;
    }

    //This method is for possible closure technical glitch
    public static void toClose(Closeable obj) {

        if (obj != null) {

            try {
                obj.close();

            } catch (IOException ex) {
                System.out.print("LisGenie : ");
                System.out.println("Possible disc error / file system full!" + ex.getMessage());
            }
        }
    }

    /**
     * Extracts a Task item by "index" or its sequenced order.
     *
     * @param idx indexed location of target Task item
     * @return A Task object.
     */
    public static Task getItem(int idx) {
        int currentIndex = 0;
        Task item = null;

        for (Task element : TASKS) {
            if (currentIndex == idx) {
                item = element;
                break;
            } else {
                ++currentIndex;
            }
        }
        return item;
    }

    public static void doDelete(String word) {
        int itemIndex = Integer.parseInt(word.trim()) - 1;

        if (itemIndex < 0 || itemIndex > 99) {
            Ui.echoOffList(itemIndex);
        } else {
            drop(itemIndex);
            Storage.writeToFile();
        }
    }

    public static void doDone(String word) {
        int itemIndex = Integer.parseInt(word.trim()) - 1;

        if (itemIndex < 0 || itemIndex > 99) {
            Ui.echoOffList(itemIndex);
        } else {
            updateDoneStatus(itemIndex);
            Storage.writeToFile();
        }
    }

    public static void drop(int idx) {
        Task item = getItem(idx);

        if (item != null) {
            TASKS.remove(item);
            Ui.echoDelete(item);
        } else {
            Ui.echoNoEntries();
        }
    }

    private static Task createTask(String str) throws DukeException {
        String[] text = str.trim().split(" # ");

        Task t;

        try {
            switch (text[0]) {
            case "T":
                t = new Todo(text[2]);
                break;
            case "D":
                t = new Deadline(text[2], text[3]);
                break;
            case "E":
                t = new Event(text[2], text[3]);
                break;
            default:
                throw new IllegalStateException("Alert!! Load-from-file Format Error detected! : "
                        + "\"" + text[0] + "\"");
            }

            if (text[1].equals("1")) {
                t.setDone();
            }

        } catch (ArrayIndexOutOfBoundsException | IllegalStateException err) {
            System.out.println();
            System.out.println("                                 +++ Database file format errors detected! :+++");
            throw new DukeException(err.getMessage(), err);
        }
        return t;
    }

    public static LinkedHashSet<Task> load(String path) throws DukeException { //load from file
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(path));
            String line = reader.readLine();

            while (line != null && !line.trim().isEmpty()) {
                Task entry = createTask(line.replace("\\s+", " "));

                if (entry != null) {
                    TaskList.TASKS.add(entry);
                }

                line = reader.readLine();
            }

        } catch (IOException e) {
            throw new DukeException("File access/read error!", e);
        } finally {
            toClose(reader);
        }
        return TASKS;
    }

    public static void updateDoneStatus(int idx) {
        Task item = getItem(idx);

        if (item != null) {
            if (!item.getStatusIcon().equals(" ")) {
                System.out.print("LisGenie : ");
                System.out.println("Mmm...item already marked done, O Master? Next @|@ task?");
            } else {
                item.setDone();
                Ui.echoDone(item);
            }
        } else {
            Ui.echoNoEntries();
        }
    }

    public static void addDeadline(String input) {
        String[] parts = input.split(" /by ", 2);
        Deadline item = new Deadline(parts[0].trim(), parts[1].trim());
        TASKS.add(item);
        Ui.echoAdded(item);
        Storage.appendToFile(TASKS.size() - 1);
    }

    public static void addEvent(String input) {
        String[] parts = input.split(" /at ", 2);
        Event item = new Event(parts[0].trim(), parts[1].trim());
        TASKS.add(item);
        Ui.echoAdded(item);
        Storage.appendToFile(TASKS.size() - 1);
    }

    public static void addTodo(String input) {
        Todo item = new Todo(input);
        TASKS.add(item);
        Ui.echoAdded(item);
        Storage.appendToFile(TASKS.size() - 1);
    }
}
