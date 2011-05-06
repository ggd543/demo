package com.taobao.api.request;

import java.util.Map;
import java.util.Date;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.TaobaoRequest;

/**
 * TOP API: taobao.sellercats.list.add request
 * 
 * @author auto create
 * @since 1.0, 2010-08-03 15:04:53.0
 */
public class SellercatsListAddRequest implements TaobaoRequest {
	private Long timestamp;	
	private TaobaoHashMap textParams = new TaobaoHashMap();


	
	/** 
	 * 卖家自定义类目名称。不超过20个字符
	 **/
	private String name;
	
	/** 
	 * 父类目编号，如果类目为店铺下的一级类目：值等于0，如果类目为子类目，调用获取taobao.sellercats.list.get父类目编号
	 **/
	private Long parentCid;
	
	/** 
	 * 链接图片URL地址。(绝对地址，格式：http://host/image_path)
	 **/
	private String pictUrl;
	
	/** 
	 * 该类目在页面上的排序位置,取值范围:大于零的整数
	 **/
	private Long sortOrder;

	public void setName(String name) {
		this.name = name;
	}
	 public String getName() {
		return this.name;
	}
	public void setParentCid(Long parentCid) {
		this.parentCid = parentCid;
	}
	 public Long getParentCid() {
		return this.parentCid;
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
		return "taobao.sellercats.list.add";
	}

	public Map<String, String> getTextParams() {		
		textParams.put("name", this.name);
		textParams.put("parent_cid", this.parentCid);
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
