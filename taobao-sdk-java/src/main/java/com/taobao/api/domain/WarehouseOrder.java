package com.taobao.api.domain;

import com.taobao.api.internal.mapping.ApiClass;
import com.taobao.api.internal.mapping.ApiField;


import com.taobao.api.TaobaoObject;

/**
 * WarehouseOrder Data Structure.
 * 
 * DESC：仓储物流订单 
 *
 * @author auto create
 * @since 1.0, 2010-08-23 21:29:56.0
 */
@ApiClass("WarehouseOrder")
public class WarehouseOrder extends TaobaoObject {

	private static final long serialVersionUID = 8819337445933825788L;

	
	/** 
	 * 物流公司id
	 **/
	@ApiField("company_id")
	private Long companyId;

	
	/** 
	 * 淘宝物流平台物流订单编号
	 **/
	@ApiField("order_code")
	private String orderCode;

	
	/** 
	 * 订单唯一标识
	 **/
	@ApiField("order_id")
	private String orderId;

	
	/** 
	 * 物流订单状态TO_BE_SENT（待处理）SIGN_IN（已签收）REJECTED_BY_OTHER_SIDE（签收失败）
	 **/
	@ApiField("order_status")
	private String orderStatus;

	
	/** 
	 * 物流公司运单号
	 **/
	@ApiField("out_sid")
	private String outSid;

	
	/** 
	 * 收货人详细地址
	 **/
	@ApiField("receiver_address")
	private String receiverAddress;

	
	/** 
	 * 收货人姓名
	 **/
	@ApiField("receiver_name")
	private String receiverName;

	
	/** 
	 * 自定义仓库ID
	 **/
	@ApiField("seller_store_id")
	private String sellerStoreId;

	
	/** 
	 * 淘宝业务订单号
	 **/
	@ApiField("tid")
	private Long tid;

	
	/** 
	 * 支付宝交易号
	 **/
	@ApiField("trade_id")
	private String tradeId;

	public Long getCompanyId() {
		return this.companyId;
	}
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public String getOrderCode() {
		return this.orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public String getOrderId() {
		return this.orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getOrderStatus() {
		return this.orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getOutSid() {
		return this.outSid;
	}
	public void setOutSid(String outSid) {
		this.outSid = outSid;
	}

	public String getReceiverAddress() {
		return this.receiverAddress;
	}
	public void setReceiverAddress(String receiverAddress) {
		this.receiverAddress = receiverAddress;
	}

	public String getReceiverName() {
		return this.receiverName;
	}
	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public String getSellerStoreId() {
		return this.sellerStoreId;
	}
	public void setSellerStoreId(String sellerStoreId) {
		this.sellerStoreId = sellerStoreId;
	}

	public Long getTid() {
		return this.tid;
	}
	public void setTid(Long tid) {
		this.tid = tid;
	}

	public String getTradeId() {
		return this.tradeId;
	}
	public void setTradeId(String tradeId) {
		this.tradeId = tradeId;
	}

}
