package com.taobao.api.response;

import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.domain.Item;


import com.taobao.api.TaobaoResponse;

/**
 * TOP API: taobao.item.recommend.delete response
 * 
 * @author auto create
 * @since 1.0,2010-11-12 10:22:05.0
 */
public class ItemRecommendDeleteResponse extends TaobaoResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6185667974898319992L;

	
	/** 
	 * 被取消橱窗推荐的商品信息
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
		return "taobao.item.recommend.delete";
	}

}
