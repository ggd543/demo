package com.taobao.api.domain;

import java.util.Date;
import java.util.List;
import com.taobao.api.internal.mapping.ApiClass;
import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.internal.mapping.ApiListField;


import com.taobao.api.TaobaoObject;

/**
 * PurchaseOrder Data Structure.
 * 
 * DESC：采购单及子采购单信息 
 *
 * @author auto create
 * @since 1.0, 2010-07-07 11:44:25.0
 */
@ApiClass("PurchaseOrder")
public class PurchaseOrder extends TaobaoObject {

	private static final long serialVersionUID = 3866766817767248974L;

	
	/** 
	 * 支付宝交易号。
	 **/
	@ApiField("alipay_no")
	private Long alipayNo;

	
	/** 
	 * 买家nick（只有分销商可查询）
	 **/
	@ApiField("buyer_nick")
	private String buyerNick;

	
	/** 
	 * 物流发货时间。格式:yyyy-MM-dd HH:mm:ss
	 **/
	@ApiField("consign_time")
	private Date consignTime;

	
	/** 
	 * 采购单创建时间。格式:yyyy-MM-dd HH:mm:ss
	 **/
	@ApiField("created")
	private Date created;

	
	/** 
	 * 分销商来源网站（暂时只有taobao）。
	 **/
	@ApiField("distributor_from")
	private String distributorFrom;

	
	/** 
	 * 分销商留言。
	 **/
	@ApiField("distributor_memo")
	private String distributorMemo;

	
	/** 
	 * 分销商实付金额。(精确到2位小数;单位:元。如:200.07，表示:200元7分 )
	 **/
	@ApiField("distributor_payment")
	private String distributorPayment;

	
	/** 
	 * 分销商在来源网站的帐号名。
	 **/
	@ApiField("distributor_username")
	private String distributorUsername;

	
	/** 
	 * 采购单编号。
	 **/
	@ApiField("id")
	private Long id;

	
	/** 
	 * 交易修改时间。格式:yyyy-MM-dd HH:mm:ss
	 **/
	@ApiField("modified")
	private Date modified;

	
	/** 
	 * 付款时间。格式:yyyy-MM-dd HH:mm:ss
	 **/
	@ApiField("pay_time")
	private Date payTime;

	
	/** 
	 * 采购单邮费。(精确到2位小数;单位:元。如:200.07，表示:200元7分 )
	 **/
	@ApiField("post_fee")
	private String postFee;

	
	/** 
	 * 买家详细的信息。
	 **/
	@ApiField("receiver")
	private Receiver receiver;

	
	/** 
	 * 订单快照URL
	 **/
	@ApiField("snapshot_url")
	private String snapshotUrl;

	
	/** 
	 * 交易状态。可选值:
	 **/
	@ApiField("status")
	private String status;

	
	/** 
	 * 子订单的详细信息列表。
	 **/
	@ApiListField("sub_purchase_orders")
	@ApiField("sub_purchase_order")
	private List<SubPurchaseOrder> subPurchaseOrders;

	
	/** 
	 * 供应商来源网站, values: taobao, alibaba
	 **/
	@ApiField("supplier_from")
	private String supplierFrom;

	
	/** 
	 * 供应商在来源网站的帐号名。
	 **/
	@ApiField("supplier_username")
	private String supplierUsername;

	
	/** 
	 * 采购单总额（不含邮费,精确到2位小数;单位:元。如:200.07，表示:200元7分 )
	 **/
	@ApiField("total_fee")
	private String totalFee;

	
	/** 
	 * 采购单类型（代销、零批） values:daixiao,lingpi。
	 **/
	@ApiField("type")
	private String type;

	public Long getAlipayNo() {
		return this.alipayNo;
	}
	public void setAlipayNo(Long alipayNo) {
		this.alipayNo = alipayNo;
	}

	public String getBuyerNick() {
		return this.buyerNick;
	}
	public void setBuyerNick(String buyerNick) {
		this.buyerNick = buyerNick;
	}

	public Date getConsignTime() {
		return this.consignTime;
	}
	public void setConsignTime(Date consignTime) {
		this.consignTime = consignTime;
	}

	public Date getCreated() {
		return this.created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}

	public String getDistributorFrom() {
		return this.distributorFrom;
	}
	public void setDistributorFrom(String distributorFrom) {
		this.distributorFrom = distributorFrom;
	}

	public String getDistributorMemo() {
		return this.distributorMemo;
	}
	public void setDistributorMemo(String distributorMemo) {
		this.distributorMemo = distributorMemo;
	}

	public String getDistributorPayment() {
		return this.distributorPayment;
	}
	public void setDistributorPayment(String distributorPayment) {
		this.distributorPayment = distributorPayment;
	}

	public String getDistributorUsername() {
		return this.distributorUsername;
	}
	public void setDistributorUsername(String distributorUsername) {
		this.distributorUsername = distributorUsername;
	}

	public Long getId() {
		return this.id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public Date getModified() {
		return this.modified;
	}
	public void setModified(Date modified) {
		this.modified = modified;
	}

	public Date getPayTime() {
		return this.payTime;
	}
	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}

	public String getPostFee() {
		return this.postFee;
	}
	public void setPostFee(String postFee) {
		this.postFee = postFee;
	}

	public Receiver getReceiver() {
		return this.receiver;
	}
	public void setReceiver(Receiver receiver) {
		this.receiver = receiver;
	}

	public String getSnapshotUrl() {
		return this.snapshotUrl;
	}
	public void setSnapshotUrl(String snapshotUrl) {
		this.snapshotUrl = snapshotUrl;
	}

	public String getStatus() {
		return this.status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public List<SubPurchaseOrder> getSubPurchaseOrders() {
		return this.subPurchaseOrders;
	}
	public void setSubPurchaseOrders(List<SubPurchaseOrder> subPurchaseOrders) {
		this.subPurchaseOrders = subPurchaseOrders;
	}

	public String getSupplierFrom() {
		return this.supplierFrom;
	}
	public void setSupplierFrom(String supplierFrom) {
		this.supplierFrom = supplierFrom;
	}

	public String getSupplierUsername() {
		return this.supplierUsername;
	}
	public void setSupplierUsername(String supplierUsername) {
		this.supplierUsername = supplierUsername;
	}

	public String getTotalFee() {
		return this.totalFee;
	}
	public void setTotalFee(String totalFee) {
		this.totalFee = totalFee;
	}

	public String getType() {
		return this.type;
	}
	public void setType(String type) {
		this.type = type;
	}

}
