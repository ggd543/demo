package com.taobao.api.response;

import java.util.Date;
import com.taobao.api.internal.mapping.ApiField;


import com.taobao.api.TaobaoResponse;

/**
 * TOP API: taobao.warehouse.order.storeConsign response
 * 
 * @author auto create
 * @since 1.0,2010-10-21 08:42:06.0
 */
public class WarehouseOrderStoreConsignResponse extends TaobaoResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4495789765875757878L;

	
	/** 
	 * 修改时间
	 **/
	@ApiField("modify_time")
	private Date modifyTime;
	
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
	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public Boolean getSuccess( ) {
		return this.success;
	}

	public String getApiMethodName() {
		return "taobao.warehouse.order.storeConsign";
	}

}
