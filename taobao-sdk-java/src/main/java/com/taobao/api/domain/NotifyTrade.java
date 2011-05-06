package com.taobao.api.domain;

import java.util.Date;
import com.taobao.api.internal.mapping.ApiClass;
import com.taobao.api.internal.mapping.ApiField;


import com.taobao.api.TaobaoObject;

/**
 * NotifyTrade Data Structure.
 * 
 * DESC：交易通知消息 
 *
 * @author auto create
 * @since 1.0, 2010-04-22 13:42:06.0
 */
@ApiClass("NotifyTrade")
public class NotifyTrade extends TaobaoObject {

	private static final long serialVersionUID = 6853957374511964943L;

	
	/** 
	 * 买家昵称
	 **/
	@ApiField("buyer_nick")
	private String buyerNick;

	
	/** 
	 * 是否3D淘宝的交易。
	 **/
	@ApiField("is_3D")
	private Boolean is3D;

	
	/** 
	 * 交易修改时间（格式：yyyy-MM-dd HH:mm:ss）
	 **/
	@ApiField("modified")
	private Date modified;

	
	/** 
	 * 买家实付金额
	 **/
	@ApiField("payment")
	private String payment;

	
	/** 
	 * 卖家昵称
	 **/
	@ApiField("seller_nick")
	private String sellerNick;

	
	/** 
	 * 交易操作所对应的交易增量消息状态，对应与NotifyTrade的status字段 

可选值 
TradeCreate（创建交易） 
TradeModifyFee（修改交易费用） 
TradeCloseAndModifyDetailOrder（关闭或修改子订单） 
TradeClose（关闭交易） 
TradeBuyerPay（买家付款） 
TradeSellerShip（卖家发货） 
TradeDelayConfirmPay（延长收货时间） 
TradePartlyRefund（子订单退款成功） 
TradePartlyConfirmPay（子订单打款成功） 
TradeSuccess（交易成功） 
TradeTimeoutRemind（交易超时提醒） 
TradeRated（交易评价变更） 
TradeMemoModified（交易备注修改） 
TradeLogisticsAddressChanged（修改交易收货地址） 
TradeChanged（修改订单信息（SKU等））
	 **/
	@ApiField("status")
	private String status;

	
	/** 
	 * 交易编号
	 **/
	@ApiField("tid")
	private Long tid;

	
	/** 
	 * 交易类型。除了交易超时提醒消息没有类型以外，其他消息都有交易类型。

具体分类有： 

可选值 
ec（直冲） 
guarantee_trade（一口价、拍卖） 
auto_delivery（自动发货） 
cod（货到付款） 
independent_shop_trade（旺店标准版交易） 
independent_simple_trade（旺店入门版交易） 
shopex_trade（ShopEX版) 
netcn_trade（淘宝与万网合作版网） 
travel（旅游产品交易） 
fenxiao（分销平台交易） 
game_equipment（网游虚拟交易）
	 **/
	@ApiField("type")
	private String type;

	public String getBuyerNick() {
		return this.buyerNick;
	}
	public void setBuyerNick(String buyerNick) {
		this.buyerNick = buyerNick;
	}

	public Boolean getIs3D() {
		return this.is3D;
	}
	public void setIs3D(Boolean is3D) {
		this.is3D = is3D;
	}

	public Date getModified() {
		return this.modified;
	}
	public void setModified(Date modified) {
		this.modified = modified;
	}

	public String getPayment() {
		return this.payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}

	public String getSellerNick() {
		return this.sellerNick;
	}
	public void setSellerNick(String sellerNick) {
		this.sellerNick = sellerNick;
	}

	public String getStatus() {
		return this.status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public Long getTid() {
		return this.tid;
	}
	public void setTid(Long tid) {
		this.tid = tid;
	}

	public String getType() {
		return this.type;
	}
	public void setType(String type) {
		this.type = type;
	}

}
