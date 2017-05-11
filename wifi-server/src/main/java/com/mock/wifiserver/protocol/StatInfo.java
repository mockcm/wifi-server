package com.mock.wifiserver.protocol;

import io.netty.buffer.ByteBuf;

import com.mock.wifiserver.util.NumberUtil;

public class StatInfo {
	
	private D0 d0;
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
		D0 d0 = D0.build(buf.getByte(2));
		statInfo.setD0(d0);
		//剩余油量
		statInfo.setOilRemind(NumberUtil.readAsLong(buf, 3, 2));;
		//总油量
		statInfo.setOilTotal(NumberUtil.readAsLong(buf, 5, 2));
		//电量 
		statInfo.setElectricity(NumberUtil.readAsLong(buf, 7, 1));
		//气泵压力
		statInfo.setPumpPressure(NumberUtil.readAsLong(buf, 8, 2));
		//环境压力
		statInfo.setEnvPressure(NumberUtil.readAsLong(buf, 10, 2));
		
		//0
		
		//机器工作时间
		statInfo.setMachineWorkTime(NumberUtil.readAsLong(buf, 16, 3));
		//气泵工作时间
		statInfo.setPumpWorkTime(NumberUtil.readAsLong(buf, 19, 3));
		return statInfo;
		
	}

	
	public D0 getD0() {
		return d0;
	}
	public void setD0(D0 d0) {
		this.d0 = d0;
	}
	
	@Override
	public String toString() {
		return "StatInfo [d0=" + d0 + ", oilRemind=" + oilRemind
				+ ", oilTotal=" + oilTotal + ", electricity=" + electricity
				+ ", pumpPressure=" + pumpPressure + ", envPressure="
				+ envPressure + ", machineWorkTime=" + machineWorkTime
				+ ", pumpWorkTime=" + pumpWorkTime + "]";
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
	
	
}
