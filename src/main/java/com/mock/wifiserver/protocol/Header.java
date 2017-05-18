package com.mock.wifiserver.protocol;

import java.nio.charset.Charset;

import io.netty.buffer.ByteBuf;

public class Header {
	
	private String mac;
	private CMD cmd;
	private byte control;
	
	public static Header decode(ByteBuf data) {
		Header header = new Header();
		byte control = data.getByte(Protocol.CONTROL_OFFSET);
		header.setCmd(CMD.decode(control));
		String mac = data.toString(Protocol.MAC_OFFSET, Protocol.MAC_LENGTH, Charset.forName("UTF-8"));
		header.setMac(mac);
		header.setControl(control);
		return header;
	}

	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	public CMD getCmd() {
		return cmd;
	}

	public void setCmd(CMD cmd) {
		this.cmd = cmd;
	}

	public byte getControl() {
		return control;
	}

	public void setControl(byte control) {
		this.control = control;
	}

	@Override
	public String toString() {
		return "Header [mac=" + mac + ", cmd=" + cmd + ", control=" + control
				+ "]";
	}
	
}
