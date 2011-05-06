package com.taobao.api.response;

import java.util.List;
import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.internal.mapping.ApiListField;
import com.taobao.api.domain.InventoryLog;


import com.taobao.api.TaobaoResponse;

/**
 * TOP API: taobao.warehouse.inventorylogs.get response
 * 
 * @author auto create
 * @since 1.0,2010-10-21 08:48:44.0
 */
public class WarehouseInventorylogsGetResponse extends TaobaoResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7746771261469951211L;

	
	/** 
	 * 对应的库存变更记录信息,JSON格式的字符串
	 **/
	@ApiListField("inventory_log_list")
	@ApiField("inventory_log")
	private List<InventoryLog> inventoryLogList;

	public void setInventoryLogList(List<InventoryLog> inventoryLogList) {
		this.inventoryLogList = inventoryLogList;
	}

	public List<InventoryLog> getInventoryLogList( ) {
		return this.inventoryLogList;
	}

	public String getApiMethodName() {
		return "taobao.warehouse.inventorylogs.get";
	}

}
