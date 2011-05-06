package com.taobao.api.response;

import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.domain.Item;


import com.taobao.api.TaobaoResponse;

/**
 * TOP API: taobao.item.get response
 * 
 * @author auto create
 * @since 1.0,2010-09-07 14:44:31.0
 */
public class ItemGetResponse extends TaobaoResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6697495642429188698L;

	
	/** 
	 * 获取的商品 具体字段根据权限和设定的fields决定
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
		return "taobao.item.get";
	}

}
