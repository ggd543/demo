package com.taobao.api.request;
import java.util.Date;

import java.util.Map;
import java.util.Date;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.TaobaoRequest;

/**
 * TOP API: taobao.guarantyfunds.get request
 * 
 * @author auto create
 * @since 1.0, 2010-08-23 20:13:33.0
 */
public class GuarantyfundsGetRequest implements TaobaoRequest {
	private Long timestamp;	
	private TaobaoHashMap textParams = new TaobaoHashMap();


	
	/** 
	 * 查询保证金操作记录创建时间开始，格式为:yyyy-MM-dd
	 **/
	private Date beginDate;
	
	/** 
	 * 查询保证金操作记录创建时间结束，格式为:yyyy-MM-dd
	 **/
	private Date endDate;

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}
	 public Date getBeginDate() {
		return this.beginDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	 public Date getEndDate() {
		return this.endDate;
	}
	
	public String getApiMethodName() {
		return "taobao.guarantyfunds.get";
	}

	public Map<String, String> getTextParams() {		
		textParams.put("begin_date", this.beginDate);
		textParams.put("end_date", this.endDate);
		return textParams;
	}
	
	public Long getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
}
