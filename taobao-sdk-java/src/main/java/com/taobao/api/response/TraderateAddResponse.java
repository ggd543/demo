package com.taobao.api.response;

import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.domain.TradeRate;


import com.taobao.api.TaobaoResponse;

/**
 * TOP API: taobao.traderate.add response
 * 
 * @author auto create
 * @since 1.0,2010-09-27 09:26:50.0
 */
public class TraderateAddResponse extends TaobaoResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3565547422176771589L;

	
	/** 
	 * 返回tid、oid、create
	 **/
	@ApiField("trade_rate")
	private TradeRate tradeRate;

	public void setTradeRate(TradeRate tradeRate) {
		this.tradeRate = tradeRate;
	}

	public TradeRate getTradeRate( ) {
		return this.tradeRate;
	}

	public String getApiMethodName() {
		return "taobao.traderate.add";
	}

}
