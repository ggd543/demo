package com.taobao.api.response;

import java.util.Date;
import com.taobao.api.internal.mapping.ApiField;


import com.taobao.api.TaobaoResponse;

/**
 * TOP API: taobao.warehouse.return.send response
 * 
 * @author auto create
 * @since 1.0,2010-12-01 15:52:32.0
 */
public class WarehouseReturnSendResponse extends TaobaoResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6558355915528569521L;

	
	/** 
	 * 修改时间
	 **/
	@ApiField("modify_time")
	private Date modifyTime;
	
	/** 
	 * 成功标志
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
		return "taobao.warehouse.return.send";
	}

}
