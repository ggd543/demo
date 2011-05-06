package com.taobao.api.response;

import java.util.Date;
import com.taobao.api.internal.mapping.ApiField;


import com.taobao.api.TaobaoResponse;

/**
 * TOP API: taobao.warehouse.item.update response
 * 
 * @author auto create
 * @since 1.0,2010-10-21 08:42:47.0
 */
public class WarehouseItemUpdateResponse extends TaobaoResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2821167937115916964L;

	
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
		return "taobao.warehouse.item.update";
	}

}
