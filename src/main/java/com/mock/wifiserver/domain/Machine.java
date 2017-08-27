package com.mock.wifiserver.domain;

import java.io.Serializable;
import java.util.List;

/**
 * 对应tbl_machine表的实体对象类
 * 
 * @author fenggang.xu
 * @www.ehuima.com 日期：2017-08-14 16:57
 * @company 广州慧码信息科技有限公司
 * @version 1.0.0
 */
public class Machine implements Serializable {

    /**
     * @www.ehuima.com 2017-08-14 16:57
     */
    private static final long serialVersionUID = 1L;
    
    private List<MachineTime> machineTimeList;
    
	/**
	 * 
	 * 对应数据表字段： machine_id
     * @www.gonecn.com 2017-08-14 16:57
	 */
	private Long machineId;
	
	/**
	 * 
	 * 对应数据表字段： machine_no
     * @www.gonecn.com 2017-08-14 16:57
	 */
	private String machineNo;
	
	/**
	 * 
	 * 对应数据表字段： machine_mac
     * @www.gonecn.com 2017-08-14 16:57
	 */
	private String machineMac;
	
	/**
	 * 
	 * 对应数据表字段： customer_id
     * @www.gonecn.com 2017-08-14 16:57
	 */
	private Long customerId;
	
	/**
	 * 
	 * 对应数据表字段： customer_name
     * @www.gonecn.com 2017-08-14 16:57
	 */
	private String customerName;
	
	/**
	 * 
	 * 对应数据表字段： user_id
     * @www.gonecn.com 2017-08-14 16:57
	 */
	private Long userId;
	
	/**
	 * 
	 * 对应数据表字段： mobile
     * @www.gonecn.com 2017-08-14 16:57
	 */
	private String mobile;
	
	/**
	 * 
	 * 对应数据表字段： machine_name
     * @www.gonecn.com 2017-08-14 16:57
	 */
	private String machineName;
	
	/**
	 * 
	 * 对应数据表字段： password
     * @www.gonecn.com 2017-08-14 16:57
	 */
	private String password;
	
	/**
	 * 
	 * 对应数据表字段： country
     * @www.gonecn.com 2017-08-14 16:57
	 */
	private String country;
	
	/**
	 * 
	 * 对应数据表字段： province
     * @www.gonecn.com 2017-08-14 16:57
	 */
	private Integer province;
	
	/**
	 * 
	 * 对应数据表字段： province_name
     * @www.gonecn.com 2017-08-14 16:57
	 */
	private String provinceName;
	
	/**
	 * 
	 * 对应数据表字段： city
     * @www.gonecn.com 2017-08-14 16:57
	 */
	private Integer city;
	
	/**
	 * 
	 * 对应数据表字段： city_name
     * @www.gonecn.com 2017-08-14 16:57
	 */
	private String cityName;
	
	/**
	 * 
	 * 对应数据表字段： area
     * @www.gonecn.com 2017-08-14 16:57
	 */
	private Integer area;
	
	/**
	 * 
	 * 对应数据表字段： area_name
     * @www.gonecn.com 2017-08-14 16:57
	 */
	private String areaName;
	
	/**
	 * 
	 * 对应数据表字段： address
     * @www.gonecn.com 2017-08-14 16:57
	 */
	private String address;
	
	/**
	 * 
	 * 对应数据表字段： attar_count
     * @www.gonecn.com 2017-08-14 16:57
	 */
	private Integer attarCount;
	
	/**
	 * 
	 * 对应数据表字段： attar_use
     * @www.gonecn.com 2017-08-14 16:57
	 */
	private Integer attarUse;
	
	/**
	 * 
	 * 对应数据表字段： attar_status
     * @www.gonecn.com 2017-08-14 16:57
	 */
	private Integer attarStatus;
	
	/**
	 * 
	 * 对应数据表字段： electric_count
     * @www.gonecn.com 2017-08-14 16:57
	 */
	private Integer electricCount;
	
	/**
	 * 
	 * 对应数据表字段： electric_status
     * @www.gonecn.com 2017-08-14 16:57
	 */
	private Integer electricStatus;
	
