package com.mock.wifiserver.protocol;

import com.mock.wifiserver.util.NumberUtil;

public class CMD {
	
	public static CMD decode(byte cmd) {
		
		CMD head = new CMD();
		head.setBit0(NumberUtil.indexOfBit(cmd, 0));
		head.setBit1(NumberUtil.indexOfBit(cmd, 1));
		head.setBit2(NumberUtil.indexOfBit(cmd, 2));
		head.setBit3(NumberUtil.indexOfBit(cmd, 3));
		head.setBit4(NumberUtil.indexOfBit(cmd, 4));
		head.setBit5(NumberUtil.indexOfBit(cmd, 5));
		
		head.setToDo(NumberUtil.indexOfBit(cmd, 6));
		head.setOps(NumberUtil.indexOfBit(cmd, 7));
		
		return head;
	}
	//cmd
	private byte bit0;
	private byte bit1;
	private byte bit2;
	private byte bit3;
	private byte bit4;
	private byte bit5;
	
	//1，设备更新，0，手机读取
	private byte toDo;
	//1，读  0，写
	private byte ops;
	
	
	public byte getBit0() {
		return bit0;
	}
	public void setBit0(byte bit0) {
		this.bit0 = bit0;
	}
	public byte getBit1() {
		return bit1;
	}
	public void setBit1(byte bit1) {
		this.bit1 = bit1;
	}
	public byte getBit2() {
		return bit2;
	}
	public void setBit2(byte bit2) {
		this.bit2 = bit2;
	}
	public byte getBit3() {
		return bit3;
	}
	public void setBit3(byte bit3) {
		this.bit3 = bit3;
	}
	public byte getBit4() {
		return bit4;
	}
	public void setBit4(byte bit4) {
		this.bit4 = bit4;
	}
	public byte getBit5() {
		return bit5;
	}
	public void setBit5(byte bit5) {
		this.bit5 = bit5;
	}
	public byte getToDo() {
		return toDo;
	}
	public void setToDo(byte toDo) {
		this.toDo = toDo;
	}
	public byte getOps() {
		return ops;
	}
	public void setOps(byte ops) {
		this.ops = ops;
	}
	@Override
	public String toString() {
		return "CMD [bit0=" + bit0 + ", bit1=" + bit1 + ", bit2=" + bit2
				+ ", bit3=" + bit3 + ", bit4=" + bit4 + ", bit5=" + bit5
				+ ", toDo=" + toDo + ", ops=" + ops + "]";
	}
}
