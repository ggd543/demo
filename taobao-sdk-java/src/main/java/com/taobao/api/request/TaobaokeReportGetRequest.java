package com.taobao.api.request;

import java.util.Map;
import java.util.Date;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.TaobaoRequest;

/**
 * TOP API: taobao.taobaoke.report.get request
 * 
 * @author auto create
 * @since 1.0, 2010-08-12 20:52:43.0
 */
public class TaobaokeReportGetRequest implements TaobaoRequest {
	private Long timestamp;	
	private TaobaoHashMap textParams = new TaobaoHashMap();


	
	/** 
	 * 需要查询报表的日期，有效的日期为最近3个月内的某一天，格式为:yyyyMMdd,如20090520.
	 **/
	private String date;
	
	/** 
	 * 需返回的字段列表.可选值:TaobaokeReportMember淘宝客报表成员结构体中的所有字段;字段之间用","分隔.
	 **/
	private String fields;

	public void setDate(String date) {
		this.date = date;
	}
	 public String getDate() {
		return this.date;
	}
	public void setFields(String fields) {
		this.fields = fields;
	}
	 public String getFields() {
		return this.fields;
	}
	
	public String getApiMethodName() {
		return "taobao.taobaoke.report.get";
	}

	public Map<String, String> getTextParams() {		
		textParams.put("date", this.date);
		textParams.put("fields", this.fields);
		return textParams;
	}
	
	public Long getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
}
