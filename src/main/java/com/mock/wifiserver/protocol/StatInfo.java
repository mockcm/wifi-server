package com.mock.wifiserver.protocol;

import static com.mock.wifiserver.protocol.StatInfoProtocol.*;

import io.netty.buffer.ByteBuf;

public class StatInfo {
	
	private Header header;
	
	private short oilRemind;
	private short oilTotal;
	private byte electricity;
	private short pumpPressure;
	private short envPressure;
	private int machineWorkTime;
	private int pumpWorkTime;
	
	/**
	 * note:需要按照协议进行解码
	 * @param buf
	 * @return
	 */
	public static StatInfo decode(ByteBuf buf) {
		
		StatInfo statInfo = new StatInfo();
		statInfo.setHeader(Header.decode(buf));
		//剩余油量
		
		statInfo.setOilRemind(buf.getShort(OIL_REMIND_OFFSET));
		//总油量
		statInfo.setOilTotal(buf.getShort(OIL_TOTAL_OFFSET));
		//电量 
		statInfo.setElectricity(buf.getByte(ELECTRICITY_OFFSET));
		//气泵压力
		statInfo.setPumpPressure(buf.getShort(PUMP_PRESSURE_OFFSET));
		//环境压力
		statInfo.setEnvPressure(buf.getShort(ENV_PRESSURE_OFFSET));
		
		//机器工作时间
		statInfo.setMachineWorkTime(buf.getInt(MACHINE_WORK_TIME_OFFSET));
		//气泵工作时间
		statInfo.setPumpWorkTime(buf.getInt(PUMP_WORK_TIME_OFFSET));
		
		return statInfo;
	}


	public Header getHeader() {
		return header;
	}

	public void setHeader(Header header) {
		this.header = header;
	}


	public short getOilRemind() {
		return oilRemind;
	}


	public void setOilRemind(short oilRemind) {
		this.oilRemind = oilRemind;
	}


	public short getOilTotal() {
		return oilTotal;
	}


	public void setOilTotal(short oilTotal) {
		this.oilTotal = oilTotal;
	}


	public byte getElectricity() {
		return electricity;
	}


	public void setElectricity(byte electricity) {
		this.electricity = electricity;
	}


	public short getPumpPressure() {
		return pumpPressure;
	}


	public void setPumpPressure(short pumpPressure) {
		this.pumpPressure = pumpPressure;
	}


	public short getEnvPressure() {
		return envPressure;
	}


	public void setEnvPressure(short envPressure) {
		this.envPressure = envPressure;
	}


	public int getMachineWorkTime() {
		return machineWorkTime;
	}


	public void setMachineWorkTime(int machineWorkTime) {
		this.machineWorkTime = machineWorkTime;
	}


	public int getPumpWorkTime() {
		return pumpWorkTime;
	}


	public void setPumpWorkTime(int pumpWorkTime) {
		this.pumpWorkTime = pumpWorkTime;
	}
}
