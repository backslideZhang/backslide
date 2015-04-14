package pku.init;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import pku.service.JettyServerService;

@Singleton
public class MainSingleton {

    @Inject
    JettyServerService jettyServerService;

    public void startAllService() {
        jettyServerService.startAsync();
    }

    public void stopAllService() {
        jettyServerService.stopAsync();
    }
}
