package com.mock.wifiserver.domain;

import java.io.Serializable;

/**
 * 对应tbl_machine_time表的实体对象类
 * 
 * @author fenggang.xu
 * @www.ehuima.com 日期：2017-08-10 18:38
 * @company 广州慧码信息科技有限公司
 * @version 1.0.0
 */
public class MachineTime implements Serializable {

    /**
     * @www.ehuima.com 2017-08-10 18:38
     */
    private static final long serialVersionUID = 1L;
    
    //时间段
    private Integer timeSlot;
    
	/**
	 * 
	 * 对应数据表字段： machine_time_id
     * @www.gonecn.com 2017-08-10 18:38
	 */
	private Long machineTimeId;
	
	/**
	 * 
	 * 对应数据表字段： machine_id
     * @www.gonecn.com 2017-08-10 18:38
	 */
	private Long machineId;
	
	/**
	 * 
	 * 对应数据表字段： day_0
     * @www.gonecn.com 2017-08-10 18:38
	 */
	private Integer day0;
	
	/**
	 * 
	 * 对应数据表字段： day_1
     * @www.gonecn.com 2017-08-10 18:38
	 */
	private Integer day1;
	
	/**
	 * 
	 * 对应数据表字段： day_2
     * @www.gonecn.com 2017-08-10 18:38
	 */
	private Integer day2;
	
	/**
	 * 
	 * 对应数据表字段： day_3
     * @www.gonecn.com 2017-08-10 18:38
	 */
	private Integer day3;
	
	/**
	 * 
	 * 对应数据表字段： day_4
     * @www.gonecn.com 2017-08-10 18:38
	 */
	private Integer day4;
	
	/**
	 * 
	 * 对应数据表字段： day_5
     * @www.gonecn.com 2017-08-10 18:38
	 */
	private Integer day5;
	
	/**
	 * 
	 * 对应数据表字段： day_6
     * @www.gonecn.com 2017-08-10 18:38
	 */
	private Integer day6;
	
	/**
	 * 
	 * 对应数据表字段： begin_hour
     * @www.gonecn.com 2017-08-10 18:38
	 */
	private Integer beginHour;
	
	/**
	 * 
	 * 对应数据表字段： begin_minute
     * @www.gonecn.com 2017-08-10 18:38
	 */
	private Integer beginMinute;
	
	/**
	 * 
	 * 对应数据表字段： end_hour
     * @www.gonecn.com 2017-08-10 18:38
	 */
	private Integer endHour;
	
	/**
	 * 
	 * 对应数据表字段： end_minute
     * @www.gonecn.com 2017-08-10 18:38
	 */
	private Integer endMinute;
	
	/**
	 * 
	 * 对应数据表字段： grade
     * @www.gonecn.com 2017-08-10 18:38
	 */
	private Integer grade;
	
	/**
	 * 
	 * 对应数据表字段： working
     * @www.gonecn.com 2017-08-10 18:38
	 */
	private Integer working;
	
	/**
	 * 
	 * 对应数据表字段： stop
     * @www.gonecn.com 2017-08-10 18:38
	 */
	private Integer stop;
	
	/**
	 * 
	 * 对应数据表字段： status
     * @www.gonecn.com 2017-08-10 18:38
	 */
	private Integer status;
	
	/**
	 * 
	 * 对应数据表字段： admin_id
     * @www.gonecn.com 2017-08-10 18:38
	 */
	private Long adminId;
	
	/**
	 * 
	 * 对应数据表字段： create_time
     * @www.gonecn.com 2017-08-10 18:38
	 */
	private Long createTime;
	
	/**
	 * 
	 * 对应数据表字段： update_time
     * @www.gonecn.com 2017-08-10 18:38
	 */
	private Long updateTime;
	

    /**
     * 获取
     * 对应数据表字段： machine_time_id
     *
     * @return 
     */
	public Long getMachineTimeId() {
		return machineTimeId;
	}
	/**
     * 设置
     * 对应数据表字段： machine_time_id
     */
	public void setMachineTimeId(Long machineTimeId) {
		this.machineTimeId = machineTimeId;
	}
	
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
     * 对应数据表字段： day_0
     *
     * @return 
     */
	public Integer getDay0() {
		return day0;
	}
	/**
     * 设置
     * 对应数据表字段： day_0
     */
	public void setDay0(Integer day0) {
		this.day0 = day0;
	}
	
    /**
     * 获取
     * 对应数据表字段： day_1
     *
     * @return 
     */
	public Integer getDay1() {
		return day1;
	}
	/**
     * 设置
     * 对应数据表字段： day_1
     */
	public void setDay1(Integer day1) {
		this.day1 = day1;
	}
	
