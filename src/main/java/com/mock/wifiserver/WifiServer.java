package com.mock.wifiserver;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mock.wifiserver.handler.WifiChannelInitializer;

public class WifiServer {
	
	private static final Logger logger = LoggerFactory.getLogger(WifiServer.class);
	
	public static final void startup(String host,Integer port) {
		
		NioEventLoopGroup bossGroup = new NioEventLoopGroup(1);
		NioEventLoopGroup workGroup = new NioEventLoopGroup(5);
		ServerBootstrap bootstrap = new ServerBootstrap();
		bootstrap.group(bossGroup, workGroup)
			.channel(NioServerSocketChannel.class)
			.childHandler(new WifiChannelInitializer())
			.childOption(ChannelOption.TCP_NODELAY, true);
		
		try {
			ChannelFuture f = bootstrap.bind(host, port).sync();
			if (f.isSuccess()) {
				logger.info("server startup succefully,listening on {} : {} ", host,port);
			}
			f.channel().closeFuture().sync();
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
		}finally {
			bossGroup.shutdownGracefully();
			workGroup.shutdownGracefully();
		}
	}
	
	public static void main(String[] args) {
		startup("0.0.0.0", 11306);
	}
}
