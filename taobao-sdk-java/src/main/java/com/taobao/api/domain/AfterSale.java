package com.taobao.api.domain;

import com.taobao.api.internal.mapping.ApiClass;
import com.taobao.api.internal.mapping.ApiField;


import com.taobao.api.TaobaoObject;

/**
 * AfterSale Data Structure.
 * 
 * DESC：卖家设置售后服务对象 
 *
 * @author auto create
 * @since 1.0, 2010-11-08 17:57:12.0
 */
@ApiClass("AfterSale")
public class AfterSale extends TaobaoObject {

	private static final long serialVersionUID = 4362835673276131779L;

	
	/** 
	 * id
	 **/
	@ApiField("after_sale_id")
	private Long afterSaleId;

	
	/** 
	 * 名称
	 **/
	@ApiField("after_sale_name")
	private String afterSaleName;

	
	/** 
	 * tfs地址
	 **/
	@ApiField("after_sale_path")
	private String afterSalePath;

	public Long getAfterSaleId() {
		return this.afterSaleId;
	}
	public void setAfterSaleId(Long afterSaleId) {
		this.afterSaleId = afterSaleId;
	}

	public String getAfterSaleName() {
		return this.afterSaleName;
	}
	public void setAfterSaleName(String afterSaleName) {
		this.afterSaleName = afterSaleName;
	}

	public String getAfterSalePath() {
		return this.afterSalePath;
	}
	public void setAfterSalePath(String afterSalePath) {
		this.afterSalePath = afterSalePath;
	}

}
