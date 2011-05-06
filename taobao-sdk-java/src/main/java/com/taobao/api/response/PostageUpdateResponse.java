package com.taobao.api.response;

import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.domain.Postage;


import com.taobao.api.TaobaoResponse;

/**
 * TOP API: taobao.postage.update response
 * 
 * @author auto create
 * @since 1.0,2010-08-05 09:37:58.0
 */
public class PostageUpdateResponse extends TaobaoResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6758736285539548639L;

	
	/** 
	 * 修改后的邮费模板信息
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
		return "taobao.postage.update";
	}

}
