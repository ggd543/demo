package com.taobao.api.domain;

import com.taobao.api.internal.mapping.ApiClass;
import com.taobao.api.internal.mapping.ApiField;


import com.taobao.api.TaobaoObject;

/**
 * Subscription Data Structure.
 * 
 * DESC：订阅类型 
 *
 * @author auto create
 * @since 1.0, 2010-04-22 14:14:56.0
 */
@ApiClass("Subscription")
public class Subscription extends TaobaoObject {

	private static final long serialVersionUID = 6433857242964374653L;

	
	/** 
	 * 增量消息的状态（隶属于主题）。具体选值请见：商品消息状态、退款消息状态、交易消息状态中的说明。
	 **/
	@ApiField("status")
	private String status;

	
	/** 
	 * 增量消息所属的主题。
可选值 
trade（交易类型） 
item（商品类型） 
refund（退款类型）
	 **/
	@ApiField("topic")
	private String topic;

	public String getStatus() {
		return this.status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public String getTopic() {
		return this.topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}

}
