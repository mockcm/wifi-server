package com.mock.wifiserver.protocol;

import io.netty.buffer.ByteBuf;

public class Control {
	
	private Header header;
	
	private byte timeSwitch;
	
	private byte onHourOfTimePhase1;
	private byte onMinuteOfTimePhase1;
	private byte offHourOfTimePhase1;
	private byte offMinuteOfTimePhase1;
	private byte switchOfTimePhase1;
	private byte gearOfTimePhase1;
	private short customeWorkTime1OfTimePhase1;
	private short customeWorkTime2OfTimePhase1;
	
	
	private byte onHourOfTimePhase2;
	private byte onMinuteOfTimePhase2;
	private byte offHourOfTimePhase2;
	private byte offMinuteOfTimePhase2;
	private byte switchOfTimePhase2;
	private byte gearOfTimePhase2;
	private short customeWorkTime1OfTimePhase2;
	private short customeWorkTime2OfTimePhase2;
	
	
	private byte onHourOfTimePhase3;
	private byte onMinuteOfTimePhase3;
	private byte offHourOfTimePhase3;
	private byte offMinuteOfTimePhase3;
	private byte switchOfTimePhase3;
	private byte gearOfTimePhase3;
	private short customeWorkTime1OfTimePhase3;
	private short customeWorkTime2OfTimePhase3;
	
	
	private byte onHourOfTimePhase4;
	private byte onMinuteOfTimePhase4;
	private byte offHourOfTimePhase4;
	private byte offMinuteOfTimePhase4;
	private byte switchOfTimePhase4;
	private byte gearOfTimePhase4;
	private short customeWorkTime1OfTimePhase4;
	private short customeWorkTime2OfTimePhase4;
	
	private byte onHourOfTimePhase5;
	private byte onMinuteOfTimePhase5;
	private byte offHourOfTimePhase5;
	private byte offMinuteOfTimePhase5;
	private byte switchOfTimePhase5;
	private byte gearOfTimePhase5;
	private short customeWorkTime1OfTimePhase5;
	private short customeWorkTime2OfTimePhase5;
	
	private byte commonSwitch;
	private byte gearCount;
	
	private byte showChoice;
	
	private short oilRemind;
	private short oilTotal;
	private byte electricity;
	
	private short startMinTime;
	private short startMaxTime;
	private short stopMinTime;
	private short stopMaxTime;
	
