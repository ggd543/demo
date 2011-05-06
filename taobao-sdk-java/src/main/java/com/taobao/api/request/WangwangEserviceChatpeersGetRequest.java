package com.taobao.api.request;

import java.util.Map;
import java.util.Date;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.TaobaoRequest;

/**
 * TOP API: taobao.wangwang.eservice.chatpeers.get request
 * 
 * @author auto create
 * @since 1.0, 2010-06-23 10:27:55.0
 */
public class WangwangEserviceChatpeersGetRequest implements TaobaoRequest {
	private Long timestamp;	
	private TaobaoHashMap textParams = new TaobaoHashMap();


	
	/** 
	 * 字符集
	 **/
	private String charset;
	
	/** 
	 * 聊天用户ID：cntaobao+淘宝nick，例如cntaobaotest
	 **/
	private String chatId;
	
	/** 
	 * 查询结束日期。如2010-03-24，与起始日期跨度不能超过7天
	 **/
	private String endDate;
	
	/** 
	 * 查询起始日期。如2010-02-01，与当前日期间隔小于3个月。
	 **/
	private String startDate;

	public void setCharset(String charset) {
		this.charset = charset;
	}
	 public String getCharset() {
		return this.charset;
	}
	public void setChatId(String chatId) {
		this.chatId = chatId;
	}
	 public String getChatId() {
		return this.chatId;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	 public String getEndDate() {
		return this.endDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	 public String getStartDate() {
		return this.startDate;
	}
	
	public String getApiMethodName() {
		return "taobao.wangwang.eservice.chatpeers.get";
	}

	public Map<String, String> getTextParams() {		
		textParams.put("charset", this.charset);
		textParams.put("chat_id", this.chatId);
		textParams.put("end_date", this.endDate);
		textParams.put("start_date", this.startDate);
		return textParams;
	}
	
	public Long getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
}
