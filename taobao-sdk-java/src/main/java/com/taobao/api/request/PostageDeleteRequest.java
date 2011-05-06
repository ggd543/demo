package com.taobao.api.request;

import java.util.Map;
import java.util.Date;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.TaobaoRequest;

/**
 * TOP API: taobao.postage.delete request
 * 
 * @author auto create
 * @since 1.0, 2010-08-03 14:55:10.0
 */
public class PostageDeleteRequest implements TaobaoRequest {
	private Long timestamp;	
	private TaobaoHashMap textParams = new TaobaoHashMap();


	
	/** 
	 * 邮费模板id
	 **/
	private Long postageId;

	public void setPostageId(Long postageId) {
		this.postageId = postageId;
	}
	 public Long getPostageId() {
		return this.postageId;
	}
	
	public String getApiMethodName() {
		return "taobao.postage.delete";
	}

	public Map<String, String> getTextParams() {		
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
