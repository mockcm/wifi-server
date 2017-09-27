package com.mock.wifiserver;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;

public class WifiServerConstants {
	
	public static final int MAX_DATA_LENGTH = 2048*100;
	
	public static final String COMMON_SUCCESS_RESP_CODE = "SUCCESS";
	
	public static final String COMMON_FAIL_RESP_CODE = "FAIL";
	
	//设置消息的长度，
	//private static final int BODY_LENGHT = 
	
	
	public static final int CMD_ATTAR_STATUA = 1;
	
	public static final int CMD_ELECTRIC_STATUA = 2;
	
	public static final int CMD_MACHINE_OPEN = 3;
	
	public static final int CMD_MECHINE_FAN = 4;
	
	public static final int CMD_WORKING_STATUS = 5;
	
	
	
	//心跳
	public static final int CMD_HEART_BEAT = 0x01;
	
	public static void main(String[] args) {
		
	Map<String,Object> aa = new HashMap<> ();
	aa.put("code", 300);
	aa.put("machineId", "573770805905126");
	aa.put("machineMac", "5c.cf.7f.d0.15.49");
	
	Map<String,Object> bb = new HashMap<String,Object> ();
	bb.put("address", "255356");
	bb.put("machineName", "测试香薰1");
	aa.put("paramValue",bb);
	
	System.out.println(JSON.toJSONString(aa));
	

	}
}
