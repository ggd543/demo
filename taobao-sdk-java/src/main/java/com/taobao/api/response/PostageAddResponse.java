package com.taobao.api.response;

import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.domain.Postage;


import com.taobao.api.TaobaoResponse;

/**
 * TOP API: taobao.postage.add response
 * 
 * @author auto create
 * @since 1.0,2010-08-03 14:56:20.0
 */
public class PostageAddResponse extends TaobaoResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2492983621882542384L;

	
	/** 
	 * 新增的商品信息
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
		return "taobao.postage.add";
	}

}
