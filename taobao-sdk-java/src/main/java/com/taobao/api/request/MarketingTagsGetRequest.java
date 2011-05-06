package com.taobao.api.request;

import java.util.Map;
import java.util.Date;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.TaobaoRequest;

/**
 * TOP API: taobao.marketing.tags.get request
 * 
 * @author auto create
 * @since 1.0, 2010-11-18 16:51:13.0
 */
public class MarketingTagsGetRequest implements TaobaoRequest {
	private Long timestamp;	
	private TaobaoHashMap textParams = new TaobaoHashMap();


	
	/** 
	 * 需要的返回字段，可选值为UserTag中所有字段
	 **/
	private String fields;

	public void setFields(String fields) {
		this.fields = fields;
	}
	 public String getFields() {
		return this.fields;
	}
	
	public String getApiMethodName() {
		return "taobao.marketing.tags.get";
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
