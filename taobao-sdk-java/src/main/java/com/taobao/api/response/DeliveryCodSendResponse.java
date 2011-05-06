package com.taobao.api.response;

import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.domain.Shipping;


import com.taobao.api.TaobaoResponse;

/**
 * TOP API: taobao.delivery.cod.send response
 * 
 * @author auto create
 * @since 1.0,2010-09-14 14:37:31.0
 */
public class DeliveryCodSendResponse extends TaobaoResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4372443947916866328L;

	
	/** 
	 * 只返回is_success：是否成功。
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
		return "taobao.delivery.cod.send";
	}

}
