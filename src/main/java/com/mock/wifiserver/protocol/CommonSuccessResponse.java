package com.mock.wifiserver.protocol;

import com.mock.wifiserver.WifiServerConstants;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelHandlerContext;

public class CommonSuccessResponse {
	
	public static void write(ChannelHandlerContext ctx,byte control) {
		ByteBuf resp = ByteBufAllocator.DEFAULT.buffer();
		resp.writeShort(2);
		resp.writeByte(control);
		resp.writeByte(WifiServerConstants.COMMON_SUCCESS_RESP_CODE);
		ctx.writeAndFlush(resp);
	}
}
