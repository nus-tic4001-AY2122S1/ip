package duke.command;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Stack;

import duke.exception.UnknownCommandException;
import duke.parse.StringParser;
import duke.ui.Message;

/**
 * A Invoker Class in Command Pattern
 */
public class CommandCaller implements PropertyChangeListener {
    private CommandFactory commandFactory;
    private Stack<Command> undoableCommandHistory = new Stack<>();

    public CommandCaller() {}
    public CommandCaller(CommandFactory commandFactory) {
        this.commandFactory = commandFactory;
    }

    /**
     * for children class to implement
     * @param cmd
     * @param args
     */
    public void runCommand(Command cmd, String[] args) {
        if (cmd instanceof UndoableCommand) {
            undoableCommandHistory.add(cmd);
        }
        cmd.run(args);
    }

    public Stack<Command> getUndoHistory() {
        return undoableCommandHistory;
    }

    /**
     * when the StringParse parse the user input,
     * evt's new value is a String array where
     * the first element is the key
     * the rest is String[] args
     * run the command if key exists accordingly
     * @param evt
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        String[] keyArgs = (String[]) evt.getNewValue();
        String key = keyArgs[0];
        String[] args = StringParser.removeFirst(keyArgs);
        if (!commandFactory.containsKey(key)) {
            try {
                throw new UnknownCommandException();
            } catch (UnknownCommandException e) {
                Message.setBuffer(e.getMessage());
            }
        } else {
            this.runCommand(commandFactory.get(key), args);
        }
    }
}
