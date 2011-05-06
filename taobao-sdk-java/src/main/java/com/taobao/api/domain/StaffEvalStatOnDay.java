package com.taobao.api.domain;

import java.util.Date;
import java.util.List;
import com.taobao.api.internal.mapping.ApiClass;
import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.internal.mapping.ApiListField;


import com.taobao.api.TaobaoObject;

/**
 * StaffEvalStatOnDay Data Structure.
 * 
 * DESC：客服评价统计列表(按天) 
 *
 * @author auto create
 * @since 1.0, 2010-07-28 15:02:36.0
 */
@ApiClass("StaffEvalStatOnDay")
public class StaffEvalStatOnDay extends TaobaoObject {

	private static final long serialVersionUID = 6659223738824589536L;

	
	/** 
	 * 评价产生的日期
	 **/
	@ApiField("eval_date")
	private Date evalDate;

	
	/** 
	 * 客服评价统计列表
	 **/
	@ApiListField("staff_eval_stat_list")
	@ApiField("staff_eval_statistics")
	private List<StaffEvalStatistics> staffEvalStatList;

	public Date getEvalDate() {
		return this.evalDate;
	}
	public void setEvalDate(Date evalDate) {
		this.evalDate = evalDate;
	}

	public List<StaffEvalStatistics> getStaffEvalStatList() {
		return this.staffEvalStatList;
	}
	public void setStaffEvalStatList(List<StaffEvalStatistics> staffEvalStatList) {
		this.staffEvalStatList = staffEvalStatList;
	}

}
