package Netty.discard;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.ReferenceCountUtil;

/**
 * Created by Administrator on 2017/8/12.
 */
public class DiscardServerHandler extends ChannelHandlerAdapter {

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }



    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf byteBuf = (ByteBuf) msg;
        int i=0;
        try {
            while (byteBuf.isReadable()) { // (1)
                i++;
                byte[] req=new byte[byteBuf.readableBytes()];
                byteBuf.readBytes(req);
                String body=new String(req,"utf-8");
                System.out.println("server :"+body);
                String response="给客户端的响应: 已接收到发来的第"+i+"消息 "+body;
                ctx.writeAndFlush(Unpooled.copiedBuffer(response.getBytes()));
            }
        } finally {
            ReferenceCountUtil.release(msg); // (2)
        }
    }
}
