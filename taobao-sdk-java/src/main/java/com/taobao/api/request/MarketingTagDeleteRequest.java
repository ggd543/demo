package com.taobao.api.request;

import java.util.Map;
import java.util.Date;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.TaobaoRequest;

/**
 * TOP API: taobao.marketing.tag.delete request
 * 
 * @author auto create
 * @since 1.0, 2010-11-18 16:51:02.0
 */
public class MarketingTagDeleteRequest implements TaobaoRequest {
	private Long timestamp;	
	private TaobaoHashMap textParams = new TaobaoHashMap();


	
	/** 
	 * 标签ID
	 **/
	private Long tagId;

	public void setTagId(Long tagId) {
		this.tagId = tagId;
	}
	 public Long getTagId() {
		return this.tagId;
	}
	
	public String getApiMethodName() {
		return "taobao.marketing.tag.delete";
	}

	public Map<String, String> getTextParams() {		
		textParams.put("tag_id", this.tagId);
		return textParams;
	}
	
	public Long getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
}
