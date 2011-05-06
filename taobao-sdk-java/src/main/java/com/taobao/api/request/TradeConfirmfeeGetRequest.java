package com.taobao.api.request;

import java.util.Map;
import java.util.Date;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.TaobaoRequest;

/**
 * TOP API: taobao.trade.confirmfee.get request
 * 
 * @author auto create
 * @since 1.0, 2010-08-04 09:31:21.0
 */
public class TradeConfirmfeeGetRequest implements TaobaoRequest {
	private Long timestamp;	
	private TaobaoHashMap textParams = new TaobaoHashMap();


	
	/** 
	 * 是否是子订单。可选值:IS_FATHER(父订单),IS_CHILD(子订单)
	 **/
	private String isDetail;
	
	/** 
	 * 交易编号，或子订单编号
	 **/
	private Long tid;

	public void setIsDetail(String isDetail) {
		this.isDetail = isDetail;
	}
	 public String getIsDetail() {
		return this.isDetail;
	}
	public void setTid(Long tid) {
		this.tid = tid;
	}
	 public Long getTid() {
		return this.tid;
	}
	
	public String getApiMethodName() {
		return "taobao.trade.confirmfee.get";
	}

	public Map<String, String> getTextParams() {		
		textParams.put("is_detail", this.isDetail);
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
