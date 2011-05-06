package com.taobao.api.request;

import java.util.Map;
import java.util.Date;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.TaobaoRequest;

/**
 * TOP API: taobao.item.sku.get request
 * 
 * @author auto create
 * @since 1.0, 2010-09-29 17:01:09.0
 */
public class ItemSkuGetRequest implements TaobaoRequest {
	private Long timestamp;	
	private TaobaoHashMap textParams = new TaobaoHashMap();


	
	/** 
	 * 需返回的字段列表。可选值：Sku结构体中的所有字段；字段之间用“,”分隔。
	 **/
	private String fields;
	
	/** 
	 * 卖家nick
	 **/
	private String nick;
	
	/** 
	 * 商品的数字IID（推荐用num_iid）
	 **/
	private Long numIid;
	
	/** 
	 * Sku的id。可以通过taobao.item.get得到
	 **/
	private Long skuId;

	public void setFields(String fields) {
		this.fields = fields;
	}
	 public String getFields() {
		return this.fields;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	 public String getNick() {
		return this.nick;
	}
	public void setNumIid(Long numIid) {
		this.numIid = numIid;
	}
	 public Long getNumIid() {
		return this.numIid;
	}
	public void setSkuId(Long skuId) {
		this.skuId = skuId;
	}
	 public Long getSkuId() {
		return this.skuId;
	}
	
	public String getApiMethodName() {
		return "taobao.item.sku.get";
	}

	public Map<String, String> getTextParams() {		
		textParams.put("fields", this.fields);
		textParams.put("nick", this.nick);
		textParams.put("num_iid", this.numIid);
		textParams.put("sku_id", this.skuId);
		return textParams;
	}
	
	public Long getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
}
