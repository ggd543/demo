package com.taobao.api.request;

import java.util.Map;
import java.util.Date;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.TaobaoRequest;

/**
 * TOP API: taobao.warehouse.storerule.save request
 * 
 * @author auto create
 * @since 1.0, 2010-10-21 08:44:10.0
 */
public class WarehouseStoreruleSaveRequest implements TaobaoRequest {
	private Long timestamp;	
	private TaobaoHashMap textParams = new TaobaoHashMap();


	
	/** 
	 * 发货规则中的备用仓库
	 **/
	private Long backSellerStoreId;
	
	/** 
	 * 仓库覆盖地区代码.如"310000,320000"代表"上海 江苏".地区代码可调用 taobao.areas.get 获取.
	 **/
	private String provAreaIds;
	
	/** 
	 * 要设置发货规则的自定义仓库的id,可调用 taobao.warehouse.sellerstores.get 获取.
	 **/
	private Long sellerStoreId;

	public void setBackSellerStoreId(Long backSellerStoreId) {
		this.backSellerStoreId = backSellerStoreId;
	}
	 public Long getBackSellerStoreId() {
		return this.backSellerStoreId;
	}
	public void setProvAreaIds(String provAreaIds) {
		this.provAreaIds = provAreaIds;
	}
	 public String getProvAreaIds() {
		return this.provAreaIds;
	}
	public void setSellerStoreId(Long sellerStoreId) {
		this.sellerStoreId = sellerStoreId;
	}
	 public Long getSellerStoreId() {
		return this.sellerStoreId;
	}
	
	public String getApiMethodName() {
		return "taobao.warehouse.storerule.save";
	}

	public Map<String, String> getTextParams() {		
		textParams.put("back_seller_store_id", this.backSellerStoreId);
		textParams.put("prov_area_ids", this.provAreaIds);
		textParams.put("seller_store_id", this.sellerStoreId);
		return textParams;
	}
	
	public Long getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
}
