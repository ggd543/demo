package com.taobao.api.request;

import java.util.Map;
import java.util.Date;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.TaobaoRequest;

/**
 * TOP API: taobao.koubei.user.get request
 * 
 * @author auto create
 * @since 1.0, 2010-12-02 12:57:48.0
 */
public class KoubeiUserGetRequest implements TaobaoRequest {
	private Long timestamp;	
	private TaobaoHashMap textParams = new TaobaoHashMap();


	
	/** 
	 * 会员的ID号
	 **/
	private String userId;

	public void setUserId(String userId) {
		this.userId = userId;
	}
	 public String getUserId() {
		return this.userId;
	}
	
	public String getApiMethodName() {
		return "taobao.koubei.user.get";
	}

	public Map<String, String> getTextParams() {		
		textParams.put("user_id", this.userId);
		return textParams;
	}
	
	public Long getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
}
