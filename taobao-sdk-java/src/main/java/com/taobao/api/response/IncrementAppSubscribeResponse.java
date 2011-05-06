package com.taobao.api.response;

import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.domain.SubscribeMessage;


import com.taobao.api.TaobaoResponse;

/**
 * TOP API: taobao.increment.app.subscribe response
 * 
 * @author auto create
 * @since 1.0,2010-10-08 15:38:02.0
 */
public class IncrementAppSubscribeResponse extends TaobaoResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1384463573682715632L;

	
	/** 
	 * ISV的订购信息
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
		return "taobao.increment.app.subscribe";
	}

}
