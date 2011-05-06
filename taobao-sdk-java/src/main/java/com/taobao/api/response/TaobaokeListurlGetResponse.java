package com.taobao.api.response;

import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.domain.TaobaokeItem;


import com.taobao.api.TaobaoResponse;

/**
 * TOP API: taobao.taobaoke.listurl.get response
 * 
 * @author auto create
 * @since 1.0,2010-08-12 20:54:01.0
 */
public class TaobaokeListurlGetResponse extends TaobaoResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6652573983583123446L;

	
	/** 
	 * 只返回keyword_click_url
	 **/
	@ApiField("taobaoke_item")
	private TaobaokeItem taobaokeItem;

	public void setTaobaokeItem(TaobaokeItem taobaokeItem) {
		this.taobaokeItem = taobaokeItem;
	}

	public TaobaokeItem getTaobaokeItem( ) {
		return this.taobaokeItem;
	}

	public String getApiMethodName() {
		return "taobao.taobaoke.listurl.get";
	}

}
