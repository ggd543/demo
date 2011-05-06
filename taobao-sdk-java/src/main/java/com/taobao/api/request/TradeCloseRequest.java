package com.taobao.api.request;

import java.util.Map;
import java.util.Date;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.TaobaoRequest;

/**
 * TOP API: taobao.trade.close request
 * 
 * @author auto create
 * @since 1.0, 2010-09-16 13:44:05.0
 */
public class TradeCloseRequest implements TaobaoRequest {
	private Long timestamp;	
	private TaobaoHashMap textParams = new TaobaoHashMap();


	
	/** 
	 * 交易关闭原因。最小长度: 6个字节
	 **/
	private String closeReason;
	
	/** 
	 * 主订单编号（不支持关闭子订单）
	 **/
	private Long tid;

	public void setCloseReason(String closeReason) {
		this.closeReason = closeReason;
	}
	 public String getCloseReason() {
		return this.closeReason;
	}
	public void setTid(Long tid) {
		this.tid = tid;
	}
	 public Long getTid() {
		return this.tid;
	}
	
	public String getApiMethodName() {
		return "taobao.trade.close";
	}

	public Map<String, String> getTextParams() {		
		textParams.put("close_reason", this.closeReason);
		textParams.put("tid", this.tid);
		return textParams;
	}
	
	public Long getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
}
