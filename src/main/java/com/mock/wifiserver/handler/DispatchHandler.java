package com.mock.wifiserver.handler;

import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mock.wifiserver.DeviceManager;
import com.mock.wifiserver.config.Directive;
import com.mock.wifiserver.protocol.Protocol;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.AttributeKey;

public class DispatchHandler extends ChannelInboundHandlerAdapter {
	
	private static final Logger logger = LoggerFactory.getLogger(DispatchHandler.class);
	
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		logger.info("A client connected! ctx:{}",ctx);
		super.channelActive(ctx);
		//每当设备连接上来时，就发送进行时间同步
		Calendar calendar = Calendar.getInstance();
		int weekOfDay = calendar.get(Calendar.DAY_OF_WEEK);
		ByteBuf resp = ByteBufAllocator.DEFAULT.buffer();
		resp.writeShort(8);
		resp.writeByte(0x02);
		resp.writeByte(weekOfDay - 1);
		resp.writeByte(calendar.get(Calendar.YEAR));
		resp.writeByte(calendar.get(Calendar.MONTH) + 1);
		resp.writeByte(calendar.get(Calendar.DAY_OF_MONTH));
		resp.writeByte(calendar.get(Calendar.HOUR_OF_DAY));
		resp.writeByte(calendar.get(Calendar.MINUTE));
		resp.writeByte(calendar.get(Calendar.SECOND));
		
		ctx.writeAndFlush(resp);
		
	}

	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		
		String mac = (String) ctx.channel().attr(AttributeKey.valueOf("mac")).get();
		ctx.channel().attr(AttributeKey.valueOf("mac")).remove();
		logger.info("A client disConnected! mac:{}, ctx:{}",mac,ctx);
		DeviceManager.removeDevice(mac);
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
