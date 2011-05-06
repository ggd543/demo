package com.taobao.api.request;

import java.util.Map;
import java.util.Date;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.TaobaoRequest;

/**
 * TOP API: taobao.warehouse.sellerstores.get request
 * 
 * @author auto create
 * @since 1.0, 2010-10-21 08:46:27.0
 */
public class WarehouseSellerstoresGetRequest implements TaobaoRequest {
	private Long timestamp;	
	private TaobaoHashMap textParams = new TaobaoHashMap();


	
	/** 
	 * 自定义仓库状态，如果不传，则返回所有
	 **/
	private String status;

	public void setStatus(String status) {
		this.status = status;
	}
	 public String getStatus() {
		return this.status;
	}
	
	public String getApiMethodName() {
		return "taobao.warehouse.sellerstores.get";
	}

	public Map<String, String> getTextParams() {		
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
