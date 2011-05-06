package com.taobao.api.request;

import java.util.Map;
import java.util.Date;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.TaobaoRequest;

/**
 * TOP API: taobao.shop.update request
 * 
 * @author auto create
 * @since 1.0, 2010-08-04 18:41:48.0
 */
public class ShopUpdateRequest implements TaobaoRequest {
	private Long timestamp;	
	private TaobaoHashMap textParams = new TaobaoHashMap();


	
	/** 
	 * 店铺公告。不超过1024个字符
	 **/
	private String bulletin;
	
	/** 
	 * 店铺描述。10～2000个字符以内
	 **/
	private String desc;
	
	/** 
	 * 店铺标题。不超过30个字符；过滤敏感词，如淘咖啡、阿里巴巴等。title, bulletin和desc至少必须传一个
	 **/
	private String title;

	public void setBulletin(String bulletin) {
		this.bulletin = bulletin;
	}
	 public String getBulletin() {
		return this.bulletin;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	 public String getDesc() {
		return this.desc;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	 public String getTitle() {
		return this.title;
	}
	
	public String getApiMethodName() {
		return "taobao.shop.update";
	}

	public Map<String, String> getTextParams() {		
		textParams.put("bulletin", this.bulletin);
		textParams.put("desc", this.desc);
		textParams.put("title", this.title);
		return textParams;
	}
	
	public Long getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
}
