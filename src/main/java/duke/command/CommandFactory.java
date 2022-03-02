package duke.command;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;

import duke.storage.TempTaskList;
import duke.ui.Message;

/**
 * This is a data structure holds all commands with their
 * trigger String word
 * When new CommandFactory get initiated, config()
 * will initiate all command object as well
 */
public class CommandFactory implements Iterable {
    private HashMap<String, Command> commands = new HashMap<>();

    private TempTaskList list;
    private File file;

    /**
     * constractor
     * @param list
     */
    public CommandFactory(TempTaskList list) {
        this.list = list;

        config();
    }

    /** add new keyword - command pair to the Map
     *  use to initiate all command object
     */
    private void config() {
        add("todo", new TodoCreationCmd(list));
        add("event", new EventCreationCmd(list));
        add("deadline", new DlCreationCmd(list));
        add("done", new TaskMarkDoneCmd(list));
        add("cmd", new AllCommandCmd(this));
        add("delete", new TaskDeleteCmd(list));
        add("find", new FindCmd(list));
        add("tag", new TagCmd(list));
    }

    public Command get(String key) {
        return commands.get(key);
    }

    public void add(String key, Command value) {
        commands.put(key, value);
    }

    public boolean containsKey(String key) {
        return commands.containsKey(key);
    }

    /**
     * prints all cmd keywords
     */
    public void print() {
        for (String key : commands.keySet()) {
            Message.echo(key);
        }
    }

    /**
     * returns String of all cmd keys
     * @return
     */
    public String getAllKeyString() {
        String str = "";
        for (String key : commands.keySet()) {
            str += key + System.lineSeparator();
        }
        return str;
    }

    @Override
    public Iterator iterator() {
        return commands.keySet().iterator();
    }
}
