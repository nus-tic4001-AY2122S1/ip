import Duke.Command.Deadline;
import Duke.Command.Event;
import Duke.Command.Todo;
import Duke.Task.Task;
import Duke.Task.Tasks;
import Duke.Ui.Ui;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import Duke.Parser;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
/**
 * The Duke program implements an application that
 * a personal Assistant Chatbot that helps to keep track various of daily items.
 *
 * @author  jr-mojito
 * @version 1.0
 * @since   2021-08-16
 */
public class Duke extends Application {

    private static Ui ui;

    public void run(){
        ui.showWelcome();
    }

    @Override
    public void start(Stage stage) {
        Label helloWorld = new Label("Hello World!"); // Creating a new Label control
        Scene scene = new Scene(helloWorld); // Setting the scene to be our Label

        stage.setScene(scene); // Setting the stage to show our screen
        stage.show(); // Render the stage.
    }

    public static void main(String[] args){
        ui = new Ui();
        new Duke().run();

        Scanner fullCommand = ui.readCommand();

        String echo = " ";
        ArrayList<Task> addedList = new ArrayList<>();
        Tasks tasks= new Tasks("");

        while (!echo.equals("bye")) {

            echo = fullCommand.nextLine();
            String[] cli = Parser.parse(echo);

            String firstCommand = cli[0];

            switch (firstCommand){
                case("list"):
                    tasks.getList(addedList);
                    break;

                case("done"):
                    try{
                        if(cli[1]!=""){
                            String doneIndex = echo.substring(5);
                            tasks.addDone(Integer.parseInt(doneIndex));
                            System.out.println("-------------------------------");
                            System.out.println("    "+ "Nice! I've marked this task as done:");
                            System.out.println("    "+ tasks.markAsDone(Integer.parseInt(doneIndex)));
                            System.out.println("-------------------------------");
                        }
                    } catch (IndexOutOfBoundsException e){
                        System.out.println("☹ OOPS!!! The number of a done cannot be empty.");
                    }
                    break;

                case("todo"):
                    try{
                        if(cli[1]!=""){
                            String todoIndex = echo.substring(5);

                            Todo todo = new Todo(echo.substring(5));
                            Task task = new Task(false, todo.toString());

                            addedList.add(task);

                            System.out.println("-------------------------------");
                            System.out.println("    " + "Got it. I've added this task:");
                            System.out.println("    " + echo.substring(5) );
                            System.out.println("-------------------------------");
                            System.out.println("    " + "Now you have " + tasks.getNumOfList() + " tasks in the list.");

                        }
                    } catch (ArrayIndexOutOfBoundsException e){
                        System.out.println("☹ OOPS!!! The description of a todo cannot be empty.");
                    }
                    break;

                case("event"):
                    try {
                        if (cli[1] != "") {
                            int task_stringIndex_After_taskWord = 0;
                            String task_words ="", by_words = " ";

                            task_stringIndex_After_taskWord = echo.indexOf(" ");
                            int by_string = echo.indexOf("/");
                            by_words = echo.substring(by_string + 3);

                            if (echo.contains("/")) {
                                by_string = echo.indexOf("/");
                                task_words = echo.substring(task_stringIndex_After_taskWord, by_string);
                            }
                            else if(echo.contains("bye")){
                            }
                            else{
                                task_words = echo.substring(task_stringIndex_After_taskWord);
                            }

                            Event event = new Event(task_words, by_words );
                            Task task = new Task(false, event.toString());

                            addedList.add(task);

                            System.out.println("-------------------------------");
                            System.out.println("    " + "Got it. I've added this task:");
                            System.out.println("    " + echo.substring(6) );
                            System.out.println("-------------------------------");
                            System.out.println("    " + "Now you have " + tasks.getNumOfList() + " tasks in the list.");
                        }
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("☹ OOPS!!! The event description cannot be empty.");
                    }
                    break;

                case("deadline"):
                    try {
                        if (cli[1] != "") {
                            String task_words ="";
                            String by_words = " ";

                            int task_stringIndex_After_taskWord = echo.indexOf(" ");
                            int by_string = echo.indexOf("/");
                            by_words = echo.substring(by_string + 3);

                            if (echo.contains("/")) {
                                by_string = echo.indexOf("/");
                                task_words = echo.substring(task_stringIndex_After_taskWord, by_string);
                            }
                            else if(echo.contains("bye")){
                            }
                            else{
                                task_words = echo.substring(task_stringIndex_After_taskWord);
                            }

                            Deadline deadline = new Deadline(task_words, by_words );
                            Task task = new Task(false, deadline.toString());

                            addedList.add(task);

                            System.out.println("-------------------------------");
                            System.out.println("    " + "Got it. I've added this task:");
                            System.out.println("    " + echo.substring(9) );
                            System.out.println("-------------------------------");
                            System.out.println("    " + "Now you have " + tasks.getNumOfList() + " tasks in the list.");
                        }
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("☹ OOPS!!! The deadline description cannot be empty.");
                    }
                    break;

                case("delete"):
                    tasks.removeTaskList(Integer.valueOf(cli[1]));
                    break;

                case ("save"):
                    try {
                        FileWriter fw = new FileWriter("./dukesave.txt");
                        File f = new File("dukesave.txt");

                        int index1 = 0;
                        System.out.println("-------------------------------");
                        Iterator itr = addedList.iterator();
                        while (itr.hasNext()){
                            Task t = (Task)itr.next();
                            fw.write("  " + ++index1 +"[" + (t.status ?"\u2713": "\u2718") +"]" + t.desc + System.lineSeparator());
                        }

                        System.out.println("File save successfully to dukesave.txt");
                        System.out.println("-------------------------------");
                        fw.close();
                    } catch (FileNotFoundException e) {
                        System.out.println("File not found");
                    } catch (IOException e) {
                        System.out.println("Something went wrong" + e.getMessage());
                    }
                    break;

                case ("find"):

                    if(cli[1]!="") {
                        String searchWord = echo.substring(5);
                        int count_todo_find = tasks.getNumOfList();
                        System.out.println(Ui.seperatorLine2);
                        System.out.println("Here are the matching task in your list");

                        int listPrintFind = 0;
                        int index1 = 0;

                        for (int i = 0; i<addedList.toArray().length; i++) {
                            ++index1;
                            if(addedList.get(i).desc.toString().contains(searchWord.trim())){
                                System.out.println("        " + index1 + ". " + "[" + addedList.get(i).status+ "]" + addedList.get(i).desc);
                                listPrintFind++;
                            }
                        }

                        if(listPrintFind == 0){
                            System.out.println("Not matching found on the list");
                        }

                        System.out.println(Ui.seperatorLine2);

                        break;
                    }
                    default:
            }
        }

        System.out.println("-------------------------------");
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println("-------------------------------");
    }
}
