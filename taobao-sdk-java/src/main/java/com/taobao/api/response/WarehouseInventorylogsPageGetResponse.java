package com.taobao.api.response;

import java.util.List;
import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.internal.mapping.ApiListField;
import com.taobao.api.domain.InventoryLog;


import com.taobao.api.TaobaoResponse;

/**
 * TOP API: taobao.warehouse.inventorylogs.page.get response
 * 
 * @author auto create
 * @since 1.0,2010-10-21 08:49:08.0
 */
public class WarehouseInventorylogsPageGetResponse extends TaobaoResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2896173311843991723L;

	
	/** 
	 * 库存变更列表
	 **/
	@ApiListField("inventory_logs")
	@ApiField("inventory_log")
	private List<InventoryLog> inventoryLogs;
	
	/** 
	 * 总的记录数
	 **/
	@ApiField("total_result")
	private Long totalResult;

	public void setInventoryLogs(List<InventoryLog> inventoryLogs) {
		this.inventoryLogs = inventoryLogs;
	}

	public List<InventoryLog> getInventoryLogs( ) {
		return this.inventoryLogs;
	}
	public void setTotalResult(Long totalResult) {
		this.totalResult = totalResult;
	}

	public Long getTotalResult( ) {
		return this.totalResult;
	}

	public String getApiMethodName() {
		return "taobao.warehouse.inventorylogs.page.get";
	}

}
