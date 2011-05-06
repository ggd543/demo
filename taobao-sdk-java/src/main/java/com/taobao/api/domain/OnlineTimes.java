package com.taobao.api.domain;

import com.taobao.api.internal.mapping.ApiClass;
import com.taobao.api.internal.mapping.ApiField;


import com.taobao.api.TaobaoObject;

/**
 * OnlineTimes Data Structure.
 * 
 * DESC：在线时长 
 *
 * @author auto create
 * @since 1.0, 2010-07-27 15:45:36.0
 */
@ApiClass("OnlineTimes")
public class OnlineTimes extends TaobaoObject {

	private static final long serialVersionUID = 8645465532125251894L;

	
	/** 
	 * 客服在线时间长度（秒）
	 **/
	@ApiField("online_times")
	private Long onlineTimes;

	
	/** 
	 * 客服人员ID
	 **/
	@ApiField("service_staff_id")
	private String serviceStaffId;

	public Long getOnlineTimes() {
		return this.onlineTimes;
	}
	public void setOnlineTimes(Long onlineTimes) {
		this.onlineTimes = onlineTimes;
	}

	public String getServiceStaffId() {
		return this.serviceStaffId;
	}
	public void setServiceStaffId(String serviceStaffId) {
		this.serviceStaffId = serviceStaffId;
	}

}
