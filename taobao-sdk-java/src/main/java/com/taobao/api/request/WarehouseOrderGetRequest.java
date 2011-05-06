package com.taobao.api.request;

import java.util.Map;
import java.util.Date;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.TaobaoRequest;

/**
 * TOP API: taobao.warehouse.order.get request
 * 
 * @author auto create
 * @since 1.0, 2010-11-23 17:19:15.0
 */
public class WarehouseOrderGetRequest implements TaobaoRequest {
	private Long timestamp;	
	private TaobaoHashMap textParams = new TaobaoHashMap();


	
	/** 
	 * 物流订单ID
	 **/
	private Long orderId;

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	 public Long getOrderId() {
		return this.orderId;
	}
	
	public String getApiMethodName() {
		return "taobao.warehouse.order.get";
	}

	public Map<String, String> getTextParams() {		
		textParams.put("order_id", this.orderId);
		return textParams;
	}
	
	public Long getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
}
