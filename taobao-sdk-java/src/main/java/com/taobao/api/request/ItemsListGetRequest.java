package com.taobao.api.request;

import java.util.Map;
import java.util.Date;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.TaobaoRequest;

/**
 * TOP API: taobao.items.list.get request
 * 
 * @author auto create
 * @since 1.0, 2010-09-21 14:04:14.0
 */
public class ItemsListGetRequest implements TaobaoRequest {
	private Long timestamp;	
	private TaobaoHashMap textParams = new TaobaoHashMap();


	
	/** 
	 * 需要返回的商品对象字段。可选值：Item商品结构体中所有字段均可返回；多个字段用“,”分隔。如果想返回整个子对象，那字段为itemimg，如果是想返回子对象里面的字段，那字段为itemimg.url。
	 **/
	private String fields;
	
	/** 
	 * 商品数字id列表，多个num_iid用逗号隔开，一次不超过20个。同时传入iids和num_iids以num_iids为主
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
		return "taobao.items.list.get";
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
