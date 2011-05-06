package com.taobao.api.request;

import java.util.Map;
import java.util.Date;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.TaobaoRequest;

/**
 * TOP API: taobao.user.get request
 * 
 * @author auto create
 * @since 1.0, 2010-09-15 11:35:04.0
 */
public class UserGetRequest implements TaobaoRequest {
	private Long timestamp;	
	private TaobaoHashMap textParams = new TaobaoHashMap();


	
	/** 
	 * 需返回的字段列表。可选值：User结构体中的所有字段；以半角逗号(,)分隔。不支持：地址，真实姓名，身份证，手机，电话，邮箱
	 **/
	private String fields;
	
	/** 
	 * 用户昵称，如果昵称为中文，请使用UTF-8字符集对昵称进行URL编码。
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
		return "taobao.user.get";
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
