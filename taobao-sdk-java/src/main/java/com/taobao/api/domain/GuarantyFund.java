package com.taobao.api.domain;

import java.util.Date;
import com.taobao.api.internal.mapping.ApiClass;
import com.taobao.api.internal.mapping.ApiField;


import com.taobao.api.TaobaoObject;

/**
 * GuarantyFund Data Structure.
 * 
 * DESC：保证金 
 *
 * @author auto create
 * @since 1.0, 2010-08-23 20:11:08.0
 */
@ApiClass("GuarantyFund")
public class GuarantyFund extends TaobaoObject {

	private static final long serialVersionUID = 6688951317531367889L;

	
	/** 
	 * 投诉编号（退款ID）
	 **/
	@ApiField("accuse_id")
	private Long accuseId;

	
	/** 
	 * 保证金金额
	 **/
	@ApiField("amount")
	private Long amount;

	
	/** 
	 * 保证金余额
	 **/
	@ApiField("balance")
	private Long balance;

	
	/** 
	 * 买家编号
	 **/
	@ApiField("buyer_id")
	private Long buyerId;

	
	/** 
	 * 买家昵称
	 **/
	@ApiField("buyer_nick")
	private String buyerNick;

	
	/** 
	 * 保证金创建时间
	 **/
	@ApiField("created")
	private Date created;

	
	/** 
	 * 保证金创建者
	 **/
	@ApiField("creator")
	private String creator;

	
	/** 
	 * 保证金编号
	 **/
	@ApiField("id")
	private Long id;

	
	/** 
	 * 备注（一般为操作类型加上操作动作）
	 **/
	@ApiField("memo")
	private String memo;

	
	/** 
	 * 保证金修改时间
	 **/
	@ApiField("modified")
	private Date modified;

	
	/** 
	 * 保证金操作动作
	 **/
	@ApiField("operation_action")
	private String operationAction;

	
	/** 
	 * 保证金操作类型 (入驻商城冻结1，补缴保证金2，交易纠纷3，退出商城解冻4，提高保证金额度5，降低保证金额度6，人工解冻保证金7，人工转移保证金8，返点9)
	 **/
	@ApiField("operation_type")
	private Long operationType;

	
	/** 
	 * 保证金操作者
	 **/
	@ApiField("operator")
	private String operator;

	
	/** 
	 * 淘宝交易号（主订单的编号）
	 **/
	@ApiField("order_id")
	private Long orderId;

	
	/** 
	 * 商家编号
	 **/
	@ApiField("seller_id")
	private Long sellerId;

	
	/** 
	 * 商家昵称
	 **/
	@ApiField("seller_nick")
	private String sellerNick;

	
	/** 
	 * 保证金状态（失败0，成功1）
	 **/
	@ApiField("status")
	private Long status;

	
	/** 
	 * 保证金类型（冻结保证金1，解冻保证金2，转移保证金3）
	 **/
	@ApiField("type")
	private Long type;

	public Long getAccuseId() {
		return this.accuseId;
	}
	public void setAccuseId(Long accuseId) {
		this.accuseId = accuseId;
	}

	public Long getAmount() {
		return this.amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public Long getBalance() {
		return this.balance;
	}
	public void setBalance(Long balance) {
		this.balance = balance;
	}

	public Long getBuyerId() {
		return this.buyerId;
	}
	public void setBuyerId(Long buyerId) {
		this.buyerId = buyerId;
	}

	public String getBuyerNick() {
		return this.buyerNick;
	}
	public void setBuyerNick(String buyerNick) {
		this.buyerNick = buyerNick;
	}

	public Date getCreated() {
		return this.created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}

	public String getCreator() {
		return this.creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}

	public Long getId() {
		return this.id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getMemo() {
		return this.memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}

	public Date getModified() {
		return this.modified;
	}
	public void setModified(Date modified) {
		this.modified = modified;
	}

	public String getOperationAction() {
		return this.operationAction;
	}
	public void setOperationAction(String operationAction) {
		this.operationAction = operationAction;
	}

	public Long getOperationType() {
		return this.operationType;
	}
	public void setOperationType(Long operationType) {
		this.operationType = operationType;
	}

	public String getOperator() {
		return this.operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}

	public Long getOrderId() {
		return this.orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getSellerId() {
		return this.sellerId;
	}
	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}

	public String getSellerNick() {
		return this.sellerNick;
	}
	public void setSellerNick(String sellerNick) {
		this.sellerNick = sellerNick;
	}

	public Long getStatus() {
		return this.status;
	}
	public void setStatus(Long status) {
		this.status = status;
	}

	public Long getType() {
		return this.type;
	}
	public void setType(Long type) {
		this.type = type;
	}

}
