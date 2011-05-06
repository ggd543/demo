package com.taobao.api.request;
import java.util.Date;

import java.util.Map;
import java.util.Date;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.TaobaoRequest;

/**
 * TOP API: taobao.tp.subsc.add request
 * 
 * @author auto create
 * @since 1.0, 2010-10-14 11:51:12.0
 */
public class TpSubscAddRequest implements TaobaoRequest {
	private Long timestamp;	
	private TaobaoHashMap textParams = new TaobaoHashMap();


	
	/** 
	 * 用户昵称
	 **/
	private String nick;
	
	/** 
	 * 订单结束时间
	 **/
	private Date orderEndTime;
	
	/** 
	 * 订单开始时间,此时间必须大于等于当前时间
	 **/
	private Date orderStartTime;
	
	/** 
	 * 外部交易订单号
	 **/
	private String outTradeNo;

	public void setNick(String nick) {
		this.nick = nick;
	}
	 public String getNick() {
		return this.nick;
	}
	public void setOrderEndTime(Date orderEndTime) {
		this.orderEndTime = orderEndTime;
	}
	 public Date getOrderEndTime() {
		return this.orderEndTime;
	}
	public void setOrderStartTime(Date orderStartTime) {
		this.orderStartTime = orderStartTime;
	}
	 public Date getOrderStartTime() {
		return this.orderStartTime;
	}
	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}
	 public String getOutTradeNo() {
		return this.outTradeNo;
	}
	
	public String getApiMethodName() {
		return "taobao.tp.subsc.add";
	}

	public Map<String, String> getTextParams() {		
		textParams.put("nick", this.nick);
		textParams.put("order_end_time", this.orderEndTime);
		textParams.put("order_start_time", this.orderStartTime);
		textParams.put("out_trade_no", this.outTradeNo);
		return textParams;
	}
	
	public Long getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
}
