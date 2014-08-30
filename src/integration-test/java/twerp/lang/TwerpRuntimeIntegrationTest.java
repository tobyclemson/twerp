package twerp.lang;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.testng.annotations.Test;
import twerp.lang.runtime.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class TwerpRuntimeIntegrationTest {
    @Test
    public void performsAddition() throws Exception {
        // Given
        // addition.tw contains "10+15"
        String additionSourceFile = getClass()
                .getResource("/addition.tw")
                .getFile();

        TwerpStringPrinter printer = new TwerpStringPrinter();
        Injector injector = Guice.createInjector(
                new TestTwerpPrintableModule(printer),
                new TwerpModule());

        TwerpRuntime runtime = new TwerpRuntimeFactory(injector).create();

        // When
        runtime.startWith(additionSourceFile);

        // Then
        assertThat(printer.getWriter().toString(), is("25"));
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
