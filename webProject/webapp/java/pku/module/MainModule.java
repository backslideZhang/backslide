package pku.module;

import com.google.inject.Binder;
import com.google.inject.Module;

public class MainModule implements Module {

    @Override
    public void configure(Binder binder) {
        binder.install(new MainServletModule());
    }
}
