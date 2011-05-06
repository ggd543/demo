package com.taobao.api.response;

import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.domain.Item;


import com.taobao.api.TaobaoResponse;

/**
 * TOP API: taobao.item.update response
 * 
 * @author auto create
 * @since 1.0,2010-11-30 10:09:44.0
 */
public class ItemUpdateResponse extends TaobaoResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3383697273765431827L;

	
	/** 
	 * 商品结构里的num_iid，modified
	 **/
	@ApiField("item")
	private Item item;

	public void setItem(Item item) {
		this.item = item;
	}

	public Item getItem( ) {
		return this.item;
	}

	public String getApiMethodName() {
		return "taobao.item.update";
	}

}
