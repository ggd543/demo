package com.taobao.api.response;

import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.domain.TaobaokeItem;


import com.taobao.api.TaobaoResponse;

/**
 * TOP API: taobao.taobaoke.caturl.get response
 * 
 * @author auto create
 * @since 1.0,2010-07-16 16:17:26.0
 */
public class TaobaokeCaturlGetResponse extends TaobaoResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1486216444895756669L;

	
	/** 
	 * 只返回taobaoke_cat_click_url
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
		return "taobao.taobaoke.caturl.get";
	}

}
