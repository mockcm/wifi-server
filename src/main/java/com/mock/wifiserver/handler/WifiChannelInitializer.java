package com.mock.wifiserver.handler;

import com.mock.wifiserver.WifiServerConstants;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;

public class WifiChannelInitializer extends ChannelInitializer<SocketChannel>{
	
	@Override
	protected void initChannel(SocketChannel ch) throws Exception {
		
		ch.pipeline().addLast("decoder",new LengthFieldBasedFrameDecoder(WifiServerConstants.MAX_DATA_LENGTH, 0, 2, 0, 0));
		ch.pipeline().addLast("headbeat",new HeartBeatHandler());
		ch.pipeline().addLast("auth", new SimpleAuthHandler());
		ch.pipeline().addLast("dispatch", new DispatchHandler());
		ch.pipeline().addLast("statInfo",new StatInfoHandler());
		ch.pipeline().addLast("about", new AboutHandler());
		ch.pipeline().addLast("control", new ControlHandler());
		ch.pipeline().addLast("deviceTime", new DeviceTimeHandler());
		ch.pipeline().addLast("productInfo", new ProductInfoHandler());
	}
}
