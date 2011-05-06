package com.taobao.api.domain;

import com.taobao.api.internal.mapping.ApiClass;
import com.taobao.api.internal.mapping.ApiField;


import com.taobao.api.TaobaoObject;

/**
 * FenxiaoSku Data Structure.
 * 
 * DESC：分销产品 
 *
 * @author auto create
 * @since 1.0, 2010-04-23 22:27:41.0
 */
@ApiClass("FenxiaoSku")
public class FenxiaoSku extends TaobaoObject {

	private static final long serialVersionUID = 2313655633531514831L;

	
	/** 
	 * 采购价格，单位：元
	 **/
	@ApiField("cost_price")
	private String costPrice;

	
	/** 
	 * SkuID
	 **/
	@ApiField("id")
	private String id;

	
	/** 
	 * 名称
	 **/
	@ApiField("name")
	private String name;

	
	/** 
	 * 商家编码
	 **/
	@ApiField("outer_id")
	private String outerId;

	
	/** 
	 * 库存
	 **/
	@ApiField("quantity")
	private String quantity;

	public String getCostPrice() {
		return this.costPrice;
	}
	public void setCostPrice(String costPrice) {
		this.costPrice = costPrice;
	}

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

	public String getOuterId() {
		return this.outerId;
	}
	public void setOuterId(String outerId) {
		this.outerId = outerId;
	}

	public String getQuantity() {
		return this.quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

}
