package com.mock.wifiserver.config;

import static io.netty.buffer.ByteBufUtil.appendPrettyHexDump;
import static io.netty.util.internal.StringUtil.NEWLINE;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mock.wifiserver.DeviceManager;
import com.mock.wifiserver.domain.About;
import com.mock.wifiserver.domain.Machine;
import com.mock.wifiserver.domain.MachineName;
import com.mock.wifiserver.domain.MachineTime;
import com.mock.wifiserver.domain.TimeSwitch;
import com.mock.wifiserver.util.NumberUtil;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.Channel;

public class DevicePusherManager {
	
	private static final Logger logger = LoggerFactory.getLogger(DevicePusherManager.class);
	
	
	private static void sendACK(Map<String,Object> ack) {
		
		
		//在你sendMessage后，执行以下操作。
		//BlockingQueue要设置成全局变量
		//BlockingQueue<PushACK> blockingQueue = new LinkedBlockingQueue<>();
		//2秒没返回，则认为失败
		//try {
		//	PushACK pushAck = blockingQueue.poll(2, TimeUnit.SECONDS);
		//} catch (InterruptedException e) {
		//	e.printStackTrace();
		//}
	
		//===============华丽的分割线======================
		
		//在redis的订阅线程上。
		//1.收到我推送给你的响应PushACK
		//2.将PushACK添加到blockingQueue
		// blockingQueue.offer(pushAck)
		
		//3.一旦往blockingQueue添加数据，将导致poll方法返回，这样你就行拿到我发给你的PushACK对象了。
		//4.如果两秒内,还没收到我的响应，poll会超时返回，可以认为发送失败，你直接告诉客户端失败。
		//5.最坏的情况也就等待2秒时间，当然可以设置得更短的超时时间
		
		
		Long consumed = JedisManager.getPublishClient().publish("PUSH_STAT", JSON.toJSONString(ack));
		if (null != consumed) {
			logger.info("channel : PUSH_STAT,consumed count : {}",consumed);
		}
	}
	
	public static void push(DeviceCommand deviceCommand) {
		
		Integer code = deviceCommand.getCode();
		if (null == code) {
			logger.warn("business code from deviceCommand is NULL");
			Map<String,Object> ack = new HashMap<>();
			ack.put("code", code);
			ack.put("mac", deviceCommand.getMachineMac());
			ack.put("status", "fail");
			ack.put("reason", "code is null");
			sendACK(ack);
			return;
		}
		
		String mac = deviceCommand.getMachineMac();
		Object value = deviceCommand.getParamValue();
		if (null == value) {
			logger.error("value is null.code:{}",code);
			Map<String,Object> ack = new HashMap<>();
			ack.put("code", code);
			ack.put("mac", deviceCommand.getMachineMac());
			ack.put("status", "fail");
			ack.put("reason", "value is null");
			sendACK(ack);
			return;
		}
		
		switch (code) {
		
		case SendCommand.DEVICE_INFO:
			pushDeviceInfo(mac, JSON.parseObject(value.toString(), MachineName.class),code);
			break;
		case SendCommand.TIME:
			break;
			
		case SendCommand.ABOUT:
			pushAbout(mac, JSON.parseObject(((JSONObject)value).toJSONString(), About.class),code);
			break;
		case SendCommand.SWITCH_ATTAR:
			pushAttarStatus(mac, (String)value,code);
			break;
		//风扇状态
		case SendCommand.SWITCH_FAN:
			pushMechineFan(mac, (String)value,code);
			break;
		//设备开关
		case SendCommand.SWITCH_DEVICE:
			pushMachineOpen(mac, (String)value,code);
			break;
		//时间段开关	
		case SendCommand.SWITCH_TIME_FRAME:
			pushSwitchTimeFrame(mac,JSON.parseObject(((JSONObject)value).toJSONString(), TimeSwitch.class),code);
			break;
		//电量
		case SendCommand.SWITCH_ELECTRIC:
			pushElectricStatus(mac, (String)value,code);
			break;
		//总控制
		case SendCommand.TOATL_CONTROL:
			pushAllInfo(mac, JSON.parseObject(((JSONObject)value).toJSONString(), Machine.class),code);
			break;
		//时间段
		case SendCommand.TIME_FRAME:
			pushTimeFrame(mac,JSON.parseObject(((JSONObject)value).toJSONString(), MachineTime.class),code);
			break;
		default:
			logger.warn("unknown command. code :{}",code);
			break;
		}
	}
	
	
	private static void send2Device(ByteBuf resp,String mac,Integer code) {
		Channel channel = DeviceManager.channel(mac);
		Map<String,Object> ack = new HashMap<>();
		if (null == channel) {
			logger.error("channel is null.mac :{}",mac);
			ack.put("code", code);
			ack.put("mac", mac);
			ack.put("status", "fail");
			ack.put("reason", "can not find device though mac");
			sendACK(ack);
			return;
		}
		logger.info("resp:{}",resp);
		ack.put("code", code);
		ack.put("mac", mac);
		ack.put("status", "success");
		sendACK(ack);
		logger.info("send data :{}",formatByteBuffer(channel, resp));
		channel.writeAndFlush(resp);
	}
	
	
	private static final void pushAbout(String mac,About about,Integer code) {
		
		Map<String,String> data = new HashMap<String,String>();
		data.put("pcbVer", about.getPcbVer());
		data.put("serial",about.getSerial());
		data.put("equipmentVer",about.getEquipmentVer());
		String dataJson = JSON.toJSONString(data);
		byte [] dataBytes = dataJson.getBytes(Charset.forName("UTF-8"));
		ByteBuf resp = ByteBufAllocator.DEFAULT.buffer();
		resp.writeShort(dataBytes.length + 1);
		resp.writeByte(0x04);
		resp.writeBytes(dataBytes);
		
		send2Device(resp, mac, code);	
	}
	
