package twerp.lang.runtime;

import org.mockito.Mock;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

public class TwerpRuntimeTest {
    @Mock TwerpReader reader;
    @Mock TwerpEvaluator evaluator;
    @Mock TwerpPrinter printer;

    @BeforeMethod
    public void setup() {
        initMocks(this);
    }

    @Test
    public void readsSourceFileUsingReader() throws Exception {
        // Given
        String pathToSourceFile = "some/sort/of/path.tw";

        TwerpRuntime runtime = new TwerpRuntime(reader, evaluator, printer);

        // When
        runtime.evaluate(pathToSourceFile);

        // Then
        verify(reader).readFileAt(Paths.get(pathToSourceFile));
    }

    @Test
    public void evaluatesTheGivenInputStream() throws Exception {
        // Given
        InputStream inputStream = mock(InputStream.class);
        TwerpRuntime runtime = new TwerpRuntime(reader, evaluator, printer);

        // When
        runtime.evaluate(inputStream);

        // Then
        verify(evaluator).evaluate(inputStream);
    }

    @Test
    public void evaluatesInputStreamFromReader() throws Exception {
        // Given
        String pathToSourceFile = "some/sort/of/path.tw";
        InputStream inputStream = mock(InputStream.class);

        TwerpRuntime runtime = new TwerpRuntime(reader, evaluator, printer);

        given(reader.readFileAt(any(Path.class)))
                .willReturn(inputStream);

        // When
        runtime.evaluate(pathToSourceFile);

        // Then
        verify(evaluator).evaluate(inputStream);
    }

    @Test
    public void printsPrintableReturnedAfterEvaluationOfSourceFile() throws Exception {
        // Given
        String pathToSourceFile = "some/sort/of/path.tw";
        TwerpPrintable printable = mock(TwerpPrintable.class);

        TwerpRuntime runtime = new TwerpRuntime(reader, evaluator, printer);

        given(evaluator.evaluate(any(InputStream.class)))
                .willReturn(printable);

        // When
        runtime.evaluate(pathToSourceFile);

        // Then
        verify(printer).print(printable);
    }

    @Test
    public void printsPrintableReturnedAfterEvaluationOfInputStream() throws Exception {
        // Given
        InputStream inputStream = mock(InputStream.class);
        TwerpPrintable printable = mock(TwerpPrintable.class);

        TwerpRuntime runtime = new TwerpRuntime(reader, evaluator, printer);

        given(evaluator.evaluate(any(InputStream.class)))
                .willReturn(printable);

        // When
        runtime.evaluate(inputStream);

        // Then
        verify(printer).print(printable);
    }
}
