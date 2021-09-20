/* For user to manage their tasks and deadline */

import java.io.FileWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors
import java.time.format.DateTimeFormatter;

public class Duke {

    public static ArrayList<Task> taskList = new ArrayList<>();
    public static final String fileSeparator = " | ";
    public static final String errorQuit = "☹ OOPS!!! Please try again. Bye!";
    public static final String errorUnknown = "☹ OOPS!!! I'm sorry, but I don't know what that means :-(";

    public static void main(String[] args) {

        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        System.out.println("Hello! I'm Duke\nWhat can I do for you?");

        System.out.println("\nCommands Available:\ntodo <task>\ndeadline <task> /by <yyyy-mmm-dd tt:mm>");
        System.out.println("event <event> /<day>\nfind <keyword>\nlist\ndone <index>\ndelete <index>\nbye");

        while (echo());
    }

    public static boolean echo() {

        String userInput;
        Scanner scan = new Scanner(System.in);
        userInput = scan.nextLine();

        String[] splitStr = userInput.split("\\s+");

        switch (splitStr[0]) {
            case "bye":
                System.out.println("Bye. Your tasks has been saved to myTask.txt.\n Hope to see you again soon!");
                return false;

            case "list":
                printList();
                return true;

            case "done":
                try {
                    int index = Integer.valueOf(splitStr[1]) - 1;
                    if (!userInput.equals("")) {
                        /*System.out.println("Nice! I've marked this task as done: \n" +
                                "       [X] " + taskList.get(index).getDescription());*/
                        System.out.println("Nice! I've marked this task as done:");
                        printUpdatedTask(taskList.get(index).getToDo(), "X", taskList.get(index).getDescription(), "");
                        taskList.get(index).setMark(true);
                        writeToFile();
                        return true;
                    } else {
                        System.out.println("☹ OOPS!!! There isn't a task <empty>.");
                        return false;
                    }
                }
                catch(Exception e){
                    System.out.println(errorQuit);
                    return false;
                }

            case "todo":
                try {
                    userInput = userInput.replace("todo ","");
                    if(!userInput.equals("") && !userInput.equals("todo")){
                        Task newTask = new Task(userInput, false, 'T', "");
                        taskList.add(newTask);
                        //newTask.setDescription(userInput);
                        /*System.out.println("Got it. I've added this task: \n" +
                                "      [T][ ] " + userInput + "\n" +
                                "Now you have " + taskList.size() + " tasks in the list.");*/
                        System.out.println("Got it. I've added this task:");
                        printUpdatedTask('T', "", userInput, "");
                        printTotalTasks();
                        writeToFile();
                        return true;
                    }
                    else {
                        System.out.println("☹ OOPS!!! The description of a todo cannot be empty.");
                        return false;
                    }
                }
                catch(Exception e){
                    System.out.println(errorQuit);
                    return false;
                }

            case "deadline":
                try {
                    userInput = userInput.replace("deadline ","");
                    if(!userInput.equals("") && !userInput.equals("deadline")){
                        String[] deadline = userInput.split(" /by ");
                        //format date (standardize)
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                        LocalDateTime newDeadline = LocalDateTime.parse(deadline[1], formatter);
                        Task newTask1 = new Task(deadline[0], false, 'D', "", newDeadline);
                        taskList.add(newTask1);
                        System.out.println("Got it. I've added this task:");
                        printUpdatedTask('D', "", deadline[0], newDeadline);// with ()?
                        printTotalTasks();
                        writeToFile();
                        return true;
                    }
                    else {
                        System.out.println("☹ OOPS!!! The description of a deadline cannot be empty.");
                        return false;
                    }
                }
                catch(Exception e){
                    System.out.println(errorQuit);
                    return false;
                }

            case "event":
                try {
                    userInput = userInput.replace("event ","");
                    if(!userInput.equals("") && !userInput.equals("event")){
                        String[] event = userInput.split("/");
                        Task newTask2 = new Task(event[0], false, 'E', event[1]);
                        taskList.add(newTask2);
                        System.out.println("Got it. I've added this task:");
                        printUpdatedTask('E', "", event[0], event[1]);
                        printTotalTasks();
                        writeToFile();
                        return true;
                    }
                    else {
                        System.out.println("☹ OOPS!!! The description of a todo cannot be empty.");
                        return false;
                    }
                }
                catch(Exception e){
                    System.out.println(errorQuit);
                    return false;
                }
            case "delete":
                try {
                    int index = Integer.valueOf(splitStr[1]) - 1;
                    if (!userInput.equals("")) {
                        String markToBeRemoved = taskList.get(index).getMarkSymbol();
                        char toDoToRemoved = taskList.get(index).getToDo();
                        String descToBeRemoved = taskList.get(index).getDescription();
                        String additionalDetailsToBeRemoved = taskList.get(index).getAdditionalDetails();
                        taskList.remove(index);
                        System.out.println("Noted. I've removed this task:");
                        printUpdatedTask(toDoToRemoved, markToBeRemoved, descToBeRemoved, additionalDetailsToBeRemoved);
                        printTotalTasks();
                        writeToFile();
                        return true;
                    } else {
                        System.out.println("☹ OOPS!!! There isn't a task <empty>.");
                        return false;
                    }

                }
                catch(Exception e){
                    System.out.println(errorQuit);
                    return false;
                }
            case "find":
                try {
                    userInput = userInput.replace("find ","");
                    if(!userInput.equals("") && !userInput.equals("find")){
                        int i = 0;
                        for (Task task : taskList) {
                            if (task.getDescription().contains(userInput)) {
                                if(i == 0){
                                    System.out.println("Here are the matching tasks in your list:");
                                }
                                i = i + 1;
                                printTaskWithNo(i, task.getToDo(), task.getMarkSymbol(), task.getDescription(),
                                        task.getAdditionalDetails(), task.getDeadline());
                            }
                        }
                        if(i == 0) {
                            System.out.println("There is no matching task in your list.");
                        }
                        return true;
                    }
                    else {
                        System.out.println("☹ OOPS!!! There is nothing to find.");
                        return false;
                    }
                }
                catch(Exception e){
                    System.out.println(errorQuit);
                    return false;
                }
            default:
                System.out.println(errorUnknown);
                return false;
        }
    }

