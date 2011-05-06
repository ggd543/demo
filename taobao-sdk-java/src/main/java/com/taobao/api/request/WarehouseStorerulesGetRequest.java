package com.taobao.api.request;

import java.util.Map;
import java.util.Date;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.TaobaoRequest;

/**
 * TOP API: taobao.warehouse.storerules.get request
 * 
 * @author auto create
 * @since 1.0, 2010-11-23 17:15:45.0
 */
public class WarehouseStorerulesGetRequest implements TaobaoRequest {
	private Long timestamp;	
	private TaobaoHashMap textParams = new TaobaoHashMap();


	

	
	
	public String getApiMethodName() {
		return "taobao.warehouse.storerules.get";
	}

	public Map<String, String> getTextParams() {		
		
		return textParams;
	}
	
	public Long getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
}
