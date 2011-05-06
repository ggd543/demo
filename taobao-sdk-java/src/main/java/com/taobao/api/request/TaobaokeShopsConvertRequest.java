package com.taobao.api.request;

import java.util.Map;
import java.util.Date;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.TaobaoRequest;

/**
 * TOP API: taobao.taobaoke.shops.convert request
 * 
 * @author auto create
 * @since 1.0, 2010-09-10 10:29:32.0
 */
public class TaobaokeShopsConvertRequest implements TaobaoRequest {
	private Long timestamp;	
	private TaobaoHashMap textParams = new TaobaoHashMap();


	
	/** 
	 * 需返回的字段列表.可选值:TaobaokeShop淘宝客商品结构体中的所有字段;字段之间用","分隔.
	 **/
	private String fields;
	
	/** 
	 * 推广者的淘宝会员昵称.注：这里指的是淘宝的登录会员名
	 **/
	private String nick;
	
	/** 
	 * 自定义输入串.格式:英文和数字组成;长度不能大于12个字符,区分不同的推广渠道,如:bbs,表示bbs为推广渠道;blog,表示blog为推广渠道.
	 **/
	private String outerCode;
	
	/** 
	 * 店铺id串.最大输入10个.格式如:"value1,value2,value3" 用" , "号分隔店铺id.
	 **/
	private String sids;

	public void setFields(String fields) {
		this.fields = fields;
	}
	 public String getFields() {
		return this.fields;
	}
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
	public void setSids(String sids) {
		this.sids = sids;
	}
	 public String getSids() {
		return this.sids;
	}
	
	public String getApiMethodName() {
		return "taobao.taobaoke.shops.convert";
	}

	public Map<String, String> getTextParams() {		
		textParams.put("fields", this.fields);
		textParams.put("nick", this.nick);
		textParams.put("outer_code", this.outerCode);
		textParams.put("sids", this.sids);
		return textParams;
	}
	
	public Long getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
}
