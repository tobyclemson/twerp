package twerp.lang.runtime;

import com.google.inject.Guice;
import com.google.inject.Injector;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TwerpRuntimeFactory {
    Injector injector;

    public TwerpRuntimeFactory() {
        this(Guice.createInjector(new TwerpModule()));
    }

    public TwerpRuntime create() {
        return injector.getInstance(TwerpRuntime.class);
    }
}
