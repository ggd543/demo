package com.taobao.api.response;

import com.taobao.api.internal.mapping.ApiField;


import com.taobao.api.TaobaoResponse;

/**
 * TOP API: taobao.warehouse.order.get response
 * 
 * @author auto create
 * @since 1.0,2010-11-23 17:19:15.0
 */
public class WarehouseOrderGetResponse extends TaobaoResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3691741926856841113L;

	
	/** 
	 * 物流公司编码
	 **/
	@ApiField("company_code")
	private String companyCode;
	
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
	 * 物流订单状态。
返回值如下：HANGUP(订单挂起)；CLOSED(订单已关闭)；
WAITING_TO_BE_SENT(等待下单给物流公司)；
SENT_COMPANY_MAKE_SURE(订单已发给物流公司)；
COMPANY_MAKE_SURE(物流公司已确认收到下单消息)；
ACCEPTED_BY_COMPANY(物流公司已接单)；
REJECTED_BY_COMPANY(物流公司不接单)；
TAKEN_IN_SUCCESS(揽收成功)；
TAKEN_IN_FAILED(揽收失败)；
LOST(丢单)；
SIGN_IN(签收成功)；
REJECTED_BY_OTHER_SIDE(签收失败)；
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
	 * 卖家默认发货所在区域详细地址
	 **/
	@ApiField("seller_address")
	private String sellerAddress;
	
	/** 
	 * 卖家默认发货所在区域ID;
如浙江省杭州市区湖区对应seller_are_id=330106;
	 **/
	@ApiField("seller_area_id")
	private String sellerAreaId;
	
	/** 
	 * 卖家移动电话
	 **/
	@ApiField("seller_mobile")
	private String sellerMobile;
	
	/** 
	 * 卖家姓名
	 **/
	@ApiField("seller_name")
	private String sellerName;
	
	/** 
	 * 卖家联系电话
	 **/
	@ApiField("seller_phone")
	private String sellerPhone;
	
	/** 
	 * 自定义仓储ID
	 **/
	@ApiField("seller_store_id")
	private String sellerStoreId;
	
	/** 
	 * 卖家默认邮编
	 **/
	@ApiField("seller_zip")
	private String sellerZip;
	
	/** 
	 * 淘宝业务订单号
	 **/
	@ApiField("tid")
	private String tid;
	
	/** 
	 * 支付宝交易号
	 **/
	@ApiField("trade_id")
	private String tradeId;

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getCompanyCode( ) {
		return this.companyCode;
	}
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public Long getCompanyId( ) {
		return this.companyId;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public String getOrderCode( ) {
		return this.orderCode;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getOrderId( ) {
		return this.orderId;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getOrderStatus( ) {
		return this.orderStatus;
	}
	public void setOutSid(String outSid) {
		this.outSid = outSid;
	}

	public String getOutSid( ) {
		return this.outSid;
	}
	public void setReceiverAddress(String receiverAddress) {
		this.receiverAddress = receiverAddress;
	}

	public String getReceiverAddress( ) {
		return this.receiverAddress;
	}
	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public String getReceiverName( ) {
		return this.receiverName;
	}
	public void setSellerAddress(String sellerAddress) {
		this.sellerAddress = sellerAddress;
	}

	public String getSellerAddress( ) {
		return this.sellerAddress;
	}
	public void setSellerAreaId(String sellerAreaId) {
		this.sellerAreaId = sellerAreaId;
	}

	public String getSellerAreaId( ) {
		return this.sellerAreaId;
	}
	public void setSellerMobile(String sellerMobile) {
		this.sellerMobile = sellerMobile;
	}

	public String getSellerMobile( ) {
		return this.sellerMobile;
	}
	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public String getSellerName( ) {
		return this.sellerName;
	}
	public void setSellerPhone(String sellerPhone) {
		this.sellerPhone = sellerPhone;
	}

	public String getSellerPhone( ) {
		return this.sellerPhone;
	}
	public void setSellerStoreId(String sellerStoreId) {
		this.sellerStoreId = sellerStoreId;
	}

	public String getSellerStoreId( ) {
		return this.sellerStoreId;
	}
	public void setSellerZip(String sellerZip) {
		this.sellerZip = sellerZip;
	}

	public String getSellerZip( ) {
		return this.sellerZip;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}

	public String getTid( ) {
		return this.tid;
	}
	public void setTradeId(String tradeId) {
		this.tradeId = tradeId;
	}

	public String getTradeId( ) {
		return this.tradeId;
	}

	public String getApiMethodName() {
		return "taobao.warehouse.order.get";
	}

}
