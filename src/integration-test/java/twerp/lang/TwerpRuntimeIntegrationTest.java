package twerp.lang;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import twerp.lang.runtime.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class TwerpRuntimeIntegrationTest {
    TwerpStringPrinter printer;
    TwerpRuntime runtime;

    @BeforeMethod
    public void setup() {
        printer = new TwerpStringPrinter();
        runtime = new TwerpRuntimeFactory(
                Guice.createInjector(
                        new TestTwerpPrintableModule(printer),
                        new TwerpModule()))
                .create();
    }

    @Test
    public void performsAddition() throws Exception {
        // Given
        String sourceCode = "15+10";
        InputStream inputStream = inputStreamFrom(sourceCode);

        // When
        runtime.evaluate(inputStream);

        // Then
        assertThat(printer.getWriter().toString(), is("25"));
    }

    @Test
    public void performsSubtraction() throws Exception {
        // Given
        String sourceCode = "15-10";
        InputStream inputStream = inputStreamFrom(sourceCode);

        // When
        runtime.evaluate(inputStream);

        // Then
        assertThat(printer.getWriter().toString(), is("5"));
    }

    private ByteArrayInputStream inputStreamFrom(String sourceCode) {
        return new ByteArrayInputStream(sourceCode.getBytes());
    }

    @AllArgsConstructor
    @FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
    private class TestTwerpPrintableModule extends AbstractModule {
        TwerpPrinter printer;

        @Override
        protected void configure() {
            bind(TwerpPrinter.class).toInstance(printer);
        }
    }
}
