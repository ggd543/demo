package com.taobao.api.domain;

import java.util.Date;
import com.taobao.api.internal.mapping.ApiClass;
import com.taobao.api.internal.mapping.ApiField;


import com.taobao.api.TaobaoObject;

/**
 * WarehouseReturnMain Data Structure.
 * 
 * DESC：退货单主信息 
 *
 * @author auto create
 * @since 1.0, 2010-12-01 15:52:13.0
 */
@ApiClass("WarehouseReturnMain")
public class WarehouseReturnMain extends TaobaoObject {

	private static final long serialVersionUID = 8361897645526954366L;

	
	/** 
	 * 买家地址
	 **/
	@ApiField("buyer_address")
	private String buyerAddress;

	
	/** 
	 * 买家联系人
	 **/
	@ApiField("buyer_contactor")
	private String buyerContactor;

	
	/** 
	 * 买家联系电话
	 **/
	@ApiField("buyer_phone")
	private String buyerPhone;

	
	/** 
	 * 联系方式,得到如下值： CONTACT_MODE_STORE -- 配送中心联系 CONTACT_MODE_DEALER -- 买家联系
	 **/
	@ApiField("contact_express_mode")
	private String contactExpressMode;

	
	/** 
	 * 退货单唯一标识
	 **/
	@ApiField("crk_code")
	private String crkCode;

	
	/** 
	 * 退货时间
	 **/
	@ApiField("crk_date")
	private Date crkDate;

	
	/** 
	 * 服务方式，得到如下值(英文): OPTIONS_STORE -- 配送中心处理 OPTIONS_DEALER -- 商家处理
	 **/
	@ApiField("options")
	private String options;

	
	/** 
	 * 原物流编号
	 **/
	@ApiField("order_code")
	private String orderCode;

	
	/** 
	 * 原因描述
	 **/
	@ApiField("return_reason")
	private String returnReason;

	
	/** 
	 * 退货原因,得到如下值(英文)： REASON_QUALITY -- 商品质量问题 REASON_UNCONFORMITY -- 收到的商品不符 REASON_REBATE -- 折扣、赠品、发票问题 REASON_HEBDOMAD -- 7天无理由退货 REASON_OTHER -- 其他
	 **/
	@ApiField("return_reason_code")
	private String returnReasonCode;

	
	/** 
	 * 商家联系人
	 **/
	@ApiField("seller_contactor")
	private String sellerContactor;

	
	/** 
	 * 商家联系电话
	 **/
	@ApiField("seller_phone")
	private String sellerPhone;

	
	/** 
	 * 配送中心，若服务方式为配送中心，则该字段必填，反之则不填
	 **/
	@ApiField("seller_store_id")
	private Long sellerStoreId;

	
	/** 
	 * 退货单状态： 
(编辑中) STATUS_EDIT; 
(同步中) STATUS_SYN; 
(已同步) STATUS_SYNCHRONIZED; 
(待确认库存) STATUS_WAIT_CONFIRM; 
(已完成) STATUS_COMPLETED;
	 **/
	@ApiField("status")
	private String status;

	
	/** 
	 * 原订单编号
	 **/
	@ApiField("taobao_trade_id")
	private Long taobaoTradeId;

	
	/** 
	 * 物流公司
	 **/
	@ApiField("transport_name")
	private String transportName;

	
	/** 
	 * 运单号码,若联系方式选择配送中心，则该字段必填，反之则不填。
	 **/
	@ApiField("transport_no")
	private String transportNo;

	public String getBuyerAddress() {
		return this.buyerAddress;
	}
	public void setBuyerAddress(String buyerAddress) {
		this.buyerAddress = buyerAddress;
	}

	public String getBuyerContactor() {
		return this.buyerContactor;
	}
	public void setBuyerContactor(String buyerContactor) {
		this.buyerContactor = buyerContactor;
	}

	public String getBuyerPhone() {
		return this.buyerPhone;
	}
	public void setBuyerPhone(String buyerPhone) {
		this.buyerPhone = buyerPhone;
	}

	public String getContactExpressMode() {
		return this.contactExpressMode;
	}
	public void setContactExpressMode(String contactExpressMode) {
		this.contactExpressMode = contactExpressMode;
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

	public String getOptions() {
		return this.options;
	}
	public void setOptions(String options) {
		this.options = options;
	}

	public String getOrderCode() {
		return this.orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public String getReturnReason() {
		return this.returnReason;
	}
	public void setReturnReason(String returnReason) {
		this.returnReason = returnReason;
	}

	public String getReturnReasonCode() {
		return this.returnReasonCode;
	}
	public void setReturnReasonCode(String returnReasonCode) {
		this.returnReasonCode = returnReasonCode;
	}

	public String getSellerContactor() {
		return this.sellerContactor;
	}
	public void setSellerContactor(String sellerContactor) {
		this.sellerContactor = sellerContactor;
	}

	public String getSellerPhone() {
		return this.sellerPhone;
	}
	public void setSellerPhone(String sellerPhone) {
		this.sellerPhone = sellerPhone;
	}

	public Long getSellerStoreId() {
		return this.sellerStoreId;
	}
	public void setSellerStoreId(Long sellerStoreId) {
		this.sellerStoreId = sellerStoreId;
	}

	public String getStatus() {
		return this.status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public Long getTaobaoTradeId() {
		return this.taobaoTradeId;
	}
	public void setTaobaoTradeId(Long taobaoTradeId) {
		this.taobaoTradeId = taobaoTradeId;
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

}
