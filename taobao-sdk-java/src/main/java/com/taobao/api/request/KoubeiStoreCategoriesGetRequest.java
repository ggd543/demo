package com.taobao.api.request;

import java.util.Map;
import java.util.Date;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.TaobaoRequest;

/**
 * TOP API: taobao.koubei.store.categories.get request
 * 
 * @author auto create
 * @since 1.0, 2010-12-02 12:58:01.0
 */
public class KoubeiStoreCategoriesGetRequest implements TaobaoRequest {
	private Long timestamp;	
	private TaobaoHashMap textParams = new TaobaoHashMap();


	
	/** 
	 * 类目id，根类目id为0
	 **/
	private Long cateId;

	public void setCateId(Long cateId) {
		this.cateId = cateId;
	}
	 public Long getCateId() {
		return this.cateId;
	}
	
	public String getApiMethodName() {
		return "taobao.koubei.store.categories.get";
	}

	public Map<String, String> getTextParams() {		
		textParams.put("cate_id", this.cateId);
		return textParams;
	}
	
	public Long getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
}
