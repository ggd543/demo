package com.taobao.api.request;

import java.util.Map;
import java.util.Date;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.TaobaoRequest;

/**
 * TOP API: taobao.warehouse.item.get request
 * 
 * @author auto create
 * @since 1.0, 2010-10-21 08:45:23.0
 */
public class WarehouseItemGetRequest implements TaobaoRequest {
	private Long timestamp;	
	private TaobaoHashMap textParams = new TaobaoHashMap();


	
	/** 
	 * 商品id。可从taobao.warehouse.items.get获得。当type="item_id"时，根据输入的item_id查询，默认为0
	 **/
	private Long itemId;
	
	/** 
	 * 商家编码.和卖家发布商品的商家编码一致,可从taobao.warehouse.items.get获得。当type="outer_id"时,根据输入的outer_id查询，默认为""
	 **/
	private String outerId;
	
	/** 
	 * 参数类型。必须传入"item_id"（根据商品Id查商品信息）或"outer_id"（根据商家编码查询商品信息）
	 **/
	private String type;

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	 public Long getItemId() {
		return this.itemId;
	}
	public void setOuterId(String outerId) {
		this.outerId = outerId;
	}
	 public String getOuterId() {
		return this.outerId;
	}
	public void setType(String type) {
		this.type = type;
	}
	 public String getType() {
		return this.type;
	}
	
	public String getApiMethodName() {
		return "taobao.warehouse.item.get";
	}

	public Map<String, String> getTextParams() {		
		textParams.put("item_id", this.itemId);
		textParams.put("outer_id", this.outerId);
		textParams.put("type", this.type);
		return textParams;
	}
	
	public Long getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
}
