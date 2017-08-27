package com.mock.wifiserver.domain;

import java.io.Serializable;

/**
 * @author fenggang.xu
 * @version 1.0 创建时间：2017年8月26日 下午3:25:40
 * @company 广州慧码信息科技有限公司
 * @web http://www.ehuima.com
 *
 * 程序的简单说明
 * @version V1.0
 */
public class MachineOperator implements Serializable {

    /**
     * @www.ehuima.com 2017-08-14 16:57
     */
    private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 * 对应数据表字段： 机器地址
     * @www.gonecn.com 2017-08-14 16:57
	 */
	private String machineMac;

	/**
	 * 
	 * 对应数据表字段： 精油总量
     * @www.gonecn.com 2017-08-14 16:57
	 */
	private Integer attarCount;
	
	/**
	 * 
	 * 对应数据表字段： 精油用量
     * @www.gonecn.com 2017-08-14 16:57
	 */
	private Integer attarUse;
	
	/**
	 * 
	 * 对应数据表字段： 电量
     * @www.gonecn.com 2017-08-14 16:57
	 */
	private Integer electricCount;

	
	/**
	 * 
	 * 对应数据表字段： 气泵压力
     * @www.gonecn.com 2017-08-14 16:57
	 */
	private Integer pump;
	
	/**
	 * 
	 * 对应数据表字段：气泵工作时间
     * @www.gonecn.com 2017-08-14 16:57
	 */
	private Integer pumpTime;
	
	/**
	 * 
	 * 对应数据表字段： 环境气压
     * @www.gonecn.com 2017-08-14 16:57
	 */
	private Integer pressure;
	
	/**
	 * 
	 * 对应数据表字段：使用时间
     * @www.gonecn.com 2017-08-14 16:57
	 */
	private Integer useTime;

	public String getMachineMac() {
		return machineMac;
	}

	public void setMachineMac(String machineMac) {
		this.machineMac = machineMac;
	}

	public Integer getAttarCount() {
		return attarCount;
	}

	public void setAttarCount(Integer attarCount) {
		this.attarCount = attarCount;
	}

	public Integer getAttarUse() {
		return attarUse;
	}

	public void setAttarUse(Integer attarUse) {
		this.attarUse = attarUse;
	}

	public Integer getElectricCount() {
		return electricCount;
	}

	public void setElectricCount(Integer electricCount) {
		this.electricCount = electricCount;
	}

	public Integer getPump() {
		return pump;
	}

	public void setPump(Integer pump) {
		this.pump = pump;
	}

	public Integer getPumpTime() {
		return pumpTime;
	}

	public void setPumpTime(Integer pumpTime) {
		this.pumpTime = pumpTime;
	}

	public Integer getPressure() {
		return pressure;
	}

	public void setPressure(Integer pressure) {
		this.pressure = pressure;
	}

	public Integer getUseTime() {
		return useTime;
	}

	public void setUseTime(Integer useTime) {
		this.useTime = useTime;
	}
}
