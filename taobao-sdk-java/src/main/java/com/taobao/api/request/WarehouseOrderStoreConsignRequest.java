package com.taobao.api.request;

import java.util.Map;
import java.util.Date;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.TaobaoRequest;

/**
 * TOP API: taobao.warehouse.order.storeConsign request
 * 
 * @author auto create
 * @since 1.0, 2010-10-21 08:42:06.0
 */
public class WarehouseOrderStoreConsignRequest implements TaobaoRequest {
	private Long timestamp;	
	private TaobaoHashMap textParams = new TaobaoHashMap();


	
	/** 
	 * 订单id
	 **/
	private String orderId;
	
	/** 
	 * 发货仓储 id 可以从接口taobao.warehouse.sellerstores.get中得到
	 **/
	private String sellerStoreId;

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	 public String getOrderId() {
		return this.orderId;
	}
	public void setSellerStoreId(String sellerStoreId) {
		this.sellerStoreId = sellerStoreId;
	}
	 public String getSellerStoreId() {
		return this.sellerStoreId;
	}
	
	public String getApiMethodName() {
		return "taobao.warehouse.order.storeConsign";
	}

	public Map<String, String> getTextParams() {		
		textParams.put("order_id", this.orderId);
		textParams.put("seller_store_id", this.sellerStoreId);
		return textParams;
	}
	
	public Long getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
}
