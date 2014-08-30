package twerp.lang.runtime;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.io.Writer;

@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class TwerpPrintable {
    Number evaluate;

    @SneakyThrows
    public void writeTo(Writer writer) {
        writer.write(evaluate.toString());
    }
}
