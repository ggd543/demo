package com.taobao.api.response;

import java.util.Date;
import com.taobao.api.internal.mapping.ApiField;


import com.taobao.api.TaobaoResponse;

/**
 * TOP API: taobao.warehouse.outside.order.import response
 * 
 * @author auto create
 * @since 1.0,2010-10-21 08:49:31.0
 */
public class WarehouseOutsideOrderImportResponse extends TaobaoResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7185951261754925959L;

	
	/** 
	 * 修改时间 格式:yyyy-mm-dd hh:mm:ss
	 **/
	@ApiField("modify_time")
	private Date modifyTime;
	
	/** 
	 * 物流订单唯一标识
	 **/
	@ApiField("order_id")
	private String orderId;
	
	/** 
	 * 是否成功
	 **/
	@ApiField("success")
	private Boolean success;

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public Date getModifyTime( ) {
		return this.modifyTime;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getOrderId( ) {
		return this.orderId;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public Boolean getSuccess( ) {
		return this.success;
	}

	public String getApiMethodName() {
		return "taobao.warehouse.outside.order.import";
	}

}
