package com.taobao.api.request;

import java.util.Map;
import java.util.Date;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.TaobaoRequest;

/**
 * TOP API: taobao.item.get request
 * 
 * @author auto create
 * @since 1.0, 2010-09-07 14:44:31.0
 */
public class ItemGetRequest implements TaobaoRequest {
	private Long timestamp;	
	private TaobaoHashMap textParams = new TaobaoHashMap();


	
	/** 
	 * 需要返回的商品对象字段。可选值：Item商品结构体中所有字段均可返回；多个字段用“,”分隔。如果想返回整个子对象，那字段为item_img，如果是想返回子对象里面的字段，那字段为item_img.url。新增返回字段：second_kill（是否秒杀商品）、auto_fill（代充商品类型）,props_name（商品属性名称）
	 **/
	private String fields;
	
	/** 
	 * 商品字符串ID(注意：iid近期即将废弃，请用num_iid参数)
	 **/
	private String iid;
	
	/** 
	 * 卖家昵称。强烈推荐在知道卖家昵称的情况下提供此字段以提高查询效率！
	 **/
	private String nick;
	
	/** 
	 * 商品数字ID
	 **/
	private Long numIid;

	public void setFields(String fields) {
		this.fields = fields;
	}
	 public String getFields() {
		return this.fields;
	}
	public void setIid(String iid) {
		this.iid = iid;
	}
	 public String getIid() {
		return this.iid;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	 public String getNick() {
		return this.nick;
	}
	public void setNumIid(Long numIid) {
		this.numIid = numIid;
	}
	 public Long getNumIid() {
		return this.numIid;
	}
	
	public String getApiMethodName() {
		return "taobao.item.get";
	}

	public Map<String, String> getTextParams() {		
		textParams.put("fields", this.fields);
		textParams.put("iid", this.iid);
		textParams.put("nick", this.nick);
		textParams.put("num_iid", this.numIid);
		return textParams;
	}
	
	public Long getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
}
