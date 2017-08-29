package com.mock.wifiserver.domain;

import java.io.Serializable;

/**
 * 对应tbl_machine表的实体对象类
 * 
 * @author fenggang.xu
 * @www.ehuima.com 日期：2017-08-14 16:57
 * @company 广州慧码信息科技有限公司
 * @version 1.0.0
 */
public class MachineName implements Serializable {

    /**
     * @www.ehuima.com 2017-08-14 16:57
     */
    private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 * 对应数据表字段： machine_mac
     * @www.gonecn.com 2017-08-14 16:57
	 */
	private String machineMac;
	/**
	 * 
	 * 对应数据表字段： machine_name
     * @www.gonecn.com 2017-08-14 16:57
	 */
	private String machineName;
	/**
	 * 
	 * 对应数据表字段： address
     * @www.gonecn.com 2017-08-14 16:57
	 */
	private String address;
	
	public String getMachineMac() {
		return machineMac;
	}
	public void setMachineMac(String machineMac) {
		this.machineMac = machineMac;
	}
	public String getMachineName() {
		return machineName;
	}
	public void setMachineName(String machineName) {
		this.machineName = machineName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "MachineName [machineMac=" + machineMac + ", machineName=" + machineName + ", address=" + address + "]";
	}

}