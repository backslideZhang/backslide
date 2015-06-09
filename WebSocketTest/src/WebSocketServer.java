import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.util.SelfSignedCertificate;

public final class WebSocketServer {
	static final boolean SSL = false;
	static final int PORT = SSL?8443:8080;

	public static Channel caller = null;
	public static Channel callee = null;
	public static Channel ws = null;

	public static String callerIp = "";
	public static String calleeIp = "";
	public static String wsIp = "";

	public static String serverIp = "162.105.75.153";

	public static void main(String[] args) throws Exception {
		final SslContext sslCtx;
		if (SSL) {
			SelfSignedCertificate ssc = new SelfSignedCertificate();
			sslCtx = SslContext.newServerContext(ssc.certificate(), ssc.privateKey());
		} else {
			sslCtx = null;
		}
		EventLoopGroup bossGroup = new NioEventLoopGroup();
		EventLoopGroup workerGroup = new NioEventLoopGroup();
		try {
			ServerBootstrap b = new ServerBootstrap();
			b.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class)
					.handler(new LoggingHandler(LogLevel.INFO))
					.childHandler(new WebSocketServerInitializer(sslCtx));
			Channel ch = b.bind(PORT).sync().channel();

			System.out.println("input http://"+serverIp+":8080/caller to load caller page");
			System.out.println("input http://"+serverIp+":8080/callee to load callee page");
			System.out.println("click button on caller page, then communication established");
			System.out.println("input http://"+serverIp+":8080/ws to load page that display the signaling" +
					" between caller and callee");

			ch.closeFuture().sync();
		} finally {
			bossGroup.shutdownGracefully();
			workerGroup.shutdownGracefully();
		}
	}
}