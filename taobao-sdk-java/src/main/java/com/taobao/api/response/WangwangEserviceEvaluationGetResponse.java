package com.taobao.api.response;

import java.util.List;
import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.internal.mapping.ApiListField;
import com.taobao.api.domain.StaffEvalStatOnDay;


import com.taobao.api.TaobaoResponse;

/**
 * TOP API: taobao.wangwang.eservice.evaluation.get response
 * 
 * @author auto create
 * @since 1.0,2010-09-19 13:10:06.0
 */
public class WangwangEserviceEvaluationGetResponse extends TaobaoResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2249339473522462695L;

	
	/** 
	 * 客服平均统计列表
	 **/
	@ApiListField("staff_eval_stat_list")
	@ApiField("staff_eval_stat_on_day")
	private List<StaffEvalStatOnDay> staffEvalStatList;

	public void setStaffEvalStatList(List<StaffEvalStatOnDay> staffEvalStatList) {
		this.staffEvalStatList = staffEvalStatList;
	}

	public List<StaffEvalStatOnDay> getStaffEvalStatList( ) {
		return this.staffEvalStatList;
	}

	public String getApiMethodName() {
		return "taobao.wangwang.eservice.evaluation.get";
	}

}
