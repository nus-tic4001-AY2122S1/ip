package duke.command;

import duke.ui.Message;

/**
 * It prints out all key from the HashMap that contains
 * key-command pair
 */
public class AllCommandCmd implements Command {
    private CommandFactory commands;

    public AllCommandCmd(CommandFactory commands) {
        this.commands = commands;
    }

    @Override
    public void run(String[] args) {
        Message.setBuffer("bye"
                    + System.lineSeparator()
                    + "list"
                    + System.lineSeparator()
                    + commands.getAllKeyString());
    }
}