	/**
	 * 
	 * 对应数据表字段： pump
     * @www.gonecn.com 2017-08-14 16:57
	 */
	private Integer pump;
	
	/**
	 * 
	 * 对应数据表字段： pump_time
     * @www.gonecn.com 2017-08-14 16:57
	 */
	private Integer pumpTime;
	
	/**
	 * 
	 * 对应数据表字段： pressure
     * @www.gonecn.com 2017-08-14 16:57
	 */
	private Integer pressure;
	
	/**
	 * 
	 * 对应数据表字段： use_time
     * @www.gonecn.com 2017-08-14 16:57
	 */
	private Integer useTime;
	
	/**
	 * 
	 * 对应数据表字段： hour_fat
     * @www.gonecn.com 2017-08-14 16:57
	 */
	private Integer hourFat;
	
	/**
	 * 
	 * 对应数据表字段： machine_open
     * @www.gonecn.com 2017-08-14 16:57
	 */
	private Integer machineOpen;
	
	/**
	 * 
	 * 对应数据表字段： machine_fan
     * @www.gonecn.com 2017-08-14 16:57
	 */
	private Integer machineFan;
	
	/**
	 * 
	 * 对应数据表字段： working_status
     * @www.gonecn.com 2017-08-14 16:57
	 */
	private Integer workingStatus;
	
	/**
	 * 
	 * 对应数据表字段： remark
     * @www.gonecn.com 2017-08-14 16:57
	 */
	private String remark;
	
	/**
	 * 
	 * 对应数据表字段： status
     * @www.gonecn.com 2017-08-14 16:57
	 */
	private Integer status;
	
	/**
	 * 
	 * 对应数据表字段： grade_max
     * @www.gonecn.com 2017-08-14 16:57
	 */
	private Integer gradeMax;
	
	/**
	 * 
	 * 对应数据表字段： is_grade
     * @www.gonecn.com 2017-08-14 16:57
	 */
	private Integer isGrade;
	
	/**
	 * 
	 * 对应数据表字段： begin_min_time
     * @www.gonecn.com 2017-08-14 16:57
	 */
	private Integer beginMinTime;
	
	/**
	 * 
	 * 对应数据表字段： begin_max_time
     * @www.gonecn.com 2017-08-14 16:57
	 */
	private Integer beginMaxTime;
	
	/**
	 * 
	 * 对应数据表字段： end_min_time
     * @www.gonecn.com 2017-08-14 16:57
	 */
	private Integer endMinTime;
	
	/**
	 * 
	 * 对应数据表字段： end_max_time
     * @www.gonecn.com 2017-08-14 16:57
	 */
	private Integer endMaxTime;
	
	/**
	 * 
	 * 对应数据表字段： admin_id
     * @www.gonecn.com 2017-08-14 16:57
	 */
	private Long adminId;
	
	/**
	 * 
	 * 对应数据表字段： create_time
     * @www.gonecn.com 2017-08-14 16:57
	 */
	private Long createTime;
	
