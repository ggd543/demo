package com.taobao.api.response;

import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.domain.KbUserInfo;


import com.taobao.api.TaobaoResponse;

/**
 * TOP API: taobao.koubei.user.get response
 * 
 * @author auto create
 * @since 1.0,2010-12-02 12:57:48.0
 */
public class KoubeiUserGetResponse extends TaobaoResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4281996814529726883L;

	
	/** 
	 * 符合条件的用户信息对象
	 **/
	@ApiField("kb_user_info")
	private KbUserInfo kbUserInfo;

	public void setKbUserInfo(KbUserInfo kbUserInfo) {
		this.kbUserInfo = kbUserInfo;
	}

	public KbUserInfo getKbUserInfo( ) {
		return this.kbUserInfo;
	}

	public String getApiMethodName() {
		return "taobao.koubei.user.get";
	}

}
