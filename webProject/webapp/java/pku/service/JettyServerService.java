package pku.service;

import com.google.common.util.concurrent.AbstractIdleService;
import com.google.inject.Singleton;
import com.google.inject.servlet.GuiceFilter;
import org.eclipse.jetty.servlet.ServletContextHandler;
import pku.main.JettyServer;

import javax.servlet.DispatcherType;
import java.util.EnumSet;

@Singleton
public class JettyServerService extends AbstractIdleService {
    private JettyServer server;

    @Override
    protected void startUp() throws Exception {
        server = new JettyServer(12306);
        ServletContextHandler context = new ServletContextHandler();
        context.setContextPath("/");
        server.setHandler(context);
        context.addFilter(GuiceFilter.class, "/*", EnumSet.allOf(DispatcherType.class));
        server.start();
        server.join();
    }

    @Override
    protected void shutDown() throws Exception {
        server.stop();
    }
}
