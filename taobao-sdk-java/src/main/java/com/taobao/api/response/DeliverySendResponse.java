package com.taobao.api.response;

import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.domain.Shipping;


import com.taobao.api.TaobaoResponse;

/**
 * TOP API: taobao.delivery.send response
 * 
 * @author auto create
 * @since 1.0,2010-11-11 19:49:44.0
 */
public class DeliverySendResponse extends TaobaoResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8144384885361116454L;

	
	/** 
	 * 只返回is_success
	 **/
	@ApiField("shipping")
	private Shipping shipping;

	public void setShipping(Shipping shipping) {
		this.shipping = shipping;
	}

	public Shipping getShipping( ) {
		return this.shipping;
	}

	public String getApiMethodName() {
		return "taobao.delivery.send";
	}

}
