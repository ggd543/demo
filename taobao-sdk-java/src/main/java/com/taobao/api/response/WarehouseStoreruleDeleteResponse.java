package com.taobao.api.response;

import java.util.Date;
import com.taobao.api.internal.mapping.ApiField;


import com.taobao.api.TaobaoResponse;

/**
 * TOP API: taobao.warehouse.storerule.delete response
 * 
 * @author auto create
 * @since 1.0,2010-10-21 08:46:58.0
 */
public class WarehouseStoreruleDeleteResponse extends TaobaoResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8755465876177482948L;

	
	/** 
	 * 操作时间
	 **/
	@ApiField("modify_time")
	private Date modifyTime;
	
	/** 
	 * 操作是否成功
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
		return "taobao.warehouse.storerule.delete";
	}

}
