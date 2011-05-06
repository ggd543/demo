package com.taobao.api.domain;

import com.taobao.api.internal.mapping.ApiClass;
import com.taobao.api.internal.mapping.ApiField;


import com.taobao.api.TaobaoObject;

/**
 * ItemCategory Data Structure.
 * 
 * DESC：商品查询分类结果 
 *
 * @author auto create
 * @since 1.0, 2010-04-22 18:56:59.0
 */
@ApiClass("ItemCategory")
public class ItemCategory extends TaobaoObject {

	private static final long serialVersionUID = 6818514483476265611L;

	
	/** 
	 * 分类ID
	 **/
	@ApiField("category_id")
	private Long categoryId;

	
	/** 
	 * 商品数量
	 **/
	@ApiField("count")
	private Long count;

	public Long getCategoryId() {
		return this.categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public Long getCount() {
		return this.count;
	}
	public void setCount(Long count) {
		this.count = count;
	}

}
