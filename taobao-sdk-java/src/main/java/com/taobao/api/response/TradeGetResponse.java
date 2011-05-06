package com.taobao.api.response;

import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.domain.Trade;


import com.taobao.api.TaobaoResponse;

/**
 * TOP API: taobao.trade.get response
 * 
 * @author auto create
 * @since 1.0,2010-09-10 16:11:53.0
 */
public class TradeGetResponse extends TaobaoResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5686196591899175773L;

	
	/** 
	 * 搜索到的交易信息列表，返回的Trade和Order中包含的具体信息为入参fields请求的字段信息
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
		return "taobao.trade.get";
	}

}
