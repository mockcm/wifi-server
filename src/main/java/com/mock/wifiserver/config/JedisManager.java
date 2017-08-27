package com.mock.wifiserver.config;

import redis.clients.jedis.Jedis;

public class JedisManager {
	
	private static final String REDIS_HOST = "localhost";
	private static final int REDIS_PORT = 6379;
			
	public static Jedis getPublishClient() {
		return publishClient;
	}

	public static Jedis getSubscriberClient() {
		return subscriberClient;
	}

	public static Jedis publishClient;
	
	public static Jedis subscriberClient;
	
	public static void init() {
		publishClient = new Jedis(REDIS_HOST, REDIS_PORT);
		subscriberClient = new Jedis(REDIS_HOST, REDIS_PORT);
	}
}
