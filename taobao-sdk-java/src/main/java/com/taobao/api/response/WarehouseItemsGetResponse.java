package com.taobao.api.response;

import java.util.List;
import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.internal.mapping.ApiListField;
import com.taobao.api.domain.WarehouseItem;


import com.taobao.api.TaobaoResponse;

/**
 * TOP API: taobao.warehouse.items.get response
 * 
 * @author auto create
 * @since 1.0,2010-07-06 12:01:28.0
 */
public class WarehouseItemsGetResponse extends TaobaoResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5861473838925297681L;

	
	/** 
	 * 商品相关信息
	 **/
	@ApiListField("warehouse_item_list")
	@ApiField("warehouse_item")
	private List<WarehouseItem> warehouseItemList;

	public void setWarehouseItemList(List<WarehouseItem> warehouseItemList) {
		this.warehouseItemList = warehouseItemList;
	}

	public List<WarehouseItem> getWarehouseItemList( ) {
		return this.warehouseItemList;
	}

	public String getApiMethodName() {
		return "taobao.warehouse.items.get";
	}

}
