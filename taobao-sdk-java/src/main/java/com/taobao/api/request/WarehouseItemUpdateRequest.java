package com.taobao.api.request;

import java.util.Map;
import java.util.Date;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.TaobaoRequest;

/**
 * TOP API: taobao.warehouse.item.update request
 * 
 * @author auto create
 * @since 1.0, 2010-10-21 08:42:47.0
 */
public class WarehouseItemUpdateRequest implements TaobaoRequest {
	private Long timestamp;	
	private TaobaoHashMap textParams = new TaobaoHashMap();


	
	/** 
	 * 商品名称，不能超过256字符,一个汉字算两个字符
	 **/
	private String itemName;
	
	/** 
	 * 商品Id.可从taobao.warehouse.items.get处获得
	 **/
	private Long itemId;
	
	/** 
	 * 自定义属性。不能超过256字符，一个汉字算两个字符
	 **/
	private String memo;
	
	/** 
	 * 该字段已作废。商家编码。和卖家发布商品的商家编码保持一致。商家编码必须唯一，且不能超过64字符，一个汉字算两个字符
	 **/
	private String outerId;

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	 public String getItemName() {
		return this.itemName;
	}
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	 public Long getItemId() {
		return this.itemId;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	 public String getMemo() {
		return this.memo;
	}
	public void setOuterId(String outerId) {
		this.outerId = outerId;
	}
	 public String getOuterId() {
		return this.outerId;
	}
	
	public String getApiMethodName() {
		return "taobao.warehouse.item.update";
	}

	public Map<String, String> getTextParams() {		
		textParams.put("item_Name", this.itemName);
		textParams.put("item_id", this.itemId);
		textParams.put("memo", this.memo);
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
