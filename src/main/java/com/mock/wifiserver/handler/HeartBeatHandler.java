package com.mock.wifiserver.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mock.wifiserver.WifiServerConstants;
import com.mock.wifiserver.protocol.Protocol;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
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
			//如果可读字节数为18，则认证是HeatBeat,协议有问题，这种判断不太妥当
			if (data.readableBytes() == Protocol.DATA_CONTENT_OFFSET) {
				logger.info("receive heatbeat from channel :{}",ctx.channel());
				//如果是更改操作，则发送响应
				if (data.getByte(Protocol.DATA_CONTENT_OFFSET) == WifiServerConstants.CMD_HEART_BEAT) {
					ByteBuf resp = ByteBufAllocator.DEFAULT.buffer(3);
					resp.writeShort(1);
					resp.writeByte(0x01);
					ctx.writeAndFlush(resp);
				}
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
}
