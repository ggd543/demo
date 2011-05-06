package com.taobao.api.request;

import java.util.Map;
import java.util.Date;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.TaobaoRequest;

/**
 * TOP API: taobao.koubei.city.subs.get request
 * 
 * @author auto create
 * @since 1.0, 2010-12-02 12:56:17.0
 */
public class KoubeiCitySubsGetRequest implements TaobaoRequest {
	private Long timestamp;	
	private TaobaoHashMap textParams = new TaobaoHashMap();


	
	/** 
	 * 口碑的城市ID
	 **/
	private Long id;

	public void setId(Long id) {
		this.id = id;
	}
	 public Long getId() {
		return this.id;
	}
	
	public String getApiMethodName() {
		return "taobao.koubei.city.subs.get";
	}

	public Map<String, String> getTextParams() {		
		textParams.put("id", this.id);
		return textParams;
	}
	
	public Long getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
}
