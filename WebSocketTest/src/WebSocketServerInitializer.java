import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.ssl.SslContext;


public class WebSocketServerInitializer extends ChannelInitializer<SocketChannel> {
	SslContext sslCtx;

	public WebSocketServerInitializer(SslContext sslCtx) {
		this.sslCtx = sslCtx;
	}


	@Override
	protected void initChannel(SocketChannel socketChannel) throws Exception {
		ChannelPipeline pipeline = socketChannel.pipeline();
		if (sslCtx != null) {
			pipeline.addLast(sslCtx.newHandler(socketChannel.alloc()));
		}
		pipeline.addLast(new HttpServerCodec());
		pipeline.addLast(new HttpObjectAggregator(65536));
		pipeline.addLast(new WebSocketServerHandler());
	}
}
