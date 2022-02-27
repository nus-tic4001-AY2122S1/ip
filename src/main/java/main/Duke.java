package main;

import javafx.stage.Stage;
import main.parsers.ParserText;
import main.taskLists.Task;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Duke {

    public static ArrayList<Task> Tasks = new ArrayList<>();

    public static void main(String[] args) throws DukeException, IOException {

        Storage storage = new Storage("C:\\Users\\yrall\\Documents\\duke\\src\\data\\current_tasks.txt");
        ParserText response = new ParserText();


        UI interaction = new UI();

        interaction.welcome(storage.start());


        while (response.isTrue) {
            Scanner in = new Scanner(System.in);
            String input = in.nextLine();
            response.parsetext(input);
        }

        storage.save();

    }

    /**
     * This is a basic parser created for the GUI application.
     * Existing Parser output is captured from the console and saved
     * as a String.
     *
     * @param
     * input - User Input to the application from JavaGX
     * @throws DukeException - catches Duke exceptions and returns a suitable message to the user
     * @throws IOException
     */
    public String getResponse(String input, Stage stage) {
        String response = "";
        ParserText res = new ParserText();

        ByteArrayOutputStream strBuffer = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(strBuffer);
        PrintStream old = System.out;
        System.setOut(ps);
        try {
            res.parsetext(input);
        } catch (IOException | DukeException e) {

        }
        System.out.flush();
        System.setOut(old);
        response = strBuffer.toString();

        return response;
    }


}