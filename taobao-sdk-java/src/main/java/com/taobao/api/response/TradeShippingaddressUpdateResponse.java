package com.taobao.api.response;

import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.domain.Trade;


import com.taobao.api.TaobaoResponse;

/**
 * TOP API: taobao.trade.shippingaddress.update response
 * 
 * @author auto create
 * @since 1.0,2010-08-25 09:31:03.0
 */
public class TradeShippingaddressUpdateResponse extends TaobaoResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7559478596217319753L;

	
	/** 
	 * 交易结构
	 **/
	@ApiField("trade")
	private Trade trade;

	public void setTrade(Trade trade) {
		this.trade = trade;
	}

	public Trade getTrade( ) {
		return this.trade;
	}

	public String getApiMethodName() {
		return "taobao.trade.shippingaddress.update";
	}

}
