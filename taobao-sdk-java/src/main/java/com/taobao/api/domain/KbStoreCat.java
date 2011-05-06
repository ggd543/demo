package com.taobao.api.domain;

import com.taobao.api.internal.mapping.ApiClass;
import com.taobao.api.internal.mapping.ApiField;


import com.taobao.api.TaobaoObject;

/**
 * KbStoreCat Data Structure.
 * 
 * DESC：店铺的分类对象，根节点ID为0，向下还有两个级别，比如：Root-餐饮美食-中餐馆 
 *
 * @author auto create
 * @since 1.0, 2010-05-17 14:03:51.0
 */
@ApiClass("KbStoreCat")
public class KbStoreCat extends TaobaoObject {

	private static final long serialVersionUID = 8586343936722436882L;

	
	/** 
	 * 分类等级
	 **/
	@ApiField("level")
	private Long level;

	
	/** 
	 * 类目的父级id
	 **/
	@ApiField("parent_id")
	private Long parentId;

	
	/** 
	 * 数字类型的ID
	 **/
	@ApiField("store_category_id")
	private Long storeCategoryId;

	
	/** 
	 * 分类名称
	 **/
	@ApiField("store_category_name")
	private String storeCategoryName;

	public Long getLevel() {
		return this.level;
	}
	public void setLevel(Long level) {
		this.level = level;
	}

	public Long getParentId() {
		return this.parentId;
	}
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public Long getStoreCategoryId() {
		return this.storeCategoryId;
	}
	public void setStoreCategoryId(Long storeCategoryId) {
		this.storeCategoryId = storeCategoryId;
	}

	public String getStoreCategoryName() {
		return this.storeCategoryName;
	}
	public void setStoreCategoryName(String storeCategoryName) {
		this.storeCategoryName = storeCategoryName;
	}

}
