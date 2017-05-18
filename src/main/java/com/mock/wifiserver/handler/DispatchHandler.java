package com.mock.wifiserver.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mock.wifiserver.config.Directive;
import com.mock.wifiserver.protocol.Protocol;

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
		byte control = data.getByte(Protocol.CONTROL_OFFSET);
		Directive directive = Directive.getDirective(control);
		switch (directive) {
		//状态信息
		case STAT_INFO:
			StatInfoHandler statInfoHandler = (StatInfoHandler) ctx.pipeline().get("statInfo");
			statInfoHandler.channelRead(ctx, msg);
			break;
		//About
		case DEVICE_INFO:
			AboutHandler aboutHandler = (AboutHandler) ctx.pipeline().get("about");
			aboutHandler.channelRead(ctx, msg);
			break;
		//控制
		case CONTROL:
			ControlHandler controlHandler = (ControlHandler) ctx.pipeline().get("control");
			controlHandler.channelRead(ctx, msg);
			break;
		//时间
		case DEVICE_TIME:
			DeviceTimeHandler deviceTimeHandler = (DeviceTimeHandler) ctx.pipeline().get("deviceTime");
			deviceTimeHandler.channelRead(ctx, msg);
			break;
		//产品信息
		case PRODUCT_INFO:
			ProductInfoHandler productInfoHandler = (ProductInfoHandler) ctx.pipeline().get("productInfo");
			productInfoHandler.channelRead(ctx, msg);
		default:
			break;
		}
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
			throws Exception {
		cause.printStackTrace();
		ctx.close();
	}
}
