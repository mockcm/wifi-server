package com.mock.wifiserver.handler;

import java.nio.charset.Charset;

import java.util.Calendar;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mock.wifiserver.DeviceManager;
import com.mock.wifiserver.config.DevicePusherManager;
import com.mock.wifiserver.config.Directive;
import com.mock.wifiserver.config.SendCommand;
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
		Executors.newSingleThreadScheduledExecutor().schedule(new Runnable() {
			@Override
			public void run() {
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
				logger.info("send device time . data :{}",DevicePusherManager.formatByteBuffer(ctx.channel(), resp));
				ctx.writeAndFlush(resp);
			}
		}, 30, TimeUnit.SECONDS);
	}

	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		
		String mac = (String) ctx.channel().attr(AttributeKey.valueOf("mac")).get();
		ctx.channel().attr(AttributeKey.valueOf("mac")).remove();
		logger.info("A client disConnected! mac:{}, ctx:{}",mac,ctx);
		if (null != mac) {
			DeviceManager.removeDevice(mac);
		}
		super.channelInactive(ctx);
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg)
			throws Exception {
		ByteBuf data = (ByteBuf) msg;
		byte control = data.getByte(Protocol.CONTROL_OFFSET);
		Directive directive = Directive.getDirective(control);
		String mac = (String) ctx.channel().attr(AttributeKey.valueOf("mac")).get();
		switch (directive) {
		//状态信息
		case STAT_INFO:
			StatInfoHandler statInfoHandler = (StatInfoHandler) ctx.pipeline().get("statInfo");
			statInfoHandler.channelRead(ctx, msg);
			break;
		//About
		case DEVICE_INFO:
			//AboutHandler aboutHandler = (AboutHandler) ctx.pipeline().get("about");
			//aboutHandler.channelRead(ctx, msg);
			logger.info("收到About信息的应答。mac:{},result:{}",
					mac,data.toString(Protocol.DATA_CONTENT_OFFSET, 
							data.readableBytes() - Protocol.DATA_CONTENT_OFFSET, Charset.forName("UTF-8"))
					);
			break;
		//控制
		case CONTROL:
			//ControlHandler controlHandler = (ControlHandler) ctx.pipeline().get("control");
			//controlHandler.channelRead(ctx, msg);
			int busCode = data.getByte(Protocol.DATA_BUSCODE_OFFSET);
			switch (busCode) {
				//总控制
				case SendCommand.TOATL_CONTROL:
					logAck(ctx, data, "总控制", busCode);
					break;
					//时间段
				case SendCommand.TIME_FRAME:
					logAck(ctx, data, "时间段", busCode);
					break;
					//时间段开关
				case SendCommand.SWITCH_TIME_FRAME:
					logAck(ctx, data, "时间段开关", busCode);
					break;
					//设备开关
				case SendCommand.SWITCH_DEVICE:
					logAck(ctx, data, "设备开关", busCode);
					break;
					//风扇开关
				case SendCommand.SWITCH_FAN:
					logAck(ctx, data, "风扇开关", busCode);
					break;
					//精油开关
				case SendCommand.SWITCH_ATTAR:
					logAck(ctx, data, "精油开关", busCode);
					break;
					//电量余量
				case SendCommand.SWITCH_ELECTRIC:
					logAck(ctx, data, "电量余量", busCode);
					break;
				default:
					break;
				}
			break;
		//时间
		case DEVICE_TIME:
			//DeviceTimeHandler deviceTimeHandler = (DeviceTimeHandler) ctx.pipeline().get("deviceTime");
			//deviceTimeHandler.channelRead(ctx, msg);
			logger.info("收到设备时间信息的应答。mac:{},result:{}",
					mac,data.toString(Protocol.DATA_CONTENT_OFFSET, 
							data.readableBytes() - Protocol.DATA_CONTENT_OFFSET, Charset.forName("UTF-8"))
					);
			break;
		//产品信息
		case PRODUCT_INFO:
			//ProductInfoHandler productInfoHandler = (ProductInfoHandler) ctx.pipeline().get("productInfo");
			//productInfoHandler.channelRead(ctx, msg);
			logger.info("收到修改设备信息的应答。mac:{},result:{}",
					mac,data.toString(Protocol.DATA_CONTENT_OFFSET, 
							data.readableBytes() - Protocol.DATA_CONTENT_OFFSET, Charset.forName("UTF-8"))
					);
		default:
			break;
		}
	}
	
	private void logAck(ChannelHandlerContext ctx,ByteBuf data,String bus,int busCode) {
		String mac = (String) ctx.channel().attr(AttributeKey.valueOf("mac")).get();
		logger.info("收到{}应答。busCode:{},mac:{},result:{}",
				bus,
				busCode,
				mac,
				data.toString(Protocol.DATA_CONTENT_OFFSET + 1, 
						data.readableBytes() - (Protocol.DATA_CONTENT_OFFSET + 1), Charset.forName("UTF-8"))
				);
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
			throws Exception {
		cause.printStackTrace();
		ctx.close();
	}
}
