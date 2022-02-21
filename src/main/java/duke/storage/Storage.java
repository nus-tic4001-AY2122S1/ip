package duke.storage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import duke.command.DeadlineCommand;
import duke.command.EventCommand;
import duke.dukeexception.DukeException;
import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.TaskList;
import duke.task.ToDo;


/**
 * Storage to read and write file in a txt file
 */
public class Storage {

    private static String filePath;

    /**
     * Constructs the storage class to store the file path of the txt file
     * @param filePath the file path of the txt file
     */
    public Storage(String filePath) {
        this.filePath = filePath;
    }


    /**
     * Handle path for different OS
     * @throws DukeException any expected error
     * @throws IOException any IOException error
     */
    public static java.nio.file.Path pathOsHandler() throws IOException, DukeException {
        String fileName = filePath;
        if (filePath.contains("/")) {
            fileName = filePath.substring(filePath.lastIndexOf('/'));
            String dirString = filePath.substring(0, filePath.lastIndexOf('/'));
            java.nio.file.Path folderDir = java.nio.file.Paths.get(dirString);
            boolean directoryExists = java.nio.file.Files.exists(folderDir);
            if (!directoryExists) {
                java.nio.file.Files.createDirectories(folderDir);
            }
        }
        if (!fileName.contains(".txt")) {
            throw new DukeException("storage files need to be in txt format");
        }


        return java.nio.file.Paths.get(filePath);

    }


    /**
     * Write into a txt file
     * @param lists list of the task to be written into the txt file
     */
    public static void save(TaskList lists) throws DukeException {
        try {
            java.nio.file.Path filePath = pathOsHandler();
            FileWriter fileWrite = new FileWriter(filePath.toString());
            for (int i = 0; i < lists.getSize(); i++) {
                String storingTask = convertTaskStoring(lists.getTask(i), i);
                fileWrite.write(storingTask);
            }
            fileWrite.close();
        } catch (IOException | DukeException e) {
            throw new DukeException("error:" + e.getMessage() + ".");

        }

    }

    /**
     * Convert the task into the saving format to save into the file
     * @param task the task to be converted
     * @return the string format to be save
     * @throws DukeException any expected error
     * @throws IllegalStateException any IllegalStateExpection
     */
    private static String convertTaskStoring(Task task, int index) throws DukeException, IllegalStateException {
        String storingTask;
        switch (task.getTaskType()) {
        case EVENT:
            Event event = (Event) task;
            storingTask = (index + 1)
                    + " | E"
                    + " | "
                    + (event.getIsDone() ? "1" : "0")
                    + " | "
                    + event.getTaskDescription()
                    + " | "
                    + event.getDateTimeString()
                    + System.lineSeparator();
            break;
        case DEADLINE:
            Deadline deadlines = (Deadline) task;
            storingTask = (index + 1)
                    + " | D"
                    + " | "
                    + (deadlines.getIsDone() ? "1" : "0")
                    + " | "
                    + deadlines.getTaskDescription()
                    + " | "
                    + deadlines.getDateTimeString()
                    + System.lineSeparator();
            break;
        case TODO:
            storingTask = (index + 1)
                    + " | T"
                    + " | "
                    + (task.getIsDone() ? "1" : "0")
                    + " | "
                    + task.getTaskDescription()
                    + System.lineSeparator();
            break;
        default:
            throw new IllegalStateException("Unexpected value: " + task.getTaskType());
        }
        return storingTask;
    }


    /**
     * Return the ArrayList of Task
     * @return the ArrayList of task
     * @throws DukeException any expected error
     */
    public static ArrayList<Task> load() throws DukeException {
        try {
            ArrayList<Task> tasks = getListOfTask();
            return tasks;
        } catch (IOException e) {
            throw new DukeException("Error with creating dir");
        }
    }

    /**
     * create the list of task from the file
     * @return the ArrayList of task that is in the file
     * @throws FileNotFoundException file that can't be found
     * @throws DukeException any other expected error
     */
    private static ArrayList<Task> getListOfTask() throws IOException, DukeException {
        java.nio.file.Path filePath = pathOsHandler();
        File f = new File(filePath.toString()); // create a File for the given file path
        if (f.length() == 0) {
            return new ArrayList<Task>();
        }
        ArrayList<Task> tasks = new ArrayList<>();
        Scanner s = new Scanner(f); // create a Scanner using the File as the source
        while (s.hasNext()) {
            Task task = convertTaskFromFile(s.nextLine());
            task.setTaskIndex(tasks.size());
            tasks.add(task);
        }

        return tasks;
    }

    /**
     * Convert the text in the file into task class
     * @param text text from the file
     * @return return the task created
     * @throws DukeException any expected error
     */
    private static Task convertTaskFromFile(String text) throws DukeException {
        Task task;
        int firstDivider = text.indexOf("| ");
        String taskType = text.substring(firstDivider + 2, firstDivider + 3);
        String taskDoneString = text.substring(firstDivider + 6, firstDivider + 7);
        String taskDetails = text.substring(firstDivider + 10);
        boolean isDone = false;
        if (!(taskDoneString.contains("0") || taskDoneString.contains("1"))) {

            throw new DukeException("Unknown boolean");
        }
        if (taskDoneString.contains("1")) {
            isDone = true;
        }
        if (taskDetails.contains(" | ")) {
            int timeDivider = taskDetails.indexOf(" | ");
            String taskDes = taskDetails.substring(0, timeDivider);
            String taskTime = taskDetails.substring(timeDivider + 3);
            task = creatingEventOrDeadline(taskType, taskDes, taskTime);
            task.editDone(isDone);
            return task;
        }
        if (!taskType.contains("T")) {
            throw new DukeException("Unknown task type");
        }
        task = new ToDo(taskDetails);
        task.editDone(isDone);

        return task;
    }


    /**
     * Separate out the event and deadline and create the individual class
     * @param taskType the type of the task
     * @param taskDes the task description stored
     * @param taskDateTime the date and time of the task
     * @return the task created
     * @throws DukeException any expected error
     */
    private static Task creatingEventOrDeadline(String taskType, String taskDes, String taskDateTime)
            throws DukeException {
        if (taskType.contains("D")) {
            return DeadlineCommand.deadlineTimeSetter(taskDes, taskDateTime);
        }
        if (taskType.contains("E")) {
            return EventCommand.eventTimeSetter(taskDes, taskDateTime);
        }

        throw new DukeException("Unknown task Type");
    }

}
