package com.taobao.api.domain;

import com.taobao.api.internal.mapping.ApiClass;
import com.taobao.api.internal.mapping.ApiField;


import com.taobao.api.TaobaoObject;

/**
 * StaffEvalStatistics Data Structure.
 * 
 * DESC：客服评价统计 
 *
 * @author auto create
 * @since 1.0, 2010-07-27 15:45:54.0
 */
@ApiClass("StaffEvalStatistics")
public class StaffEvalStatistics extends TaobaoObject {

	private static final long serialVersionUID = 3742681318353271849L;

	
	/** 
	 * 客服评价代码
	 **/
	@ApiField("evaluations")
	private String evaluations;

	
	/** 
	 * 客服人员ID
	 **/
	@ApiField("service_staff_id")
	private String serviceStaffId;

	public String getEvaluations() {
		return this.evaluations;
	}
	public void setEvaluations(String evaluations) {
		this.evaluations = evaluations;
	}

	public String getServiceStaffId() {
		return this.serviceStaffId;
	}
	public void setServiceStaffId(String serviceStaffId) {
		this.serviceStaffId = serviceStaffId;
	}

}
