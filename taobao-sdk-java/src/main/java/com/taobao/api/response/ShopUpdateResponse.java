package com.taobao.api.response;

import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.domain.Shop;


import com.taobao.api.TaobaoResponse;

/**
 * TOP API: taobao.shop.update response
 * 
 * @author auto create
 * @since 1.0,2010-08-04 18:41:48.0
 */
public class ShopUpdateResponse extends TaobaoResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1265945925513861254L;

	
	/** 
	 * 店铺信息
	 **/
	@ApiField("shop")
	private Shop shop;

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public Shop getShop( ) {
		return this.shop;
	}

	public String getApiMethodName() {
		return "taobao.shop.update";
	}

}
