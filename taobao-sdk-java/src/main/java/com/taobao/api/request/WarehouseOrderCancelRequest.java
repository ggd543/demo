package com.taobao.api.request;

import java.util.Map;
import java.util.Date;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.TaobaoRequest;

/**
 * TOP API: taobao.warehouse.order.cancel request
 * 
 * @author auto create
 * @since 1.0, 2010-10-21 08:47:54.0
 */
public class WarehouseOrderCancelRequest implements TaobaoRequest {
	private Long timestamp;	
	private TaobaoHashMap textParams = new TaobaoHashMap();


	
	/** 
	 * 订单id，order_id可以根据接口taobao.warehouse.orders.page.get得到
	 **/
	private Long orderId;

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	 public Long getOrderId() {
		return this.orderId;
	}
	
	public String getApiMethodName() {
		return "taobao.warehouse.order.cancel";
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
