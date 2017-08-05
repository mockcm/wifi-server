package com.mock.wifiserver;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import redis.clients.jedis.Jedis;

import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mock.wifiserver.handler.WifiChannelInitializer;
import com.mock.wifiserver.sub.CommandSubscriber;

public class WifiServer {
	
	private static final Logger logger = LoggerFactory.getLogger(WifiServer.class);
	private static Jedis jedis;
	
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
				Executors.newSingleThreadExecutor().execute(new Runnable() {
					@Override
					public void run() {
						jedis = new Jedis("192.168.0.102", 6379);
						jedis.subscribe(new CommandSubscriber(), "DEVICE_COMMAND");
					}
				});
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
