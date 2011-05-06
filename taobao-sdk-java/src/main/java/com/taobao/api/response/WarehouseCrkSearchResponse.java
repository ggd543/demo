package com.taobao.api.response;

import java.util.List;
import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.internal.mapping.ApiListField;
import com.taobao.api.domain.WarehouseCrkMain;


import com.taobao.api.TaobaoResponse;

/**
 * TOP API: taobao.warehouse.crk.search response
 * 
 * @author auto create
 * @since 1.0,2010-11-24 11:28:26.0
 */
public class WarehouseCrkSearchResponse extends TaobaoResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7465741934525187642L;

	
	/** 
	 * 出入库单对应数据信息
	 **/
	@ApiListField("crk_main_dos")
	@ApiField("warehouse_crk_main")
	private List<WarehouseCrkMain> crkMainDos;
	
	/** 
	 * 出入库单商品库存变更记录ID，若无数据则返回空
	 **/
	@ApiListField("inventory_log_ids")
	@ApiField("string")
	private List<String> inventoryLogIds;
	
	/** 
	 * 查询结果总数
	 **/
	@ApiField("total_item")
	private Long totalItem;

	public void setCrkMainDos(List<WarehouseCrkMain> crkMainDos) {
		this.crkMainDos = crkMainDos;
	}

	public List<WarehouseCrkMain> getCrkMainDos( ) {
		return this.crkMainDos;
	}
	public void setInventoryLogIds(List<String> inventoryLogIds) {
		this.inventoryLogIds = inventoryLogIds;
	}

	public List<String> getInventoryLogIds( ) {
		return this.inventoryLogIds;
	}
	public void setTotalItem(Long totalItem) {
		this.totalItem = totalItem;
	}

	public Long getTotalItem( ) {
		return this.totalItem;
	}

	public String getApiMethodName() {
		return "taobao.warehouse.crk.search";
	}

}
