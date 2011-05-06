package com.taobao.api.response;

import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.domain.Refund;


import com.taobao.api.TaobaoResponse;

/**
 * TOP API: taobao.refund.get response
 * 
 * @author auto create
 * @since 1.0,2010-08-03 15:20:42.0
 */
public class RefundGetResponse extends TaobaoResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3138376494746927182L;

	
	/** 
	 * 搜索到的交易信息列表
	 **/
	@ApiField("refund")
	private Refund refund;

	public void setRefund(Refund refund) {
		this.refund = refund;
	}

	public Refund getRefund( ) {
		return this.refund;
	}

	public String getApiMethodName() {
		return "taobao.refund.get";
	}

}
