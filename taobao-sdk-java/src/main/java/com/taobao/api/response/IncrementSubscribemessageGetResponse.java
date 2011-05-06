package com.taobao.api.response;

import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.domain.SubscribeMessage;


import com.taobao.api.TaobaoResponse;

/**
 * TOP API: taobao.increment.subscribemessage.get response
 * 
 * @author auto create
 * @since 1.0,2010-09-17 12:01:37.0
 */
public class IncrementSubscribemessageGetResponse extends TaobaoResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6263998324358526943L;

	
	/** 
	 * ISV增量消息订阅信息
	 **/
	@ApiField("subscribe_message")
	private SubscribeMessage subscribeMessage;

	public void setSubscribeMessage(SubscribeMessage subscribeMessage) {
		this.subscribeMessage = subscribeMessage;
	}

	public SubscribeMessage getSubscribeMessage( ) {
		return this.subscribeMessage;
	}

	public String getApiMethodName() {
		return "taobao.increment.subscribemessage.get";
	}

}
