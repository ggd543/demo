package com.taobao.api.response;

import java.util.Date;
import com.taobao.api.internal.mapping.ApiField;


import com.taobao.api.TaobaoResponse;

/**
 * TOP API: taobao.warehouse.storerule.save response
 * 
 * @author auto create
 * @since 1.0,2010-10-21 08:44:10.0
 */
public class WarehouseStoreruleSaveResponse extends TaobaoResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1875198821566729633L;

	
	/** 
	 * 是否保存成功
	 **/
	@ApiField("is_success")
	private Boolean isSuccess;
	
	/** 
	 * 修改时间
	 **/
	@ApiField("modify_time")
	private Date modifyTime;

	public void setIsSuccess(Boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public Boolean getIsSuccess( ) {
		return this.isSuccess;
	}
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public Date getModifyTime( ) {
		return this.modifyTime;
	}

	public String getApiMethodName() {
		return "taobao.warehouse.storerule.save";
	}

}
