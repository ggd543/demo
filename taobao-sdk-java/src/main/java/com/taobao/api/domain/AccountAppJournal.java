package com.taobao.api.domain;

import java.util.Date;
import com.taobao.api.internal.mapping.ApiClass;
import com.taobao.api.internal.mapping.ApiField;


import com.taobao.api.TaobaoObject;

/**
 * AccountAppJournal Data Structure.
 * 
 * DESC：账户流水列表 
 *
 * @author auto create
 * @since 1.0, 2010-11-26 16:33:04.0
 */
@ApiClass("AccountAppJournal")
public class AccountAppJournal extends TaobaoObject {

	private static final long serialVersionUID = 6216156183356564987L;

	
	/** 
	 * 资产类型
	 **/
	@ApiField("balance_type")
	private Long balanceType;

	
	/** 
	 * 操作金额
	 **/
	@ApiField("deal_amount")
	private Long dealAmount;

	
	/** 
	 * 创建时间
	 **/
	@ApiField("gmt_create")
	private Date gmtCreate;

	
	/** 
	 * 流水类型
	 **/
	@ApiField("journal_type")
	private Long journalType;

	
	/** 
	 * 请求时间
	 **/
	@ApiField("response_time")
	private Date responseTime;

	
	/** 
	 * 交易号
	 **/
	@ApiField("trade_no")
	private String tradeNo;

	
	/** 
	 * 用户id
	 **/
	@ApiField("user_id")
	private Long userId;

	public Long getBalanceType() {
		return this.balanceType;
	}
	public void setBalanceType(Long balanceType) {
		this.balanceType = balanceType;
	}

	public Long getDealAmount() {
		return this.dealAmount;
	}
	public void setDealAmount(Long dealAmount) {
		this.dealAmount = dealAmount;
	}

	public Date getGmtCreate() {
		return this.gmtCreate;
	}
	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public Long getJournalType() {
		return this.journalType;
	}
	public void setJournalType(Long journalType) {
		this.journalType = journalType;
	}

	public Date getResponseTime() {
		return this.responseTime;
	}
	public void setResponseTime(Date responseTime) {
		this.responseTime = responseTime;
	}

	public String getTradeNo() {
		return this.tradeNo;
	}
	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}

	public Long getUserId() {
		return this.userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}

}
