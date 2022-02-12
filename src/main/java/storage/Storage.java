package storage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.Vector;

import exceptions.DukeDateTimeError;
import exceptions.DukeStorageError;
import taskclasses.Task;

public class Storage {

    /**
     * An default file path which is "data/dukeTasks.txt"
     */

    private final String defaultStorageFilepath = "data/dukeTasks.txt";
    private final Path rootPath = Paths.get("").toAbsolutePath();
    private final String rootDir = rootPath.normalize().toString();
    private Path path = Paths.get(rootDir + "/" + defaultStorageFilepath);

    /**
     * The method to initialize Storage
     * @param filePath storage file path
     */
    public Storage (String filePath) {
        path = Paths.get(filePath);
    }

    /**
     * To add all the Task which in String type in the list into txt file as local storage
     *
     * @param lst all the task
     * @throws IOException to handle all errors for FileWriter
     */
    private void toSaveTaskListToLocal(Vector<Task> lst) throws IOException {

        if (lst.size() == 0) {
            return;
        }

        Vector<String> taskListInString = TaskListEncoder.encodeTaskList(lst);

        String fileDirectory = String.valueOf(defaultStorageFilepath);

        //To clear content of existing txt file
        FileWriter fw = new FileWriter(fileDirectory);
        fw.write("");
        fw.close();

        //Start writing Task(s) in Vector<String> list into the new txt file
        FileWriter newFw = new FileWriter(fileDirectory, true);

        for (String task : taskListInString) {
            newFw.write(task + System.lineSeparator());
        }

        newFw.close();
    }

    /**
     * To check whether the default file path is exist
     * @return return boolean whether the default file path is exist
     */
    private boolean fileDoExist() {
        return (Files.exists(path));
    }

    /**
     * To check whether the directory folder path is exist
     *
     * @return return boolean whether the directory folder path is exist
     */
    private boolean dirDoExist() {
        return Files.exists(Paths.get(rootDir + "/data"));
    }

    /**
     * The function to transfer all the Task information
     * by using Encoder function from Task type Vector List to String and store into txt file
     * @param lst Task type Vector List
     * @throws IOException If the FileWrite those kind of function got any error, an error will be thrown to user
     */
    public void transferToFile(Vector<Task> lst) throws IOException {

        if (!fileDoExist()) {
            if (!dirDoExist()) {
                Files.createDirectories(Paths.get(rootDir + "/data"));
            }
            Files.createFile(path);
        }

        toSaveTaskListToLocal(lst);
    }

    /**
     * The method to extract date from local storage, txt file.
     * @return the task list extracted in Task type Vector format
     * @throws DukeStorageError handles all storage errors during data extraction and storing
     * @throws IOException handles all input errors
     * @throws DukeDateTimeError handles all date time error
     */
    public Vector<Task> load() throws DukeStorageError, IOException, DukeDateTimeError {
        Vector<String> extractedTaskInfo = extractTaskInfoFromTxt();
        Vector<Task> list = new Vector<>();

        if (extractedTaskInfo.size() == 0) {
            return list;
        }

        list = TaskListDecoder.decodeTaskList(extractedTaskInfo);

        return list;
    }

    /**
     * The method to extract date from local storage, txt file.
     * @return the task list extracted in String type Vector format
     * @throws DukeStorageError handles all storage errors during data extraction and storing
     * @throws IOException handles all input errors
     */
    private Vector<String> extractTaskInfoFromTxt() throws IOException, DukeStorageError {

        if (!fileDoExist()) {
            if (!dirDoExist()) {
                Files.createDirectories(Paths.get(rootDir + "/data"));
            }

            Files.createFile(path);

            throw new DukeStorageError();
        }

        Vector<String> extractedInfo = new Vector<>();
        Scanner sc = null;

        try {
            File file = new File(defaultStorageFilepath); // java.io.File
            sc = new Scanner(file);
            String line;

            while (sc.hasNextLine()) {
                line = sc.nextLine();
                extractedInfo.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (sc != null) {
                sc.close();
            }
        }

        return extractedInfo;
    }
}

