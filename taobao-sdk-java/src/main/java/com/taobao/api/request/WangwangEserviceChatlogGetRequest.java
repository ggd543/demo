package com.taobao.api.request;

import java.util.Map;
import java.util.Date;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.TaobaoRequest;

/**
 * TOP API: taobao.wangwang.eservice.chatlog.get request
 * 
 * @author auto create
 * @since 1.0, 2010-06-23 10:29:24.0
 */
public class WangwangEserviceChatlogGetRequest implements TaobaoRequest {
	private Long timestamp;	
	private TaobaoHashMap textParams = new TaobaoHashMap();


	
	/** 
	 * 字符集
	 **/
	private String charset;
	
	/** 
	 * 聊天消息终止时间，如2010-03-24
	 **/
	private String endDate;
	
	/** 
	 * 聊天消息被查询用户ID：cntaobao+淘宝nick，例如cntaobaotest
	 **/
	private String fromId;
	
	/** 
	 * 聊天消息起始时间，如2010-02-01
	 **/
	private String startDate;
	
	/** 
	 * 聊天消息相关方ID：cntaobao+淘宝nick，例如cntaobaotest
	 **/
	private String toId;

	public void setCharset(String charset) {
		this.charset = charset;
	}
	 public String getCharset() {
		return this.charset;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	 public String getEndDate() {
		return this.endDate;
	}
	public void setFromId(String fromId) {
		this.fromId = fromId;
	}
	 public String getFromId() {
		return this.fromId;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	 public String getStartDate() {
		return this.startDate;
	}
	public void setToId(String toId) {
		this.toId = toId;
	}
	 public String getToId() {
		return this.toId;
	}
	
	public String getApiMethodName() {
		return "taobao.wangwang.eservice.chatlog.get";
	}

	public Map<String, String> getTextParams() {		
		textParams.put("charset", this.charset);
		textParams.put("end_date", this.endDate);
		textParams.put("from_id", this.fromId);
		textParams.put("start_date", this.startDate);
		textParams.put("to_id", this.toId);
		return textParams;
	}
	
	public Long getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
}
