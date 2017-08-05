package com.mock.wifiserver.util;

import io.netty.buffer.ByteBuf;

/**
 * 数据读取
 * @author mock
 *
 */
public class NumberUtil {
	
	/**
	 * 获取某个byte上的第index位bit,注意index从0开始
	 * @param data
	 * @param index
	 * @return
	 */
	public static byte indexOfBit(byte data,int index) {
		return (byte) (data >> index & 1);
	}
	
	public static byte setBit(byte src,int index,int value) {
		return (byte) (src | (value >> index));
	}
	

	
	public static Integer readInt(ByteBuf data,int index,int length) {
		
		Integer result = 0;
		int offset = length;
		for (int i = index;i< (index + length);i++) {
			result += (data.getByte(i) & 0xff) << (8*(--offset));
			System.out.println(result);
		}
		return result;
	}
	
	/**
	 * 读取short值(大端模式)
	 * @param data 数据源
	 * @param index	开始读取的字节位置
	 * @param length 读取的字节长度
	 * @return
	 */
	public static short readAsShort(ByteBuf data,int index,int length) {
		
		if (length > 2 || length <= 0) throw new RuntimeException("illegal length to read a short value!");
		if (length != 2) return (short)readWithRandomLength(data, index, length).intValue();
		short result = 0;
		int offset = length;
		for (int i = index;i< (index + length);i++) {
			result += (data.getByte(i) & 0xff) << (8*(--offset));
		}
		return result;
	}	
	
	
	/**
	 * 读取Long值(大端模式)
	 * @param data 数据源
	 * @param index	开始读取的字节位置
	 * @param length 读取的字节长度
	 * @return
	 */
	public static Long readAsLong(ByteBuf data,int index,int length) {
		
		if (length > 8 || length <= 0) throw new RuntimeException("illegal length to read a double value!");
		if (length != 8) return readWithRandomLength(data, index, length);
		Long result = 0L;
		int offset = length;
		for (int i = index;i< (index + length);i++) {
			result += (data.getByte(i) & 0xff) << (8*(--offset));
		}
		return result;
	}	
	
	/**
	 * 读取Long值(大端模式)
	 * @param data 数据源
	 * @param index	开始读取的字节位置
	 * @param length 读取的字节长度
	 * @return
	 */
	public static Long readWithRandomLength(ByteBuf data,int index,int length) {
		
		if (length > 8 || length <= 0) throw new RuntimeException("illegal length to read a double value!");
		Long result = 0L;
		int offset = length;
		boolean navigative = false;
		for (int i = index;i< (index + length);i++) {
			int moveBit = 8 *(--offset);
			byte val = data.getByte(i);
			if (val < 0 && i == index) navigative = true;
			//如果整体是负数，则取反
			if (navigative) {
				val = (byte) ~val;
				//取反后有可能此byte还是负数，则转为无符号
				if (val < 0) {
					result += (val & 0xff) << moveBit;
					continue;
				}
			} else if (val < 0) {
				result += (val & 0xff) << moveBit;
				continue;
			}
			result += val << moveBit;
		}
		
		//记得取反后要加上1
		return navigative ? -(result + 1) : result;
	}
	
	
	/**
	 * 读取Long值(小端模式)
	 * @param data 数据源
	 * @param index	开始读取的字节位置
	 * @param length 读取的字节长度
	 * @return
	 */
	public static Long readAsLongWithLittleEndian(ByteBuf data,int index,int length) {
		
		if (length > 8 || length <= 0) throw new RuntimeException("illegal length to read a double value!");
		Long result = 0L;
		int offset = 0;
		for (int i = index;i<(index + length);i++) {
			result += (long)(data.getByte(i) << 8 * offset);
			++offset;
		}
		return result;
	}
	
	
	
	/**
	 * 读取Double值(大端模式)
	 * @param data 数据源
	 * @param index	开始读取的字节位置
	 * @param length 读取的字节长度
	 * @return
	 */
	public static double readAsDouble(ByteBuf data,int index,int length) {
		
		if (length > 8) throw new RuntimeException("illegal length to read a double value!");
		double result = 0;
		for (int i = index;i<length;i++) {
			result += (double)(data.getByte(i) << 8 *(length - (i + 1)));
		}
		return result;
	}
	
	
	/**
	 * 读取Double值(小端模式)
	 * @param data 数据源
	 * @param index	开始读取的字节位置
	 * @param length 读取的字节长度
	 * @return
	 */
	public static double readAsDoubleWithLittleEndian(ByteBuf data,int index,int length) {
		
		if (length > 8) throw new RuntimeException("illegal length to read a double value!");
		double result = 0;
		int offset = 0;
		for (int i = index;i<length;i++) {
			result += (double)(data.getByte(i) << 8 * offset);
			++offset;
		}
		return result;
	}
}
