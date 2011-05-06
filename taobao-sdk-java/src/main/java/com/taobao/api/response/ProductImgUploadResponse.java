package com.taobao.api.response;

import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.domain.ProductImg;


import com.taobao.api.TaobaoResponse;

/**
 * TOP API: taobao.product.img.upload response
 * 
 * @author auto create
 * @since 1.0,2010-08-03 15:57:44.0
 */
public class ProductImgUploadResponse extends TaobaoResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6868359985786116922L;

	
	/** 
	 * 返回产品图片结构中的：url,id,created,modified
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
		return "taobao.product.img.upload";
	}

}