	public static Control decode(ByteBuf data) {
		
		Control control = new Control();
		
		control.setHeader(Header.decode(data));
		
		control.setTimeSwitch(data.getByte(ControlProtocol.TIME_SWITCH_OFFSET));
		
		control.setOnHourOfTimePhase1(data.getByte(ControlProtocol.ON_HOUR_OF_TIME_PHASE_1_OFFSET));
		control.setOnMinuteOfTimePhase1(data.getByte(ControlProtocol.ON_MINUTE_OF_TIME_PHASE_1_OFFSET));
		control.setOffHourOfTimePhase1(data.getByte(ControlProtocol.OFF_HOUR_OF_TIME_PHASE_1_OFFSET));
		control.setOffMinuteOfTimePhase1(data.getByte(ControlProtocol.OFF_MINUTEOF_TIME_PHASE_1_OFFSET));
		control.setSwitchOfTimePhase1(data.getByte(ControlProtocol.SWITCH_OF_TIME_PHASE_1_OFFSET));
		control.setGearOfTimePhase1(data.getByte(ControlProtocol.GEAR_OF_TIME_PHASE_1_OFFSET));
		control.setCustomeWorkTime1OfTimePhase1(data.getShort(ControlProtocol.CUSTOME_WORK_TIME_1_OF_TIME_PHASE_1_OFFSET));
		control.setCustomeWorkTime2OfTimePhase1(data.getShort(ControlProtocol.CUSTOME_WORK_TIME_2_OF_TIME_PHASE_1_OFFSET));
		
		control.setOnHourOfTimePhase2(data.getByte(ControlProtocol.ON_HOUR_OF_TIME_PHASE_2_OFFSET));
		control.setOnMinuteOfTimePhase2(data.getByte(ControlProtocol.ON_MINUTE_OF_TIME_PHASE_2_OFFSET));
		control.setOffHourOfTimePhase2(data.getByte(ControlProtocol.OFF_HOUR_OF_TIME_PHASE_2_OFFSET));
		control.setOffMinuteOfTimePhase2(data.getByte(ControlProtocol.OFF_MINUTEOF_TIME_PHASE_2_OFFSET));
		control.setSwitchOfTimePhase2(data.getByte(ControlProtocol.SWITCH_OF_TIME_PHASE_2_OFFSET));
		control.setGearOfTimePhase2(data.getByte(ControlProtocol.GEAR_OF_TIME_PHASE_2_OFFSET));
		control.setCustomeWorkTime1OfTimePhase2(data.getShort(ControlProtocol.CUSTOME_WORK_TIME_1_OF_TIME_PHASE_2_OFFSET));
		control.setCustomeWorkTime2OfTimePhase2(data.getShort(ControlProtocol.CUSTOME_WORK_TIME_2_OF_TIME_PHASE_2_OFFSET));
		
		
		control.setOnHourOfTimePhase3(data.getByte(ControlProtocol.ON_HOUR_OF_TIME_PHASE_3_OFFSET));
		control.setOnMinuteOfTimePhase3(data.getByte(ControlProtocol.ON_MINUTE_OF_TIME_PHASE_3_OFFSET));
		control.setOffHourOfTimePhase3(data.getByte(ControlProtocol.OFF_HOUR_OF_TIME_PHASE_3_OFFSET));
		control.setOffMinuteOfTimePhase3(data.getByte(ControlProtocol.OFF_MINUTEOF_TIME_PHASE_3_OFFSET));
		control.setSwitchOfTimePhase3(data.getByte(ControlProtocol.SWITCH_OF_TIME_PHASE_3_OFFSET));
		control.setGearOfTimePhase3(data.getByte(ControlProtocol.GEAR_OF_TIME_PHASE_3_OFFSET));
		control.setCustomeWorkTime1OfTimePhase3(data.getShort(ControlProtocol.CUSTOME_WORK_TIME_1_OF_TIME_PHASE_3_OFFSET));
		control.setCustomeWorkTime2OfTimePhase3(data.getShort(ControlProtocol.CUSTOME_WORK_TIME_2_OF_TIME_PHASE_3_OFFSET));
		
		
		control.setOnHourOfTimePhase4(data.getByte(ControlProtocol.ON_HOUR_OF_TIME_PHASE_4_OFFSET));
		control.setOnMinuteOfTimePhase4(data.getByte(ControlProtocol.ON_MINUTE_OF_TIME_PHASE_4_OFFSET));
		control.setOffHourOfTimePhase4(data.getByte(ControlProtocol.OFF_HOUR_OF_TIME_PHASE_4_OFFSET));
		control.setOffMinuteOfTimePhase4(data.getByte(ControlProtocol.OFF_MINUTEOF_TIME_PHASE_4_OFFSET));
		control.setSwitchOfTimePhase4(data.getByte(ControlProtocol.SWITCH_OF_TIME_PHASE_4_OFFSET));
		control.setGearOfTimePhase4(data.getByte(ControlProtocol.GEAR_OF_TIME_PHASE_4_OFFSET));
		control.setCustomeWorkTime1OfTimePhase4(data.getShort(ControlProtocol.CUSTOME_WORK_TIME_1_OF_TIME_PHASE_4_OFFSET));
		control.setCustomeWorkTime2OfTimePhase4(data.getShort(ControlProtocol.CUSTOME_WORK_TIME_2_OF_TIME_PHASE_4_OFFSET));
		
		
		control.setOnHourOfTimePhase5(data.getByte(ControlProtocol.ON_HOUR_OF_TIME_PHASE_5_OFFSET));
		control.setOnMinuteOfTimePhase5(data.getByte(ControlProtocol.ON_MINUTE_OF_TIME_PHASE_5_OFFSET));
		control.setOffHourOfTimePhase5(data.getByte(ControlProtocol.OFF_HOUR_OF_TIME_PHASE_5_OFFSET));
		control.setOffMinuteOfTimePhase5(data.getByte(ControlProtocol.OFF_MINUTEOF_TIME_PHASE_5_OFFSET));
		control.setSwitchOfTimePhase5(data.getByte(ControlProtocol.SWITCH_OF_TIME_PHASE_5_OFFSET));
		control.setGearOfTimePhase5(data.getByte(ControlProtocol.GEAR_OF_TIME_PHASE_5_OFFSET));
		control.setCustomeWorkTime1OfTimePhase5(data.getShort(ControlProtocol.CUSTOME_WORK_TIME_1_OF_TIME_PHASE_5_OFFSET));
		control.setCustomeWorkTime2OfTimePhase5(data.getShort(ControlProtocol.CUSTOME_WORK_TIME_2_OF_TIME_PHASE_5_OFFSET));
		
		
		control.setGearCount(data.getByte(ControlProtocol.GEAR_COUNT_OFFSET));
		control.setCommonSwitch(data.getByte(ControlProtocol.COMMON_SWITCH_OFFSET));
		control.setShowChoice(data.getByte(ControlProtocol.SHOW_CHOICE_OFFSET));
		
		control.setOilRemind(data.getShort(ControlProtocol.OIL_REMIND_OFFSET));
		control.setOilTotal(data.getShort(ControlProtocol.OIL_TOTAL_OFFSET));
		control.setElectricity(data.getByte(ControlProtocol.ELECTRICITY_OFFSET));
		
		control.setStartMinTime(data.getShort(ControlProtocol.START_MIN_TIME_OFFSET));
		control.setStartMaxTime(data.getShort(ControlProtocol.START_MAX_TIME_OFFSET));
		control.setStopMinTime(data.getShort(ControlProtocol.STOP_MIN_TIME_OFFSET));
		control.setStopMaxTime(data.getShort(ControlProtocol.STOP_MAX_TIME_OFFSET));
		
		return control;
		
	}
	

