package com.taobao.api.request;

import java.util.Map;
import java.util.Date;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.TaobaoRequest;

/**
 * TOP API: taobao.postages.get request
 * 
 * @author auto create
 * @since 1.0, 2010-08-19 19:27:14.0
 */
public class PostagesGetRequest implements TaobaoRequest {
	private Long timestamp;	
	private TaobaoHashMap textParams = new TaobaoHashMap();


	
	/** 
	 * 需返回的字段列表.可选值:Postage结构体中的所有字段;字段之间用","分隔.
	 **/
	private String fields;

	public void setFields(String fields) {
		this.fields = fields;
	}
	 public String getFields() {
		return this.fields;
	}
	
	public String getApiMethodName() {
		return "taobao.postages.get";
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
