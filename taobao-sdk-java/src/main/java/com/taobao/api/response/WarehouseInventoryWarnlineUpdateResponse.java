package com.taobao.api.response;

import java.util.Date;
import com.taobao.api.internal.mapping.ApiField;


import com.taobao.api.TaobaoResponse;

/**
 * TOP API: taobao.warehouse.inventory.warnline.update response
 * 
 * @author auto create
 * @since 1.0,2010-10-21 08:44:26.0
 */
public class WarehouseInventoryWarnlineUpdateResponse extends TaobaoResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3156332163755319853L;

	
	/** 
	 * 部分成功时返回操作失败的库存id
	 **/
	@ApiField("failed_inventory_ids")
	private String failedInventoryIds;
	
	/** 
	 * 修改时间.格式:yyyy-mm-dd hh:mm:ss
	 **/
	@ApiField("modify_time")
	private Date modifyTime;
	
	/** 
	 * 是否成功 (返回失败:P01为参数为空)
	 **/
	@ApiField("success")
	private Boolean success;

	public void setFailedInventoryIds(String failedInventoryIds) {
		this.failedInventoryIds = failedInventoryIds;
	}

	public String getFailedInventoryIds( ) {
		return this.failedInventoryIds;
	}
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
		return "taobao.warehouse.inventory.warnline.update";
	}

}
