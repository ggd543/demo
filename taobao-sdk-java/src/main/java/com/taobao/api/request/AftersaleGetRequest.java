package com.taobao.api.request;

import java.util.Map;
import java.util.Date;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.TaobaoRequest;

/**
 * TOP API: taobao.aftersale.get request
 * 
 * @author auto create
 * @since 1.0, 2010-11-08 17:57:12.0
 */
public class AftersaleGetRequest implements TaobaoRequest {
	private Long timestamp;	
	private TaobaoHashMap textParams = new TaobaoHashMap();


	

	
	
	public String getApiMethodName() {
		return "taobao.aftersale.get";
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
