package com.taobao.api.response;

import java.util.Date;
import com.taobao.api.internal.mapping.ApiField;


import com.taobao.api.TaobaoResponse;

/**
 * TOP API: taobao.warehouse.item.add response
 * 
 * @author auto create
 * @since 1.0,2010-10-21 08:42:27.0
 */
public class WarehouseItemAddResponse extends TaobaoResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1523323725865653951L;

	
	/** 
	 * 创建时间 格式:yyyy-mm-dd hh:mm:ss
	 **/
	@ApiField("create_time")
	private Date createTime;
	
	/** 
	 * 商品id
	 **/
	@ApiField("item_id")
	private String itemId;
	
	/** 
	 * 是否成功
	 **/
	@ApiField("success")
	private Boolean success;

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getCreateTime( ) {
		return this.createTime;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getItemId( ) {
		return this.itemId;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public Boolean getSuccess( ) {
		return this.success;
	}

	public String getApiMethodName() {
		return "taobao.warehouse.item.add";
	}

}
