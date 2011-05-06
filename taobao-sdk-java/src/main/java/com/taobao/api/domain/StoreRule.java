package com.taobao.api.domain;

import com.taobao.api.internal.mapping.ApiClass;
import com.taobao.api.internal.mapping.ApiField;


import com.taobao.api.TaobaoObject;

/**
 * StoreRule Data Structure.
 * 
 * DESC：发货规则结构 
 *
 * @author auto create
 * @since 1.0, 2010-11-23 17:15:44.0
 */
@ApiClass("StoreRule")
public class StoreRule extends TaobaoObject {

	private static final long serialVersionUID = 5247791595397424663L;

	
	/** 
	 * 发货规则中的备用仓库ID
	 **/
	@ApiField("back_seller_store_id")
	private String backSellerStoreId;

	
	/** 
	 * 发货规则id
	 **/
	@ApiField("id")
	private Long id;

	
	/** 
	 * 自定义仓库附带地区ID串
	 **/
	@ApiField("prov_area_ids")
	private String provAreaIds;

	
	/** 
	 * 自定义仓库ID
	 **/
	@ApiField("seller_store_id")
	private Long sellerStoreId;

	public String getBackSellerStoreId() {
		return this.backSellerStoreId;
	}
	public void setBackSellerStoreId(String backSellerStoreId) {
		this.backSellerStoreId = backSellerStoreId;
	}

	public Long getId() {
		return this.id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getProvAreaIds() {
		return this.provAreaIds;
	}
	public void setProvAreaIds(String provAreaIds) {
		this.provAreaIds = provAreaIds;
	}

	public Long getSellerStoreId() {
		return this.sellerStoreId;
	}
	public void setSellerStoreId(Long sellerStoreId) {
		this.sellerStoreId = sellerStoreId;
	}

}
