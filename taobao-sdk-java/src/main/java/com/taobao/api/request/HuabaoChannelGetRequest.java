package com.taobao.api.request;

import java.util.Map;
import java.util.Date;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.TaobaoRequest;

/**
 * TOP API: taobao.huabao.channel.get request
 * 
 * @author auto create
 * @since 1.0, 2010-11-26 11:03:23.0
 */
public class HuabaoChannelGetRequest implements TaobaoRequest {
	private Long timestamp;	
	private TaobaoHashMap textParams = new TaobaoHashMap();


	
	/** 
	 * 频道Id
	 **/
	private Long channelId;

	public void setChannelId(Long channelId) {
		this.channelId = channelId;
	}
	 public Long getChannelId() {
		return this.channelId;
	}
	
	public String getApiMethodName() {
		return "taobao.huabao.channel.get";
	}

	public Map<String, String> getTextParams() {		
		textParams.put("channel_id", this.channelId);
		return textParams;
	}
	
	public Long getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
}