	/**
	 * 
	 * 对应数据表字段： update_time
     * @www.gonecn.com 2017-08-14 16:57
	 */
	private Long updateTime;
	

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
     * 对应数据表字段： machine_no
     *
     * @return 
     */
	public String getMachineNo() {
		return machineNo;
	}
	/**
     * 设置
     * 对应数据表字段： machine_no
     */
	public void setMachineNo(String machineNo) {
		this.machineNo = machineNo;
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
     * 对应数据表字段： customer_id
     *
     * @return 
     */
	public Long getCustomerId() {
		return customerId;
	}
	/**
     * 设置
     * 对应数据表字段： customer_id
     */
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	
    /**
     * 获取
     * 对应数据表字段： customer_name
     *
     * @return 
     */
	public String getCustomerName() {
		return customerName;
	}
	/**
     * 设置
     * 对应数据表字段： customer_name
     */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
    /**
     * 获取
     * 对应数据表字段： user_id
     *
     * @return 
     */
	public Long getUserId() {
		return userId;
	}
	/**
     * 设置
     * 对应数据表字段： user_id
     */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
    /**
     * 获取
     * 对应数据表字段： mobile
     *
     * @return 
     */
	public String getMobile() {
		return mobile;
	}
	/**
     * 设置
     * 对应数据表字段： mobile
     */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
    /**
     * 获取
     * 对应数据表字段： machine_name
     *
     * @return 
     */
	public String getMachineName() {
		return machineName;
	}
	/**
     * 设置
     * 对应数据表字段： machine_name
     */
	public void setMachineName(String machineName) {
		this.machineName = machineName;
	}
	
    /**
     * 获取
     * 对应数据表字段： password
     *
     * @return 
     */
	public String getPassword() {
		return password;
	}
	/**
     * 设置
     * 对应数据表字段： password
     */
	public void setPassword(String password) {
		this.password = password;
	}
	
    /**
     * 获取
     * 对应数据表字段： country
     *
     * @return 
     */
	public String getCountry() {
		return country;
	}
	/**
     * 设置
     * 对应数据表字段： country
     */
	public void setCountry(String country) {
		this.country = country;
	}
	
    /**
     * 获取
     * 对应数据表字段： province
     *
     * @return 
     */
	public Integer getProvince() {
		return province;
	}
	/**
     * 设置
     * 对应数据表字段： province
     */
	public void setProvince(Integer province) {
		this.province = province;
	}
	
    /**
     * 获取
     * 对应数据表字段： province_name
     *
     * @return 
     */
	public String getProvinceName() {
		return provinceName;
	}
	/**
     * 设置
     * 对应数据表字段： province_name
     */
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	
    /**
     * 获取
     * 对应数据表字段： city
     *
     * @return 
     */
	public Integer getCity() {
		return city;
	}
	/**
     * 设置
     * 对应数据表字段： city
     */
	public void setCity(Integer city) {
		this.city = city;
	}
	
    /**
     * 获取
     * 对应数据表字段： city_name
     *
     * @return 
     */
	public String getCityName() {
		return cityName;
	}
	/**
     * 设置
     * 对应数据表字段： city_name
     */
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
    /**
     * 获取
     * 对应数据表字段： area
     *
     * @return 
     */
	public Integer getArea() {
		return area;
	}
	/**
     * 设置
     * 对应数据表字段： area
     */
	public void setArea(Integer area) {
		this.area = area;
	}
	
    /**
     * 获取
     * 对应数据表字段： area_name
     *
     * @return 
     */
	public String getAreaName() {
		return areaName;
	}
	/**
     * 设置
     * 对应数据表字段： area_name
     */
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	
    /**
     * 获取
     * 对应数据表字段： address
     *
     * @return 
     */
	public String getAddress() {
		return address;
	}
	/**
     * 设置
     * 对应数据表字段： address
     */
	public void setAddress(String address) {
		this.address = address;
	}
	
    /**
     * 获取
     * 对应数据表字段： attar_count
     *
     * @return 
     */
	public Integer getAttarCount() {
		return attarCount;
	}
	/**
     * 设置
     * 对应数据表字段： attar_count
     */
	public void setAttarCount(Integer attarCount) {
		this.attarCount = attarCount;
	}
	
    /**
     * 获取
     * 对应数据表字段： attar_use
     *
     * @return 
     */
	public Integer getAttarUse() {
		return attarUse;
	}
	/**
     * 设置
     * 对应数据表字段： attar_use
     */
	public void setAttarUse(Integer attarUse) {
		this.attarUse = attarUse;
	}
	
    /**
     * 获取
     * 对应数据表字段： attar_status
     *
     * @return 
     */
	public Integer getAttarStatus() {
		return attarStatus;
	}
	/**
     * 设置
     * 对应数据表字段： attar_status
     */
	public void setAttarStatus(Integer attarStatus) {
		this.attarStatus = attarStatus;
	}
	
    /**
     * 获取
     * 对应数据表字段： electric_count
     *
     * @return 
     */
	public Integer getElectricCount() {
		return electricCount;
	}
	/**
     * 设置
     * 对应数据表字段： electric_count
     */
	public void setElectricCount(Integer electricCount) {
		this.electricCount = electricCount;
	}
	
    /**
     * 获取
     * 对应数据表字段： electric_status
     *
     * @return 
     */
	public Integer getElectricStatus() {
		return electricStatus;
	}
	/**
     * 设置
     * 对应数据表字段： electric_status
     */
	public void setElectricStatus(Integer electricStatus) {
		this.electricStatus = electricStatus;
	}
	
    /**
     * 获取
     * 对应数据表字段： pump
     *
     * @return 
     */
	public Integer getPump() {
		return pump;
	}
	/**
     * 设置
     * 对应数据表字段： pump
     */
	public void setPump(Integer pump) {
		this.pump = pump;
	}
	
    /**
     * 获取
     * 对应数据表字段： pump_time
     *
     * @return 
     */
	public Integer getPumpTime() {
		return pumpTime;
	}
	/**
     * 设置
     * 对应数据表字段： pump_time
     */
	public void setPumpTime(Integer pumpTime) {
		this.pumpTime = pumpTime;
	}
	
    /**
     * 获取
     * 对应数据表字段： pressure
     *
     * @return 
     */
	public Integer getPressure() {
		return pressure;
	}
	/**
     * 设置
     * 对应数据表字段： pressure
     */
	public void setPressure(Integer pressure) {
		this.pressure = pressure;
	}
	
    /**
     * 获取
     * 对应数据表字段： use_time
     *
     * @return 
     */
	public Integer getUseTime() {
		return useTime;
	}
	/**
     * 设置
     * 对应数据表字段： use_time
     */
	public void setUseTime(Integer useTime) {
		this.useTime = useTime;
	}
	
    /**
     * 获取
     * 对应数据表字段： hour_fat
     *
     * @return 
     */
	public Integer getHourFat() {
		return hourFat;
	}
	/**
     * 设置
     * 对应数据表字段： hour_fat
     */
	public void setHourFat(Integer hourFat) {
		this.hourFat = hourFat;
	}
	
    /**
     * 获取
     * 对应数据表字段： machine_open
     *
     * @return 
     */
	public Integer getMachineOpen() {
		return machineOpen;
	}
	/**
     * 设置
     * 对应数据表字段： machine_open
     */
	public void setMachineOpen(Integer machineOpen) {
		this.machineOpen = machineOpen;
	}
	
    /**
     * 获取
     * 对应数据表字段： machine_fan
     *
     * @return 
     */
	public Integer getMachineFan() {
		return machineFan;
	}
	/**
     * 设置
     * 对应数据表字段： machine_fan
     */
	public void setMachineFan(Integer machineFan) {
		this.machineFan = machineFan;
	}
	
    /**
     * 获取
     * 对应数据表字段： working_status
     *
     * @return 
     */
	public Integer getWorkingStatus() {
		return workingStatus;
	}
	/**
     * 设置
     * 对应数据表字段： working_status
     */
	public void setWorkingStatus(Integer workingStatus) {
		this.workingStatus = workingStatus;
	}
	
    /**
     * 获取
     * 对应数据表字段： remark
     *
     * @return 
     */
	public String getRemark() {
		return remark;
	}
	/**
     * 设置
     * 对应数据表字段： remark
     */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
    /**
     * 获取
     * 对应数据表字段： status
     *
     * @return 
     */
	public Integer getStatus() {
		return status;
	}
	/**
     * 设置
     * 对应数据表字段： status
     */
	public void setStatus(Integer status) {
		this.status = status;
	}
	
    /**
     * 获取
     * 对应数据表字段： grade_max
     *
     * @return 
     */
	public Integer getGradeMax() {
		return gradeMax;
	}
	/**
     * 设置
     * 对应数据表字段： grade_max
     */
	public void setGradeMax(Integer gradeMax) {
		this.gradeMax = gradeMax;
	}
	
    /**
     * 获取
     * 对应数据表字段： is_grade
     *
     * @return 
     */
	public Integer getIsGrade() {
		return isGrade;
	}
	/**
     * 设置
     * 对应数据表字段： is_grade
     */
	public void setIsGrade(Integer isGrade) {
		this.isGrade = isGrade;
	}
	
    /**
     * 获取
     * 对应数据表字段： begin_min_time
     *
     * @return 
     */
	public Integer getBeginMinTime() {
		return beginMinTime;
	}
	/**
     * 设置
     * 对应数据表字段： begin_min_time
     */
	public void setBeginMinTime(Integer beginMinTime) {
		this.beginMinTime = beginMinTime;
	}
	
    /**
     * 获取
     * 对应数据表字段： begin_max_time
     *
     * @return 
     */
	public Integer getBeginMaxTime() {
		return beginMaxTime;
	}
	/**
     * 设置
     * 对应数据表字段： begin_max_time
     */
	public void setBeginMaxTime(Integer beginMaxTime) {
		this.beginMaxTime = beginMaxTime;
	}
	
    /**
     * 获取
     * 对应数据表字段： end_min_time
     *
     * @return 
     */
	public Integer getEndMinTime() {
		return endMinTime;
	}
	/**
     * 设置
     * 对应数据表字段： end_min_time
     */
	public void setEndMinTime(Integer endMinTime) {
		this.endMinTime = endMinTime;
	}
	
    /**
     * 获取
     * 对应数据表字段： end_max_time
     *
     * @return 
     */
	public Integer getEndMaxTime() {
		return endMaxTime;
	}
	/**
     * 设置
     * 对应数据表字段： end_max_time
     */
	public void setEndMaxTime(Integer endMaxTime) {
		this.endMaxTime = endMaxTime;
	}
	
    /**
     * 获取
     * 对应数据表字段： admin_id
     *
     * @return 
     */
	public Long getAdminId() {
		return adminId;
	}
	/**
     * 设置
     * 对应数据表字段： admin_id
     */
	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}
	
