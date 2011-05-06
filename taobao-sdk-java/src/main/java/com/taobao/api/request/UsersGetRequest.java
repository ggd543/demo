package com.taobao.api.request;

import java.util.Map;
import java.util.Date;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.TaobaoRequest;

/**
 * TOP API: taobao.users.get request
 * 
 * @author auto create
 * @since 1.0, 2010-11-16 13:30:32.0
 */
public class UsersGetRequest implements TaobaoRequest {
	private Long timestamp;	
	private TaobaoHashMap textParams = new TaobaoHashMap();


	
	/** 
	 * 查询字段：User数据结构的公开信息字段列表，以半角逗号(,)分隔
	 **/
	private String fields;
	
	/** 
	 * 用户昵称，多个以半角逗号(,)分隔，最多40个
	 **/
	private String nicks;

	public void setFields(String fields) {
		this.fields = fields;
	}
	 public String getFields() {
		return this.fields;
	}
	public void setNicks(String nicks) {
		this.nicks = nicks;
	}
	 public String getNicks() {
		return this.nicks;
	}
	
	public String getApiMethodName() {
		return "taobao.users.get";
	}

	public Map<String, String> getTextParams() {		
		textParams.put("fields", this.fields);
		textParams.put("nicks", this.nicks);
		return textParams;
	}
	
	public Long getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
}
