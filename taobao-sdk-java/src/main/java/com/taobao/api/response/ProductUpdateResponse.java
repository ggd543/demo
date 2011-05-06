package com.taobao.api.response;

import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.domain.Product;


import com.taobao.api.TaobaoResponse;

/**
 * TOP API: taobao.product.update response
 * 
 * @author auto create
 * @since 1.0,2010-08-05 09:37:49.0
 */
public class ProductUpdateResponse extends TaobaoResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5539695258471521885L;

	
	/** 
	 * 返回product数据结构中的：product_id,modified
	 **/
	@ApiField("product")
	private Product product;

	public void setProduct(Product product) {
		this.product = product;
	}

	public Product getProduct( ) {
		return this.product;
	}

	public String getApiMethodName() {
		return "taobao.product.update";
	}

}