    /**
     * 获取
     * 对应数据表字段： day_2
     *
     * @return 
     */
	public Integer getDay2() {
		return day2;
	}
	/**
     * 设置
     * 对应数据表字段： day_2
     */
	public void setDay2(Integer day2) {
		this.day2 = day2;
	}
	
    /**
     * 获取
     * 对应数据表字段： day_3
     *
     * @return 
     */
	public Integer getDay3() {
		return day3;
	}
	/**
     * 设置
     * 对应数据表字段： day_3
     */
	public void setDay3(Integer day3) {
		this.day3 = day3;
	}
	
    /**
     * 获取
     * 对应数据表字段： day_4
     *
     * @return 
     */
	public Integer getDay4() {
		return day4;
	}
	/**
     * 设置
     * 对应数据表字段： day_4
     */
	public void setDay4(Integer day4) {
		this.day4 = day4;
	}
	
    /**
     * 获取
     * 对应数据表字段： day_5
     *
     * @return 
     */
	public Integer getDay5() {
		return day5;
	}
	/**
     * 设置
     * 对应数据表字段： day_5
     */
	public void setDay5(Integer day5) {
		this.day5 = day5;
	}
	
    /**
     * 获取
     * 对应数据表字段： day_6
     *
     * @return 
     */
	public Integer getDay6() {
		return day6;
	}
	/**
     * 设置
     * 对应数据表字段： day_6
     */
	public void setDay6(Integer day6) {
		this.day6 = day6;
	}
	
    /**
     * 获取
     * 对应数据表字段： begin_hour
     *
     * @return 
     */
	public Integer getBeginHour() {
		return beginHour;
	}
	/**
     * 设置
     * 对应数据表字段： begin_hour
     */
	public void setBeginHour(Integer beginHour) {
		this.beginHour = beginHour;
	}
	
    /**
     * 获取
     * 对应数据表字段： begin_minute
     *
     * @return 
     */
	public Integer getBeginMinute() {
		return beginMinute;
	}
	/**
     * 设置
     * 对应数据表字段： begin_minute
     */
	public void setBeginMinute(Integer beginMinute) {
		this.beginMinute = beginMinute;
	}
	
    /**
     * 获取
     * 对应数据表字段： end_hour
     *
     * @return 
     */
	public Integer getEndHour() {
		return endHour;
	}
	/**
     * 设置
     * 对应数据表字段： end_hour
     */
	public void setEndHour(Integer endHour) {
		this.endHour = endHour;
	}
	
    /**
     * 获取
     * 对应数据表字段： end_minute
     *
     * @return 
     */
	public Integer getEndMinute() {
		return endMinute;
	}
	/**
     * 设置
     * 对应数据表字段： end_minute
     */
	public void setEndMinute(Integer endMinute) {
		this.endMinute = endMinute;
	}
	
    /**
     * 获取
     * 对应数据表字段： grade
     *
     * @return 
     */
	public Integer getGrade() {
		return grade;
	}
	/**
     * 设置
     * 对应数据表字段： grade
     */
	public void setGrade(Integer grade) {
		this.grade = grade;
	}
	
    /**
     * 获取
     * 对应数据表字段： working
     *
     * @return 
     */
	public Integer getWorking() {
		return working;
	}
	/**
     * 设置
     * 对应数据表字段： working
     */
	public void setWorking(Integer working) {
		this.working = working;
	}
	
    /**
     * 获取
     * 对应数据表字段： stop
     *
     * @return 
     */
	public Integer getStop() {
		return stop;
	}
	/**
     * 设置
     * 对应数据表字段： stop
     */
	public void setStop(Integer stop) {
		this.stop = stop;
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
	

    public Integer getTimeSlot() {
		return timeSlot;
	}
	public void setTimeSlot(Integer timeSlot) {
		this.timeSlot = timeSlot;
	}
	/**
     * 
     *
     * @www.gonecn.com 2017-08-10 18:38
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", machineTimeId=").append(machineTimeId);
        sb.append(", machineId=").append(machineId);
        sb.append(", day0=").append(day0);
        sb.append(", day1=").append(day1);
        sb.append(", day2=").append(day2);
        sb.append(", day3=").append(day3);
        sb.append(", day4=").append(day4);
        sb.append(", day5=").append(day5);
        sb.append(", day6=").append(day6);
        sb.append(", beginHour=").append(beginHour);
        sb.append(", beginMinute=").append(beginMinute);
        sb.append(", endHour=").append(endHour);
        sb.append(", endMinute=").append(endMinute);
        sb.append(", grade=").append(grade);
        sb.append(", working=").append(working);
        sb.append(", stop=").append(stop);
        sb.append(", status=").append(status);
        sb.append(", adminId=").append(adminId);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}