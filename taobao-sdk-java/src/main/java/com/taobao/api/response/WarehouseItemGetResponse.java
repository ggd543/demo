package com.taobao.api.response;

import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.domain.WarehouseItem;


import com.taobao.api.TaobaoResponse;

/**
 * TOP API: taobao.warehouse.item.get response
 * 
 * @author auto create
 * @since 1.0,2010-10-21 08:45:23.0
 */
public class WarehouseItemGetResponse extends TaobaoResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1316375867641685682L;

	
	/** 
	 * 商品信息。返回JSON格式的字符串，包括商家编码，商品名称，条形码/货号，自定义属性
	 **/
	@ApiField("warehouse_item")
	private WarehouseItem warehouseItem;

	public void setWarehouseItem(WarehouseItem warehouseItem) {
		this.warehouseItem = warehouseItem;
	}

	public WarehouseItem getWarehouseItem( ) {
		return this.warehouseItem;
	}

	public String getApiMethodName() {
		return "taobao.warehouse.item.get";
	}

}
