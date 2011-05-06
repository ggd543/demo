package com.taobao.api.response;

import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.domain.Order;


import com.taobao.api.TaobaoResponse;

/**
 * TOP API: taobao.trade.ordersku.update response
 * 
 * @author auto create
 * @since 1.0,2010-07-29 20:52:54.0
 */
public class TradeOrderskuUpdateResponse extends TaobaoResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3834115528542768642L;

	
	/** 
	 * 只返回oid和modified
	 **/
	@ApiField("order")
	private Order order;

	public void setOrder(Order order) {
		this.order = order;
	}

	public Order getOrder( ) {
		return this.order;
	}

	public String getApiMethodName() {
		return "taobao.trade.ordersku.update";
	}

}
