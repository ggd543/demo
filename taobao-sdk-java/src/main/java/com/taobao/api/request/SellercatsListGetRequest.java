package com.taobao.api.request;

import java.util.Map;
import java.util.Date;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.TaobaoRequest;

/**
 * TOP API: taobao.sellercats.list.get request
 * 
 * @author auto create
 * @since 1.0, 2010-08-05 12:41:49.0
 */
public class SellercatsListGetRequest implements TaobaoRequest {
	private Long timestamp;	
	private TaobaoHashMap textParams = new TaobaoHashMap();


	
	/** 
	 * fields参数
	 **/
	private String fields;
	
	/** 
	 * 卖家昵称
	 **/
	private String nick;

	public void setFields(String fields) {
		this.fields = fields;
	}
	 public String getFields() {
		return this.fields;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	 public String getNick() {
		return this.nick;
	}
	
	public String getApiMethodName() {
		return "taobao.sellercats.list.get";
	}

	public Map<String, String> getTextParams() {		
		textParams.put("fields", this.fields);
		textParams.put("nick", this.nick);
		return textParams;
	}
	
	public Long getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
}
