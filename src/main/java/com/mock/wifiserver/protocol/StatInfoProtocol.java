package com.mock.wifiserver.protocol;

public class StatInfoProtocol {
	
	public static final int OIL_REMIND_OFFSET = 18;
	public static final int OIL_REMIND_LENGTH = 2;
	
	public static final int OIL_TOTAL_OFFSET = 20;
	public static final int OIL_TOTAL_LENGTH = 2;
	
	public static final int ELECTRICITY_OFFSET = 22;
	public static final int ELECTRICITY_LENGTH = 1;
	
	public static final int PUMP_PRESSURE_OFFSET = 23;
	public static final int PUMP_PRESSURE_LENGTH = 2;
	
	public static final int ENV_PRESSURE_OFFSET = 25;
	public static final int ENV_PRESSURE_LENGTH = 2;
	
	
	public static final int MACHINE_WORK_TIME_OFFSET = 27;
	public static final int MACHINE_WORK_TIME_LENGTH = 4;
	
	public static final int PUMP_WORK_TIME_OFFSET = 31;
	public static final int PUMP_WORK_TIME_LENGTH = 4;
	
	public static final int CHANGED_FLAG_OFFSET = 35;
	public static final int CHANGED_FLAG_LENGTH = 1;
}
