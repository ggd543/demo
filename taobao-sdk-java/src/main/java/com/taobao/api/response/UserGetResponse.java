package com.taobao.api.response;

import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.domain.User;


import com.taobao.api.TaobaoResponse;

/**
 * TOP API: taobao.user.get response
 * 
 * @author auto create
 * @since 1.0,2010-09-15 11:35:04.0
 */
public class UserGetResponse extends TaobaoResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5277132999885746649L;

	
	/** 
	 * 用户信息
	 **/
	@ApiField("user")
	private User user;

	public void setUser(User user) {
		this.user = user;
	}

	public User getUser( ) {
		return this.user;
	}

	public String getApiMethodName() {
		return "taobao.user.get";
	}

}
