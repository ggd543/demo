package com.taobao.api.request;

import java.util.Map;
import java.util.Date;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.TaobaoRequest;

/**
 * TOP API: taobao.trade.snapshot.get request
 * 
 * @author auto create
 * @since 1.0, 2010-08-03 14:57:15.0
 */
public class TradeSnapshotGetRequest implements TaobaoRequest {
	private Long timestamp;	
	private TaobaoHashMap textParams = new TaobaoHashMap();


	
	/** 
	 * 需要返回的字段列表。现只支持："snapshot"字段
	 **/
	private String fields;
	
	/** 
	 * 交易编号
	 **/
	private Long tid;

	public void setFields(String fields) {
		this.fields = fields;
	}
	 public String getFields() {
		return this.fields;
	}
	public void setTid(Long tid) {
		this.tid = tid;
	}
	 public Long getTid() {
		return this.tid;
	}
	
	public String getApiMethodName() {
		return "taobao.trade.snapshot.get";
	}

	public Map<String, String> getTextParams() {		
		textParams.put("fields", this.fields);
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