	public byte getTimeSwitch() {
		return timeSwitch;
	}
	public void setTimeSwitch(byte timeSwitch) {
		this.timeSwitch = timeSwitch;
	}
	public byte getOnHourOfTimePhase1() {
		return onHourOfTimePhase1;
	}
	public void setOnHourOfTimePhase1(byte onHourOfTimePhase1) {
		this.onHourOfTimePhase1 = onHourOfTimePhase1;
	}
	public byte getOnMinuteOfTimePhase1() {
		return onMinuteOfTimePhase1;
	}
	public void setOnMinuteOfTimePhase1(byte onMinuteOfTimePhase1) {
		this.onMinuteOfTimePhase1 = onMinuteOfTimePhase1;
	}
	public byte getOffHourOfTimePhase1() {
		return offHourOfTimePhase1;
	}
	public void setOffHourOfTimePhase1(byte offHourOfTimePhase1) {
		this.offHourOfTimePhase1 = offHourOfTimePhase1;
	}
	public byte getOffMinuteOfTimePhase1() {
		return offMinuteOfTimePhase1;
	}
	public void setOffMinuteOfTimePhase1(byte offMinuteOfTimePhase1) {
		this.offMinuteOfTimePhase1 = offMinuteOfTimePhase1;
	}
	public byte getSwitchOfTimePhase1() {
		return switchOfTimePhase1;
	}
	public void setSwitchOfTimePhase1(byte switchOfTimePhase1) {
		this.switchOfTimePhase1 = switchOfTimePhase1;
	}
	public byte getGearOfTimePhase1() {
		return gearOfTimePhase1;
	}
	public void setGearOfTimePhase1(byte gearOfTimePhase1) {
		this.gearOfTimePhase1 = gearOfTimePhase1;
	}
	public byte getOnHourOfTimePhase2() {
		return onHourOfTimePhase2;
	}
	public void setOnHourOfTimePhase2(byte onHourOfTimePhase2) {
		this.onHourOfTimePhase2 = onHourOfTimePhase2;
	}
	public byte getOnMinuteOfTimePhase2() {
		return onMinuteOfTimePhase2;
	}
	public void setOnMinuteOfTimePhase2(byte onMinuteOfTimePhase2) {
		this.onMinuteOfTimePhase2 = onMinuteOfTimePhase2;
	}
	public byte getOffHourOfTimePhase2() {
		return offHourOfTimePhase2;
	}
	public void setOffHourOfTimePhase2(byte offHourOfTimePhase2) {
		this.offHourOfTimePhase2 = offHourOfTimePhase2;
	}
	public byte getOffMinuteOfTimePhase2() {
		return offMinuteOfTimePhase2;
	}
	public void setOffMinuteOfTimePhase2(byte offMinuteOfTimePhase2) {
		this.offMinuteOfTimePhase2 = offMinuteOfTimePhase2;
	}
	public byte getSwitchOfTimePhase2() {
		return switchOfTimePhase2;
	}
	public void setSwitchOfTimePhase2(byte switchOfTimePhase2) {
		this.switchOfTimePhase2 = switchOfTimePhase2;
	}
	public byte getGearOfTimePhase2() {
		return gearOfTimePhase2;
	}
	public void setGearOfTimePhase2(byte gearOfTimePhase2) {
		this.gearOfTimePhase2 = gearOfTimePhase2;
	}
	public byte getOnHourOfTimePhase3() {
		return onHourOfTimePhase3;
	}
	public void setOnHourOfTimePhase3(byte onHourOfTimePhase3) {
		this.onHourOfTimePhase3 = onHourOfTimePhase3;
	}
	public byte getOnMinuteOfTimePhase3() {
		return onMinuteOfTimePhase3;
	}
	public void setOnMinuteOfTimePhase3(byte onMinuteOfTimePhase3) {
		this.onMinuteOfTimePhase3 = onMinuteOfTimePhase3;
	}
	public byte getOffHourOfTimePhase3() {
		return offHourOfTimePhase3;
	}
	public void setOffHourOfTimePhase3(byte offHourOfTimePhase3) {
		this.offHourOfTimePhase3 = offHourOfTimePhase3;
	}
	public byte getOffMinuteOfTimePhase3() {
		return offMinuteOfTimePhase3;
	}
	public void setOffMinuteOfTimePhase3(byte offMinuteOfTimePhase3) {
		this.offMinuteOfTimePhase3 = offMinuteOfTimePhase3;
	}
	public byte getSwitchOfTimePhase3() {
		return switchOfTimePhase3;
	}
	public void setSwitchOfTimePhase3(byte switchOfTimePhase3) {
		this.switchOfTimePhase3 = switchOfTimePhase3;
	}
	public byte getGearOfTimePhase3() {
		return gearOfTimePhase3;
	}
	public void setGearOfTimePhase3(byte gearOfTimePhase3) {
		this.gearOfTimePhase3 = gearOfTimePhase3;
	}
	public byte getOnHourOfTimePhase4() {
		return onHourOfTimePhase4;
	}
	public void setOnHourOfTimePhase4(byte onHourOfTimePhase4) {
		this.onHourOfTimePhase4 = onHourOfTimePhase4;
	}
	public byte getOnMinuteOfTimePhase4() {
		return onMinuteOfTimePhase4;
	}
	public void setOnMinuteOfTimePhase4(byte onMinuteOfTimePhase4) {
		this.onMinuteOfTimePhase4 = onMinuteOfTimePhase4;
	}
	public byte getOffHourOfTimePhase4() {
		return offHourOfTimePhase4;
	}
	public void setOffHourOfTimePhase4(byte offHourOfTimePhase4) {
		this.offHourOfTimePhase4 = offHourOfTimePhase4;
	}
	public byte getOffMinuteOfTimePhase4() {
		return offMinuteOfTimePhase4;
	}
	public void setOffMinuteOfTimePhase4(byte offMinuteOfTimePhase4) {
		this.offMinuteOfTimePhase4 = offMinuteOfTimePhase4;
	}
	public byte getSwitchOfTimePhase4() {
		return switchOfTimePhase4;
	}
	public void setSwitchOfTimePhase4(byte switchOfTimePhase4) {
		this.switchOfTimePhase4 = switchOfTimePhase4;
	}
	public byte getGearOfTimePhase4() {
		return gearOfTimePhase4;
	}
	public void setGearOfTimePhase4(byte gearOfTimePhase4) {
		this.gearOfTimePhase4 = gearOfTimePhase4;
	}
	public byte getOnHourOfTimePhase5() {
		return onHourOfTimePhase5;
	}
	public void setOnHourOfTimePhase5(byte onHourOfTimePhase5) {
		this.onHourOfTimePhase5 = onHourOfTimePhase5;
	}
	public byte getOnMinuteOfTimePhase5() {
		return onMinuteOfTimePhase5;
	}
	public void setOnMinuteOfTimePhase5(byte onMinuteOfTimePhase5) {
		this.onMinuteOfTimePhase5 = onMinuteOfTimePhase5;
	}
	public byte getOffHourOfTimePhase5() {
		return offHourOfTimePhase5;
	}
	public void setOffHourOfTimePhase5(byte offHourOfTimePhase5) {
		this.offHourOfTimePhase5 = offHourOfTimePhase5;
	}
	public byte getOffMinuteOfTimePhase5() {
		return offMinuteOfTimePhase5;
	}
	public void setOffMinuteOfTimePhase5(byte offMinuteOfTimePhase5) {
		this.offMinuteOfTimePhase5 = offMinuteOfTimePhase5;
	}
	public byte getSwitchOfTimePhase5() {
		return switchOfTimePhase5;
	}
	public void setSwitchOfTimePhase5(byte switchOfTimePhase5) {
		this.switchOfTimePhase5 = switchOfTimePhase5;
	}
	public byte getGearOfTimePhase5() {
		return gearOfTimePhase5;
	}
	public void setGearOfTimePhase5(byte gearOfTimePhase5) {
		this.gearOfTimePhase5 = gearOfTimePhase5;
	}
	public byte getGearCount() {
		return gearCount;
	}
	public void setGearCount(byte gearCount) {
		this.gearCount = gearCount;
	}
	public byte getCommonSwitch() {
		return commonSwitch;
	}
	public void setCommonSwitch(byte commonSwitch) {
		this.commonSwitch = commonSwitch;
	}
	public byte getShowChoice() {
		return showChoice;
	}
	public void setShowChoice(byte showChoice) {
		this.showChoice = showChoice;
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
	public short getElectricity() {
		return electricity;
	}
	public Header getHeader() {
		return header;
	}

	public void setHeader(Header header) {
		this.header = header;
	}

	public short getCustomeWorkTime1OfTimePhase1() {
		return customeWorkTime1OfTimePhase1;
	}

	public void setCustomeWorkTime1OfTimePhase1(short customeWorkTime1OfTimePhase1) {
		this.customeWorkTime1OfTimePhase1 = customeWorkTime1OfTimePhase1;
	}

	public short getCustomeWorkTime2OfTimePhase1() {
		return customeWorkTime2OfTimePhase1;
	}

	public void setCustomeWorkTime2OfTimePhase1(short customeWorkTime2OfTimePhase1) {
		this.customeWorkTime2OfTimePhase1 = customeWorkTime2OfTimePhase1;
	}

	public short getCustomeWorkTime1OfTimePhase2() {
		return customeWorkTime1OfTimePhase2;
	}

	public void setCustomeWorkTime1OfTimePhase2(short customeWorkTime1OfTimePhase2) {
		this.customeWorkTime1OfTimePhase2 = customeWorkTime1OfTimePhase2;
	}

	public short getCustomeWorkTime2OfTimePhase2() {
		return customeWorkTime2OfTimePhase2;
	}

	public void setCustomeWorkTime2OfTimePhase2(short customeWorkTime2OfTimePhase2) {
		this.customeWorkTime2OfTimePhase2 = customeWorkTime2OfTimePhase2;
	}

	public short getCustomeWorkTime1OfTimePhase3() {
		return customeWorkTime1OfTimePhase3;
	}

	public void setCustomeWorkTime1OfTimePhase3(short customeWorkTime1OfTimePhase3) {
		this.customeWorkTime1OfTimePhase3 = customeWorkTime1OfTimePhase3;
	}

	public short getCustomeWorkTime2OfTimePhase3() {
		return customeWorkTime2OfTimePhase3;
	}

	public void setCustomeWorkTime2OfTimePhase3(short customeWorkTime2OfTimePhase3) {
		this.customeWorkTime2OfTimePhase3 = customeWorkTime2OfTimePhase3;
	}

	public short getCustomeWorkTime1OfTimePhase4() {
		return customeWorkTime1OfTimePhase4;
	}

	public void setCustomeWorkTime1OfTimePhase4(short customeWorkTime1OfTimePhase4) {
		this.customeWorkTime1OfTimePhase4 = customeWorkTime1OfTimePhase4;
	}

	public short getCustomeWorkTime2OfTimePhase4() {
		return customeWorkTime2OfTimePhase4;
	}

	public void setCustomeWorkTime2OfTimePhase4(short customeWorkTime2OfTimePhase4) {
		this.customeWorkTime2OfTimePhase4 = customeWorkTime2OfTimePhase4;
	}

	public short getCustomeWorkTime1OfTimePhase5() {
		return customeWorkTime1OfTimePhase5;
	}

	public void setCustomeWorkTime1OfTimePhase5(short customeWorkTime1OfTimePhase5) {
		this.customeWorkTime1OfTimePhase5 = customeWorkTime1OfTimePhase5;
	}

	public short getCustomeWorkTime2OfTimePhase5() {
		return customeWorkTime2OfTimePhase5;
	}

	public void setCustomeWorkTime2OfTimePhase5(short customeWorkTime2OfTimePhase5) {
		this.customeWorkTime2OfTimePhase5 = customeWorkTime2OfTimePhase5;
	}

	public short getStartMinTime() {
		return startMinTime;
	}

	public void setStartMinTime(short startMinTime) {
		this.startMinTime = startMinTime;
	}

	public short getStartMaxTime() {
		return startMaxTime;
	}

	public void setStartMaxTime(short startMaxTime) {
		this.startMaxTime = startMaxTime;
	}

	public short getStopMinTime() {
		return stopMinTime;
	}

	public void setStopMinTime(short stopMinTime) {
		this.stopMinTime = stopMinTime;
	}

	public short getStopMaxTime() {
		return stopMaxTime;
	}

	public void setStopMaxTime(short stopMaxTime) {
		this.stopMaxTime = stopMaxTime;
	}

	public void setElectricity(byte electricity) {
		this.electricity = electricity;
	}


	@Override
	public String toString() {
		return "Control [header=" + header + ", timeSwitch=" + timeSwitch
				+ ", onHourOfTimePhase1=" + onHourOfTimePhase1
				+ ", onMinuteOfTimePhase1=" + onMinuteOfTimePhase1
				+ ", offHourOfTimePhase1=" + offHourOfTimePhase1
				+ ", offMinuteOfTimePhase1=" + offMinuteOfTimePhase1
				+ ", switchOfTimePhase1=" + switchOfTimePhase1
				+ ", gearOfTimePhase1=" + gearOfTimePhase1
				+ ", customeWorkTime1OfTimePhase1="
				+ customeWorkTime1OfTimePhase1
				+ ", customeWorkTime2OfTimePhase1="
				+ customeWorkTime2OfTimePhase1 + ", onHourOfTimePhase2="
				+ onHourOfTimePhase2 + ", onMinuteOfTimePhase2="
				+ onMinuteOfTimePhase2 + ", offHourOfTimePhase2="
				+ offHourOfTimePhase2 + ", offMinuteOfTimePhase2="
				+ offMinuteOfTimePhase2 + ", switchOfTimePhase2="
				+ switchOfTimePhase2 + ", gearOfTimePhase2=" + gearOfTimePhase2
				+ ", customeWorkTime1OfTimePhase2="
				+ customeWorkTime1OfTimePhase2
				+ ", customeWorkTime2OfTimePhase2="
				+ customeWorkTime2OfTimePhase2 + ", onHourOfTimePhase3="
				+ onHourOfTimePhase3 + ", onMinuteOfTimePhase3="
				+ onMinuteOfTimePhase3 + ", offHourOfTimePhase3="
				+ offHourOfTimePhase3 + ", offMinuteOfTimePhase3="
				+ offMinuteOfTimePhase3 + ", switchOfTimePhase3="
				+ switchOfTimePhase3 + ", gearOfTimePhase3=" + gearOfTimePhase3
				+ ", customeWorkTime1OfTimePhase3="
				+ customeWorkTime1OfTimePhase3
				+ ", customeWorkTime2OfTimePhase3="
				+ customeWorkTime2OfTimePhase3 + ", onHourOfTimePhase4="
				+ onHourOfTimePhase4 + ", onMinuteOfTimePhase4="
				+ onMinuteOfTimePhase4 + ", offHourOfTimePhase4="
				+ offHourOfTimePhase4 + ", offMinuteOfTimePhase4="
				+ offMinuteOfTimePhase4 + ", switchOfTimePhase4="
				+ switchOfTimePhase4 + ", gearOfTimePhase4=" + gearOfTimePhase4
				+ ", customeWorkTime1OfTimePhase4="
				+ customeWorkTime1OfTimePhase4
				+ ", customeWorkTime2OfTimePhase4="
				+ customeWorkTime2OfTimePhase4 + ", onHourOfTimePhase5="
				+ onHourOfTimePhase5 + ", onMinuteOfTimePhase5="
				+ onMinuteOfTimePhase5 + ", offHourOfTimePhase5="
				+ offHourOfTimePhase5 + ", offMinuteOfTimePhase5="
				+ offMinuteOfTimePhase5 + ", switchOfTimePhase5="
				+ switchOfTimePhase5 + ", gearOfTimePhase5=" + gearOfTimePhase5
				+ ", customeWorkTime1OfTimePhase5="
				+ customeWorkTime1OfTimePhase5
				+ ", customeWorkTime2OfTimePhase5="
				+ customeWorkTime2OfTimePhase5 + ", commonSwitch="
				+ commonSwitch + ", gearCount=" + gearCount + ", showChoice="
				+ showChoice + ", oilRemind=" + oilRemind + ", oilTotal="
				+ oilTotal + ", electricity=" + electricity + ", startMinTime="
				+ startMinTime + ", startMaxTime=" + startMaxTime
				+ ", stopMinTime=" + stopMinTime + ", stopMaxTime="
				+ stopMaxTime + "]";
	}
	
	
}
