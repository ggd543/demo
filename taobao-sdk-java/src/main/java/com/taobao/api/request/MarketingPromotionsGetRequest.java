package com.taobao.api.request;

import java.util.Map;
import java.util.Date;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.TaobaoRequest;

/**
 * TOP API: taobao.marketing.promotions.get request
 * 
 * @author auto create
 * @since 1.0, 2010-11-18 16:50:18.0
 */
public class MarketingPromotionsGetRequest implements TaobaoRequest {
	private Long timestamp;	
	private TaobaoHashMap textParams = new TaobaoHashMap();


	
	/** 
	 * 需返回的优惠策略结构字段列表。可选值为Promotion中所有字段，如：promotion_id, promotion_title, item_id, status, tag_id等等
	 **/
	private String fields;
	
	/** 
	 * 商品数字ID。根据该ID查询商品下通过第三方工具设置的所有优惠策略
	 **/
	private String numIid;
	
	/** 
	 * 优惠策略状态。可选值：ACTIVE(有效)，UNACTIVE(无效)，若不传或者传入其他值，则默认查询全部
	 **/
	private String status;
	
	/** 
	 * 标签ID
	 **/
	private Long tagId;

	public void setFields(String fields) {
		this.fields = fields;
	}
	 public String getFields() {
		return this.fields;
	}
	public void setNumIid(String numIid) {
		this.numIid = numIid;
	}
	 public String getNumIid() {
		return this.numIid;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	 public String getStatus() {
		return this.status;
	}
	public void setTagId(Long tagId) {
		this.tagId = tagId;
	}
	 public Long getTagId() {
		return this.tagId;
	}
	
	public String getApiMethodName() {
		return "taobao.marketing.promotions.get";
	}

	public Map<String, String> getTextParams() {		
		textParams.put("fields", this.fields);
		textParams.put("num_iid", this.numIid);
		textParams.put("status", this.status);
		textParams.put("tag_id", this.tagId);
		return textParams;
	}
	
	public Long getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
}