    /**
     * 获取
     * 对应数据表字段： create_time
     *
     * @return 
     */
	public Long getCreateTime() {
		return createTime;
	}
	/**
     * 设置
     * 对应数据表字段： create_time
     */
	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}
	
    /**
     * 获取
     * 对应数据表字段： update_time
     *
     * @return 
     */
	public Long getUpdateTime() {
		return updateTime;
	}
	/**
     * 设置
     * 对应数据表字段： update_time
     */
	public void setUpdateTime(Long updateTime) {
		this.updateTime = updateTime;
	}
	

    public List<MachineTime> getMachineTimeList() {
		return machineTimeList;
	}
	public void setMachineTimeList(List<MachineTime> machineTimeList) {
		this.machineTimeList = machineTimeList;
	}
	/**
     * 
     *
     * @www.gonecn.com 2017-08-14 16:57
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", machineId=").append(machineId);
        sb.append(", machineNo=").append(machineNo);
        sb.append(", machineMac=").append(machineMac);
        sb.append(", customerId=").append(customerId);
        sb.append(", customerName=").append(customerName);
        sb.append(", userId=").append(userId);
        sb.append(", mobile=").append(mobile);
        sb.append(", machineName=").append(machineName);
        sb.append(", password=").append(password);
        sb.append(", country=").append(country);
        sb.append(", province=").append(province);
        sb.append(", provinceName=").append(provinceName);
        sb.append(", city=").append(city);
        sb.append(", cityName=").append(cityName);
        sb.append(", area=").append(area);
        sb.append(", areaName=").append(areaName);
        sb.append(", address=").append(address);
        sb.append(", attarCount=").append(attarCount);
        sb.append(", attarUse=").append(attarUse);
        sb.append(", attarStatus=").append(attarStatus);
        sb.append(", electricCount=").append(electricCount);
        sb.append(", electricStatus=").append(electricStatus);
        sb.append(", pump=").append(pump);
        sb.append(", pumpTime=").append(pumpTime);
        sb.append(", pressure=").append(pressure);
        sb.append(", useTime=").append(useTime);
        sb.append(", hourFat=").append(hourFat);
        sb.append(", machineOpen=").append(machineOpen);
        sb.append(", machineFan=").append(machineFan);
        sb.append(", workingStatus=").append(workingStatus);
        sb.append(", remark=").append(remark);
        sb.append(", status=").append(status);
        sb.append(", gradeMax=").append(gradeMax);
        sb.append(", isGrade=").append(isGrade);
        sb.append(", beginMinTime=").append(beginMinTime);
        sb.append(", beginMaxTime=").append(beginMaxTime);
        sb.append(", endMinTime=").append(endMinTime);
        sb.append(", endMaxTime=").append(endMaxTime);
        sb.append(", adminId=").append(adminId);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}