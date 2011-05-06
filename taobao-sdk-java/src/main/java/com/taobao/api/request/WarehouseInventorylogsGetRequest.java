package com.taobao.api.request;

import java.util.Map;
import java.util.Date;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.TaobaoRequest;

/**
 * TOP API: taobao.warehouse.inventorylogs.get request
 * 
 * @author auto create
 * @since 1.0, 2010-10-21 08:48:44.0
 */
public class WarehouseInventorylogsGetRequest implements TaobaoRequest {
	private Long timestamp;	
	private TaobaoHashMap textParams = new TaobaoHashMap();


	
	/** 
	 * 库存记录id,可从taobao.warehouse.inventories.get获
	 **/
	private Long inventoryId;
	
	/** 
	 * 库存变更状态,可选值: UNCONFIRMED(待确认) ,CONFIRMED(已确认)
	 **/
	private String status;

	public void setInventoryId(Long inventoryId) {
		this.inventoryId = inventoryId;
	}
	 public Long getInventoryId() {
		return this.inventoryId;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	 public String getStatus() {
		return this.status;
	}
	
	public String getApiMethodName() {
		return "taobao.warehouse.inventorylogs.get";
	}

	public Map<String, String> getTextParams() {		
		textParams.put("inventory_id", this.inventoryId);
		textParams.put("status", this.status);
		return textParams;
	}
	
	public Long getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
}
