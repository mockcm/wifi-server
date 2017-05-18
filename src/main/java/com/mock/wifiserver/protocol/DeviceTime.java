package com.mock.wifiserver.protocol;

import io.netty.buffer.ByteBuf;

public class DeviceTime {
	
	private Header header;
	
	private byte week;
	private byte year;
	private byte month;
	private byte day;
	private byte hour;
	private byte minute;
	private byte second;
	 
	public static DeviceTime decode(ByteBuf data) {
		
		DeviceTime deviceTime = new DeviceTime();
		
		deviceTime.setHeader(Header.decode(data));
		deviceTime.setWeek(data.getByte(DeviceTimeProtocol.WEEK_OFFSET));
		deviceTime.setYear(data.getByte(DeviceTimeProtocol.YEAR_OFFSET));
		deviceTime.setMonth(data.getByte(DeviceTimeProtocol.MONTH_OFFSET));
		deviceTime.setDay(data.getByte(DeviceTimeProtocol.DAY_OFFSET));
		deviceTime.setHour(data.getByte(DeviceTimeProtocol.HOUR_OFFSET));
		deviceTime.setMinute(data.getByte(DeviceTimeProtocol.MINUTE_OFFSET));
		deviceTime.setSecond(data.getByte(DeviceTimeProtocol.SECOND_OFFSET));
		
		return deviceTime;
		
	}
	
	public byte getWeek() {
		return week;
	}
	public void setWeek(byte week) {
		this.week = week;
	}
	public byte getYear() {
		return year;
	}
	public void setYear(byte year) {
		this.year = year;
	}
	public byte getMonth() {
		return month;
	}
	public void setMonth(byte month) {
		this.month = month;
	}
	public byte getDay() {
		return day;
	}
	public void setDay(byte day) {
		this.day = day;
	}
	public byte getHour() {
		return hour;
	}
	public void setHour(byte hour) {
		this.hour = hour;
	}
	public byte getMinute() {
		return minute;
	}
	public void setMinute(byte minute) {
		this.minute = minute;
	}
	public byte getSecond() {
		return second;
	}
	public void setSecond(byte second) {
		this.second = second;
	}

	public Header getHeader() {
		return header;
	}

	public void setHeader(Header header) {
		this.header = header;
	}

	@Override
	public String toString() {
		return "DeviceTime [header=" + header + ", week=" + week + ", year="
				+ year + ", month=" + month + ", day=" + day + ", hour=" + hour
				+ ", minute=" + minute + ", second=" + second + "]";
	}
	
}
