package com.taobao.api.request;

import java.util.Map;
import java.util.Date;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.TaobaoRequest;

/**
 * TOP API: taobao.warehouse.inventory.get request
 * 
 * @author auto create
 * @since 1.0, 2010-10-21 08:50:31.0
 */
public class WarehouseInventoryGetRequest implements TaobaoRequest {
	private Long timestamp;	
	private TaobaoHashMap textParams = new TaobaoHashMap();


	
	/** 
	 * 库存ID (可从taobao.warehouse.inventories.get取)
	 **/
	private Long inventoryId;

	public void setInventoryId(Long inventoryId) {
		this.inventoryId = inventoryId;
	}
	 public Long getInventoryId() {
		return this.inventoryId;
	}
	
	public String getApiMethodName() {
		return "taobao.warehouse.inventory.get";
	}

	public Map<String, String> getTextParams() {		
		textParams.put("inventory_id", this.inventoryId);
		return textParams;
	}
	
	public Long getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
}
