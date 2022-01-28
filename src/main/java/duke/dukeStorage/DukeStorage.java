package duke.dukeStorage;

import java.util.ArrayList;
import java.util.Date;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.text.ParseException;
import duke.dukeCommand.*;
import duke.dukeTask.*;
import duke.dukeTaskList.*;
import duke.dukeException.*;

public class DukeStorage {

    private static String file_path;
    private BufferedReader fileRead;
    private File file;

    public DukeStorage(String path){
        file_path = path;
        try{
            fileRead = new BufferedReader(new FileReader(file_path));
            fileRead.close();
        }
        catch (FileNotFoundException e){
            createFile();
        }catch(IOException e1){
            e1.printStackTrace();
        }

    }

    public void createFile(){
        try {
            if(file.getParentFile().mkdirs()){
            }
            if(file.createNewFile()){
            }
        }
        catch(IOException e){
            new IOException("The file " + file.getAbsolutePath() + " is unable to be create.");
        }
    }

    public static void deleteFromFile(int taskIndex) throws IOException {
        FileWriter fileWriter = new FileWriter(file_path, true);
        BufferedReader fileRead = new BufferedReader(new FileReader(file_path));
        PrintWriter printWriter = new PrintWriter(fileWriter);
        StringBuffer inputBuffer = new StringBuffer();
        String line = "";
        for(int i = 0; i < DukeTaskList.getSize(); i++ ){
            line = fileRead.readLine();
            if(i != taskIndex){
                // keep all other task other than deleted task
                inputBuffer.append(line);
                inputBuffer.append('\n');
            }
        }
        FileOutputStream fileOut = new FileOutputStream(file_path);
        fileOut.write(inputBuffer.toString().getBytes());
        fileWriter.close();
        fileRead.close();
        printWriter.close();
        fileOut.close();
    }

    public static void saveFunction(Task description){
        DukeTaskList.addList(description);
        System.out.println("Got it. I've added this task:");
        System.out.println("   " + description);
        System.out.println("Now you have " + DukeTaskList.getSize() + " tasks in the list.");
    }

    public static void deleteFunction(int listLocation){
        System.out.println("Noted. I've removed this task:");
        System.out.println("   " + DukeTaskList.getTask(listLocation).toString());
        DukeTaskList.deleteList(listLocation);
        System.out.println("Now you have " + DukeTaskList.getSize() + " tasks in the list.");
    }

    public static void doneFunction(int listLocation){
        Task t = DukeTaskList.getTask(listLocation);
        t.markAsDone();
        System.out.println("    " + t.toString()) ;
    }

    public static void changeIsDone(int taskIndex) throws IOException {
        FileWriter fileWriter = new FileWriter(file_path, true);
        BufferedReader fileRead = new BufferedReader(new FileReader(file_path));
        PrintWriter printWriter = new PrintWriter(fileWriter);
        StringBuffer inputBuffer = new StringBuffer();
        String line = "";
        for(int i = 0; i < DukeTaskList.getSize(); i++ ){
            line = fileRead.readLine();
            if(i == taskIndex){
                // change task to done in txt file
                String[] splitLine = line.split(" \\| ");
                String changeToDone = "";
                for(int k = 0; k < splitLine.length; k++){
                    if(k == splitLine.length-1){
                        changeToDone += splitLine[k];
                    }else if (k == 1){
                        changeToDone += "1" + " | ";
                    }else{
                        changeToDone += splitLine[k] + " | ";
                    }

                }
                inputBuffer.append(changeToDone);
            }else{
                inputBuffer.append(line);
            }
            inputBuffer.append('\n');
        }
        FileOutputStream fileOut = new FileOutputStream(file_path);
        fileOut.write(inputBuffer.toString().getBytes());
        fileWriter.close();
        fileRead.close();
        printWriter.close();
        fileOut.close();
    }

    /**
     * Save file
     */
     public static void saveToFile(String taskClass, String description, String date) throws IOException {
         FileWriter fileWriter = new FileWriter(file_path, true);
         PrintWriter printWriter = new PrintWriter(fileWriter);
         String taskData = taskClass + " | " + "0" + " | " + description;
         if (taskClass == "T"){
             printWriter.println(taskData);  //New line
         }else{
             taskData = taskData + " | " + date;
             printWriter.println(taskData);  //New line
         }
         fileWriter.close();
         printWriter.close();
     }

    /**
     * Read file
     */
    public void readFile() throws FileNotFoundException, IOException, ParseException, DukeException {
        DukeTaskList taskList = new DukeTaskList();
        BufferedReader fileRead = new BufferedReader(new FileReader(file_path));
        String line = fileRead.readLine();
        while(line != null){
            String[] splitLine = line.split(" \\| ");
            switch(splitLine[0]){
                case "E":
                    Event newEvent = new Event(splitLine[2], DeadlineCommand.convertDateTime(splitLine[3]));
                    if(splitLine[1].equals("1")){
                        newEvent.markAsDone();
                    }
                    taskList.addList(newEvent);
                    break;
                case "D":
                    try{
                        Deadline newDeadline = new Deadline(splitLine[2], DeadlineCommand.convertDateTime(splitLine[3]));
                        if(splitLine[1].equals("1")){
                            newDeadline.markAsDone();
                        }
                        taskList.addList(newDeadline);
                    }catch(ParseException e){
                        System.out.println("please key in the correct date time");
                    }catch(DukeException e){
                        throw new DukeException("☹ OOPS!!! Please check deadline command that you have key in is in correct format.");
                    }


                    break;
                case "T":
                    Todo newTodo = new Todo(splitLine[2]);
                    if(splitLine[1].equals("1")){
                        newTodo.markAsDone();
                    }
                    taskList.addList(newTodo);
            }
            line = fileRead.readLine();
        }
        fileRead.close();
    }
}