package com.taobao.api.domain;

import java.util.Date;
import com.taobao.api.internal.mapping.ApiClass;
import com.taobao.api.internal.mapping.ApiField;


import com.taobao.api.TaobaoObject;

/**
 * WarehouseCrkMain Data Structure.
 * 
 * DESC：出入库主体信息 
 *
 * @author auto create
 * @since 1.0, 2010-07-20 13:41:19.0
 */
@ApiClass("WarehouseCrkMain")
public class WarehouseCrkMain extends TaobaoObject {

	private static final long serialVersionUID = 7179725612175458276L;

	
	/** 
	 * 商品种类数量
	 **/
	@ApiField("auction_count")
	private Long auctionCount;

	
	/** 
	 * 运输公司联系人身份证号
	 **/
	@ApiField("card_id")
	private String cardId;

	
	/** 
	 * 出入库单唯一标识
	 **/
	@ApiField("crk_code")
	private String crkCode;

	
	/** 
	 * 出入库实际日期
	 **/
	@ApiField("crk_date")
	private Date crkDate;

	
	/** 
	 * 出库运输目的地
	 **/
	@ApiField("destination")
	private String destination;

	
	/** 
	 * 预计出入库时间
	 **/
	@ApiField("expect_crk_date")
	private Date expectCrkDate;

	
	/** 
	 * 已返回的出入库商品数量
	 **/
	@ApiField("return_count")
	private Long returnCount;

	
	/** 
	 * 商家联系人
	 **/
	@ApiField("seller_contactor")
	private String sellerContactor;

	
	/** 
	 * 商家名称
	 **/
	@ApiField("seller_name")
	private String sellerName;

	
	/** 
	 * 商家联系电话
	 **/
	@ApiField("seller_phone")
	private String sellerPhone;

	
	/** 
	 * 出入库状态： 
(编辑中) STATUS_EDIT;
(同步中) STATUS_SYN;
(已同步) STATUS_SYNCHRONIZED;
(待确认库存) STATUS_WAIT_CONFIRM;
(已完成) STATUS_COMPLETED;
	 **/
	@ApiField("status")
	private String status;

	
	/** 
	 * 总箱数
	 **/
	@ApiField("total_package")
	private Long totalPackage;

	
	/** 
	 * 运输公司联系人
	 **/
	@ApiField("transport_contactor")
	private String transportContactor;

	
	/** 
	 * 运输公司联系电话
	 **/
	@ApiField("transport_contactor_phone")
	private String transportContactorPhone;

	
	/** 
	 * 运输公司名称
	 **/
	@ApiField("transport_name")
	private String transportName;

	
	/** 
	 * 运输公司运单号
	 **/
	@ApiField("transport_no")
	private String transportNo;

	
	/** 
	 * 出入库类型:TYPE_STOCK_IN  TYPE_STOCK_OUT
	 **/
	@ApiField("type")
	private String type;

	
	/** 
	 * 待确认的库存变更数
	 **/
	@ApiField("wait_confirm")
	private Long waitConfirm;

	public Long getAuctionCount() {
		return this.auctionCount;
	}
	public void setAuctionCount(Long auctionCount) {
		this.auctionCount = auctionCount;
	}

	public String getCardId() {
		return this.cardId;
	}
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	public String getCrkCode() {
		return this.crkCode;
	}
	public void setCrkCode(String crkCode) {
		this.crkCode = crkCode;
	}

	public Date getCrkDate() {
		return this.crkDate;
	}
	public void setCrkDate(Date crkDate) {
		this.crkDate = crkDate;
	}

	public String getDestination() {
		return this.destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Date getExpectCrkDate() {
		return this.expectCrkDate;
	}
	public void setExpectCrkDate(Date expectCrkDate) {
		this.expectCrkDate = expectCrkDate;
	}

	public Long getReturnCount() {
		return this.returnCount;
	}
	public void setReturnCount(Long returnCount) {
		this.returnCount = returnCount;
	}

	public String getSellerContactor() {
		return this.sellerContactor;
	}
	public void setSellerContactor(String sellerContactor) {
		this.sellerContactor = sellerContactor;
	}

	public String getSellerName() {
		return this.sellerName;
	}
	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public String getSellerPhone() {
		return this.sellerPhone;
	}
	public void setSellerPhone(String sellerPhone) {
		this.sellerPhone = sellerPhone;
	}

	public String getStatus() {
		return this.status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public Long getTotalPackage() {
		return this.totalPackage;
	}
	public void setTotalPackage(Long totalPackage) {
		this.totalPackage = totalPackage;
	}

	public String getTransportContactor() {
		return this.transportContactor;
	}
	public void setTransportContactor(String transportContactor) {
		this.transportContactor = transportContactor;
	}

	public String getTransportContactorPhone() {
		return this.transportContactorPhone;
	}
	public void setTransportContactorPhone(String transportContactorPhone) {
		this.transportContactorPhone = transportContactorPhone;
	}

	public String getTransportName() {
		return this.transportName;
	}
	public void setTransportName(String transportName) {
		this.transportName = transportName;
	}

	public String getTransportNo() {
		return this.transportNo;
	}
	public void setTransportNo(String transportNo) {
		this.transportNo = transportNo;
	}

	public String getType() {
		return this.type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public Long getWaitConfirm() {
		return this.waitConfirm;
	}
	public void setWaitConfirm(Long waitConfirm) {
		this.waitConfirm = waitConfirm;
	}

}
