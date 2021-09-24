package duke.dukeUI;
import java.util.Scanner;
import java.io.InputStream;

public class DukeUI{
    private final Scanner in;

    public DukeUI(){
        this(System.in);
    }

    public DukeUI(InputStream in){
        this.in = new Scanner(in);
    }

    private boolean shouldIgnore(String rawInputLine) {
        return rawInputLine.trim().isEmpty();
    }

    public void welcomeMessage(){
        String logo = "\t ____        _        \n"
                    + "\t|  _ \\ _   _| | _____ \n"
                    + "\t| | | | | | | |/ / _ \\\n"
                    + "\t| |_| | |_| |   <  __/\n"
                    + "\t|____/ \\__,_|_|\\_\\___|\n";
        System.out.println(logo + "Hello! I'm Duke\n\tWhat can I do for you?");
    }

    public void goodbyeMessage(){
        System.out.println("Bye. Hope to see you again soon!");
    }

    public static void donePrint(){
        System.out.println("Nice! I've marked this task as done:");
    }

    public static void wrongCommand(){
        System.out.print("You have enter an invalid command!!!");
    }

    public String readUserInput(){
        String input = in.nextLine();
        while(shouldIgnore(input)){
            input = in.nextLine();
        }
        return input;
    }

    public void showOutputToUser(String output) {
        System.out.println(output);
    }

    public void showError(String errorMessage){
        System.out.println("☹ OOPS!!! " + errorMessage);
    }
}