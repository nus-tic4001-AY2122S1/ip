package duke.task;

import java.util.HashSet;
import java.util.Optional;

import duke.parse.StringParser;

/**
 * SuperClass , Abstract Class
 * Also, a Receiver Class in Command Pattern
 */

public abstract class Task {
    protected static int taskCount = 0;
    protected String title;
    protected boolean isDone;
    protected Optional<HashSet<String>> tags;

    /**
     * constractor to initiate new instance of Task
     * @param title
     */
    public Task(String title) {
        this.title = title.replaceAll(" :(.+):", "");
        this.isDone = false;
        taskCount++;
        tags = StringParser.getTagSet(title);
    }

    public String getStatusIcon() {
        return (isDone ? "x" : " "); // mark done task with x
    }

    public String getTitle() {
        return title;
    }
    public boolean isDone() {
        return isDone;
    }
    public void markDone() {
        this.isDone = true;
    }
    public void markUnDone() {
        this.isDone = false;
    }
    public Optional<HashSet<String>> getTags() {
        return tags;
    }
    /**
     * append tag to tags
     * @param tag
     */
    public void tagging(String tag) {
        if (tags.isPresent()) {
            tags.get().add(tag);
        } else {
            tags = Optional.of(new HashSet<>());
            tags.get().add(tag);
        }
    }

    @Override
    public String toString() {
        String status = "[ ]";
        if (isDone()) {
            status = "[x]";
        }
        if (!tags.isPresent()) {
            return status + " " + title;
        } else {
            return status + " " + title
                    + " "
                    + printTags();
        }
    }

    private String printTags() {
        String alltag = "";
        for (String tag : tags.get()) {
            alltag += ":" + tag;
        }
        return alltag + ":";
    }
}
