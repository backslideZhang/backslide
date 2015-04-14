package pku.main;

import com.google.common.util.concurrent.Service;
import pku.service.MainService;

public class Main {

    public static void main(String[] args) throws Exception {
        final MainService mainService = new MainService();
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                if (mainService.state().equals(Service.State.RUNNING)) {
                    mainService.stopAsync();
                }
            }
        }));
        mainService.startAsync().awaitRunning();
    }
}
