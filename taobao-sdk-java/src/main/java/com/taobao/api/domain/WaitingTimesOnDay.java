package com.taobao.api.domain;

import java.util.Date;
import java.util.List;
import com.taobao.api.internal.mapping.ApiClass;
import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.internal.mapping.ApiListField;


import com.taobao.api.TaobaoObject;

/**
 * WaitingTimesOnDay Data Structure.
 * 
 * DESC：客户等待（客服）平均时长列表 
 *
 * @author auto create
 * @since 1.0, 2010-07-28 15:02:55.0
 */
@ApiClass("WaitingTimesOnDay")
public class WaitingTimesOnDay extends TaobaoObject {

	private static final long serialVersionUID = 4499777349493234663L;

	
	/** 
	 * 等待时长（统计）日期
	 **/
	@ApiField("waiting_date")
	private Date waitingDate;

	
	/** 
	 * 等待时长列表
	 **/
	@ApiListField("waiting_time_list")
	@ApiField("waiting_times")
	private List<WaitingTimes> waitingTimeList;

	public Date getWaitingDate() {
		return this.waitingDate;
	}
	public void setWaitingDate(Date waitingDate) {
		this.waitingDate = waitingDate;
	}

	public List<WaitingTimes> getWaitingTimeList() {
		return this.waitingTimeList;
	}
	public void setWaitingTimeList(List<WaitingTimes> waitingTimeList) {
		this.waitingTimeList = waitingTimeList;
	}

}
