package com.taobao.api.response;

import java.util.List;
import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.internal.mapping.ApiListField;
import com.taobao.api.domain.TaobaokeShop;


import com.taobao.api.TaobaoResponse;

/**
 * TOP API: taobao.taobaoke.shops.convert response
 * 
 * @author auto create
 * @since 1.0,2010-09-10 10:29:32.0
 */
public class TaobaokeShopsConvertResponse extends TaobaoResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1145539221123977235L;

	
	/** 
	 * 淘宝客店铺对象列表
	 **/
	@ApiListField("taobaoke_shops")
	@ApiField("taobaoke_shop")
	private List<TaobaokeShop> taobaokeShops;

	public void setTaobaokeShops(List<TaobaokeShop> taobaokeShops) {
		this.taobaokeShops = taobaokeShops;
	}

	public List<TaobaokeShop> getTaobaokeShops( ) {
		return this.taobaokeShops;
	}

	public String getApiMethodName() {
		return "taobao.taobaoke.shops.convert";
	}

}
