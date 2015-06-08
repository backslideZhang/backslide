import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.util.SelfSignedCertificate;

import java.util.HashMap;
import java.util.Map;

public final class WebSocketServer {
	static final boolean SSL = true;
	static final int PORT = SSL?8443:8080;

	public static Channel caller = null;
	public static Channel callee = null;

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

			System.out.println("Open your web browser and navigate to " +
					(SSL? "https" : "http") + "://127.0.0.1:" + PORT + '/');

			ch.closeFuture().sync();
		} finally {
			bossGroup.shutdownGracefully();
			workerGroup.shutdownGracefully();
		}
	}
}