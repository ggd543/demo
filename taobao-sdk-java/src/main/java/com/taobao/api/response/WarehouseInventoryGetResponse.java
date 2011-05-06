package com.taobao.api.response;

import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.domain.Inventory;


import com.taobao.api.TaobaoResponse;

/**
 * TOP API: taobao.warehouse.inventory.get response
 * 
 * @author auto create
 * @since 1.0,2010-10-21 08:50:31.0
 */
public class WarehouseInventoryGetResponse extends TaobaoResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5832631348218399261L;

	
	/** 
	 * 库存信息。返回JSON格式的字符串
	 **/
	@ApiField("inventory")
	private Inventory inventory;

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public Inventory getInventory( ) {
		return this.inventory;
	}

	public String getApiMethodName() {
		return "taobao.warehouse.inventory.get";
	}

}
