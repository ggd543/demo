package com.taobao.api.response;

import java.util.Date;
import com.taobao.api.internal.mapping.ApiField;


import com.taobao.api.TaobaoResponse;

/**
 * TOP API: taobao.warehouse.order.cancel response
 * 
 * @author auto create
 * @since 1.0,2010-10-21 08:47:54.0
 */
public class WarehouseOrderCancelResponse extends TaobaoResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1342382723297759277L;

	
	/** 
	 * 修改时间
	 **/
	@ApiField("modify_time")
	private Date modifyTime;
	
	/** 
	 * 重新创建订单id
	 **/
	@ApiField("recreated_order_id")
	private Long recreatedOrderId;
	
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
	public void setRecreatedOrderId(Long recreatedOrderId) {
		this.recreatedOrderId = recreatedOrderId;
	}

	public Long getRecreatedOrderId( ) {
		return this.recreatedOrderId;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public Boolean getSuccess( ) {
		return this.success;
	}

	public String getApiMethodName() {
		return "taobao.warehouse.order.cancel";
	}

}
