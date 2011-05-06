package com.taobao.api.domain;

import com.taobao.api.internal.mapping.ApiClass;
import com.taobao.api.internal.mapping.ApiField;


import com.taobao.api.TaobaoObject;

/**
 * WaitingTimes Data Structure.
 * 
 * DESC：平均等待时长 
 *
 * @author auto create
 * @since 1.0, 2010-07-27 15:45:45.0
 */
@ApiClass("WaitingTimes")
public class WaitingTimes extends TaobaoObject {

	private static final long serialVersionUID = 7398285735916374399L;

	
	/** 
	 * 平均等待时间长度（秒）
	 **/
	@ApiField("avg_waiting_times")
	private Long avgWaitingTimes;

	
	/** 
	 * 客服人员ID
	 **/
	@ApiField("service_staff_id")
	private String serviceStaffId;

	public Long getAvgWaitingTimes() {
		return this.avgWaitingTimes;
	}
	public void setAvgWaitingTimes(Long avgWaitingTimes) {
		this.avgWaitingTimes = avgWaitingTimes;
	}

	public String getServiceStaffId() {
		return this.serviceStaffId;
	}
	public void setServiceStaffId(String serviceStaffId) {
		this.serviceStaffId = serviceStaffId;
	}

}
