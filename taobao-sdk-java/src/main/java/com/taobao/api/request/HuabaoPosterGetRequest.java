package com.taobao.api.request;

import java.util.Map;
import java.util.Date;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.TaobaoRequest;

/**
 * TOP API: taobao.huabao.poster.get request
 * 
 * @author auto create
 * @since 1.0, 2010-11-26 09:49:05.0
 */
public class HuabaoPosterGetRequest implements TaobaoRequest {
	private Long timestamp;	
	private TaobaoHashMap textParams = new TaobaoHashMap();


	
	/** 
	 * 画报的Id值
	 **/
	private Long posterId;

	public void setPosterId(Long posterId) {
		this.posterId = posterId;
	}
	 public Long getPosterId() {
		return this.posterId;
	}
	
	public String getApiMethodName() {
		return "taobao.huabao.poster.get";
	}

	public Map<String, String> getTextParams() {		
		textParams.put("poster_id", this.posterId);
		return textParams;
	}
	
	public Long getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
}
