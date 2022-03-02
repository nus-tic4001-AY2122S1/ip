package duke.ui;

import java.util.ArrayList;

import duke.storage.TempTaskList;

/**
 * Message Class offers the one and only place to look for
 * and amend the messages that will print on screen
 */
public final class Message {
    private static String buffer = "";
    public Message() { }

    /**
     * echo prints out the String parameter passed to it
     * @param input
     */
    public static void echo(String input) {
        System.out.print("\t");
        System.out.println(input);
    }

    /**
     * Take raw String returns formated string
     * @param raw
     * @return Formated String
     */
    public static String stringf(String raw) {
        return raw
             + System.lineSeparator();
    }

    /**
     * get buffer
     * @return buffer
     */
    public static String getBuffer() {
        return buffer;
    }

    /**
     * set buffer
     * @param text
     * @return buffer
     */
    public static String setBuffer(String text) {
        buffer = text;
        return buffer;
    }

    /**
     * append to buffer
     * @param text
     * @return buffer
     */
    public static String appendBuffer(String text) {
        buffer += text;
        return buffer;
    }

    /**
     * add task msg
     * @param tasks
     */
    public static void taskAdd(TempTaskList tasks) {
        String repeat = "added: "
                      + tasks.get(tasks.size() - 1).toString();
        buffer = repeat;
        tasks.tellStats();
    }

    /**
     * return String empty list msg
     * @return msg
     */
    public static String emptyList() {
        return "Zero task, add something new!";
    }

    /**
     * delete task msg
     * @param tasks
     */
    public static void taskDelete(ArrayList tasks) {
        String delete = "Roger. Below get removed: ";
        buffer = delete;
        tasks.stream().forEach(t -> buffer += t.toString());
    }

    /**
     * task done msg
     * @param tasks
     * @param index
     */
    public static void taskDone(TempTaskList tasks, int index) {
        buffer = "Marked below as DONE:"
                + System.lineSeparator()
                + tasks.get(index).toString();
        tasks.tellStats();
    }

    /**
     * task marked as undone msg
     * @param tasks
     * @param index
     */
    public static void taskUndone(TempTaskList tasks, int index) {
        buffer = "Marked below as UNDONE:"
                + System.lineSeparator()
                + tasks.get(index).toString();
        tasks.tellStats();
    }

    /**
     * task add tags
     * @param tasks
     * @param index
     */
    public static void taskTagged(TempTaskList tasks, int index) {
        buffer = "Tags after append:"
                + System.lineSeparator()
                + tasks.get(index).toString();
    }

    /**
     * msg prints [1/5] [done/total] task
     * @param numTask
     * @param numDoneTask
     */
    public static void tellTaskNum(int numTask, int numDoneTask) {
        buffer += System.lineSeparator()
                + "Task completion status: "
                + numDoneTask + " / " + numTask;
    }

    public static void exit() {
        System.out.println("\n👋 Bye, see ya ~ \n");
    }

    public static String exceptionUnknownCommand() {
        return "X_X : Unknown command, please try again";
    }

    public static String exceptionNumArgs() {
        return "X_X : Wrong number of argument, please try again";
    }

    public static String exceptionInvalidArgs() {
        return "X_X : Contains invalid argument, please try again";
    }

    public static String exceptionNoDate() {
        return "X_X : Please give a proper date for this type of task, please try again";
    }

    /**
     * duke linus text string
     */
    public static String greeting() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        return "Bonjour~ from"
                + System.lineSeparator()
                + logo
                + System.lineSeparator()
                + "You may spell your wish:"
                + System.lineSeparator();
    }
}
