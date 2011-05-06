package com.taobao.api.request;

import java.util.Map;
import java.util.Date;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.TaobaoRequest;

/**
 * TOP API: taobao.increment.subscribemessage.get request
 * 
 * @author auto create
 * @since 1.0, 2010-09-17 12:01:37.0
 */
public class IncrementSubscribemessageGetRequest implements TaobaoRequest {
	private Long timestamp;	
	private TaobaoHashMap textParams = new TaobaoHashMap();


	
	/** 
	 * 需要返回的字段。具体字段间SubscribeMessage说明
	 **/
	private String fields;

	public void setFields(String fields) {
		this.fields = fields;
	}
	 public String getFields() {
		return this.fields;
	}
	
	public String getApiMethodName() {
		return "taobao.increment.subscribemessage.get";
	}

	public Map<String, String> getTextParams() {		
		textParams.put("fields", this.fields);
		return textParams;
	}
	
	public Long getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
}
