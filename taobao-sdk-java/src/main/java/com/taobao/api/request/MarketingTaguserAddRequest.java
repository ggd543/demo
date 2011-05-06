package com.taobao.api.request;

import java.util.Map;
import java.util.Date;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.TaobaoRequest;

/**
 * TOP API: taobao.marketing.taguser.add request
 * 
 * @author auto create
 * @since 1.0, 2010-11-18 16:51:30.0
 */
public class MarketingTaguserAddRequest implements TaobaoRequest {
	private Long timestamp;	
	private TaobaoHashMap textParams = new TaobaoHashMap();


	
	/** 
	 * 淘宝会员昵称
	 **/
	private String nick;
	
	/** 
	 * 标签ID
	 **/
	private Long tagId;

	public void setNick(String nick) {
		this.nick = nick;
	}
	 public String getNick() {
		return this.nick;
	}
	public void setTagId(Long tagId) {
		this.tagId = tagId;
	}
	 public Long getTagId() {
		return this.tagId;
	}
	
	public String getApiMethodName() {
		return "taobao.marketing.taguser.add";
	}

	public Map<String, String> getTextParams() {		
		textParams.put("nick", this.nick);
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
