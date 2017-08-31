package com.mock.wifiserver.config;

import java.util.Calendar;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mock.wifiserver.DeviceManager;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.Channel;

public class DeviceTimeSendScheduler {
	
	private static final Logger logger = LoggerFactory.getLogger(DeviceTimeSendScheduler.class);
	public static void scheduler() {
		logger.info("device time scheduler started");
		Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(new Runnable() {
			@Override
			public void run() {
				//每当设备连接上来时，就发送进行时间同步
				Calendar calendar = Calendar.getInstance();
				int weekOfDay = calendar.get(Calendar.DAY_OF_WEEK);
				
				try {
					for (Channel channel : DeviceManager.devices().values()) {
						if (null == channel) continue;
						ByteBuf resp = ByteBufAllocator.DEFAULT.buffer();
						resp.writeShort(8);
						resp.writeByte(0x02);
						resp.writeByte(weekOfDay - 1);
						resp.writeByte(calendar.get(Calendar.YEAR));
						resp.writeByte(calendar.get(Calendar.MONTH) + 1);
						resp.writeByte(calendar.get(Calendar.DAY_OF_MONTH));
						resp.writeByte(calendar.get(Calendar.HOUR_OF_DAY));
						resp.writeByte(calendar.get(Calendar.MINUTE));
						resp.writeByte(calendar.get(Calendar.SECOND));
						channel.writeAndFlush(resp);
					}
				}catch (Exception e) {
					logger.error(e.getMessage(),e);
				}
			}
		}, 60, 7*24*3600, TimeUnit.SECONDS);
	}

}
