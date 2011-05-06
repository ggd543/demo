package com.taobao.api.request;

import java.util.Map;
import java.util.Date;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.TaobaoRequest;

/**
 * TOP API: taobao.item.skus.get request
 * 
 * @author auto create
 * @since 1.0, 2010-11-12 10:27:52.0
 */
public class ItemSkusGetRequest implements TaobaoRequest {
	private Long timestamp;	
	private TaobaoHashMap textParams = new TaobaoHashMap();


	
	/** 
	 * 需返回的字段列表。可选值：Sku结构体中的所有字段；字段之间用“,”分隔。
	 **/
	private String fields;
	
	/** 
	 * sku所属商品数字id，　必选
	 **/
	private String numIids;

	public void setFields(String fields) {
		this.fields = fields;
	}
	 public String getFields() {
		return this.fields;
	}
	public void setNumIids(String numIids) {
		this.numIids = numIids;
	}
	 public String getNumIids() {
		return this.numIids;
	}
	
	public String getApiMethodName() {
		return "taobao.item.skus.get";
	}

	public Map<String, String> getTextParams() {		
		textParams.put("fields", this.fields);
		textParams.put("num_iids", this.numIids);
		return textParams;
	}
	
	public Long getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
}
