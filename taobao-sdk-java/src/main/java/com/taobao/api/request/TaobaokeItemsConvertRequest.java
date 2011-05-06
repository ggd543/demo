package com.taobao.api.request;

import java.util.Map;
import java.util.Date;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.TaobaoRequest;

/**
 * TOP API: taobao.taobaoke.items.convert request
 * 
 * @author auto create
 * @since 1.0, 2010-11-04 11:20:23.0
 */
public class TaobaokeItemsConvertRequest implements TaobaoRequest {
	private Long timestamp;	
	private TaobaoHashMap textParams = new TaobaoHashMap();


	
	/** 
	 * 需返回的字段列表.可选值:num_iid,title,nick,pic_url,price,click_url,commission,ommission_rate,commission_num,commission_volume,shop_click_url,seller_credit_score,item_location,volume
;字段之间用","分隔.
	 **/
	private String fields;
	
	/** 
	 * 推广者的淘宝会员昵称.注：指的是淘宝的会员登录名
	 **/
	private String nick;
	
	/** 
	 * 淘宝客商品数字id串.最大输入50个.格式如:"value1,value2,value3" 用" , "号分隔商品数字id
	 **/
	private String numIids;
	
	/** 
	 * 自定义输入串.格式:英文和数字组成;长度不能大于12个字符,区分不同的推广渠道,如:bbs,表示bbs为推广渠道;blog,表示blog为推广渠道.
	 **/
	private String outerCode;

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
	public void setNumIids(String numIids) {
		this.numIids = numIids;
	}
	 public String getNumIids() {
		return this.numIids;
	}
	public void setOuterCode(String outerCode) {
		this.outerCode = outerCode;
	}
	 public String getOuterCode() {
		return this.outerCode;
	}
	
	public String getApiMethodName() {
		return "taobao.taobaoke.items.convert";
	}

	public Map<String, String> getTextParams() {		
		textParams.put("fields", this.fields);
		textParams.put("nick", this.nick);
		textParams.put("num_iids", this.numIids);
		textParams.put("outer_code", this.outerCode);
		return textParams;
	}
	
	public Long getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
}
