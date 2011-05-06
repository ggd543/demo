package com.taobao.api.response;

import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.domain.Sku;


import com.taobao.api.TaobaoResponse;

/**
 * TOP API: taobao.item.sku.update response
 * 
 * @author auto create
 * @since 1.0,2010-08-03 15:57:02.0
 */
public class ItemSkuUpdateResponse extends TaobaoResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4627792383148533391L;

	
	/** 
	 * 商品Sku
	 **/
	@ApiField("sku")
	private Sku sku;

	public void setSku(Sku sku) {
		this.sku = sku;
	}

	public Sku getSku( ) {
		return this.sku;
	}

	public String getApiMethodName() {
		return "taobao.item.sku.update";
	}

}
