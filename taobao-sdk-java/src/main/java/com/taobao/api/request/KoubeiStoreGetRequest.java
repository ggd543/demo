package com.taobao.api.request;

import java.util.Map;
import java.util.Date;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.TaobaoRequest;

/**
 * TOP API: taobao.koubei.store.get request
 * 
 * @author auto create
 * @since 1.0, 2010-12-02 12:57:34.0
 */
public class KoubeiStoreGetRequest implements TaobaoRequest {
	private Long timestamp;	
	private TaobaoHashMap textParams = new TaobaoHashMap();


	
	/** 
	 * 城市id
	 **/
	private Long cityId;
	
	/** 
	 * 店铺id
	 **/
	private String storeId;

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}
	 public Long getCityId() {
		return this.cityId;
	}
	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}
	 public String getStoreId() {
		return this.storeId;
	}
	
	public String getApiMethodName() {
		return "taobao.koubei.store.get";
	}

	public Map<String, String> getTextParams() {		
		textParams.put("city_id", this.cityId);
		textParams.put("store_id", this.storeId);
		return textParams;
	}
	
	public Long getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
}
