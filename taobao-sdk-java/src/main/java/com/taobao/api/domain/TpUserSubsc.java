package com.taobao.api.domain;

import com.taobao.api.internal.mapping.ApiClass;
import com.taobao.api.internal.mapping.ApiField;


import com.taobao.api.TaobaoObject;

/**
 * TpUserSubsc Data Structure.
 * 
 * DESC：TP订购数据结构 
 *
 * @author auto create
 * @since 1.0, 2010-08-18 11:02:37.0
 */
@ApiClass("TpUserSubsc")
public class TpUserSubsc extends TaobaoObject {

	private static final long serialVersionUID = 8879358343192163313L;

	
	/** 
	 * 订购状况成功
	 **/
	@ApiField("status")
	private String status;

	
	/** 
	 * 订购url链接
	 **/
	@ApiField("subsc_link")
	private String subscLink;

	public String getStatus() {
		return this.status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public String getSubscLink() {
		return this.subscLink;
	}
	public void setSubscLink(String subscLink) {
		this.subscLink = subscLink;
	}

}
