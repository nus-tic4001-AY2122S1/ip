package storage;

import java.util.Vector;

import exceptions.DukeDateTimeError;
import exceptions.DukeStorageError;
import taskclasses.Deadline;
import taskclasses.Event;
import taskclasses.Task;
import taskclasses.Todo;

class TaskListDecoder {

    /**
     * The method to convert all the data extracted from local storage,
     * txt file, to task format and store in Task type Vector format
     *
     * @param storageInformation All the data extracted from txt file in String type Vector format
     * @return all the extracted task in Task type Vector format
     * @throws DukeStorageError handles all the errors about storage
     * @throws DukeDateTimeError the error about variable date String's input date format
     */
    static Vector<Task> decodeTaskList(Vector<String> storageInformation) throws DukeStorageError, DukeDateTimeError {
        Vector<Task> decodedTaskList = new Vector<>();

        for (String singleTaskInfo : storageInformation) {
            Task task = decodeTask(singleTaskInfo);

            decodedTaskList.add(task);
        }

        return decodedTaskList;
    }

    /**
     * The method to convert a single task String extracted to a single Task
     * @param taskString The single task String extracted from txt file
     * @return The task created based on the single task String
     * @throws DukeStorageError handles all the errors about storage
     * @throws DukeDateTimeError the error about variable date String's input date format
     */
    private static Task decodeTask(String taskString) throws DukeStorageError, DukeDateTimeError {

        String[] parts = taskString.split(" \\| ");
        String taskType = parts[0];
        String taskDescription = parts[2];
        boolean taskStatus = !parts[1].equals("0");

        if (parts.length == 3) { //todo type with correct length
            return new Todo(taskDescription, taskStatus);

        } else if (parts.length == 5 && taskType.equals("E")) { // event with correct length
            //  type [0] | status [1] | description [2] | starting [3] | ending [4]
            return new Event(taskDescription, taskStatus, parts[3], parts[4]);

        } else if (parts.length == 4 && taskType.equals("D")) { // deadline with correct length
            // type [0] | status [1] | description [2] | deadline date [3]
            return new Deadline(taskDescription, taskStatus, parts[3]);
        } else {
            throw new DukeStorageError();
        }
    }
}
