package com.taobao.api.response;

import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.domain.InventoryLog;


import com.taobao.api.TaobaoResponse;

/**
 * TOP API: taobao.warehouse.inventorylog.get response
 * 
 * @author auto create
 * @since 1.0,2010-10-21 08:48:29.0
 */
public class WarehouseInventorylogGetResponse extends TaobaoResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1295217259423671984L;

	
	/** 
	 * 对应的库存变更记录信息
	 **/
	@ApiField("inventory_log")
	private InventoryLog inventoryLog;

	public void setInventoryLog(InventoryLog inventoryLog) {
		this.inventoryLog = inventoryLog;
	}

	public InventoryLog getInventoryLog( ) {
		return this.inventoryLog;
	}

	public String getApiMethodName() {
		return "taobao.warehouse.inventorylog.get";
	}

}
