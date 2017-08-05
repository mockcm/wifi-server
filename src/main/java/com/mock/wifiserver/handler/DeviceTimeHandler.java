package com.mock.wifiserver.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mock.wifiserver.protocol.CommonResponse;
import com.mock.wifiserver.protocol.DeviceTime;

public class DeviceTimeHandler extends ChannelInboundHandlerAdapter {

	private static final Logger logger = LoggerFactory.getLogger(DeviceTimeHandler.class);
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg)
			throws Exception {
		try {
			ByteBuf data = (ByteBuf) msg;
			DeviceTime deviceTime = DeviceTime.decode(data);
			logger.info("decode deviceTime : {}",deviceTime);
			CommonResponse.responseSuccess(ctx, deviceTime.getHeader().getControl());
		}finally {
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
