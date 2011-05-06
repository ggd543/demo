package com.taobao.api.response;

import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.domain.WarehouseItems;


import com.taobao.api.TaobaoResponse;

/**
 * TOP API: taobao.warehouse.items.page.get response
 * 
 * @author auto create
 * @since 1.0,2010-10-21 08:49:56.0
 */
public class WarehouseItemsPageGetResponse extends TaobaoResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1891123218256815929L;

	
	/** 
	 * 搜索到符合条件的结果总数
	 **/
	@ApiField("total_result")
	private Long totalResult;
	
	/** 
	 * 商品相关信息，包括商品信息列表，库存信息列表和自定义仓库信息列表组成的JSON格式的字符串
	 **/
	@ApiField("warehouse_page_items")
	private WarehouseItems warehousePageItems;

	public void setTotalResult(Long totalResult) {
		this.totalResult = totalResult;
	}

	public Long getTotalResult( ) {
		return this.totalResult;
	}
	public void setWarehousePageItems(WarehouseItems warehousePageItems) {
		this.warehousePageItems = warehousePageItems;
	}

	public WarehouseItems getWarehousePageItems( ) {
		return this.warehousePageItems;
	}

	public String getApiMethodName() {
		return "taobao.warehouse.items.page.get";
	}

}
