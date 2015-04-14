package pku.main;

import org.eclipse.jetty.server.Server;

public class JettyServer extends Server {
    public JettyServer(int port) {
        super(port);
    }
}
