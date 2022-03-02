package duke.command;

import java.util.concurrent.atomic.AtomicInteger;

import duke.parse.StringParser;
import duke.storage.TempTaskList;
import duke.ui.Message;

public class FindCmd implements Command {
    protected TempTaskList list;

    public FindCmd(TempTaskList list) {
        this.list = list;
    }

    @Override
    public void run(String[] args) {
        String key = StringParser.join(args).strip();
        AtomicInteger i = new AtomicInteger(1);
        if (key.startsWith(":") && key.endsWith(":")) {
            String tag = key.substring(1, key.length() - 1).strip();
            /*
            to filter the tasks with tags match the key word
             */
            list.stream()
                    .filter(t -> t.getTags().isPresent())
                    .filter(t -> t.getTags().get().contains(tag.toLowerCase()))
                    .forEach(t ->
                            Message.appendBuffer(
                                    i.getAndIncrement()
                                            + "."
                                            + t.toString()
                                            + System.lineSeparator()));
            return;
        }

        list.stream()
                .filter(t -> t.getTags().isPresent())
                .filter(t -> t.getTags().get().contains(key.toLowerCase()))
                .forEach(t ->
                        Message.appendBuffer(
                                i.getAndIncrement()
                                        + "."
                                        + t.toString()
                                        + System.lineSeparator()));
        /*
        to filter the tasks with title contains the key word
         */
        list.stream()
                .filter(t -> t.getTitle().contains(key))
                .forEach(t ->
                        Message.appendBuffer(
                                        i.getAndIncrement()
                                             + "."
                                             + t.toString()
                                             + System.lineSeparator()));


        if (Message.getBuffer() == "") {
            Message.setBuffer("X_X: Not found");
        }
    }
}
