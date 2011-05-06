package com.taobao.api.response;

import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.domain.Item;


import com.taobao.api.TaobaoResponse;

/**
 * TOP API: taobao.item.update.listing response
 * 
 * @author auto create
 * @since 1.0,2010-11-12 10:15:01.0
 */
public class ItemUpdateListingResponse extends TaobaoResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8853683149927945659L;

	
	/** 
	 * 上架后返回的商品信息：返回的结果就是:num_iid和modified
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
		return "taobao.item.update.listing";
	}

}
