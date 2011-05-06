package com.taobao.api.response;

import com.taobao.api.internal.mapping.ApiField;


import com.taobao.api.TaobaoResponse;

/**
 * TOP API: taobao.marketing.taguser.add response
 * 
 * @author auto create
 * @since 1.0,2010-11-18 16:51:30.0
 */
public class MarketingTaguserAddResponse extends TaobaoResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8611497794964939357L;

	
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
		return "taobao.marketing.taguser.add";
	}

}
