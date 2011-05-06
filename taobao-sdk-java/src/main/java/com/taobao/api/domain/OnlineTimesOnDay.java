package com.taobao.api.domain;

import java.util.Date;
import java.util.List;
import com.taobao.api.internal.mapping.ApiClass;
import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.internal.mapping.ApiListField;


import com.taobao.api.TaobaoObject;

/**
 * OnlineTimesOnDay Data Structure.
 * 
 * DESC：某天的客服在线时长列表 
 *
 * @author auto create
 * @since 1.0, 2010-07-28 15:02:44.0
 */
@ApiClass("OnlineTimesOnDay")
public class OnlineTimesOnDay extends TaobaoObject {

	private static final long serialVersionUID = 1184931523797195653L;

	
	/** 
	 * 在线日期
	 **/
	@ApiField("online_date")
	private Date onlineDate;

	
	/** 
	 * 在线时长列表
	 **/
	@ApiListField("online_time_list")
	@ApiField("online_times")
	private List<OnlineTimes> onlineTimeList;

	public Date getOnlineDate() {
		return this.onlineDate;
	}
	public void setOnlineDate(Date onlineDate) {
		this.onlineDate = onlineDate;
	}

	public List<OnlineTimes> getOnlineTimeList() {
		return this.onlineTimeList;
	}
	public void setOnlineTimeList(List<OnlineTimes> onlineTimeList) {
		this.onlineTimeList = onlineTimeList;
	}

}
