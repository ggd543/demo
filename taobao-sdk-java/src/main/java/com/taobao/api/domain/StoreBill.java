package com.taobao.api.domain;

import com.taobao.api.internal.mapping.ApiClass;
import com.taobao.api.internal.mapping.ApiField;


import com.taobao.api.TaobaoObject;

/**
 * StoreBill Data Structure.
 * 
 * DESC：仓储费用结构 
 *
 * @author auto create
 * @since 1.0, 2010-04-23 22:07:27.0
 */
@ApiClass("StoreBill")
public class StoreBill extends TaobaoObject {

	private static final long serialVersionUID = 8853469242749161557L;

	
	/** 
	 * 运费, 以分为单位.
	 **/
	@ApiField("carriage_costs")
	private String carriageCosts;

	
	/** 
	 * 订单处理费, 以分为单位.
	 **/
	@ApiField("order_costs")
	private String orderCosts;

	
	/** 
	 * 仓库租赁费, 以分为单位.
	 **/
	@ApiField("rend_costs")
	private String rendCosts;

	
	/** 
	 * 自定义仓库id
	 **/
	@ApiField("seller_store_id")
	private String sellerStoreId;

	public String getCarriageCosts() {
		return this.carriageCosts;
	}
	public void setCarriageCosts(String carriageCosts) {
		this.carriageCosts = carriageCosts;
	}

	public String getOrderCosts() {
		return this.orderCosts;
	}
	public void setOrderCosts(String orderCosts) {
		this.orderCosts = orderCosts;
	}

	public String getRendCosts() {
		return this.rendCosts;
	}
	public void setRendCosts(String rendCosts) {
		this.rendCosts = rendCosts;
	}

	public String getSellerStoreId() {
		return this.sellerStoreId;
	}
	public void setSellerStoreId(String sellerStoreId) {
		this.sellerStoreId = sellerStoreId;
	}

}
