package com.taobao.api.request;

import java.util.Map;
import java.util.Date;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.TaobaoRequest;

/**
 * TOP API: taobao.warehouse.return.add request
 * 
 * @author auto create
 * @since 1.0, 2010-12-01 15:53:39.0
 */
public class WarehouseReturnAddRequest implements TaobaoRequest {
	private Long timestamp;	
	private TaobaoHashMap textParams = new TaobaoHashMap();


	
	/** 
	 * 买家地址
	 **/
	private String buyerAddress;
	
	/** 
	 * 买家联系人
	 **/
	private String buyerContactor;
	
	/** 
	 * 买家联系电话。格式：纯数字(手机) 或者 区号-数字
	 **/
	private String buyerPhone;
	
	/** 
	 * 联系方式,只能输入如下值：
CONTACT_MODE_STORE --  配送中心联系
CONTACT_MODE_DEALER --  买家联系
	 **/
	private String contactExpressMode;
	
	/** 
	 * 服务方式，只能输入如下值(英文):
OPTIONS_STORE --  配送中心处理
OPTIONS_DEALER --  商家处理
	 **/
	private String options;
	
	/** 
	 * 原物流编号，与“原订单编号”至少选填一个
	 **/
	private String orderCode;
	
	/** 
	 * 要退货的商品的商家编码，以逗号隔开
	 **/
	private String outerIds;
	
	/** 
	 * 计划退货数量，以逗号隔开，个数与商家编码一致。
	 **/
	private String planCount;
	
	/** 
	 * 备注,个数与商家编码一致，以逗号隔开。若中间无值也需以占一个值. 例"test1,,test3".若全为空则不需要给值
	 **/
	private String remarks;
	
	/** 
	 * 原因描述
	 **/
	private String returnReason;
	
	/** 
	 * 退货原因,只能输入如下值(英文)：
REASON_QUALITY -- 商品质量问题
REASON_UNCONFORMITY -- 收到的商品不符
REASON_REBATE  -- 折扣、赠品、发票问题
REASON_HEBDOMAD  -- 7天无理由退货
REASON_OTHER  -- 其他
	 **/
	private String returnReasonCode;
	
	/** 
	 * 商家联系人
	 **/
	private String sellerContactor;
	
	/** 
	 * 商家联系电话。格式：纯数字(手机) 或者 区号-数字
	 **/
	private String sellerPhone;
	
	/** 
	 * 配送中心，若服务方式为配送中心处理，则该字段必填，反之则不填
	 **/
	private Long sellerStoreId;
	
	/** 
	 * 原订单编号，与“原物流编号”至少选填一个。
	 **/
	private Long taobaoTradeId;
	
	/** 
	 * 物流公司
	 **/
	private String transportName;
	
	/** 
	 * 运单号码,若联系方式选择买家联系，则该字段必填，反之则不填。说明：退货快递公司运单上的运单号
	 **/
	private String transportNo;

	public void setBuyerAddress(String buyerAddress) {
		this.buyerAddress = buyerAddress;
	}
	 public String getBuyerAddress() {
		return this.buyerAddress;
	}
	public void setBuyerContactor(String buyerContactor) {
		this.buyerContactor = buyerContactor;
	}
	 public String getBuyerContactor() {
		return this.buyerContactor;
	}
	public void setBuyerPhone(String buyerPhone) {
		this.buyerPhone = buyerPhone;
	}
	 public String getBuyerPhone() {
		return this.buyerPhone;
	}
	public void setContactExpressMode(String contactExpressMode) {
		this.contactExpressMode = contactExpressMode;
	}
	 public String getContactExpressMode() {
		return this.contactExpressMode;
	}
	public void setOptions(String options) {
		this.options = options;
	}
	 public String getOptions() {
		return this.options;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	 public String getOrderCode() {
		return this.orderCode;
	}
	public void setOuterIds(String outerIds) {
		this.outerIds = outerIds;
	}
	 public String getOuterIds() {
		return this.outerIds;
	}
	public void setPlanCount(String planCount) {
		this.planCount = planCount;
	}
	 public String getPlanCount() {
		return this.planCount;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	 public String getRemarks() {
		return this.remarks;
	}
	public void setReturnReason(String returnReason) {
		this.returnReason = returnReason;
	}
	 public String getReturnReason() {
		return this.returnReason;
	}
	public void setReturnReasonCode(String returnReasonCode) {
		this.returnReasonCode = returnReasonCode;
	}
	 public String getReturnReasonCode() {
		return this.returnReasonCode;
	}
	public void setSellerContactor(String sellerContactor) {
		this.sellerContactor = sellerContactor;
	}
	 public String getSellerContactor() {
		return this.sellerContactor;
	}
	public void setSellerPhone(String sellerPhone) {
		this.sellerPhone = sellerPhone;
	}
	 public String getSellerPhone() {
		return this.sellerPhone;
	}
	public void setSellerStoreId(Long sellerStoreId) {
		this.sellerStoreId = sellerStoreId;
	}
	 public Long getSellerStoreId() {
		return this.sellerStoreId;
	}
	public void setTaobaoTradeId(Long taobaoTradeId) {
		this.taobaoTradeId = taobaoTradeId;
	}
	 public Long getTaobaoTradeId() {
		return this.taobaoTradeId;
	}
	public void setTransportName(String transportName) {
		this.transportName = transportName;
	}
	 public String getTransportName() {
		return this.transportName;
	}
	public void setTransportNo(String transportNo) {
		this.transportNo = transportNo;
	}
	 public String getTransportNo() {
		return this.transportNo;
	}
	
	public String getApiMethodName() {
		return "taobao.warehouse.return.add";
	}

	public Map<String, String> getTextParams() {		
		textParams.put("buyer_address", this.buyerAddress);
		textParams.put("buyer_contactor", this.buyerContactor);
		textParams.put("buyer_phone", this.buyerPhone);
		textParams.put("contact_express_mode", this.contactExpressMode);
		textParams.put("options", this.options);
		textParams.put("order_code", this.orderCode);
		textParams.put("outer_ids", this.outerIds);
		textParams.put("plan_count", this.planCount);
		textParams.put("remarks", this.remarks);
		textParams.put("return_reason", this.returnReason);
		textParams.put("return_reason_code", this.returnReasonCode);
		textParams.put("seller_contactor", this.sellerContactor);
		textParams.put("seller_phone", this.sellerPhone);
		textParams.put("seller_store_id", this.sellerStoreId);
		textParams.put("taobao_trade_id", this.taobaoTradeId);
		textParams.put("transport_name", this.transportName);
		textParams.put("transport_no", this.transportNo);
		return textParams;
	}
	
	public Long getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
}
