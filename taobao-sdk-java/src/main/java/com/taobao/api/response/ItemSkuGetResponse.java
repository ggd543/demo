package com.taobao.api.response;

import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.domain.Sku;


import com.taobao.api.TaobaoResponse;

/**
 * TOP API: taobao.item.sku.get response
 * 
 * @author auto create
 * @since 1.0,2010-09-29 17:01:09.0
 */
public class ItemSkuGetResponse extends TaobaoResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3469954377553476593L;

	
	/** 
	 * Sku
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
		return "taobao.item.sku.get";
	}

}
