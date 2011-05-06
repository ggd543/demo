package com.taobao.api.domain;

import java.util.Date;
import java.util.List;
import com.taobao.api.internal.mapping.ApiClass;
import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.internal.mapping.ApiListField;


import com.taobao.api.TaobaoObject;

/**
 * NonReplyStatOnDay Data Structure.
 * 
 * DESC：未回复统计列表(按天) 
 *
 * @author auto create
 * @since 1.0, 2010-07-28 15:03:04.0
 */
@ApiClass("NonReplyStatOnDay")
public class NonReplyStatOnDay extends TaobaoObject {

	private static final long serialVersionUID = 3253451172516227336L;

	
	/** 
	 * （某天的）未回复统计
	 **/
	@ApiField("nonreply_date")
	private Date nonreplyDate;

	
	/** 
	 * 未回复统计列表
	 **/
	@ApiListField("nonreply_stat_list")
	@ApiField("non_reply_statistics")
	private List<NonReplyStatistics> nonreplyStatList;

	public Date getNonreplyDate() {
		return this.nonreplyDate;
	}
	public void setNonreplyDate(Date nonreplyDate) {
		this.nonreplyDate = nonreplyDate;
	}

	public List<NonReplyStatistics> getNonreplyStatList() {
		return this.nonreplyStatList;
	}
	public void setNonreplyStatList(List<NonReplyStatistics> nonreplyStatList) {
		this.nonreplyStatList = nonreplyStatList;
	}

}
