package com.taobao.api.response;

import java.util.Date;
import com.taobao.api.internal.mapping.ApiField;


import com.taobao.api.TaobaoResponse;

/**
 * TOP API: taobao.warehouse.inventory.warnlines.update response
 * 
 * @author auto create
 * @since 1.0,2010-10-21 08:45:57.0
 */
public class WarehouseInventoryWarnlinesUpdateResponse extends TaobaoResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2172183197235875327L;

	
	/** 
	 * 修改时间.格式:yyyy-mm-dd hh:mm:ss
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
		return "taobao.warehouse.inventory.warnlines.update";
	}

}
