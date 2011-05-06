package com.taobao.api.domain;

import com.taobao.api.internal.mapping.ApiClass;
import com.taobao.api.internal.mapping.ApiField;


import com.taobao.api.TaobaoObject;

/**
 * ReplyStatistics Data Structure.
 * 
 * DESC：客服回复统计 
 *
 * @author auto create
 * @since 1.0, 2010-07-27 15:46:12.0
 */
@ApiClass("ReplyStatistics")
public class ReplyStatistics extends TaobaoObject {

	private static final long serialVersionUID = 7642185827888985972L;

	
	/** 
	 * 客服回复数
	 **/
	@ApiField("reply_num")
	private Long replyNum;

	
	/** 
	 * 客服ID
	 **/
	@ApiField("user_id")
	private String userId;

	public Long getReplyNum() {
		return this.replyNum;
	}
	public void setReplyNum(Long replyNum) {
		this.replyNum = replyNum;
	}

	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

}
