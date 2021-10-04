import java.util.ArrayList;
import java.util.Scanner;

public class Duke {
    private static ArrayList<Task> tasklist=new ArrayList<>();
    private static int taskCount = 0;

    public static void addTask(Task s){
        tasklist.add(taskCount,s);
        taskCount++;
    }

    public static void printLine(){
        System.out.println("______________________________");
    }

    public static void showGreetings(){
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");
    }

    public static void showFarewell(){
        printLine();
        System.out.println("Bye. Hope to see you again soon!");
        printLine();
    }

    public static void showAddedTasks(String addedTask,int numOfTask){
        System.out.println("Got it. I've added this task: ");
        System.out.println(addedTask);
        System.out.println("Now you have " + numOfTask + " tasks in the list.");
    }

    public static void checkException(String message){
        try{
            throw new DukeException(message);
        }
        catch (DukeException ex){
            System.out.println(ex.getMessage());
        }
        printLine();
    }

    public static void main(String[] args){
        showGreetings();
        Scanner myObj = new Scanner(System.in);
        String userInput;
        while (myObj.hasNextLine()) {
            userInput = myObj.nextLine();
            String[] split = userInput.split(" ");
            String first = split[0];
            if (userInput.equals("list")) {
                //Print list of tasks
                printLine();
                System.out.println("Here are the tasks in your list:");
                for (int i = 0; i < taskCount; i++) {
                    System.out.println((i + 1) + ". " + tasklist.get(i).toString());
                }
                printLine();
                continue;
            }
            if (userInput.equals("bye")) {
                break;
            }
            else if (first.equals("done")) {
                //Get task index to mark as done
                String second = split[1];
                tasklist.get(Integer.parseInt(second) - 1).markAsDone();
                printLine();
                System.out.println("Nice! I've marked this task as done: ");
                System.out.println(tasklist.get(Integer.parseInt(second) - 1).getStatusIcon() + " " + tasklist.get(Integer.parseInt(second) - 1).description);
                printLine();
            } else {
                printLine();
                if (first.equals("todo")) {
                    //add to-do task and return exception if task name is empty
                    try{
                        String[] split01 = userInput.split(" ");
                        String firstTD = split01[0];
                        String secondTD = split01[1];
                        addTask(new ToDo(secondTD));
                        showAddedTasks(tasklist.get(taskCount-1).toString(),taskCount);
                    }
                    catch (ArrayIndexOutOfBoundsException e){
                        checkException("☹ OOPS!!! The description of a todo cannot be empty.");
                        continue;
                    }
                }
                if (first.equals("deadline")) {
                    //add deadline task and return exception if task name is empty
                    try{
                        String[] headerSplit02 = userInput.split("deadline");
                        String[] split02 = headerSplit02[1].split("/by");
                        String firstD = split02[0];
                        String secondD = split02[1];
                        addTask(new Deadline(firstD, secondD));
                        showAddedTasks(tasklist.get(taskCount-1).toString(),taskCount);
                    }
                    catch (ArrayIndexOutOfBoundsException e){
                        checkException("☹ OOPS!!! The description of a deadline cannot be empty.");
                        continue;
                    }
                }
                if (first.equals("event")) {
                    //add event task and return exception if task name is empty
                    try{
                        String[] headerSplit03 = userInput.split("event");
                        String[] split03 = headerSplit03[1].split("/at");
                        String firstE = split03[0];
                        String secondE = split03[1];
                        addTask(new Event(firstE, secondE));
                        showAddedTasks(tasklist.get(taskCount-1).toString(),taskCount);
                    }
                    catch (ArrayIndexOutOfBoundsException e){
                        checkException("☹ OOPS!!! The description of a event cannot be empty.");
                        continue;
                    }
                }
                else if (!first.equals("event") && !first.equals("deadline") &&!first.equals("todo")) {
                    checkException("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
                    continue;
                }
                printLine();
            }
        }
        showFarewell();
    }
}