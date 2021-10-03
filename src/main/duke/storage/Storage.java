package duke.storage;

import duke.exception.DukeException;
import duke.task.TaskList;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

/**
 * deals with loading tasks from the file and saving tasks in the file. Refer to More OOP.
 */
public class Storage {
    private String path_str;

    /**
     * @param t
     * @return false means no saved data, true means has saved data.
     */
    public void readSaveFile(TaskList t) throws DukeException {
        File f = new File(path_str);
        if (!f.exists()) {
            System.out.println("Save file not found. Creating new file!");

            f = writeToSaveFile("");
            System.out.println(f.getAbsolutePath());
        }
        loadSaveFile(f, t);
    }

    public void loadSaveFile(File f, TaskList t) throws DukeException {
        try {
            Scanner s = new Scanner(f);
            while (s.hasNext()) {
                t.add(s.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println(String.format("%s", e.getMessage()));
        }
    }

    /**
     * @param s string representation of data to be saved.
     * @return Writes s to savefile at ./data/duke.txt, overwriting the original content.
     */
    public File writeToSaveFile(String s) {
        File f = new File(path_str);
        Path p = f.toPath();

        try {
            if(!Files.exists(p.getParent())){
                //System.out.println(String.format("%s directory does not exist.", p.getParent().toAbsolutePath()));
                p.getParent().toFile().mkdir();
            }
            if (!f.exists()) {
                f.createNewFile();
            }
            FileWriter fw = new FileWriter(path_str);
            fw.write(s);
            fw.close();
        } catch (IOException e) {
            System.out.println(String.format("%s", e.getMessage()));
        }
        return f;
    }

    public Storage(String path_str) {
        this.path_str = (!path_str.isEmpty() || !path_str.isBlank())? path_str : "duke.txt";
    }

}
