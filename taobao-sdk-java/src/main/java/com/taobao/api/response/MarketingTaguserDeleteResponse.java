package com.taobao.api.response;

import com.taobao.api.internal.mapping.ApiField;


import com.taobao.api.TaobaoResponse;

/**
 * TOP API: taobao.marketing.taguser.delete response
 * 
 * @author auto create
 * @since 1.0,2010-11-18 16:51:43.0
 */
public class MarketingTaguserDeleteResponse extends TaobaoResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1435783365266835681L;

	
	/** 
	 * 是否成功
	 **/
	@ApiField("is_success")
	private Boolean isSuccess;

	public void setIsSuccess(Boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public Boolean getIsSuccess( ) {
		return this.isSuccess;
	}

	public String getApiMethodName() {
		return "taobao.marketing.taguser.delete";
	}

}
