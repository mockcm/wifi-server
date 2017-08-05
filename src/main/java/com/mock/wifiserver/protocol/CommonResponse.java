package com.mock.wifiserver.protocol;

import java.nio.charset.Charset;

import com.mock.wifiserver.WifiServerConstants;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelHandlerContext;

public class CommonResponse {
	
	public static void responseSuccess(ChannelHandlerContext ctx,byte control) {
		ByteBuf resp = ByteBufAllocator.DEFAULT.buffer();
		resp.writeShort(2);
		resp.writeByte(control);
		resp.writeBytes(WifiServerConstants.COMMON_SUCCESS_RESP_CODE.getBytes(Charset.forName("UTF-8")));
		ctx.writeAndFlush(resp);
	}
	
	public static void responseFail(ChannelHandlerContext ctx,byte control) {
		ByteBuf resp = ByteBufAllocator.DEFAULT.buffer();
		resp.writeShort(2);
		resp.writeByte(control);
		resp.writeBytes(WifiServerConstants.COMMON_FAIL_RESP_CODE.getBytes(Charset.forName("UTF-8")));
		ctx.writeAndFlush(resp);
	}
}
