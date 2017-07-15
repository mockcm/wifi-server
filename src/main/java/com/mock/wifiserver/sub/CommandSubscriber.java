package com.mock.wifiserver.sub;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import redis.clients.jedis.JedisPubSub;

public class CommandSubscriber extends JedisPubSub {
	
	@Override
	public void onSubscribe(String channel, int subscribedChannels) {
		logger.info("subscrib to channel : {} succeed!",channel);
		super.onSubscribe(channel, subscribedChannels);
	}

	private static final Logger logger = LoggerFactory.getLogger(CommandSubscriber.class);
	
	@Override
	public void onMessage(String channel, String message) {
		super.onMessage(channel, message);
		logger.info("channel : {},message:{}",channel,message);
	}
}
