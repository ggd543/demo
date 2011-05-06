package com.taobao.api.request;

import java.util.Map;
import java.util.Date;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.TaobaoRequest;

/**
 * TOP API: taobao.sellercats.list.update request
 * 
 * @author auto create
 * @since 1.0, 2010-08-03 15:02:39.0
 */
public class SellercatsListUpdateRequest implements TaobaoRequest {
	private Long timestamp;	
	private TaobaoHashMap textParams = new TaobaoHashMap();


	
	/** 
	 * 卖家自定义类目编号
	 **/
	private Long cid;
	
	/** 
	 * 卖家自定义类目名称。不超过20个字符
	 **/
	private String name;
	
	/** 
	 * 链接图片URL地址
	 **/
	private String pictUrl;
	
	/** 
	 * 该类目在页面上的排序位置,取值范围:大于零的整数
	 **/
	private Long sortOrder;

	public void setCid(Long cid) {
		this.cid = cid;
	}
	 public Long getCid() {
		return this.cid;
	}
	public void setName(String name) {
		this.name = name;
	}
	 public String getName() {
		return this.name;
	}
	public void setPictUrl(String pictUrl) {
		this.pictUrl = pictUrl;
	}
	 public String getPictUrl() {
		return this.pictUrl;
	}
	public void setSortOrder(Long sortOrder) {
		this.sortOrder = sortOrder;
	}
	 public Long getSortOrder() {
		return this.sortOrder;
	}
	
	public String getApiMethodName() {
		return "taobao.sellercats.list.update";
	}

	public Map<String, String> getTextParams() {		
		textParams.put("cid", this.cid);
		textParams.put("name", this.name);
		textParams.put("pict_url", this.pictUrl);
		textParams.put("sort_order", this.sortOrder);
		return textParams;
	}
	
	public Long getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
}
