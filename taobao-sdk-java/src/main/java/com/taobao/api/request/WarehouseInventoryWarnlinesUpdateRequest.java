package com.taobao.api.request;

import java.util.Map;
import java.util.Date;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.TaobaoRequest;

/**
 * TOP API: taobao.warehouse.inventory.warnlines.update request
 * 
 * @author auto create
 * @since 1.0, 2010-10-21 08:45:57.0
 */
public class WarehouseInventoryWarnlinesUpdateRequest implements TaobaoRequest {
	private Long timestamp;	
	private TaobaoHashMap textParams = new TaobaoHashMap();


	
	/** 
	 * 库存警戒值
	 **/
	private Long warnValue;

	public void setWarnValue(Long warnValue) {
		this.warnValue = warnValue;
	}
	 public Long getWarnValue() {
		return this.warnValue;
	}
	
	public String getApiMethodName() {
		return "taobao.warehouse.inventory.warnlines.update";
	}

	public Map<String, String> getTextParams() {		
		textParams.put("warn_value", this.warnValue);
		return textParams;
	}
	
	public Long getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
}
