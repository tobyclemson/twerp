package twerp.lang.runtime;

import com.google.inject.Inject;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.io.InputStream;
import java.nio.file.Paths;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TwerpRuntime {
    TwerpReader reader;
    TwerpEvaluator evaluator;
    TwerpPrinter printer;

    @Inject
    public TwerpRuntime(
            TwerpReader reader,
            TwerpEvaluator evaluator,
            TwerpPrinter printer) {
        this.reader = reader;
        this.evaluator = evaluator;
        this.printer = printer;
    }

    public void startWith(String sourceFile) {
        InputStream inputStream = reader.readFileAt(Paths.get(sourceFile));
        TwerpPrintable printable = evaluator.evaluate(inputStream);
        printer.print(printable);
    }

}
