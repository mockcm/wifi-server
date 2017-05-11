package com.mock.wifiserver.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mock.wifiserver.config.Directive;

public class DispatchHandler extends ChannelInboundHandlerAdapter {
	
	private static final Logger logger = LoggerFactory.getLogger(DispatchHandler.class);
	
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		logger.info("A client connected! ctx:{}",ctx);
		super.channelActive(ctx);
	}

	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		logger.info("A client disConnected! ctx:{}",ctx);
		super.channelInactive(ctx);
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg)
			throws Exception {
		ByteBuf data = (ByteBuf) msg;
		byte control = data.getByte(2);
		Directive directive = Directive.getDirective(control);
		switch (directive) {
		//状态信息
		case STAT_INFO:
			StatInfoHandler statInfoHandler = (StatInfoHandler) ctx.pipeline().get("statInfo");
			statInfoHandler.channelRead(ctx, msg);
			break;
			//其实
		default:
			break;
		}
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
			throws Exception {
		cause.printStackTrace();
	}
}
