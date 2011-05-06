package com.taobao.api.request;

import java.util.Map;
import java.util.Date;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.TaobaoRequest;

/**
 * TOP API: taobao.shopcats.list.get request
 * 
 * @author auto create
 * @since 1.0, 2010-08-03 15:50:09.0
 */
public class ShopcatsListGetRequest implements TaobaoRequest {
	private Long timestamp;	
	private TaobaoHashMap textParams = new TaobaoHashMap();


	
	/** 
	 * 需要返回的字段列表，见ShopCat，默认返回：cid,parent_cid,name,is_parent
	 **/
	private String fields;

	public void setFields(String fields) {
		this.fields = fields;
	}
	 public String getFields() {
		return this.fields;
	}
	
	public String getApiMethodName() {
		return "taobao.shopcats.list.get";
	}

	public Map<String, String> getTextParams() {		
		textParams.put("fields", this.fields);
		return textParams;
	}
	
	public Long getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
}
