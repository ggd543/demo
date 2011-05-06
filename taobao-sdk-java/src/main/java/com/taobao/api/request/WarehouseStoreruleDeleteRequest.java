package com.taobao.api.request;

import java.util.Map;
import java.util.Date;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.TaobaoRequest;

/**
 * TOP API: taobao.warehouse.storerule.delete request
 * 
 * @author auto create
 * @since 1.0, 2010-10-21 08:46:58.0
 */
public class WarehouseStoreruleDeleteRequest implements TaobaoRequest {
	private Long timestamp;	
	private TaobaoHashMap textParams = new TaobaoHashMap();


	
	/** 
	 * 发货规则id
	 **/
	private String id;

	public void setId(String id) {
		this.id = id;
	}
	 public String getId() {
		return this.id;
	}
	
	public String getApiMethodName() {
		return "taobao.warehouse.storerule.delete";
	}

	public Map<String, String> getTextParams() {		
		textParams.put("id", this.id);
		return textParams;
	}
	
	public Long getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
}
