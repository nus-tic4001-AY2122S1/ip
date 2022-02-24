package seedu.duke;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Handles input from user entry
 */

public class Parser {
    private static ArrayList<Task> todoList = TaskList.getInstance().getList();
    protected String input;
    protected String[] text;
    protected String body;
    protected boolean isPending;
    protected boolean isTask;
    protected Task task;
    protected Scanner scan = new Scanner(System.in);

    public Parser() {
        this.isPending = true;
    }

    /**
     * @param input String type input from user entry
     * @throws DukeException Duke specific errors
     */

    public void parse(String input) throws DukeException {
        this.text = input.split(" ");
        String date;
        switch (text[0].toLowerCase()) {
        case "bye":
            this.setExit();
            this.isTask = false;
            break;
        case "list":
            Ui.printList();
            this.isTask = false;
            break;
        case "todo":
            this.body = String.join(" ", Arrays.copyOfRange(text, 1, text.length));
            try {
                this.addTodo(this.body);
                this.isTask = true;
            } catch (DukeException e) {
                e.printErrorMessage();
                this.isTask = false;
            }
            break;
        case "deadline":
            this.body = String.join(" ", Arrays.copyOfRange(text, 1, text.length - 2));
            date = String.join(" ", Arrays.copyOfRange(text, text.length - 2, text.length));
            try {
                this.addDeadline(this.body, date);
                this.isTask = true;
            } catch (DukeException e) {
                e.printErrorMessage();
                this.isTask = false;
            }
            break;
        case "event":
            this.body = String.join(" ", Arrays.copyOfRange(text, 1, text.length - 3));
            date = String.join(" ", Arrays.copyOfRange(text, text.length - 3, text.length - 1));
            try {
                this.addEvent(this.body, date, text[text.length - 1]);
                this.isTask = true;
            } catch (DukeException e) {
                e.printErrorMessage();
                this.isTask = false;
            }
            break;
        case "delete":
            if (text[1].isEmpty() || text[1].isBlank()) {
                throw new DukeException("\t☹ OOPS!!! Please specify a task to delete!");
            }
            try {
                int index = Integer.parseInt(text[1]);
                if (index > todoList.size()) {
                    Ui.specifyValidNumber();
                    this.body = "";
                    this.isTask = false;
                    break;
                }
                if (index > 0) {
                    Ui.removedTask(todoList.remove(index - 1).toString());
                    this.isTask = false;
                }
            } catch (NumberFormatException e) {
                throw new DukeException("\t☹ OOPS!!! Please specify a valid number instead. E.g. 'delete 1'");
            }
            break;
        case "find":
            if (text[1].isEmpty() || text[1].isBlank()) {
                throw new DukeException("\t☹ OOPS!!! Please specify a word to find!");
            }
            Ui.searchList(text[1]);
            this.body = "";
            this.isTask = false;
            break;
        case "update":
            if (text[1].isEmpty() || text[1].isBlank()) {
                throw new DukeException("\t☹ OOPS!!! Please specify a task to update!");
            }
            try {
                int index = Integer.parseInt(text[1]);
                if (index > todoList.size()) {
                    Ui.specifyValidNumber();
                    this.body = "";
                    this.isTask = false;
                    break;
                }
                if (index > 0) {
                    this.updateTask(index, text);
                    Ui.updateTask(todoList.get(index - 1).toString());
                    this.isTask = false;
                }
            } catch (NumberFormatException e) {
                throw new DukeException("\t☹ OOPS!!! Please specify a valid number instead. E.g. 'delete 1'");
            }
            break;
        case "done":
            if (text[1].isEmpty() || text[1].isBlank()) {
                throw new DukeException("\t☹ OOPS!!! Please specify a task to be marked as done!");
            }
            try {
                int index = Integer.parseInt(text[1]);
                if (index > todoList.size()) {
                    Ui.specifyValidNumber();
                    this.body = "";
                    this.isTask = false;
                    break;
                }
                if (index > 0) {
                    todoList.get(index - 1).markAsDone();
                    Ui.markAsDone(todoList.get(index - 1).toString());
                    this.isTask = false;
                }
            } catch (NumberFormatException e) {
                throw new DukeException("\t☹ OOPS!!! Please specify a valid number instead. E.g. 'delete 1'");
            }
            break;
        default:
            this.body = "";
            this.isTask = false;
            throw new DukeException("\t☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
        }
    }

    /**
     * ends the parsing of user entry
     */

    public void setExit() {
        this.isPending = false;
    }

    /**
     * @param todo is the description of the entry
     * @throws DukeException Duke specific errors
     */
    public void addTodo(String todo) throws DukeException {
        this.task = new Todo(todo);
        todoList.add(this.task);
    }

    /**
     * @param deadline is the description of the entry
     * @param date     is the date of the entry
     * @throws DukeException Duke specific errors
     */
    public void addDeadline(String deadline, String date) throws DukeException {
        this.task = new Deadline(deadline, date);
        todoList.add(this.task);
    }

    /**
     * @param event is the description of the entry
     * @param date     is the date of the entry
     * @param time     is the time of the entry
     * @throws DukeException Duke specific errors
     */
    public void addEvent(String event, String date, String time) throws DukeException {
        this.task = new Event(event, date, time);
        todoList.add(this.task);
    }

    public void updateTask(int index, String[] text) {
        String date;
        if (todoList.get(index - 1).getType() == "T") {
            this.body = String.join(" ", Arrays.copyOfRange(text, 1, text.length));
            Todo updateTodo = (Todo) todoList.get(index - 1);
            updateTodo.update(this.body);
        } else if (todoList.get(index - 1).getType() == "D") {
            Deadline updateDeadline = (Deadline) todoList.get(index - 1);
            this.body = String.join(" ", Arrays.copyOfRange(text, 1, text.length - 2));
            date = String.join(" ", Arrays.copyOfRange(text, text.length - 2, text.length));
            updateDeadline.update(this.body, date);
        } else {
            Event updateEvent = (Event) todoList.get(index - 1);
            this.body = String.join(" ", Arrays.copyOfRange(text, 1, text.length - 3));
            date = String.join(" ", Arrays.copyOfRange(text, text.length - 3, text.length - 1));
            updateEvent.update(this.body, date, text[text.length - 1]);
        }
    }

    public Task getTask() {
        return this.task;
    }

    public void scan() throws DukeException {
        this.input = this.scan.nextLine();
        this.parse(input);
    }

    public void getInput(String input) throws DukeException {
        this.parse(input);
    }
}
