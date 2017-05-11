package com.mock.wifiserver.config;

public enum Directive {
	

	//产品信息
	PRODUCT_INFO((byte)0x01),
	
	//时间
	TIME((byte)0X02),
	
	//开关机时间
	START_SHUTDOWN_TIME((byte)0x03),
	
	//档位设置
	GEAR_SETTING((byte)0x04),
	
	//About
	DEVICE_INFO((byte)0x05),
	
	//状态数据
	STAT_INFO((byte)0x06),
	
	//连接服务器
	CONNECT_SERVER((byte)0x0D),
	
	//设备密码
	DEVICE_PASSWORD((byte)0x8F),
	
	//修改密码
	MODIFY_PASSWORD((byte)0x0F),
	
	DEFAULT((byte)-1);
	
	
	private byte _value;
	
	private Directive(byte value) {
		_value = value;
	}
	public byte value() {
		return _value;
	}
	
	public static Directive getDirective(Byte val) {
		for (Directive directive : values()) {
			if (directive._value == val) return directive;
		}
		return DEFAULT;
	}
}
