package com.taobao.api.request;

import java.util.Map;
import java.util.Date;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.TaobaoRequest;

/**
 * TOP API: taobao.koubei.store.search request
 * 
 * @author auto create
 * @since 1.0, 2010-12-02 12:58:19.0
 */
public class KoubeiStoreSearchRequest implements TaobaoRequest {
	private Long timestamp;	
	private TaobaoHashMap textParams = new TaobaoHashMap();


	
	/** 
	 * 根据一级类目Id查找店铺，比如餐饮美食
	 **/
	private Long cateId;
	
	/** 
	 * 城市id
	 **/
	private Long cityId;
	
	/** 
	 * 页码，显示第page页的店铺。
	 **/
	private Long pageNo;
	
	/** 
	 * 返回的店铺数
	 **/
	private Long pageSize;
	
	/** 
	 * 平均消费,传入价格区间，整数用波浪线分隔
	 **/
	private String perPrice;
	
	/** 
	 * 关键词搜索时使用
	 **/
	private String q;
	
	/** 
	 * 需要定位搜索店铺时使用，以指定的xy为中心，（+-）range米范围内店铺。
	 **/
	private Long range;
	
	/** 
	 * 根据店铺名搜索时使用，返回店铺名中带有storeName的店铺
	 **/
	private String storeName;
	
	/** 
	 * 根据二级类目Id查找店铺，比如中餐馆
	 **/
	private Long subcateId;
	
	/** 
	 * 需要定位搜索店铺时使用，经度,已经将经度的分秒转换成度的小数部分，最好精确到小数点后5位
	 **/
	private String x;
	
	/** 
	 * 需要定位搜索店铺时使用，纬度,已经将纬度的分秒转换成度的小数部分，最好精确到小数点后5位
	 **/
	private String y;

	public void setCateId(Long cateId) {
		this.cateId = cateId;
	}
	 public Long getCateId() {
		return this.cateId;
	}
	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}
	 public Long getCityId() {
		return this.cityId;
	}
	public void setPageNo(Long pageNo) {
		this.pageNo = pageNo;
	}
	 public Long getPageNo() {
		return this.pageNo;
	}
	public void setPageSize(Long pageSize) {
		this.pageSize = pageSize;
	}
	 public Long getPageSize() {
		return this.pageSize;
	}
	public void setPerPrice(String perPrice) {
		this.perPrice = perPrice;
	}
	 public String getPerPrice() {
		return this.perPrice;
	}
	public void setQ(String q) {
		this.q = q;
	}
	 public String getQ() {
		return this.q;
	}
	public void setRange(Long range) {
		this.range = range;
	}
	 public Long getRange() {
		return this.range;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	 public String getStoreName() {
		return this.storeName;
	}
	public void setSubcateId(Long subcateId) {
		this.subcateId = subcateId;
	}
	 public Long getSubcateId() {
		return this.subcateId;
	}
	public void setX(String x) {
		this.x = x;
	}
	 public String getX() {
		return this.x;
	}
	public void setY(String y) {
		this.y = y;
	}
	 public String getY() {
		return this.y;
	}
	
	public String getApiMethodName() {
		return "taobao.koubei.store.search";
	}

	public Map<String, String> getTextParams() {		
		textParams.put("cate_id", this.cateId);
		textParams.put("city_id", this.cityId);
		textParams.put("page_no", this.pageNo);
		textParams.put("page_size", this.pageSize);
		textParams.put("per_price", this.perPrice);
		textParams.put("q", this.q);
		textParams.put("range", this.range);
		textParams.put("store_name", this.storeName);
		textParams.put("subcate_id", this.subcateId);
		textParams.put("x", this.x);
		textParams.put("y", this.y);
		return textParams;
	}
	
	public Long getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
}
