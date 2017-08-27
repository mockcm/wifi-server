package com.mock.wifiserver.config;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mock.wifiserver.DeviceManager;
import com.mock.wifiserver.domain.Machine;
import com.mock.wifiserver.domain.MachineTime;
import com.mock.wifiserver.domain.TimeSwitch;
import com.mock.wifiserver.util.NumberUtil;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.Channel;

public class DevicePusherManager {
	
	private static final Logger logger = LoggerFactory.getLogger(DevicePusherManager.class);
	
	public static void push(DeviceCommand deviceCommand) {
		
		Integer code = deviceCommand.getCode();
		if (null == code) {
			logger.warn("business code from deviceCommand is NULL");
			return;
		}
		
		String mac = deviceCommand.getMachineMac();
		Object value = deviceCommand.getParamValue();
		if (null == value) {
			logger.error("value is null.code:{}",code);
			return;
		}
		
		switch (code) {
		case SendCommand.SWITCH_ATTAR:
			pushAttarStatus(mac, (String)value);
			break;
		//风扇状态
		case SendCommand.SWITCH_FAN:
			pushMechineFan(mac, (String)value);
			break;
		//设备开关
		case SendCommand.SWITCH_DEVICE:
			pushMachineOpen(mac, (String)value);
			break;
		//时间段开关	
		case SendCommand.SWITCH_TIME_FRAME:
			pushSwitchTimeFrame(mac,(TimeSwitch)value);
			break;
		//电量
		case SendCommand.SWITCH_ELECTRIC:
			pushElectricStatus(mac, (String)value);
			break;
		//总控制
		case SendCommand.TOATL_CONTROL:
			pushAllInfo(mac, (Machine)value);
			break;
		//时间段
		case SendCommand.TIME_FRAME:
			pushTimeFrame(mac,(MachineTime)value);
			break;
		default:
			logger.warn("unknown command. code :{}",code);
			break;
		}
	}
	
	//发送总控制
	private static final void pushAllInfo(String mac,Machine machine) {
		
		ByteBuf resp = ByteBufAllocator.DEFAULT.buffer();
		resp.writeShort(67);
		byte contro = 0x03;
		resp.writeByte(contro);
		resp.writeByte(SendCommand.TOATL_CONTROL);
		
		byte totalTimeSwitch = 0;
		List<MachineTime> machineTimeList = machine.getMachineTimeList();
		if (null != machineTimeList && machineTimeList.size() > 0) {
			for (int i = 0;i<machineTimeList.size();i++) {
				NumberUtil.setBit(totalTimeSwitch, i, machineTimeList.get(i).getStatus());
			}
			resp.writeByte(totalTimeSwitch);
			
			for (int i = 0;i<machineTimeList.size();i++) {
				
				MachineTime machineTime = machineTimeList.get(i);
				resp.writeByte(machineTime.getBeginHour());
				resp.writeByte(machineTime.getBeginMinute());
				resp.writeByte(machineTime.getEndHour());
				resp.writeByte(machineTime.getEndMinute());
				
				byte weekend = 0;
				NumberUtil.setBit(weekend, 0, machineTime.getDay0());
				NumberUtil.setBit(weekend, 1, machineTime.getDay1());
				NumberUtil.setBit(weekend, 2, machineTime.getDay2());
				NumberUtil.setBit(weekend, 3, machineTime.getDay3());
				NumberUtil.setBit(weekend, 4, machineTime.getDay4());
				NumberUtil.setBit(weekend, 5, machineTime.getDay5());
				NumberUtil.setBit(weekend, 6, machineTime.getDay6());
				
				resp.writeByte(weekend);
			
				//如果是自定义档位，则置0
				resp.writeByte(machine.getIsGrade() == 0 ? 0 : machineTime.getGrade());
				
				//自定义工作时间
				resp.writeShort(0);
				resp.writeShort(0);
			}
		}else {
			resp.writeZero(51);
		}
		
		//D69开关
		byte tswitch = 0;
		NumberUtil.setBit(tswitch, 0, machine.getMachineOpen());
		NumberUtil.setBit(tswitch, 1,machine.getMachineFan());
		//少了个灯开关
		//NumberUtil.setBit(tswitch, 2, machineTime.getDay2());
		resp.writeByte(tswitch);
		
		//int remindOil = machine.getAttarCount() - machine.getAttarUse();
		resp.writeShort(machine.getAttarUse());
		resp.writeShort(machine.getAttarCount());
		
		//电量
		resp.writeByte(machine.getElectricCount());
		
		//自定义工作时间
		resp.writeShort(machine.getBeginMinTime());
		resp.writeShort(machine.getBeginMaxTime());
		resp.writeShort(machine.getEndMinTime());
		resp.writeShort(machine.getEndMaxTime());
		
		Channel channel = DeviceManager.channel(mac);
		if (null == channel) {
			logger.error("channel is null.mac :{}",mac);
			return;
		}
		logger.info("resp:{}",resp);
		channel.writeAndFlush(resp);
	}
	
