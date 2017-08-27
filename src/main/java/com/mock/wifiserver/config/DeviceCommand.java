package com.mock.wifiserver.config;

import java.io.Serializable;

public class DeviceCommand implements Serializable {

	private static final long serialVersionUID = 1L;
	private String machineId;
	private Object paramValue;
	private Integer code;
	private String machineMac;
	
	public String getMachineId() {
		return machineId;
	}
	public void setMachineId(String machineId) {
		this.machineId = machineId;
	}
	public Object getParamValue() {
		return paramValue;
	}
	public void setParamValue(Object paramValue) {
		this.paramValue = paramValue;
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
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}

}
