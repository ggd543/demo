package com.taobao.api.response;

import java.util.List;
import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.internal.mapping.ApiListField;
import com.taobao.api.domain.WarehouseOrder;


import com.taobao.api.TaobaoResponse;

/**
 * TOP API: taobao.warehouse.orders.page.get response
 * 
 * @author auto create
 * @since 1.0,2010-10-21 08:45:01.0
 */
public class WarehouseOrdersPageGetResponse extends TaobaoResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2313197978276437363L;

	
	/** 
	 * 仓储的物流订单列表
	 **/
	@ApiListField("order_list")
	@ApiField("warehouse_order")
	private List<WarehouseOrder> orderList;
	
	/** 
	 * 总的记录数
	 **/
	@ApiField("total_result")
	private Long totalResult;

	public void setOrderList(List<WarehouseOrder> orderList) {
		this.orderList = orderList;
	}

	public List<WarehouseOrder> getOrderList( ) {
		return this.orderList;
	}
	public void setTotalResult(Long totalResult) {
		this.totalResult = totalResult;
	}

	public Long getTotalResult( ) {
		return this.totalResult;
	}

	public String getApiMethodName() {
		return "taobao.warehouse.orders.page.get";
	}

}
