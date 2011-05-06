package com.taobao.api.request;

import java.util.Map;
import java.util.Date;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.TaobaoRequest;

/**
 * TOP API: taobao.huabao.specialposters.get request
 * 
 * @author auto create
 * @since 1.0, 2010-11-26 09:44:04.0
 */
public class HuabaoSpecialpostersGetRequest implements TaobaoRequest {
	private Long timestamp;	
	private TaobaoHashMap textParams = new TaobaoHashMap();


	
	/** 
	 * 频道Id
	 **/
	private String channelIds;
	
	/** 
	 * 返回的记录数，默认10条，最多20条，如果请求超过20或者小于等于0，则按10条返回
	 **/
	private Long number;
	
	/** 
	 * 类型可选：HOT(热门），RECOMMEND（推荐）
	 **/
	private String type;

	public void setChannelIds(String channelIds) {
		this.channelIds = channelIds;
	}
	 public String getChannelIds() {
		return this.channelIds;
	}
	public void setNumber(Long number) {
		this.number = number;
	}
	 public Long getNumber() {
		return this.number;
	}
	public void setType(String type) {
		this.type = type;
	}
	 public String getType() {
		return this.type;
	}
	
	public String getApiMethodName() {
		return "taobao.huabao.specialposters.get";
	}

	public Map<String, String> getTextParams() {		
		textParams.put("channel_ids", this.channelIds);
		textParams.put("number", this.number);
		textParams.put("type", this.type);
		return textParams;
	}
	
	public Long getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
}
