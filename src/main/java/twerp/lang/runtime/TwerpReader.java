package twerp.lang.runtime;

import lombok.SneakyThrows;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class TwerpReader {
    @SneakyThrows
    public InputStream readFileAt(Path path) {
        return Files.newInputStream(path);
    }
}
