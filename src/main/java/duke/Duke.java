package duke;

import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.ToDo;
import duke.exception.ErrorHandler;
import duke.command.DeleteCommand;

import java.util.ArrayList;
import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        new Duke().run();
    }

    public boolean readCommand(String line, ArrayList<Task> tasks) {
        try {
            int result = line.indexOf(" ");
            String output;
            switch (line.split(" ")[0].toLowerCase()) {
            case ("list"):
                for (int i = 0; i < tasks.size(); i++) {
                    System.out.println((i + 1) + ". " + tasks.get(i).toString());
                }
                break;

            case ("done"):
                int i = Integer.parseInt(line.split(" ")[1]);
                tasks.get(i - 1).markAsDone();
                System.out.println("Nice! I've marked this duke.task as done: \n"
                    +
                    "[" + tasks.get(i - 1).getStatus() + "] " + tasks.get(i - 1).getTask());
                break;

            case ("deadline"):
                output = line.substring(result);
                if (output.contains("/by")) {
                    String description = output.split("/by")[0];
                    String time = output.split("/by")[1];
                    tasks.add(new Deadline(description, time));
                    System.out.println("I have added the deadline duke.task");
                } else {
                    throw new ErrorHandler("You forgot to include a date using /by");
                }
                break;

            case ("event"):
                output = line.substring(result);
                if (output.contains("/at")) {
                    String description = output.split("/at")[0];
                    String time = output.split("/at")[1];
                    tasks.add(new Event(description, time));
                    System.out.println("I have added the event duke.task");
                } else {
                    throw new ErrorHandler("You forgot to include a date using /at");
                }
                break;

            case ("todo"):
                if (result < 0) {
                    System.out.println(" ☹ OOPS!!! The description of a todo cannot be empty.");
                }
                output = line.substring(result);
                tasks.add(new ToDo(output));
                System.out.println("I have added the todo duke.task");
                break;

            case ("bye"):
                System.out.println("See you!");
                return true;

            case ("delete"):
                if (result < 2) {
                    System.out.println(" ☹ OOPS!!! Please indicate task number.");
                }
                //return new DeleteCommand(line);
                break;

            default:
                throw new ErrorHandler(" ☹ OOPS!!! I'm sorry, but I don't know what that means :-(");

            }
        } catch (Exception e) {
            System.out.println("error:" + e.getMessage() + ". Please type again");
        }
        return false;
    }

    public void run() {
        System.out.println("Hello! I'm duke.Duke \n  "
            +
            "What can I do for you?");
        ArrayList<Task> tasks = new ArrayList<>();
        boolean isExit = false;
        while (!isExit) {
            String line;
            Scanner in = new Scanner(System.in);
            System.out.println("Type something: ");
            line = in.nextLine();
            isExit = readCommand(line, tasks);
        }
    }
}
