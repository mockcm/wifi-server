package com.mock.wifiserver.sub;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.mock.wifiserver.config.DeviceCommand;
import com.mock.wifiserver.config.DevicePusherManager;

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
		//logger.info("channel : {},message:{}",channel,message);
		try {
			DeviceCommand deviceCommand = JSON.parseObject(message, DeviceCommand.class);
			logger.info("deviceCommand:{}",deviceCommand);
			DevicePusherManager.push(deviceCommand);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}
}
