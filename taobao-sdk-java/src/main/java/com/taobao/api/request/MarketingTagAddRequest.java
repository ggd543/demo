package com.taobao.api.request;

import java.util.Map;
import java.util.Date;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.TaobaoRequest;

/**
 * TOP API: taobao.marketing.tag.add request
 * 
 * @author auto create
 * @since 1.0, 2010-11-18 16:50:33.0
 */
public class MarketingTagAddRequest implements TaobaoRequest {
	private Long timestamp;	
	private TaobaoHashMap textParams = new TaobaoHashMap();


	
	/** 
	 * 标签用途描述
	 **/
	private String description;
	
	/** 
	 * 标签名称
	 **/
	private String tagName;

	public void setDescription(String description) {
		this.description = description;
	}
	 public String getDescription() {
		return this.description;
	}
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
	 public String getTagName() {
		return this.tagName;
	}
	
	public String getApiMethodName() {
		return "taobao.marketing.tag.add";
	}

	public Map<String, String> getTextParams() {		
		textParams.put("description", this.description);
		textParams.put("tag_name", this.tagName);
		return textParams;
	}
	
	public Long getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
}
