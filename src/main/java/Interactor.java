import Duke.Task.Deadline;
import Duke.Task.Event;
import Duke.Task.Task;
import Duke.Task.Todo;
import Duke.exceptions.DukeEmptyListException;
import Duke.exceptions.DukeException;
import Duke.exceptions.NoSuchCommandException;

import java.util.Scanner;

public class Interactor {

    Operations operations;
    private String exitKeyword = "";
    private String doneKeyword = "";
    private String todoKeyword = "todo";
    private String eventKeyword = "event";
    private String deadlineKeyword = "deadline";
    private String deleteKeyword = "delete";

    public Interactor() {}

    public void setOperations(Operations operations) {
        this.operations = operations;
    }

    public void setExitKeyword(String exitKeyword){
        this.exitKeyword = exitKeyword;
    }

    public void setDoneKeyword(String doneKeyword) {
        this.doneKeyword = doneKeyword;
    }


    public void start() throws DukeException {
        printGreeting();
        printExitKeyword();

        boolean toContinue = true;

        Scanner scanner = new Scanner(System.in);

        do {
            try {
                String currentInput = scanner.nextLine();


                if (currentInput.equals(exitKeyword)) {
                    printGoodbye();
                    break;
                } else if (currentInput.equals("list")) {
                    operations.printDatabase();
                }
                // When user toggles done-ness of task
                else if (beginsWith(currentInput, doneKeyword)) {
                    int i = getNumberFromInput(currentInput);
                    operations.setDone(i);
                }

                // handle user delete item
                else if (beginsWith(currentInput, deleteKeyword)) {
                    int i = getNumberFromInput(currentInput);
                    operations.deleteFromDatabase(i);
                    System.out.println("Deleted successfully " + i);
                }

                //*** check for Duke.Task.Todo, deadline, event creations ***
                else if (beginsWith(currentInput, todoKeyword)) {
                    Todo todo = handleTodoCreation(currentInput);
                    operations.addToDatabase(todo);
                    printTaskAddedMessage(todo);

                } else if (beginsWith(currentInput, deadlineKeyword)) {
                    Deadline deadline = handleDeadlineCreation(currentInput);
                    operations.addToDatabase(deadline);
                    printTaskAddedMessage(deadline);

                } else if (beginsWith(currentInput, eventKeyword)) {
                    Event event = handleEventCreation(currentInput);
                    operations.addToDatabase(event);
                    printTaskAddedMessage(event);

                } else {
                    throw new NoSuchCommandException("Please enter a proper command");
                }
            }
            catch (NoSuchCommandException e) {
                e.getMessage();
                System.out.println("No such command. Please enter a proper command.");
            }
            catch(DukeEmptyListException e){
                e.getMessage();
                System.out.println("Our list is currently empty. Please add something to the list first.");
            }
            catch(IndexOutOfBoundsException e){
                e.getMessage();
                System.out.println("You have tried to delete or done an item not in the list. Please choose a number from the list.");
            }
        } while (true);
    }

    private Todo handleTodoCreation(String currentInput) {
        // currentInput in the form "todo borrow book"

        String [] arr = currentInput.split(" ", 2); // 2 indicates we expect 2 values in array
        String description = arr[1];
        return new Todo(description);
    }

    private Deadline handleDeadlineCreation(String currentInput) {
        // currentInput in the shape of: "deadline return book /by Sunday"
        String [] arr = currentInput.split(" ", 2); // 2 indicates we expect 2 values in array
        String [] splitArr = arr[1].split("/by", 0);
        String description = splitArr[0];
        String endTime = splitArr[1];
        return new Deadline(false, description, endTime);
    }

    private Event handleEventCreation(String currentInput) {
        // currentInput in the shape of: "event project meeting /at Mon 2-4pm"
        String [] arr = currentInput.split(" ",2);
        String [] splitArr = arr[1].split("/at");
        String description = splitArr[0];
        String [] times = splitArr[1].split("-");
        String startTime = times[0];
        String endTime = times[1];
        return new Event(false, description, endTime, startTime);
    }

    private int getNumberFromInput(String currentInput) {
        // takes: "someLongString 4". returns: 4
        String [] arr = currentInput.split(" ", 0);
        return Integer.parseInt(arr[1]);
    }

    private static boolean beginsWith(String longerString, String shorterString) {
        if (shorterString.length() > longerString.length()){
            return false;
        }
        // returns true if longerString begins with shorterString
        // beginsWith("done 4", "done") should return True.
        int length = shorterString.length();
        String slicedString = longerString.substring(0, length);
        if (slicedString.equals(shorterString)){
            return true;
        }
        else {return false;}
    }

    private void printExitKeyword() {
        String message = String.format("Please type %s if you want to exit.", this.exitKeyword);
        System.out.println(message);
    }

    private void printGreeting(){
        System.out.println("Dunder Mifflin, this is Pam");
    }

    private void printGoodbye(){
        System.out.println("Okay bye");
    }

    private void printTaskAddedMessage(Task task){
        System.out.println("You have added: " + task);
    }
}