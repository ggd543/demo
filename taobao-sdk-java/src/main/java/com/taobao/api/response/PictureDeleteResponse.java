package com.taobao.api.response;

import com.taobao.api.internal.mapping.ApiField;


import com.taobao.api.TaobaoResponse;

/**
 * TOP API: taobao.picture.delete response
 * 
 * @author auto create
 * @since 1.0,2010-08-12 20:55:27.0
 */
public class PictureDeleteResponse extends TaobaoResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6736481236683824146L;

	
	/** 
	 * 是否删除
	 **/
	@ApiField("success")
	private Boolean success;

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public Boolean getSuccess( ) {
		return this.success;
	}

	public String getApiMethodName() {
		return "taobao.picture.delete";
	}

}
