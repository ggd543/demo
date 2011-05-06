package com.taobao.api.request;

import java.util.Map;
import java.util.Date;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.TaobaoRequest;

/**
 * TOP API: taobao.warehouse.item.delete request
 * 
 * @author auto create
 * @since 1.0, 2010-10-21 08:45:40.0
 */
public class WarehouseItemDeleteRequest implements TaobaoRequest {
	private Long timestamp;	
	private TaobaoHashMap textParams = new TaobaoHashMap();


	
	/** 
	 * 商品ID.可从taobao.warehouse.items.get获得
	 **/
	private Long itemId;

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	 public Long getItemId() {
		return this.itemId;
	}
	
	public String getApiMethodName() {
		return "taobao.warehouse.item.delete";
	}

	public Map<String, String> getTextParams() {		
		textParams.put("item_id", this.itemId);
		return textParams;
	}
	
	public Long getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
}
