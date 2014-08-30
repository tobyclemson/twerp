package twerp.lang.runtime;

import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.StringWriter;

@Value
@NoArgsConstructor
public class TwerpStringPrinter implements TwerpPrinter {
    StringWriter writer = new StringWriter();

    @Override
    public void print(TwerpPrintable printable) {
        printable.writeTo(writer);
    }
}
