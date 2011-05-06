package com.taobao.api.response;

import java.util.List;
import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.internal.mapping.ApiListField;
import com.taobao.api.domain.ShopCat;


import com.taobao.api.TaobaoResponse;

/**
 * TOP API: taobao.shopcats.list.get response
 * 
 * @author auto create
 * @since 1.0,2010-08-03 15:50:09.0
 */
public class ShopcatsListGetResponse extends TaobaoResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7583448777597835854L;

	
	/** 
	 * 店铺类目列表信息
	 **/
	@ApiListField("shop_cats")
	@ApiField("shop_cat")
	private List<ShopCat> shopCats;

	public void setShopCats(List<ShopCat> shopCats) {
		this.shopCats = shopCats;
	}

	public List<ShopCat> getShopCats( ) {
		return this.shopCats;
	}

	public String getApiMethodName() {
		return "taobao.shopcats.list.get";
	}

}
