package com.taobao.api.request;

import java.util.Map;
import java.util.Date;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.TaobaoRequest;

/**
 * TOP API: taobao.appstore.subscribe.get request
 * 
 * @author auto create
 * @since 1.0, 2010-07-27 14:43:11.0
 */
public class AppstoreSubscribeGetRequest implements TaobaoRequest {
	private Long timestamp;	
	private TaobaoHashMap textParams = new TaobaoHashMap();

	/** 
	 * 插件实例ID
	 **/
	private Long leaseId;
	
	/** 
	 * 用户昵称
	 **/
	private String nick;

	public void setLeaseId(Long leaseId) {
		this.leaseId = leaseId;
	}
	 public Long getLeaseId() {
		return this.leaseId;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	 public String getNick() {
		return this.nick;
	}
	
	public String getApiMethodName() {
		return "taobao.appstore.subscribe.get";
	}

	public Map<String, String> getTextParams() {		
		textParams.put("lease_id", this.leaseId);
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
