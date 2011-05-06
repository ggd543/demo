package com.taobao.api.response;

import java.util.List;
import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.internal.mapping.ApiListField;
import com.taobao.api.domain.Item;


import com.taobao.api.TaobaoResponse;

/**
 * TOP API: taobao.items.custom.get response
 * 
 * @author auto create
 * @since 1.0,2010-08-03 14:42:20.0
 */
public class ItemsCustomGetResponse extends TaobaoResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7131644812589252318L;

	
	/** 
	 * 商品列表，具体返回字段以fields决定
	 **/
	@ApiListField("items")
	@ApiField("item")
	private List<Item> items;

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public List<Item> getItems( ) {
		return this.items;
	}

	public String getApiMethodName() {
		return "taobao.items.custom.get";
	}

}
