package com.taobao.api.domain;

import com.taobao.api.internal.mapping.ApiClass;
import com.taobao.api.internal.mapping.ApiField;


import com.taobao.api.TaobaoObject;

/**
 * ItemCat Data Structure.
 * 
 * DESC：商品类目结构 
 *
 * @author auto create
 * @since 1.0, 2010-04-22 14:10:52.0
 */
@ApiClass("ItemCat")
public class ItemCat extends TaobaoObject {

	private static final long serialVersionUID = 1248135317747333315L;

	
	/** 
	 * 商品所属类目ID
	 **/
	@ApiField("cid")
	private Long cid;

	
	/** 
	 * 该类目是否为父类目(即：该类目是否还有子类目)
	 **/
	@ApiField("is_parent")
	private Boolean isParent;

	
	/** 
	 * 类目名称
	 **/
	@ApiField("name")
	private String name;

	
	/** 
	 * 父类目ID=0时，代表的是一级的类目
	 **/
	@ApiField("parent_cid")
	private Long parentCid;

	
	/** 
	 * 排列序号，表示同级类目的展现次序，如数值相等则按名称次序排列。取值范围:大于零的整数
	 **/
	@ApiField("sort_order")
	private Long sortOrder;

	
	/** 
	 * 状态。可选值:normal(正常),deleted(删除)
	 **/
	@ApiField("status")
	private String status;

	public Long getCid() {
		return this.cid;
	}
	public void setCid(Long cid) {
		this.cid = cid;
	}

	public Boolean getIsParent() {
		return this.isParent;
	}
	public void setIsParent(Boolean isParent) {
		this.isParent = isParent;
	}

	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Long getParentCid() {
		return this.parentCid;
	}
	public void setParentCid(Long parentCid) {
		this.parentCid = parentCid;
	}

	public Long getSortOrder() {
		return this.sortOrder;
	}
	public void setSortOrder(Long sortOrder) {
		this.sortOrder = sortOrder;
	}

	public String getStatus() {
		return this.status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}
