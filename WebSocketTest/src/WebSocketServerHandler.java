import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpHeaderUtil;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.handler.codec.http.websocketx.CloseWebSocketFrame;
import io.netty.handler.codec.http.websocketx.PingWebSocketFrame;
import io.netty.handler.codec.http.websocketx.PongWebSocketFrame;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketServerHandshaker;
import io.netty.handler.codec.http.websocketx.WebSocketServerHandshakerFactory;
import io.netty.util.CharsetUtil;

import java.awt.Toolkit;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WebSocketServerHandler extends SimpleChannelInboundHandler<Object> {

    private static final String WEBSOCKET_PATH = "/websocket";

    private Map<String, WebSocketServerHandshaker> handshakers = new HashMap<String, WebSocketServerHandshaker>();

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (msg instanceof FullHttpRequest) {
            handleHttpRequest(ctx, (FullHttpRequest) msg);
        } else if (msg instanceof WebSocketFrame) {
            handleWebSocketFrame(ctx, (WebSocketFrame) msg);
        }
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    private void handleHttpRequest(ChannelHandlerContext ctx, FullHttpRequest req) {
        if (!req.decoderResult().isSuccess()) {
            sendHttpResponse(ctx, req, new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.BAD_REQUEST));
            return;
        }
        if (req.method() != HttpMethod.GET) {
            sendHttpResponse(ctx, req, new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.FORBIDDEN));
            return;
        }
        if ("/".equals(req.uri())) {
            File f = new File(Toolkit.getDefaultToolkit().getClass().getResource("/onepage.html").getFile());
            String tmp = "";
            try {
                FileReader fr = new FileReader(f);
                Scanner scanner = new Scanner(fr);
                while (scanner.hasNext()) {
                    tmp += scanner.nextLine()+"\n";
                }
            } catch (FileNotFoundException e) {
                System.out.println("file not found!");
                return;
            }
            ByteBuf content = Unpooled.copiedBuffer(tmp, CharsetUtil.US_ASCII);
            FullHttpResponse resp = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, content);
            resp.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/html; charset=UTF-8");
            HttpHeaderUtil.setContentLength(resp, content.readableBytes());
            sendHttpResponse(ctx, req, resp);
            return;
        } else if ("/ws".equals(req.uri())) {
            File f = new File(Toolkit.getDefaultToolkit().getClass().getResource("/ws.html").getFile());
            String tmp = "";
            try {
                FileReader fr = new FileReader(f);
                Scanner scanner = new Scanner(fr);
                while (scanner.hasNext()) {
                    tmp += scanner.nextLine()+"\n";
                }
            } catch (FileNotFoundException e) {
                System.out.println("file not found!");
                return;
            }
            tmp = tmp.replace("127.0.0.1", WebSocketServer.serverIp);
            ByteBuf content = Unpooled.copiedBuffer(tmp, CharsetUtil.US_ASCII);
            FullHttpResponse resp = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, content);
            resp.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/html; charset=UTF-8");
            HttpHeaderUtil.setContentLength(resp, content.readableBytes());
            sendHttpResponse(ctx, req, resp);
            String tmpStr = ctx.channel().remoteAddress().toString();
            WebSocketServer.wsIp = tmpStr.substring(1, tmpStr.indexOf(':'));
            return;
        } else if ("/caller".equals(req.uri())) {
            File f = new File(Toolkit.getDefaultToolkit().getClass().getResource("/caller.html").getFile());
            String tmp = "";
            try {
                FileReader fr = new FileReader(f);
                Scanner scanner = new Scanner(fr);
                while (scanner.hasNext()) {
                    tmp += scanner.nextLine() + "\n";
                }
            } catch (FileNotFoundException e) {
                System.out.println("file not found!");
                return;
            }
            tmp = tmp.replace("127.0.0.1", WebSocketServer.serverIp);
            ByteBuf content = Unpooled.copiedBuffer(tmp, CharsetUtil.US_ASCII);
            FullHttpResponse resp = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, content);
            resp.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/html; charset=UTF-8");
            HttpHeaderUtil.setContentLength(resp, content.readableBytes());
            sendHttpResponse(ctx, req, resp);
            String tmpStr = ctx.channel().remoteAddress().toString();
            WebSocketServer.callerIp = tmpStr.substring(1, tmpStr.indexOf(':'));
            return;
        } else if ("/callee".equals(req.uri())) {
            File f = new File(Toolkit.getDefaultToolkit().getClass().getResource("/callee.html").getFile());
            String tmp = "";
            try {
                FileReader fr = new FileReader(f);
                Scanner scanner = new Scanner(fr);
                while (scanner.hasNext()) {
                    tmp += scanner.nextLine()+"\n";
                }
            } catch (FileNotFoundException e) {
                System.out.println("file not found!");
                return;
            }
            tmp = tmp.replace("127.0.0.1", WebSocketServer.serverIp);
            ByteBuf content = Unpooled.copiedBuffer(tmp, CharsetUtil.US_ASCII);
            FullHttpResponse resp = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, content);
            resp.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/html; charset=UTF-8");
            HttpHeaderUtil.setContentLength(resp, content.readableBytes());
            sendHttpResponse(ctx, req, resp);
            String tmpStr = ctx.channel().remoteAddress().toString();
            WebSocketServer.calleeIp = tmpStr.substring(1, tmpStr.indexOf(':'));
            return;
        } else if ("/favicon.ico".equals(req.uri())) {
            FullHttpResponse resp = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.NOT_FOUND);
            sendHttpResponse(ctx, req, resp);
            return;
        }
        WebSocketServerHandshakerFactory wsFactory = new WebSocketServerHandshakerFactory(getWebSocketLocation(req), null, true);
        WebSocketServerHandshaker handshaker = wsFactory.newHandshaker(req);
        if (handshaker == null) {
            WebSocketServerHandshakerFactory.sendUnsupportedVersionResponse(ctx.channel());
        } else {
            handshaker.handshake(ctx.channel(), req);
            handshakers.put(ctx.channel().remoteAddress().toString(), handshaker);
            if (!WebSocketServer.wsIp.isEmpty() && ctx.channel().remoteAddress().toString().contains(WebSocketServer.wsIp)) {
                WebSocketServer.ws = ctx.channel();
            } else if (!WebSocketServer.callerIp.isEmpty() && ctx.channel().remoteAddress().toString().contains(WebSocketServer.callerIp)) {
                WebSocketServer.caller = ctx.channel();
            } else if (!WebSocketServer.calleeIp.isEmpty() && ctx.channel().remoteAddress().toString().contains(WebSocketServer.calleeIp)) {
                WebSocketServer.callee = ctx.channel();
            }
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

    private void handleWebSocketFrame(ChannelHandlerContext ctx, WebSocketFrame frame) {
        if (frame instanceof CloseWebSocketFrame) {
            handshakers.get(ctx.channel().remoteAddress().toString()).close(ctx.channel(), (CloseWebSocketFrame) frame.retain());
            return;
        }
        if (frame instanceof PingWebSocketFrame) {
            ctx.channel().writeAndFlush(new PongWebSocketFrame(frame.content().retain()));
            return;
        }
        if (!(frame instanceof TextWebSocketFrame)) {
            throw new UnsupportedOperationException(String.format("%s frame types not supported", frame.getClass().getName()));
        }
        String request = ((TextWebSocketFrame) frame).text();
        System.err.printf("%s received %s%n", ctx.channel(), request);
        if (request.contains("caller")) {
            System.out.println("msg from caller");
            if (WebSocketServer.callee != null) {
                System.out.println("write msg to callee");
                WebSocketServer.callee.writeAndFlush(new TextWebSocketFrame(request));
            }
        } else if (request.contains("callee")) {
            System.out.println("msg from callee");
            if (WebSocketServer.caller != null) {
                System.out.println("write msg to caller");
                WebSocketServer.caller.writeAndFlush(new TextWebSocketFrame(request));
            }
        }
        if (WebSocketServer.ws != null) {
            System.out.println("write msg to ws");
            WebSocketServer.ws.writeAndFlush(new TextWebSocketFrame(request));
        }
    }

    private static void sendHttpResponse(ChannelHandlerContext ctx, FullHttpRequest req, FullHttpResponse resp) {
        if (resp.status().code() != 200) {
            ByteBuf buf = Unpooled.copiedBuffer(resp.status().toString(), CharsetUtil.UTF_8);
            resp.content().writeBytes(buf);
            buf.release();
            HttpHeaderUtil.setContentLength(resp, resp.content().readableBytes());
        }

        ChannelFuture f = ctx.channel().writeAndFlush(resp);
        if (HttpHeaderUtil.isKeepAlive(req) || resp.status().code() != 200) {
            f.addListener(ChannelFutureListener.CLOSE);
        }
    }

    private static String getWebSocketLocation(FullHttpRequest req) {
        String location = req.headers().get(HttpHeaderNames.HOST) + WEBSOCKET_PATH;
        if (WebSocketServer.SSL) {
            return "wss://" + location;
        } else {
            return "ws://" + location;
        }
    }
}
