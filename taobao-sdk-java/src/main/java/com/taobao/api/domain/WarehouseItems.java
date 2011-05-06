package com.taobao.api.domain;

import java.util.List;
import com.taobao.api.internal.mapping.ApiClass;
import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.internal.mapping.ApiListField;


import com.taobao.api.TaobaoObject;

/**
 * WarehouseItems Data Structure.
 * 
 * DESC：仓储商品搜索 
 *
 * @author auto create
 * @since 1.0, 2010-09-01 18:38:32.0
 */
@ApiClass("WarehouseItems")
public class WarehouseItems extends TaobaoObject {

	private static final long serialVersionUID = 1219656586525559122L;

	
	/** 
	 * 库存列表
	 **/
	@ApiListField("inventory_list")
	@ApiField("inventory")
	private List<Inventory> inventoryList;

	
	/** 
	 * 商品列表
	 **/
	@ApiListField("warehouse_item_list")
	@ApiField("warehouse_item")
	private List<WarehouseItem> warehouseItemList;

	public List<Inventory> getInventoryList() {
		return this.inventoryList;
	}
	public void setInventoryList(List<Inventory> inventoryList) {
		this.inventoryList = inventoryList;
	}

	public List<WarehouseItem> getWarehouseItemList() {
		return this.warehouseItemList;
	}
	public void setWarehouseItemList(List<WarehouseItem> warehouseItemList) {
		this.warehouseItemList = warehouseItemList;
	}

}
