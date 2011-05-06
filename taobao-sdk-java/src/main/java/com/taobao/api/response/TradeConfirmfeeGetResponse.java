package com.taobao.api.response;

import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.domain.TradeConfirmFee;


import com.taobao.api.TaobaoResponse;

/**
 * TOP API: taobao.trade.confirmfee.get response
 * 
 * @author auto create
 * @since 1.0,2010-08-04 09:31:21.0
 */
public class TradeConfirmfeeGetResponse extends TaobaoResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5575691265945219974L;

	
	/** 
	 * 获取到的交易确认收货费用
	 **/
	@ApiField("trade_confirm_fee")
	private TradeConfirmFee tradeConfirmFee;

	public void setTradeConfirmFee(TradeConfirmFee tradeConfirmFee) {
		this.tradeConfirmFee = tradeConfirmFee;
	}

	public TradeConfirmFee getTradeConfirmFee( ) {
		return this.tradeConfirmFee;
	}

	public String getApiMethodName() {
		return "taobao.trade.confirmfee.get";
	}

}
