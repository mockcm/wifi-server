package com.mock.wifiserver.config;

import java.io.Serializable;

public class DeviceCommand implements Serializable {

	private static final long serialVersionUID = 1L;
	private String machineId;
	private String paramValue;
	private String paramName;
	private String machineMac;
	
	public String getMachineId() {
		return machineId;
	}
	public void setMachineId(String machineId) {
		this.machineId = machineId;
	}
	public String getParamValue() {
		return paramValue;
	}
	public void setParamValue(String paramValue) {
		this.paramValue = paramValue;
	}
	public String getParamName() {
		return paramName;
	}
	public void setParamName(String paramName) {
		this.paramName = paramName;
	}
	public String getMachineMac() {
		return machineMac;
	}
	public void setMachineMac(String machineMac) {
		this.machineMac = machineMac;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "DeviceCommand [machineId=" + machineId + ", paramValue=" + paramValue + ", paramName=" + paramName
				+ ", machineMac=" + machineMac + "]";
	}

}
