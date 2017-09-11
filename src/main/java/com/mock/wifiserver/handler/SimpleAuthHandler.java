package com.mock.wifiserver.handler;

import static io.netty.buffer.ByteBufUtil.appendPrettyHexDump;
import static io.netty.util.internal.StringUtil.NEWLINE;

import java.nio.charset.Charset;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mock.wifiserver.DeviceManager;
import com.mock.wifiserver.protocol.Protocol;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.AttributeKey;

public class SimpleAuthHandler extends ChannelInboundHandlerAdapter {
	
	private static final Logger logger = LoggerFactory.getLogger(SimpleAuthHandler.class);
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		
		ByteBuf data = (ByteBuf) msg;
		logger.info("data length :{},readerIndex:{},writerIndex:{},readableBytes:{},:data:{}",
				new Object[]{data.getShort(0),data.readerIndex(),data.writerIndex(),data.readableBytes(),
						formatByteBuffer(ctx,data)});
		//获取固定认证字符串
		String authStr = data.toString(Protocol.AUTH_OFFSET, Protocol.AUTH_LENGTH, Charset.forName("UTF-8"));
		if (null == authStr || "".equals(authStr)) {
			logger.error("auth content is empty,close channel!");
			ctx.close();
			data.release();
			return;
		}
		
		//认证字符串不正确
		if (!"CY_CH_IAA".equals(authStr)) {
			logger.error("auth content : {} not correct!,close channel!");
			ctx.close();
			data.release();
			return;
		}
		
		//获取MAC地址
		String mac = data.toString(Protocol.MAC_OFFSET, Protocol.MAC_LENGTH, Charset.forName("UTF-8"));
		if (null == mac || "".equals(mac)) {
			logger.error("mac is empty.close channel!");
			ctx.close();
			data.release();
			return;
		}
		
		//添加映射关系 
		DeviceManager.addDevice(mac, ctx.channel());
		
		//添加到channel上下文
		ctx.channel().attr(AttributeKey.valueOf("mac")).set(mac);
		
		//转发到下一个Handler处理
		ctx.fireChannelRead(msg);
		
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		if (!"远程主机强迫关闭了一个现有的连接。".equals(cause.getMessage()) 
				&& !"Connection reset by peer".equals(cause.getMessage()))
			logger.error("socket error!,closing channel",cause);
		ctx.close();
	}
	
	private String formatByteBuffer(ChannelHandlerContext ctx,ByteBuf msg) {
		String chStr = ctx.channel().toString();
		String eventName = "read";
		int length = msg.readableBytes();
        if (length == 0) {
            StringBuilder buf = new StringBuilder(chStr.length() + 1 + eventName.length() + 4);
            buf.append(chStr).append(' ').append(eventName).append(": 0B");
            return buf.toString();
        } else {
            int rows = length / 16 + (length % 15 == 0? 0 : 1) + 4;
            StringBuilder buf = new StringBuilder(chStr.length() + 1 + eventName.length() + 2 + 10 + 1 + 2 + rows * 80);

            buf.append(chStr).append(' ').append(eventName).append(": ").append(length).append('B').append(NEWLINE);
            appendPrettyHexDump(buf, msg);
            return buf.toString();
        }
	}
}
