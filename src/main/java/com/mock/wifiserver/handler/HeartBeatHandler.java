package com.mock.wifiserver.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mock.wifiserver.DeviceManager;
import com.mock.wifiserver.protocol.Protocol;
import com.mock.wifiserver.util.NumberUtil;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;
/**
 * 心跳处理包
 * @author Mock
 *
 */
public class HeartBeatHandler extends ChannelInboundHandlerAdapter {
	
	private static final Logger logger = LoggerFactory.getLogger(HeartBeatHandler.class);
	
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg)
			throws Exception {
		
		try {
			ByteBuf data = (ByteBuf) msg;
			//如果可读字节数为18，则认证是HeartBeat,协议有问题，这种判断不太妥当
			if (data.getShort(0) == 8) {
				String mac = getMac(data, 2, Protocol.MAC_LENGTH);
				//添加映射关系 
				DeviceManager.addDevice(mac, ctx.channel());
				logger.info("receive heatbeat from channel mac:{} :{}",mac,ctx.channel());
				ReferenceCountUtil.release(msg);
			}else {
				ctx.fireChannelRead(msg);
			}
		}catch(Exception e) {
			ReferenceCountUtil.release(msg);
		}
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
			throws Exception {
		cause.printStackTrace();
		ctx.channel();
	}
	
	private String getMac(ByteBuf data,int macIndex,int macLength) {
		
		String macHex = "";
		for (int i = 0;i<macLength;i++) {
			byte part = data.getByte(macIndex + i);
			macHex += NumberUtil.byte2Hex(part);
		}
		return macHex;
	}
}
