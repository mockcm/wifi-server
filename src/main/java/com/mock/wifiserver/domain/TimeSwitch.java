package com.mock.wifiserver.domain;

import java.io.Serializable;

public class TimeSwitch implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	//时间段（1—5）
	private Integer timeSlot;
	
	//对应时间段开关，1：开，0：关
	private Integer value;

	public Integer getTimeSlot() {
		return timeSlot;
	}

	public void setTimeSlot(Integer timeSlot) {
		this.timeSlot = timeSlot;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}
}
