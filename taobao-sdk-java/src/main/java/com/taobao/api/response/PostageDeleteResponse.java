package com.taobao.api.response;

import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.domain.Postage;


import com.taobao.api.TaobaoResponse;

/**
 * TOP API: taobao.postage.delete response
 * 
 * @author auto create
 * @since 1.0,2010-08-03 14:55:10.0
 */
public class PostageDeleteResponse extends TaobaoResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4246443974562119926L;

	
	/** 
	 * 邮费模板
	 **/
	@ApiField("postage")
	private Postage postage;

	public void setPostage(Postage postage) {
		this.postage = postage;
	}

	public Postage getPostage( ) {
		return this.postage;
	}

	public String getApiMethodName() {
		return "taobao.postage.delete";
	}

}
