package com.mock.wifiserver.protocol;

import io.netty.buffer.ByteBuf;

import com.mock.wifiserver.util.NumberUtil;

public class GearSetting {
	
	private Header header;
	
	private short minOpen;
	private short maxOpen;
	private short minClose;
	private short maxClose;
	
	private short openSecondOfGreaOne;
	private short closeSecondOfGreaOne;
	
	private short openSecondOfGreaTwo;
	private short closeSecondOfGreaTwo;
	
	private short openSecondOfGreaOThree;
	private short closeSecondOfGreaThree;
	
	private short openSecondOfGreaFour;
	private short closeSecondOfGreaFour;
	
	
	/**
	 * note:需要按照协议进行解码
	 * @param buf
	 * @return
	 */
	public static GearSetting decode(ByteBuf data) {
		
		GearSetting gearSetting = new GearSetting();
		Header header = Header.decode(data);
		gearSetting.setHeader(header);
		//Read
		if (header.getCmd().getOps() == 0) {
			//第1档开关秒数
			gearSetting.setOpenSecondOfGreaOne(NumberUtil.readAsShort(data, 3, 2));
			gearSetting.setCloseSecondOfGreaOne(NumberUtil.readAsShort(data, 5, 2));
			
			//第2档开关秒数
			gearSetting.setOpenSecondOfGreaTwo(NumberUtil.readAsShort(data, 7, 2));
			gearSetting.setCloseSecondOfGreaTwo(NumberUtil.readAsShort(data, 9, 2));
			
			//第3档开关秒数
			gearSetting.setOpenSecondOfGreaOThree(NumberUtil.readAsShort(data, 11, 2));
			gearSetting.setCloseSecondOfGreaThree(NumberUtil.readAsShort(data, 13, 2));
			
			//第4档开关秒数
			gearSetting.setOpenSecondOfGreaFour(NumberUtil.readAsShort(data, 15, 2));
			gearSetting.setCloseSecondOfGreaFour(NumberUtil.readAsShort(data, 17, 2));
		}
		return gearSetting;
	}


	public short getMinOpen() {
		return minOpen;
	}


	public void setMinOpen(short minOpen) {
		this.minOpen = minOpen;
	}


	public short getMaxOpen() {
		return maxOpen;
	}


	public void setMaxOpen(short maxOpen) {
		this.maxOpen = maxOpen;
	}


	public short getMinClose() {
		return minClose;
	}


	public void setMinClose(short minClose) {
		this.minClose = minClose;
	}


	public short getMaxClose() {
		return maxClose;
	}


	public void setMaxClose(short maxClose) {
		this.maxClose = maxClose;
	}


	public short getOpenSecondOfGreaOne() {
		return openSecondOfGreaOne;
	}


	public void setOpenSecondOfGreaOne(short openSecondOfGreaOne) {
		this.openSecondOfGreaOne = openSecondOfGreaOne;
	}


	public short getCloseSecondOfGreaOne() {
		return closeSecondOfGreaOne;
	}


	public void setCloseSecondOfGreaOne(short closeSecondOfGreaOne) {
		this.closeSecondOfGreaOne = closeSecondOfGreaOne;
	}


	public short getOpenSecondOfGreaTwo() {
		return openSecondOfGreaTwo;
	}


	public void setOpenSecondOfGreaTwo(short openSecondOfGreaTwo) {
		this.openSecondOfGreaTwo = openSecondOfGreaTwo;
	}


	public short getCloseSecondOfGreaTwo() {
		return closeSecondOfGreaTwo;
	}


	public void setCloseSecondOfGreaTwo(short closeSecondOfGreaTwo) {
		this.closeSecondOfGreaTwo = closeSecondOfGreaTwo;
	}


	public short getOpenSecondOfGreaOThree() {
		return openSecondOfGreaOThree;
	}


	public void setOpenSecondOfGreaOThree(short openSecondOfGreaOThree) {
		this.openSecondOfGreaOThree = openSecondOfGreaOThree;
	}


	public short getCloseSecondOfGreaThree() {
		return closeSecondOfGreaThree;
	}


	public void setCloseSecondOfGreaThree(short closeSecondOfGreaThree) {
		this.closeSecondOfGreaThree = closeSecondOfGreaThree;
	}


	public short getOpenSecondOfGreaFour() {
		return openSecondOfGreaFour;
	}


	public void setOpenSecondOfGreaFour(short openSecondOfGreaFour) {
		this.openSecondOfGreaFour = openSecondOfGreaFour;
	}


	public short getCloseSecondOfGreaFour() {
		return closeSecondOfGreaFour;
	}


	public void setCloseSecondOfGreaFour(short closeSecondOfGreaFour) {
		this.closeSecondOfGreaFour = closeSecondOfGreaFour;
	}


	public Header getHeader() {
		return header;
	}


	public void setHeader(Header header) {
		this.header = header;
	}


	@Override
	public String toString() {
		return "GearSetting [header=" + header + ", minOpen=" + minOpen
				+ ", maxOpen=" + maxOpen + ", minClose=" + minClose
				+ ", maxClose=" + maxClose + ", openSecondOfGreaOne="
				+ openSecondOfGreaOne + ", closeSecondOfGreaOne="
				+ closeSecondOfGreaOne + ", openSecondOfGreaTwo="
				+ openSecondOfGreaTwo + ", closeSecondOfGreaTwo="
				+ closeSecondOfGreaTwo + ", openSecondOfGreaOThree="
				+ openSecondOfGreaOThree + ", closeSecondOfGreaThree="
				+ closeSecondOfGreaThree + ", openSecondOfGreaFour="
				+ openSecondOfGreaFour + ", closeSecondOfGreaFour="
				+ closeSecondOfGreaFour + "]";
	}
}