	//发送时间段
	private static final void pushTimeFrame(String mac,MachineTime machineTime) {
		
		ByteBuf resp = ByteBufAllocator.DEFAULT.buffer();
		resp.writeShort(13);
		
		byte contro = 0x03;
		resp.writeByte(contro);
		resp.writeByte(SendCommand.TIME_FRAME);
		
		int timeSlot = machineTime.getTimeSlot();
		//bit0~bit3，时间段序号
		byte timeFrameSwitch = (byte) timeSlot;
		
		int value = machineTime.getStatus();
		//bit4对应时间段开关
		NumberUtil.setBit(timeFrameSwitch, 4, value);
		
		resp.writeByte(timeFrameSwitch);
		
		resp.writeByte(machineTime.getBeginHour());
		resp.writeByte(machineTime.getBeginMinute());
		resp.writeByte(machineTime.getEndHour());
		resp.writeByte(machineTime.getEndMinute());
		
		byte weekend = 0;
		NumberUtil.setBit(weekend, 0, machineTime.getDay0());
		NumberUtil.setBit(weekend, 1, machineTime.getDay1());
		NumberUtil.setBit(weekend, 2, machineTime.getDay2());
		NumberUtil.setBit(weekend, 3, machineTime.getDay3());
		NumberUtil.setBit(weekend, 4, machineTime.getDay4());
		NumberUtil.setBit(weekend, 5, machineTime.getDay5());
		NumberUtil.setBit(weekend, 6, machineTime.getDay6());
		
		resp.writeByte(weekend);
		
		resp.writeByte(machineTime.getGrade());
		
		//自定义时间
		resp.writeShort(0);
		resp.writeShort(0);
		
		Channel channel = DeviceManager.channel(mac);
		if (null == channel) {
			logger.error("channel is null.mac :{}",mac);
			return;
		}
		logger.info("resp:{}",resp);
		channel.writeAndFlush(resp);
	
	}
	
	//发送时间段开关
	private static final void pushSwitchTimeFrame(String mac,TimeSwitch timeSwitch) {
		
		int timeSlot = timeSwitch.getTimeSlot();
		//bit0~bit3，时间段序号
		byte timeFrameSwitch = (byte) timeSlot;
		
		int value = timeSwitch.getValue();
		//bit4对应时间段开关
		NumberUtil.setBit(timeFrameSwitch, 4, value);
		
		ByteBuf resp = ByteBufAllocator.DEFAULT.buffer();
		resp.writeShort(3);
		byte contro = 0x03;
		resp.writeByte(contro);
		resp.writeByte(SendCommand.SWITCH_TIME_FRAME);
		resp.writeByte(timeFrameSwitch);
		
		Channel channel = DeviceManager.channel(mac);
		if (null == channel) {
			logger.error("channel is null.mac :{}",mac);
			return;
		}
		logger.info("resp:{}",resp);
		channel.writeAndFlush(resp);
		
	}
	
	//发送精油
	private static final void pushAttarStatus(String mac,String value) {
		
		ByteBuf resp = ByteBufAllocator.DEFAULT.buffer();
		resp.writeShort(3);
		byte contro = 0x03;
		resp.writeByte(contro);
		resp.writeByte(SendCommand.SWITCH_ATTAR);
		resp.writeByte(Integer.parseInt(value));
		
		Channel channel = DeviceManager.channel(mac);
		if (null == channel) {
			logger.error("channel is null.mac :{}",mac);
			return;
		}
		logger.info("resp:{}",resp);
		channel.writeAndFlush(resp);
	}
	
	//发送电量
	private static final void pushElectricStatus(String mac,String value) {
		
		ByteBuf resp = ByteBufAllocator.DEFAULT.buffer();
		resp.writeShort(3);
		byte contro = 0x03;
		resp.writeByte(contro);
		resp.writeByte(SendCommand.SWITCH_ELECTRIC);
		resp.writeByte(Integer.parseInt(value));
		
		Channel channel = DeviceManager.channel(mac);
		if (null == channel) {
			logger.error("channel is null.mac :{}",mac);
			return;
		}
		logger.info("resp:{}",resp);
		channel.writeAndFlush(resp);
	}
	
	//发送设备开关
	private static final void pushMachineOpen(String mac,String value) {
			
			ByteBuf resp = ByteBufAllocator.DEFAULT.buffer();
			resp.writeShort(3);
			byte contro = 0x03;
			resp.writeByte(contro);
			resp.writeByte(SendCommand.SWITCH_DEVICE);
			resp.writeByte(Integer.parseInt(value));
			
			Channel channel = DeviceManager.channel(mac);
			if (null == channel) {
				logger.error("channel is null.mac :{}",mac);
				return;
			}
			logger.info("resp:{}",resp);
			channel.writeAndFlush(resp);
		}
	
	//发送风扇
	private static final void pushMechineFan(String mac,String value) {
		
		ByteBuf resp = ByteBufAllocator.DEFAULT.buffer();
		resp.writeShort(3);
		byte contro = 0x03;
		resp.writeByte(contro);
		resp.writeByte(SendCommand.SWITCH_FAN);
		resp.writeByte(Integer.parseInt(value));
		
		Channel channel = DeviceManager.channel(mac);
		if (null == channel) {
			logger.error("channel is null.mac :{}",mac);
			return;
		}
		logger.info("resp:{}",resp);
		channel.writeAndFlush(resp);
	}
	
	//发送工作状态
//	private static final void pushWorkingStatus(String mac,String value) {
//		
//		ByteBuf resp = ByteBufAllocator.DEFAULT.buffer();
//		resp.writeShort(3);
//		byte contro = 0x03;
//		resp.writeByte(contro);
//		resp.writeByte(WifiServerConstants.CMD_WORKING_STATUS);
//		resp.writeByte(Integer.parseInt(value));
//		
//		Channel channel = DeviceManager.channel(mac);
//		if (null == channel) {
//			logger.error("channel is null.mac :{}",mac);
//			return;
//		}
//		channel.writeAndFlush(resp);
//	}
}
