package com.taobao.api.domain;

import com.taobao.api.internal.mapping.ApiClass;
import com.taobao.api.internal.mapping.ApiField;


import com.taobao.api.TaobaoObject;

/**
 * SellerStore Data Structure.
 * 
 * DESC：自定义仓库集合 
 *
 * @author auto create
 * @since 1.0, 2010-09-28 11:32:50.0
 */
@ApiClass("SellerStore")
public class SellerStore extends TaobaoObject {

	private static final long serialVersionUID = 4566889918169449122L;

	
	/** 
	 * 卖家默认使用的淘宝合作物流公司ID
	 **/
	@ApiField("def_company_id")
	private Long defCompanyId;

	
	/** 
	 * 备注，最大长度516字节
	 **/
	@ApiField("remark")
	private String remark;

	
	/** 
	 * 淘宝网为仓储用户分配的编号
	 **/
	@ApiField("seller_code")
	private String sellerCode;

	
	/** 
	 * 卖家申请使用仓库的面积
	 **/
	@ApiField("square")
	private Long square;

	
	/** 
	 * 自定义仓库状态:
"WAIT”-待审核 “CANCEL”-撤销申请 “PASS”-审核通过 “UNPASS”-审核未通过
	 **/
	@ApiField("status")
	private Long status;

	
	/** 
	 * 卖家申请使用的外部仓库代号，最大长度32字节
	 **/
	@ApiField("store_code")
	private String storeCode;

	
	/** 
	 * 自定义仓库唯一标识
	 **/
	@ApiField("store_id")
	private Long storeId;

	
	/** 
	 * 卖家申请使用的外部仓库名称，最大长度64字节
	 **/
	@ApiField("store_name")
	private String storeName;

	
	/** 
	 * 每月补货次数
	 **/
	@ApiField("supply_times")
	private Long supplyTimes;

	public Long getDefCompanyId() {
		return this.defCompanyId;
	}
	public void setDefCompanyId(Long defCompanyId) {
		this.defCompanyId = defCompanyId;
	}

	public String getRemark() {
		return this.remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getSellerCode() {
		return this.sellerCode;
	}
	public void setSellerCode(String sellerCode) {
		this.sellerCode = sellerCode;
	}

	public Long getSquare() {
		return this.square;
	}
	public void setSquare(Long square) {
		this.square = square;
	}

	public Long getStatus() {
		return this.status;
	}
	public void setStatus(Long status) {
		this.status = status;
	}

	public String getStoreCode() {
		return this.storeCode;
	}
	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}

	public Long getStoreId() {
		return this.storeId;
	}
	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}

	public String getStoreName() {
		return this.storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public Long getSupplyTimes() {
		return this.supplyTimes;
	}
	public void setSupplyTimes(Long supplyTimes) {
		this.supplyTimes = supplyTimes;
	}

}
