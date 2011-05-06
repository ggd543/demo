package com.taobao.api.request;

import java.util.Map;
import java.util.Date;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.TaobaoRequest;

/**
 * TOP API: taobao.postage.get request
 * 
 * @author auto create
 * @since 1.0, 2010-08-04 18:43:05.0
 */
public class PostageGetRequest implements TaobaoRequest {
	private Long timestamp;	
	private TaobaoHashMap textParams = new TaobaoHashMap();


	
	/** 
	 * 需返回的字段列表.可选值:Postage结构体中的所有字段;字段之间用","隔开
	 **/
	private String fields;
	
	/** 
	 * 卖家昵称
	 **/
	private String nick;
	
	/** 
	 * 邮费模板id
	 **/
	private Long postageId;

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
	public void setPostageId(Long postageId) {
		this.postageId = postageId;
	}
	 public Long getPostageId() {
		return this.postageId;
	}
	
	public String getApiMethodName() {
		return "taobao.postage.get";
	}

	public Map<String, String> getTextParams() {		
		textParams.put("fields", this.fields);
		textParams.put("nick", this.nick);
		textParams.put("postage_id", this.postageId);
		return textParams;
	}
	
	public Long getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
}
