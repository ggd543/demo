package com.taobao.api.request;

import java.util.Map;
import java.util.Date;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.TaobaoRequest;

/**
 * TOP API: taobao.warehouse.inventory.warnline.update request
 * 
 * @author auto create
 * @since 1.0, 2010-10-21 08:44:26.0
 */
public class WarehouseInventoryWarnlineUpdateRequest implements TaobaoRequest {
	private Long timestamp;	
	private TaobaoHashMap textParams = new TaobaoHashMap();


	
	/** 
	 * 库存id列表，形式如"111,222,333,444"的库存id列表，可以根据taobao.warehouse.inventories.get接口得到,每个id必须为数值型
	 **/
	private String inventoryIds;
	
	/** 
	 * 库存警戒值列表,形式如"11，22，33，44"的警戒值列表，每个id必须为数值型
	 **/
	private String warnValues;

	public void setInventoryIds(String inventoryIds) {
		this.inventoryIds = inventoryIds;
	}
	 public String getInventoryIds() {
		return this.inventoryIds;
	}
	public void setWarnValues(String warnValues) {
		this.warnValues = warnValues;
	}
	 public String getWarnValues() {
		return this.warnValues;
	}
	
	public String getApiMethodName() {
		return "taobao.warehouse.inventory.warnline.update";
	}

	public Map<String, String> getTextParams() {		
		textParams.put("inventory_ids", this.inventoryIds);
		textParams.put("warn_values", this.warnValues);
		return textParams;
	}
	
	public Long getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
}
