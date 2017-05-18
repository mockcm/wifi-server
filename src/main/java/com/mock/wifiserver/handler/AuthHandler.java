package com.mock.wifiserver.handler;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.nio.charset.Charset;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mock.wifiserver.DeviceManager;
import com.mock.wifiserver.protocol.Protocol;

public class AuthHandler extends ChannelInboundHandlerAdapter {
	
	private static final int TOKEN_OFFSET = 9;
	
	private static final Logger logger = LoggerFactory.getLogger(AuthHandler.class);
	
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg)
			throws Exception {
		
		ByteBuf data = (ByteBuf) msg;
		//获取MAC
		String mac = data.toString(Protocol.MAC_OFFSET, Protocol.MAC_LENGTH, Charset.forName("UTF-8"));
		if (null == mac || "".equals(mac)) {
			logger.error("mac is empty.close channel!");
			ctx.close();
			data.release();
			return;
		}
		//认证信息
		if (data.getByte(Protocol.CONTROL_OFFSET) == 0x0D) {
			//获取TOKEN
			String token = data.toString(TOKEN_OFFSET, (data.readableBytes() - TOKEN_OFFSET), Charset.forName("UTF-8"));
			if (!"IAA_GZCYDQ_GZCH".equals(token)) {
				logger.error("auth fail -> token : {},close channel!",token);
				ctx.close();
			}else {
				//认证成功
				logger.info("device with mac:{} auth successfully!",mac);
				this.response(mac, ctx);
			}
			data.release();
			return;
		}
		//非认证信息，首先检查是否已经认证
		if (null == DeviceManager.channel(mac)) {
			logger.error("device with mac:{} not auth,close channel!",mac);
			data.release();
			ctx.close();
			return;
		}
		
		//已经认证，转发到下一个Handler处理
		ctx.fireChannelRead(msg);
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
			throws Exception {
	}
	
	/** 发送响应
	 * @param mac
	 * @param ctx
	 */
	private void response(String mac,ChannelHandlerContext ctx) {
		
		DeviceManager.addDevice(mac, ctx.channel());
		//返回认证成功
		ByteBuf resp = ByteBufAllocator.DEFAULT.ioBuffer();
		byte [] respContent = "IAA_GZCYDQ_GZCH_CONNECT".getBytes();
		resp.writeShort(respContent.length + 1);
		resp.writeByte(0x0D);
		resp.writeBytes(respContent);
		ctx.writeAndFlush(resp);
	}
}
