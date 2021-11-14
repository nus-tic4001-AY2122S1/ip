package duke.storage;

import java.io.FileNotFoundException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import duke.task.Task;
import java.io.File;
import java.util.Scanner;

public class Storage {

    private static final String SAVE = ";";
    private String Path;

    public Storage(String Path, Task task) throws FileNotFoundException {
        this.Path = Path;
        File file = new File(this.Path);
        if (file.isFile()) {
            loadData(file, task);

        }
    }

    private void loadData(File file, Task task) throws FileNotFoundException {
        Scanner scan = new Scanner(file);
        String line = scan.nextLine();
        task.getTask();
    }
}

