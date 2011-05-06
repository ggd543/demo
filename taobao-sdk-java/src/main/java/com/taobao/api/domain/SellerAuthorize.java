package com.taobao.api.domain;

import java.util.List;
import com.taobao.api.internal.mapping.ApiClass;
import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.internal.mapping.ApiListField;


import com.taobao.api.TaobaoObject;

/**
 * SellerAuthorize Data Structure.
 * 
 * DESC：授权 
 *
 * @author auto create
 * @since 1.0, 2010-09-08 13:38:15.0
 */
@ApiClass("SellerAuthorize")
public class SellerAuthorize extends TaobaoObject {

	private static final long serialVersionUID = 4753563631423954335L;

	
	/** 
	 * 品牌列表
	 **/
	@ApiListField("brands")
	@ApiField("brand")
	private List<Brand> brands;

	
	/** 
	 * 类目列表
	 **/
	@ApiListField("item_cats")
	@ApiField("item_cat")
	private List<ItemCat> itemCats;

	public List<Brand> getBrands() {
		return this.brands;
	}
	public void setBrands(List<Brand> brands) {
		this.brands = brands;
	}

	public List<ItemCat> getItemCats() {
		return this.itemCats;
	}
	public void setItemCats(List<ItemCat> itemCats) {
		this.itemCats = itemCats;
	}

}
