package com.taobao.api.request;

import java.util.Map;
import java.util.Date;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.TaobaoRequest;

/**
 * TOP API: taobao.warehouse.inventorylog.get request
 * 
 * @author auto create
 * @since 1.0, 2010-10-21 08:48:29.0
 */
public class WarehouseInventorylogGetRequest implements TaobaoRequest {
	private Long timestamp;	
	private TaobaoHashMap textParams = new TaobaoHashMap();


	
	/** 
	 * 库存变更id,可以根据taobao.warehouse.inventorylogs.get接口得到
	 **/
	private String inventoryLogId;

	public void setInventoryLogId(String inventoryLogId) {
		this.inventoryLogId = inventoryLogId;
	}
	 public String getInventoryLogId() {
		return this.inventoryLogId;
	}
	
	public String getApiMethodName() {
		return "taobao.warehouse.inventorylog.get";
	}

	public Map<String, String> getTextParams() {		
		textParams.put("inventory_log_id", this.inventoryLogId);
		return textParams;
	}
	
	public Long getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
}
