package com.mock.wifiserver.protocol;

import io.netty.buffer.ByteBuf;

import com.mock.wifiserver.util.NumberUtil;
import static com.mock.wifiserver.protocol.StatInfoProtocol.*;

public class StatInfo {
	
	private Header header;
	
	private Long oilRemind;
	private Long oilTotal;
	private Long electricity;
	private Long pumpPressure;
	private Long envPressure;
	private Long machineWorkTime;
	private Long pumpWorkTime;
	
	/**
	 * note:需要按照协议进行解码
	 * @param buf
	 * @return
	 */
	public static StatInfo decode(ByteBuf buf) {
		
		StatInfo statInfo = new StatInfo();
		statInfo.setHeader(Header.decode(buf));
		//剩余油量
		statInfo.setOilRemind(NumberUtil.readAsLong(buf, OIL_REMIND_OFFSET, OIL_REMIND_LENGTH));;
		//总油量
		statInfo.setOilTotal(NumberUtil.readAsLong(buf, OIL_TOTAL_OFFSET, OIL_TOTAL_LENGTH));
		//电量 
		statInfo.setElectricity(NumberUtil.readAsLong(buf, ELECTRICITY_OFFSET, ELECTRICITY_LENGTH));
		//气泵压力
		statInfo.setPumpPressure(NumberUtil.readAsLong(buf, PUMP_PRESSURE_OFFSET, PUMP_PRESSURE_LENGTH));
		//环境压力
		statInfo.setEnvPressure(NumberUtil.readAsLong(buf, ENV_PRESSURE_OFFSET, ENV_PRESSURE_LENGTH));
		
		//机器工作时间
		statInfo.setMachineWorkTime(NumberUtil.readAsLong(buf, MACHINE_WORK_TIME_OFFSET, MACHINE_WORK_TIME_LENGTH));
		//气泵工作时间
		statInfo.setPumpWorkTime(NumberUtil.readAsLong(buf, PUMP_WORK_TIME_OFFSET, PUMP_WORK_TIME_LENGTH));
		
		return statInfo;
	}

	public Long getOilRemind() {
		return oilRemind;
	}


	public void setOilRemind(Long oilRemind) {
		this.oilRemind = oilRemind;
	}


	public Long getOilTotal() {
		return oilTotal;
	}


	public void setOilTotal(Long oilTotal) {
		this.oilTotal = oilTotal;
	}


	public Long getElectricity() {
		return electricity;
	}


	public void setElectricity(Long electricity) {
		this.electricity = electricity;
	}


	public Long getPumpPressure() {
		return pumpPressure;
	}


	public void setPumpPressure(Long pumpPressure) {
		this.pumpPressure = pumpPressure;
	}


	public Long getEnvPressure() {
		return envPressure;
	}


	public void setEnvPressure(Long envPressure) {
		this.envPressure = envPressure;
	}


	public Long getMachineWorkTime() {
		return machineWorkTime;
	}


	public void setMachineWorkTime(Long machineWorkTime) {
		this.machineWorkTime = machineWorkTime;
	}


	public Long getPumpWorkTime() {
		return pumpWorkTime;
	}


	public void setPumpWorkTime(Long pumpWorkTime) {
		this.pumpWorkTime = pumpWorkTime;
	}

	@Override
	public String toString() {
		return "StatInfo [oilRemind=" + oilRemind + ", oilTotal=" + oilTotal
				+ ", electricity=" + electricity + ", pumpPressure="
				+ pumpPressure + ", envPressure=" + envPressure
				+ ", machineWorkTime=" + machineWorkTime + ", pumpWorkTime="
				+ pumpWorkTime + "]";
	}

	public Header getHeader() {
		return header;
	}

	public void setHeader(Header header) {
		this.header = header;
	}
}
