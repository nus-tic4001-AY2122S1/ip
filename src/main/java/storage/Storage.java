package storage;

import exceptions.DukeDateTimeError;
import exceptions.DukeStorageError;
import task_classes.Task;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.Vector;
import java.nio.file.Files;


public class Storage {

    /**
     * An default file path which is "data/dukeTasks.txt"
     */

    private final String DEFAULT_STORAGE_FILEPATH = "data/dukeTasks.txt";
    private final Path rootPath = Paths.get("").toAbsolutePath();
    private final String rootDir = rootPath.normalize().toString();
    private Path path = Paths.get(rootDir + "/" + DEFAULT_STORAGE_FILEPATH);


    /**
     * Constructs StorageFile with default file path
     */
    public Storage() {
        path = Paths.get(rootDir + "/" + DEFAULT_STORAGE_FILEPATH);
    }

    /**
     * The method to initialize Storage
     * @param filePath
     */
    public Storage (String filePath) {
        path = Paths.get(filePath);
    }

    /**
     * To add all the Task which in String type in the list into txt file as local storage
     *
     * @param List all the task
     * @throws IOException to handle all errors for FileWriter
     */
    private void toSaveTaskListToLocal(Vector<Task> List) throws IOException {

        if(List.size() == 0){
            return;
        }

        Vector<String> taskListInString = TaskListEncoder.encodeTaskList(List);

        String fileDirectory = String.valueOf(DEFAULT_STORAGE_FILEPATH);

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
    private boolean fileDoExist(){
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
     * The function to transfer all the Task information by using Encoder function from Vector<Task> List to String and store into txt file
     * @param List Vector<Task> List
     * @throws IOException If the FileWrite those kind of function got any error, an error will be thrown to user
     */
    public void transferToFile(Vector<Task> List) throws IOException {

        if(!fileDoExist()){
            if(!dirDoExist()){
                Files.createDirectories(Paths.get(rootDir + "/data"));
            }

            Files.createFile(path);
        }

        toSaveTaskListToLocal(List);
    }

    /**
     * The method to extract date from local storage, txt file.
     * @return the task list extracted in Vector<Task> format
     * @throws DukeStorageError handles all storage errors during data extraction and storing
     * @throws IOException handles all input errors
     */
    public Vector<Task> load() throws DukeStorageError, IOException, DukeDateTimeError {
        Vector<String> extractedTaskInfo = extractTaskInfoFromTxt();
        Vector<Task> list = new Vector<>();

        if(extractedTaskInfo.size() == 0){
            return list;
        }

        list = TaskListDecoder.decodeTaskList(extractedTaskInfo);

        return list;
    }

    /**
     * The method to extract date from local storage, txt file.
     * @return the task list extracted in Vector<String> format
     * @throws DukeStorageError handles all storage errors during data extraction and storing
     * @throws IOException handles all input errors
     */
    private Vector<String> extractTaskInfoFromTxt() throws IOException, DukeStorageError {

        if(!fileDoExist()){
            if(!dirDoExist()){
                Files.createDirectories(Paths.get(rootDir + "/data"));
            }

            Files.createFile(path);

            throw new DukeStorageError();
        }

        Vector<String> extractedInfo = new Vector<>();
        Scanner sc = null;

        try {
            File file = new File(DEFAULT_STORAGE_FILEPATH); // java.io.File
            sc = new Scanner(file);
            String line;

            while (sc.hasNextLine()) {
                line = sc.nextLine();
                extractedInfo.add(line);
            }
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
        finally {
            if (sc != null) sc.close();
        }

        return extractedInfo;
    }
}