    public static void printList(){
        for(int i = 0; i < taskList.size(); i++){
            if(i==0){
                System.out.println("Here are the tasks in your list:");
            }
            printTaskWithNo(i+1, taskList.get(i).getToDo(), taskList.get(i).getMarkSymbol(),
                    taskList.get(i).getDescription(), taskList.get(i).getAdditionalDetails(),taskList.get(i).getDeadline());
        }
    }

    public static String getFileContent(){
        String result = "";
        for(int i = 0; i < taskList.size(); i++){
            result = result + taskList.get(i).getToDo() + fileSeparator + taskList.get(i).getMark() + fileSeparator;
            result = result + taskList.get(i).getDescription() + fileSeparator + taskList.get(i).getAdditionalDetails() + "\n";
        }
        return result;
    }

    public static void writeToFile() {
        try {
            //create file is it doesnt exist
            File myObj = new File("myTask.txt");
            if (myObj.createNewFile()) {
                //System.out.println("File created");
            }
            //exist
            FileWriter myWriter = new FileWriter("myTask.txt");
            myWriter.write(getFileContent());
            myWriter.close();
            //System.out.println("Successfully wrote to the file.");
        }
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void printUpdatedTask(char toDo, String mark, String desc, String additionalInfo){
        System.out.println("      [" + toDo + "][" + mark + "] " + desc + additionalInfo);
    }
    public static void printUpdatedTask(char toDo, String mark, String desc, LocalDateTime deadline){
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("E, MMM dd yyyy HH:mm:ss");
        String formattedDate = deadline.format(myFormatObj);
        System.out.println("      [" + toDo + "][" + mark + "] " + desc + " by " + formattedDate);
    }

    public static void printTaskWithNo(int num, char toDo, String mark, String desc, String additionalInfo, LocalDateTime deadline){
        System.out.print(num + ". [" + toDo + "][" + mark + "] " + desc + additionalInfo);
        if(deadline != null){
            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("E, MMM dd yyyy HH:mm:ss");
            String formattedDate = deadline.format(myFormatObj);
            System.out.println(" by " + formattedDate);
        }
        else{
            System.out.println("");
        }
    }

    public static void printTotalTasks() {
        System.out.println("Now you have " + taskList.size() + " tasks in the list.");
    }
}