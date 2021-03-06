package com.mock.wifiserver.handler;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mock.wifiserver.protocol.StatInfo;

public class GearSettingHandler extends ChannelInboundHandlerAdapter {

	private static final Logger logger = LoggerFactory.getLogger(GearSettingHandler.class);
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg)
			throws Exception {
		
		try {
			StatInfo statInfo = StatInfo.decode((ByteBuf)msg);
			logger.info("decode statInfo : {}",statInfo);
			ByteBuf resp = ByteBufAllocator.DEFAULT.buffer(3);
			resp.writeShort(1);
			resp.writeByte(1);
			ctx.writeAndFlush(resp);
		} finally {
			ReferenceCountUtil.release(msg);
		}
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
			throws Exception {
		cause.printStackTrace();
		ctx.close();
	}
}
