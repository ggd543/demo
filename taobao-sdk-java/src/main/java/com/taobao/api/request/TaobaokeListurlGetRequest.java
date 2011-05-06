package com.taobao.api.request;

import java.util.Map;
import java.util.Date;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.TaobaoRequest;

/**
 * TOP API: taobao.taobaoke.listurl.get request
 * 
 * @author auto create
 * @since 1.0, 2010-08-12 20:54:01.0
 */
public class TaobaokeListurlGetRequest implements TaobaoRequest {
	private Long timestamp;	
	private TaobaoHashMap textParams = new TaobaoHashMap();


	
	/** 
	 * 推广者的淘宝会员昵称.注：这里指的是淘宝的登录会员名
	 **/
	private String nick;
	
	/** 
	 * 自定义输入串.格式:英文和数字组成;长度不能大于12个字符,区分不同的推广渠道,如:bbs,表示bbs为推广渠道;blog,表示blog为推广渠道.
	 **/
	private String outerCode;
	
	/** 
	 * 关键词
	 **/
	private String q;

	public void setNick(String nick) {
		this.nick = nick;
	}
	 public String getNick() {
		return this.nick;
	}
	public void setOuterCode(String outerCode) {
		this.outerCode = outerCode;
	}
	 public String getOuterCode() {
		return this.outerCode;
	}
	public void setQ(String q) {
		this.q = q;
	}
	 public String getQ() {
		return this.q;
	}
	
	public String getApiMethodName() {
		return "taobao.taobaoke.listurl.get";
	}

	public Map<String, String> getTextParams() {		
		textParams.put("nick", this.nick);
		textParams.put("outer_code", this.outerCode);
		textParams.put("q", this.q);
		return textParams;
	}
	
	public Long getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
}
