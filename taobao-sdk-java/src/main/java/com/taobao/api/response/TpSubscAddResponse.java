package com.taobao.api.response;

import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.domain.TpUserSubsc;


import com.taobao.api.TaobaoResponse;

/**
 * TOP API: taobao.tp.subsc.add response
 * 
 * @author auto create
 * @since 1.0,2010-10-14 11:51:12.0
 */
public class TpSubscAddResponse extends TaobaoResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4237478622727797746L;

	
	/** 
	 * TP用户订购返回信息
	 **/
	@ApiField("tp_user_subsc")
	private TpUserSubsc tpUserSubsc;

	public void setTpUserSubsc(TpUserSubsc tpUserSubsc) {
		this.tpUserSubsc = tpUserSubsc;
	}

	public TpUserSubsc getTpUserSubsc( ) {
		return this.tpUserSubsc;
	}

	public String getApiMethodName() {
		return "taobao.tp.subsc.add";
	}

}
