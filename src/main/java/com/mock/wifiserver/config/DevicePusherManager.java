package com.mock.wifiserver.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mock.wifiserver.DeviceManager;
import com.mock.wifiserver.WifiServerConstants;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.Channel;

public class DevicePusherManager {
	
	private static final Logger logger = LoggerFactory.getLogger(DevicePusherManager.class);
	
	public static void push(DeviceCommand deviceCommand) {
		
		String paramName = deviceCommand.getParamName();
		if (null == paramName || "".equals(paramName)) {
			logger.warn("paramName from deviceCommand is NULL");
			return;
		}
		
		String mac = deviceCommand.getMachineMac();
		String value = deviceCommand.getParamValue();
		
		switch (paramName) {
			//精油显示状态
		case "attarStatus":
			pushAttarStatus(mac, value);
			break;
			//电量显示状态
		case "electricStatus":
			pushElectricStatus(mac, value);
			break;
			//设备开关
		case "machineOpen":
			pushMachineOpen(mac, value);
			break;
			//风扇状态
		case "mechineFan":
			pushMechineFan(mac, value);
			break;
			//状态工作状态
		case "workingStatus":
			pushWorkingStatus(mac, value);
			break;
		default:
			break;
		}
	}
	
	private static final void pushAttarStatus(String mac,String value) {
		
		ByteBuf resp = ByteBufAllocator.DEFAULT.buffer();
		resp.writeShort(4);
		byte contro = 0;
		resp.writeByte(contro);
		resp.writeByte(WifiServerConstants.CMD_ATTAR_STATUA);
		resp.writeByte(Integer.parseInt(value));
		
		Channel channel = DeviceManager.channel(mac);
		if (null == channel) {
			logger.error("channel is null.mac :{}",mac);
			return;
		}
		channel.writeAndFlush(resp);
	}
	
	
	private static final void pushElectricStatus(String mac,String value) {
		
		ByteBuf resp = ByteBufAllocator.DEFAULT.buffer();
		resp.writeShort(4);
		byte contro = 0;
		resp.writeByte(contro);
		resp.writeByte(WifiServerConstants.CMD_ELECTRIC_STATUA);
		resp.writeByte(Integer.parseInt(value));
		
		Channel channel = DeviceManager.channel(mac);
		if (null == channel) {
			logger.error("channel is null.mac :{}",mac);
			return;
		}
		channel.writeAndFlush(resp);
	}
	
	private static final void pushMachineOpen(String mac,String value) {
			
			ByteBuf resp = ByteBufAllocator.DEFAULT.buffer();
			resp.writeShort(4);
			byte contro = 0;
			resp.writeByte(contro);
			resp.writeByte(WifiServerConstants.CMD_MACHINE_OPEN);
			resp.writeByte(Integer.parseInt(value));
			
			Channel channel = DeviceManager.channel(mac);
			if (null == channel) {
				logger.error("channel is null.mac :{}",mac);
				return;
			}
			channel.writeAndFlush(resp);
		}
	
	
	private static final void pushMechineFan(String mac,String value) {
		
		ByteBuf resp = ByteBufAllocator.DEFAULT.buffer();
		resp.writeShort(4);
		byte contro = 0;
		resp.writeByte(contro);
		resp.writeByte(WifiServerConstants.CMD_MECHINE_FAN);
		resp.writeByte(Integer.parseInt(value));
		
		Channel channel = DeviceManager.channel(mac);
		if (null == channel) {
			logger.error("channel is null.mac :{}",mac);
			return;
		}
		channel.writeAndFlush(resp);
	}
	
	private static final void pushWorkingStatus(String mac,String value) {
		
		ByteBuf resp = ByteBufAllocator.DEFAULT.buffer();
		resp.writeShort(4);
		byte contro = 0;
		resp.writeByte(contro);
		resp.writeByte(WifiServerConstants.CMD_WORKING_STATUS);
		resp.writeByte(Integer.parseInt(value));
		
		Channel channel = DeviceManager.channel(mac);
		if (null == channel) {
			logger.error("channel is null.mac :{}",mac);
			return;
		}
		channel.writeAndFlush(resp);
	}
}
