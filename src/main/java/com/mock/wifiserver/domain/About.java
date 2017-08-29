package com.mock.wifiserver.domain;

import java.io.Serializable;

/**
 * 对应tbl_about表的实体对象类
 * 
 * @author fenggang.xu
 * @www.ehuima.com 日期：2017-08-16 15:34
 * @company 广州慧码信息科技有限公司
 * @version 1.0.0
 */
public class About implements Serializable {

    /**
     * @www.ehuima.com 2017-08-16 15:34
     */
    private static final long serialVersionUID = 1L;
    
	/**
	 * 
	 * 对应数据表字段： machine_id
     * @www.gonecn.com 2017-08-16 15:34
	 */
	private Long machineId;
	
	/**
	 * 
	 * 对应数据表字段： machine_mac
     * @www.gonecn.com 2017-08-16 15:34
	 */
	private String machineMac;
	
	/**
	 * 
	 * 对应数据表字段： pcb_ver
     * @www.gonecn.com 2017-08-16 15:34
	 */
	private String pcbVer;
	
	/**
	 * 
	 * 对应数据表字段： serial
     * @www.gonecn.com 2017-08-16 15:34
	 */
	private String serial;
	
	/**
	 * 
	 * 对应数据表字段： equipment_ver
     * @www.gonecn.com 2017-08-16 15:34
	 */
	private String equipmentVer;
	
	/**
	 * 
	 * 对应数据表字段： about
     * @www.gonecn.com 2017-08-16 15:34
	 */
	private String about;
	

    /**
     * 获取
     * 对应数据表字段： machine_id
     *
     * @return 
     */
	public Long getMachineId() {
		return machineId;
	}
	/**
     * 设置
     * 对应数据表字段： machine_id
     */
	public void setMachineId(Long machineId) {
		this.machineId = machineId;
	}
	
    /**
     * 获取
     * 对应数据表字段： machine_mac
     *
     * @return 
     */
	public String getMachineMac() {
		return machineMac;
	}
	/**
     * 设置
     * 对应数据表字段： machine_mac
     */
	public void setMachineMac(String machineMac) {
		this.machineMac = machineMac;
	}
	
    /**
     * 获取
     * 对应数据表字段： pcb_ver
     *
     * @return 
     */
	public String getPcbVer() {
		return pcbVer;
	}
	/**
     * 设置
     * 对应数据表字段： pcb_ver
     */
	public void setPcbVer(String pcbVer) {
		this.pcbVer = pcbVer;
	}
	
    /**
     * 获取
     * 对应数据表字段： serial
     *
     * @return 
     */
	public String getSerial() {
		return serial;
	}
	/**
     * 设置
     * 对应数据表字段： serial
     */
	public void setSerial(String serial) {
		this.serial = serial;
	}
	
    /**
     * 获取
     * 对应数据表字段： equipment_ver
     *
     * @return 
     */
	public String getEquipmentVer() {
		return equipmentVer;
	}
	/**
     * 设置
     * 对应数据表字段： equipment_ver
     */
	public void setEquipmentVer(String equipmentVer) {
		this.equipmentVer = equipmentVer;
	}
	
    /**
     * 获取
     * 对应数据表字段： about
     *
     * @return 
     */
	public String getAbout() {
		return about;
	}
	/**
     * 设置
     * 对应数据表字段： about
     */
	public void setAbout(String about) {
		this.about = about;
	}
	

    /**
     * 
     *
     * @www.gonecn.com 2017-08-16 15:34
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", machineId=").append(machineId);
        sb.append(", machineMac=").append(machineMac);
        sb.append(", pcbVer=").append(pcbVer);
        sb.append(", serial=").append(serial);
        sb.append(", equipmentVer=").append(equipmentVer);
        sb.append(", about=").append(about);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}