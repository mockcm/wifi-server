package com.mock.wifiserver.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mock.wifiserver.protocol.CommonSuccessResponse;
import com.mock.wifiserver.protocol.Control;

public class ControlHandler extends ChannelInboundHandlerAdapter  {
	
	private static final Logger logger = LoggerFactory.getLogger(ControlHandler.class);
	
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg)
			throws Exception {
		
		try {
			ByteBuf data = (ByteBuf)msg;
			Control control = Control.decode(data);
			logger.info("decode control : {}",control);
			CommonSuccessResponse.write(ctx, control.getHeader().getControl());
		}finally {
			ReferenceCountUtil.release(msg);
		}
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
			throws Exception {
		cause.printStackTrace();
		ctx.channel();
	}

}
