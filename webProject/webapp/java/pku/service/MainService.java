package pku.service;

import com.google.common.util.concurrent.AbstractIdleService;
import com.google.inject.Guice;
import com.google.inject.Injector;
import pku.init.MainSingleton;
import pku.module.MainModule;

public class MainService extends AbstractIdleService {

    MainSingleton mainSingleton;

    @Override
    protected void startUp() throws Exception {
        System.out.println("Project begin to start...");
        Injector injector = Guice.createInjector(new MainModule());
        mainSingleton = injector.getInstance(MainSingleton.class);
        mainSingleton.startAllService();
        System.out.println("Project all start!");
    }

    @Override
    protected void shutDown() throws Exception {
        System.out.println("Project begin to shutdown...");
        mainSingleton.stopAllService();
        System.out.println("Project all shutdown!");
    }
}
