package com.taobao.api.response;

import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.domain.ProductImg;


import com.taobao.api.TaobaoResponse;

/**
 * TOP API: taobao.product.img.delete response
 * 
 * @author auto create
 * @since 1.0,2010-08-03 15:59:21.0
 */
public class ProductImgDeleteResponse extends TaobaoResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3296266611813513666L;

	
	/** 
	 * 返回productimg中的：id,product_id
	 **/
	@ApiField("product_img")
	private ProductImg productImg;

	public void setProductImg(ProductImg productImg) {
		this.productImg = productImg;
	}

	public ProductImg getProductImg( ) {
		return this.productImg;
	}

	public String getApiMethodName() {
		return "taobao.product.img.delete";
	}

}
