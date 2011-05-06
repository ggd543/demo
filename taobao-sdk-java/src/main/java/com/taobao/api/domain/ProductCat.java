package com.taobao.api.domain;

import com.taobao.api.internal.mapping.ApiClass;
import com.taobao.api.internal.mapping.ApiField;


import com.taobao.api.TaobaoObject;

/**
 * ProductCat Data Structure.
 * 
 * DESC：产品线 
 *
 * @author auto create
 * @since 1.0, 2010-04-25 17:00:40.0
 */
@ApiClass("ProductCat")
public class ProductCat extends TaobaoObject {

	private static final long serialVersionUID = 3525511862748984583L;

	
	/** 
	 * 产品线ID
	 **/
	@ApiField("id")
	private String id;

	
	/** 
	 * 产品线名称
	 **/
	@ApiField("name")
	private String name;

	
	/** 
	 * 产品数量
	 **/
	@ApiField("product_num")
	private Long productNum;

	public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Long getProductNum() {
		return this.productNum;
	}
	public void setProductNum(Long productNum) {
		this.productNum = productNum;
	}

}
