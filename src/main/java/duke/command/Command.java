package duke.command;

@FunctionalInterface
public interface Command {
    void run(String[] args);
}
