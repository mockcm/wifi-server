package com.mock.wifiserver.protocol;

import io.netty.buffer.ByteBuf;

import java.nio.charset.Charset;

import com.alibaba.fastjson.JSON;

public class ProductInfo {
	
	private Header header;
	private String name;
	private String addr;
	
	public static ProductInfo decode(ByteBuf data) {
		
		String info = data.toString(ProductInfoProtocol.PRODUCT_INFO_OFFSET, data.readableBytes() - ProductInfoProtocol.PRODUCT_INFO_OFFSET, Charset.forName("UTF-8"));
		if (null == info || "".equals(info)) return null;
		ProductInfo productInfo = JSON.parseObject(info, ProductInfo.class);
		
		productInfo.setHeader(Header.decode(data));
		return productInfo;
	}
	

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}


	public Header getHeader() {
		return header;
	}


	public void setHeader(Header header) {
		this.header = header;
	}


	@Override
	public String toString() {
		return "ProductInfo [header=" + header + ", name=" + name + ", addr="
				+ addr + "]";
	}
}
