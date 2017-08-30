package com.mock.wifiserver;

import io.netty.channel.Channel;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class DeviceManager {
	
	private static final ConcurrentMap<String, Channel> devices = new ConcurrentHashMap<String, Channel>();
	
	public static void addDevice(String mac,Channel channel) {
		devices.putIfAbsent(mac, channel);
	}
	
	public static void removeDevice(String mac) {
		devices.remove(mac);
	}
	
	public static Channel channel(String mac) {
		return devices.get(mac);
	}
	
	public static ConcurrentMap<String, Channel> devices() {
		return devices;
	}
}
