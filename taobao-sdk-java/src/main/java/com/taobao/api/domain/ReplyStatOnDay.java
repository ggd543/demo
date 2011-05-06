package com.taobao.api.domain;

import java.util.Date;
import java.util.List;
import com.taobao.api.internal.mapping.ApiClass;
import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.internal.mapping.ApiListField;


import com.taobao.api.TaobaoObject;

/**
 * ReplyStatOnDay Data Structure.
 * 
 * DESC：(某天)回复统计列表 
 *
 * @author auto create
 * @since 1.0, 2010-07-28 15:03:16.0
 */
@ApiClass("ReplyStatOnDay")
public class ReplyStatOnDay extends TaobaoObject {

	private static final long serialVersionUID = 2275722426588376488L;

	
	/** 
	 * 某天（的回复统计）
	 **/
	@ApiField("reply_date")
	private Date replyDate;

	
	/** 
	 * 客服回复统计
	 **/
	@ApiListField("reply_stat_list")
	@ApiField("reply_statistics")
	private List<ReplyStatistics> replyStatList;

	public Date getReplyDate() {
		return this.replyDate;
	}
	public void setReplyDate(Date replyDate) {
		this.replyDate = replyDate;
	}

	public List<ReplyStatistics> getReplyStatList() {
		return this.replyStatList;
	}
	public void setReplyStatList(List<ReplyStatistics> replyStatList) {
		this.replyStatList = replyStatList;
	}

}