	private static final void pushDeviceInfo(String mac,MachineName machineName,Integer code) {
		
		Map<String,String> data = new HashMap<String,String>();
		data.put("name", machineName.getMachineName());
		data.put("addr", machineName.getAddress());
		String dataJson = JSON.toJSONString(data);
		dataJson = dataJson.replace("\"", "'");
		byte [] dataBytes = dataJson.getBytes(Charset.forName("UTF-8"));
		
		ByteBuf resp = ByteBufAllocator.DEFAULT.buffer();
		resp.writeShort(dataBytes.length + 1);
		resp.writeByte(0x01);
		resp.writeBytes(dataBytes);
		
		send2Device(resp, mac, code);	
	}
	
	//发送总控制
	private static final void pushAllInfo(String mac,Machine machine,Integer code) {
		
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
		
		send2Device(resp, mac, code);
	}
	
	//发送时间段
	private static final void pushTimeFrame(String mac,MachineTime machineTime,Integer code) {
		
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
		
		send2Device(resp, mac, code);	
	
	}
	
	//发送时间段开关
	private static final void pushSwitchTimeFrame(String mac,TimeSwitch timeSwitch,Integer code) {
		
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
		
		send2Device(resp, mac, code);	
		
	}
	
	//发送精油
	private static final void pushAttarStatus(String mac,String value,Integer code) {
		
		ByteBuf resp = ByteBufAllocator.DEFAULT.buffer();
		resp.writeShort(3);
		byte contro = 0x03;
		resp.writeByte(contro);
		resp.writeByte(SendCommand.SWITCH_ATTAR);
		resp.writeByte(Integer.parseInt(value));
		
		send2Device(resp, mac, code);	
	}
	
	//发送电量
	private static final void pushElectricStatus(String mac,String value,Integer code) {
		
		ByteBuf resp = ByteBufAllocator.DEFAULT.buffer();
		resp.writeShort(3);
		byte contro = 0x03;
		resp.writeByte(contro);
		resp.writeByte(SendCommand.SWITCH_ELECTRIC);
		resp.writeByte(Integer.parseInt(value));
		
		send2Device(resp, mac, code);
	}
	
	//发送设备开关
	private static final void pushMachineOpen(String mac,String value,Integer code) {
			
			ByteBuf resp = ByteBufAllocator.DEFAULT.buffer();
			resp.writeShort(3);
			byte contro = 0x03;
			resp.writeByte(contro);
			resp.writeByte(SendCommand.SWITCH_DEVICE);
			resp.writeByte(Integer.parseInt(value));
			
			send2Device(resp, mac, code);
		}
	
	//发送风扇
	private static final void pushMechineFan(String mac,String value,Integer code) {
		
		ByteBuf resp = ByteBufAllocator.DEFAULT.buffer();
		resp.writeShort(3);
		byte contro = 0x03;
		resp.writeByte(contro);
		resp.writeByte(SendCommand.SWITCH_FAN);
		resp.writeByte(Integer.parseInt(value));
		
		send2Device(resp, mac, code);
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
	
	public static String formatByteBuffer(Channel channel,ByteBuf msg) {
		String chStr = channel.toString();
		String eventName = "write";
		int length = msg.readableBytes();
        if (length == 0) {
            StringBuilder buf = new StringBuilder(chStr.length() + 1 + eventName.length() + 4);
            buf.append(chStr).append(' ').append(eventName).append(": 0B");
            return buf.toString();
        } else {
            int rows = length / 16 + (length % 15 == 0? 0 : 1) + 4;
            StringBuilder buf = new StringBuilder(chStr.length() + 1 + eventName.length() + 2 + 10 + 1 + 2 + rows * 80);

            buf.append(chStr).append(' ').append(eventName).append(": ").append(length).append('B').append(NEWLINE);
            appendPrettyHexDump(buf, msg);
            return buf.toString();
        }
	}
}
