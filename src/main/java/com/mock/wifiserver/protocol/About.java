package com.mock.wifiserver.protocol;

import io.netty.buffer.ByteBuf;

import java.nio.charset.Charset;

import com.alibaba.fastjson.JSON;

public class About {
	
	private Header header;
	
	private String pcbVer;
	private String serial;
	private String EquipmentVer;
	
	public static About decode(ByteBuf data) {
		
		String info = data.toString(AboutProtocol.DEVICE_ABOUT_OFFSET,
				data.readableBytes() - AboutProtocol.DEVICE_ABOUT_OFFSET, Charset.forName("UTF-8"));
		if (null == info || "".equals(info)) return null;
		About about = JSON.parseObject(info, About.class);
		about.setHeader(Header.decode(data));
		return about;
	}

	public String getPcbVer() {
		return pcbVer;
	}

	public void setPcbVer(String pcbVer) {
		this.pcbVer = pcbVer;
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public String getEquipmentVer() {
		return EquipmentVer;
	}

	public Header getHeader() {
		return header;
	}

	public void setHeader(Header header) {
		this.header = header;
	}

	public void setEquipmentVer(String equipmentVer) {
		EquipmentVer = equipmentVer;
	}

	@Override
	public String toString() {
		return "About [header=" + header + ", pcbVer=" + pcbVer + ", serial="
				+ serial + ", EquipmentVer=" + EquipmentVer + "]";
	}
}
