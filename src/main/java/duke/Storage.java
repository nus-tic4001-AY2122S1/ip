package duke;

import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.Todo;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Storage {
    protected String filePath;

    public Storage(String filePath) {
        this.filePath = filePath;
    }

    public void loadFile(TaskList taskList) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String s;
            while ((s = br.readLine()) != null) {
                String[] command = s.split("\\|", 0);

                switch (command[0].trim()) {
                case "T":
                    taskList.tasks.add(new Todo(command[2].trim()));
                    taskList.size++;
                    if (command[1].trim().equals("\u2713"))
                        taskList.tasks.get(taskList.size - 1).markAsDone();
                    break;
                case "E":
                    taskList.tasks.add(new Event(command[2].trim(), command[3].trim()));
                    if (command[1].trim().equals("\u2713"))
                        taskList.tasks.get(taskList.size - 1).markAsDone();
                    taskList.size++;
                    break;
                case "D":
                    taskList.tasks.add(new Deadline(command[2].trim(), command[3].trim()));
                    if (command[1].trim().equals("\u2713"))
                        taskList.tasks.get(taskList.size - 1).markAsDone();
                    taskList.size++;
                    break;
                }
            }
        } catch (IOException e) {
            UI.splitLine();
            System.out.println("Oops!! Cannot load file!");
            UI.splitLine();
        }
    }

    public void saveFile(TaskList taskList) {
        try {
            FileOutputStream out = new FileOutputStream(filePath);
            for(int i=0; i < taskList.tasks.size(); i++) {
                String s = taskList.tasks.get(i).save_toString() + System.lineSeparator();
                byte b[]= s.getBytes();
                out.write(b);
            }
            out.close();
        } catch (IOException e) {
            System.out.println("Oops!! Cannot save file!");
        }
    }
}
