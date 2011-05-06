package com.taobao.api.response;

import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.domain.Item;


import com.taobao.api.TaobaoResponse;

/**
 * TOP API: taobao.item.add response
 * 
 * @author auto create
 * @since 1.0,2010-11-30 10:08:17.0
 */
public class ItemAddResponse extends TaobaoResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3271377685239856759L;

	
	/** 
	 * 商品结构,仅有iid,numIid和created返回
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
		return "taobao.item.add";
	}

}
