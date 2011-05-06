package com.taobao.api.response;

import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.domain.ItemImg;


import com.taobao.api.TaobaoResponse;

/**
 * TOP API: taobao.item.img.delete response
 * 
 * @author auto create
 * @since 1.0,2010-11-16 19:31:27.0
 */
public class ItemImgDeleteResponse extends TaobaoResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7468739791416249388L;

	
	/** 
	 * 商品图片结构
	 **/
	@ApiField("item_img")
	private ItemImg itemImg;

	public void setItemImg(ItemImg itemImg) {
		this.itemImg = itemImg;
	}

	public ItemImg getItemImg( ) {
		return this.itemImg;
	}

	public String getApiMethodName() {
		return "taobao.item.img.delete";
	}

}
