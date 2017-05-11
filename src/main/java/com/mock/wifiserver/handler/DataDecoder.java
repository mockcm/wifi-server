package com.mock.wifiserver.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

public class DataDecoder extends ByteToMessageDecoder {

	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf in,
			List<Object> out) throws Exception {
		
		/*if (in.readableBytes() < 1) return;
		
		byte data = in.getByte(0);
		Directive directive = Directive.getDirective(data);
		switch (directive) {
		//状态数据
		case STAT_INFO:
			//1 + 19
			if (in.readableBytes() < 20) return;
			out.add(in.readBytes(ByteBufAllocator.DEFAULT.buffer(20), 0, 20));
			break;
		default:
			break;
		}*/
	}
}
