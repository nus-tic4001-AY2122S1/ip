package ip.duke.storage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import ip.duke.task.Task;
import ip.duke.tasklist.TaskList;

public class Storage {
    // This class-level text file is to save all online records stored in TASKS database
    private static String fileLocation;

    public Storage(String filePath) {
        fileLocation = filePath;
    }

    public void setFilePath(String path) {
        fileLocation = path;
    }

    public static String getFilePath() {
        return fileLocation;
    }

    public static void appendToFile(int index) {
        BufferedWriter disk = null;

        try {
            disk = new BufferedWriter(new FileWriter(fileLocation, true));
            disk.write(TaskList.getItem(index).toFileString() + System.lineSeparator());

        } catch (IOException e) {
            System.out.print("LisGenie : ");
            System.out.println("File access problem... " + e.getMessage());

        } finally {
            TaskList.toClose(disk);
        }
    }

    public static void writeToFile() {
        BufferedWriter disk = null;

        try {
            disk = new BufferedWriter(new FileWriter(fileLocation));

            for (Task item : TaskList.getList()) {
                disk.write(item.toFileString() + System.lineSeparator());
            }

        } catch (IOException e) {
            System.out.print("LisGenie : ");
            System.out.println("File access problem... " + e.getMessage());

        } finally {
            TaskList.toClose(disk);
        }
    }
}
