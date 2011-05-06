package com.taobao.api.response;

import java.util.List;
import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.internal.mapping.ApiListField;
import com.taobao.api.domain.Inventory;


import com.taobao.api.TaobaoResponse;

/**
 * TOP API: taobao.warehouse.inventories.get response
 * 
 * @author auto create
 * @since 1.0,2010-10-21 08:50:15.0
 */
public class WarehouseInventoriesGetResponse extends TaobaoResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3632183471342966596L;

	
	/** 
	 * 库存信息列表。返回JSON格式的字符串
	 **/
	@ApiListField("inventory_list")
	@ApiField("inventory")
	private List<Inventory> inventoryList;

	public void setInventoryList(List<Inventory> inventoryList) {
		this.inventoryList = inventoryList;
	}

	public List<Inventory> getInventoryList( ) {
		return this.inventoryList;
	}

	public String getApiMethodName() {
		return "taobao.warehouse.inventories.get";
	}

}
