package storage;

import java.nio.file.FileSystems;
import java.nio.file.Path;

public class Storage {
    private final Path root = FileSystems.getDefault().getPath("").toAbsolutePath();
    private String filePath;

    public Storage(String filePath) {
        this.filePath = "/" + filePath;
    }
}

