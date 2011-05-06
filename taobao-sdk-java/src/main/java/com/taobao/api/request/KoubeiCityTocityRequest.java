package com.taobao.api.request;

import java.util.Map;
import java.util.Date;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.TaobaoRequest;

/**
 * TOP API: taobao.koubei.city.tocity request
 * 
 * @author auto create
 * @since 1.0, 2010-12-02 12:56:35.0
 */
public class KoubeiCityTocityRequest implements TaobaoRequest {
	private Long timestamp;	
	private TaobaoHashMap textParams = new TaobaoHashMap();


	
	/** 
	 * 口碑的城市ID,优先根据ID取城市，再根据name取
	 **/
	private Long id;
	
	/** 
	 * 城市名
	 **/
	private String name;

	public void setId(Long id) {
		this.id = id;
	}
	 public Long getId() {
		return this.id;
	}
	public void setName(String name) {
		this.name = name;
	}
	 public String getName() {
		return this.name;
	}
	
	public String getApiMethodName() {
		return "taobao.koubei.city.tocity";
	}

	public Map<String, String> getTextParams() {		
		textParams.put("id", this.id);
		textParams.put("name", this.name);
		return textParams;
	}
	
	public Long getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
}
