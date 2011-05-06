package com.taobao.api.request;

import java.util.Map;
import java.util.Date;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.TaobaoRequest;

/**
 * TOP API: taobao.items.custom.get request
 * 
 * @author auto create
 * @since 1.0, 2010-08-03 14:42:20.0
 */
public class ItemsCustomGetRequest implements TaobaoRequest {
	private Long timestamp;	
	private TaobaoHashMap textParams = new TaobaoHashMap();


	
	/** 
	 * 需返回的字段列表。可选值：Item商品结构体中的所有字段；多个字段之间用“,”分隔。如果想返回整个子对象，那字段为item_img，如果是想返回子对象里面的字段，那字段为item_img.url。新增返回字段：one_station标记商品是否淘1站商品
	 **/
	private String fields;
	
	/** 
	 * 商品的外部商品ID
	 **/
	private String outerId;

	public void setFields(String fields) {
		this.fields = fields;
	}
	 public String getFields() {
		return this.fields;
	}
	public void setOuterId(String outerId) {
		this.outerId = outerId;
	}
	 public String getOuterId() {
		return this.outerId;
	}
	
	public String getApiMethodName() {
		return "taobao.items.custom.get";
	}

	public Map<String, String> getTextParams() {		
		textParams.put("fields", this.fields);
		textParams.put("outer_id", this.outerId);
		return textParams;
	}
	
	public Long getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
}
