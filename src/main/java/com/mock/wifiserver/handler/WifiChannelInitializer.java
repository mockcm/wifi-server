package com.mock.wifiserver.handler;

import com.mock.wifiserver.WifiServerConstants;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;

public class WifiChannelInitializer extends ChannelInitializer<SocketChannel>{
	
	@Override
	protected void initChannel(SocketChannel ch) throws Exception {
		//ch.pipeline().addLast("decoder", new DataDecoder());
		ch.pipeline().addLast("decoder",new LengthFieldBasedFrameDecoder(WifiServerConstants.MAX_DATA_LENGTH, 0, 2, 0, 0));
		ch.pipeline().addLast("dispatch", new DispatchHandler());
		ch.pipeline().addLast("statInfo",new StatInfoHandler());
	}
}
