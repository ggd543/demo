package com.taobao.api.response;

import java.util.List;
import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.internal.mapping.ApiListField;
import com.taobao.api.domain.WarehouseReturnMain;


import com.taobao.api.TaobaoResponse;

/**
 * TOP API: taobao.warehouse.returns.page.get response
 * 
 * @author auto create
 * @since 1.0,2010-12-01 15:52:13.0
 */
public class WarehouseReturnsPageGetResponse extends TaobaoResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8419119761462276657L;

	
	/** 
	 * 退货单明细单ID，若无数据则返回空
	 **/
	@ApiListField("inventory_log_ids")
	@ApiField("string")
	private List<String> inventoryLogIds;
	
	/** 
	 * 退货单主信息列表
	 **/
	@ApiListField("return_main_dos")
	@ApiField("warehouse_return_main")
	private List<WarehouseReturnMain> returnMainDos;
	
	/** 
	 * 查询结果总数
	 **/
	@ApiField("total_item")
	private Long totalItem;

	public void setInventoryLogIds(List<String> inventoryLogIds) {
		this.inventoryLogIds = inventoryLogIds;
	}

	public List<String> getInventoryLogIds( ) {
		return this.inventoryLogIds;
	}
	public void setReturnMainDos(List<WarehouseReturnMain> returnMainDos) {
		this.returnMainDos = returnMainDos;
	}

	public List<WarehouseReturnMain> getReturnMainDos( ) {
		return this.returnMainDos;
	}
	public void setTotalItem(Long totalItem) {
		this.totalItem = totalItem;
	}

	public Long getTotalItem( ) {
		return this.totalItem;
	}

	public String getApiMethodName() {
		return "taobao.warehouse.returns.page.get";
	}

}
