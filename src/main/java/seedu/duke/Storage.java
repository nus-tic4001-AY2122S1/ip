package seedu.duke;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage {
    private static String basePath = new File("").getAbsolutePath();
    private static File file = new File(basePath.concat("/data/duke.txt"));
    private static ArrayList<Task> todoList = TaskList.getInstance().getList();

    public static void loadData() {
        try {
            if (file.getParentFile() != null) {
                file.getParentFile().mkdirs();
            }
            if (file.createNewFile()) {
                System.out.println("Unable to find existing data, will create a new file storage.");
            } else {
                Scanner scan = new Scanner(file);
                while (scan.hasNextLine()) {
                    transformToLoadData(scan.nextLine());
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void transformToLoadData(String data) {
        Parser parser = new Parser();
        String[] transformData = data.split(" \\| ");
        switch (transformData[0]) {
        case "T":
            try {
                parser.addTodo(transformData[2]);
            } catch (DukeException e) {
                e.printErrorMessage();
            }
            if (Integer.parseInt(transformData[1]) > 0) {
                todoList.get(todoList.size() - 1).markAsDone();
            }
            break;
        case "D":
            try {
                parser.addDeadline(transformData[2], transformData[3]);
            } catch (DukeException e) {
                e.printErrorMessage();
            }
            if (Integer.parseInt(transformData[1]) > 0) {
                todoList.get(todoList.size() - 1).markAsDone();
            }
            break;
        case "E":
            String[] dateAndTime = transformData[3].split(" ");
            try {
                parser.addEvent(transformData[2], dateAndTime[0] + " " + dateAndTime[1], dateAndTime[2]);
            } catch (DukeException e) {
                e.printErrorMessage();
            }
            if (Integer.parseInt(transformData[1]) > 0) {
                todoList.get(todoList.size() - 1).markAsDone();
            }
            break;
        default:
            break;
        }
    }

    public static String transformToSaveData(Task td) {
        return td.toSave() + "\n";
    }

    public static void saveData() {
        try {
            FileWriter fileWriter = new FileWriter(file);
            todoList.forEach((td) -> {
                try {
                    fileWriter.write(transformToSaveData(td));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
