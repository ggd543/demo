package com.taobao.api.request;

import java.util.Map;
import java.util.Date;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.TaobaoRequest;

/**
 * TOP API: taobao.koubei.coupon.search request
 * 
 * @author auto create
 * @since 1.0, 2010-12-02 12:57:11.0
 */
public class KoubeiCouponSearchRequest implements TaobaoRequest {
	private Long timestamp;	
	private TaobaoHashMap textParams = new TaobaoHashMap();


	
	/** 
	 * 口碑城市代码，可参见口碑全国各城市的对照表
	 **/
	private Long cityId;
	
	/** 
	 * 搜索用的排序字段，暂时只支持publish_time,offer_hits.升降序规则是排序字段加英文逗号加DESC或ASC
比如：offer_hits,DESC
	 **/
	private String orderBy;
	
	/** 
	 * 页码.传入值为1代表第一页,传入值为2代表第二页,依此类推.默认返回的数据是从第一页开始
	 **/
	private Long pageNo;
	
	/** 
	 * 每页数量默认10条，最大1000条
	 **/
	private Long pageSize;
	
	/** 
	 * 搜索商圈的范围
	 **/
	private Long periRange;
	
	/** 
	 * 搜索用的关键字
	 **/
	private String q;
	
	/** 
	 * 搜索用是否支持短信下载,如果使用该参数即使赋值空在内部处理时也会以false值进行查询
	 **/
	private Boolean smsDown;
	
	/** 
	 * 搜索用店的id
	 **/
	private String storeId;
	
	/** 
	 * 优惠券子类目，比如10123,10124,10125,10126,10127
	 **/
	private Long subCate;
	
	/** 
	 * 经度,已经将经度的分秒转换成度的小数部分,最好精确到小数点后5位
	 **/
	private String x;
	
	/** 
	 * 纬度，已经将纬度的分秒转换成度的小数部分，最好精确到小数点后5位
	 **/
	private String y;

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}
	 public Long getCityId() {
		return this.cityId;
	}
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	 public String getOrderBy() {
		return this.orderBy;
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
	public void setPeriRange(Long periRange) {
		this.periRange = periRange;
	}
	 public Long getPeriRange() {
		return this.periRange;
	}
	public void setQ(String q) {
		this.q = q;
	}
	 public String getQ() {
		return this.q;
	}
	public void setSmsDown(Boolean smsDown) {
		this.smsDown = smsDown;
	}
	 public Boolean getSmsDown() {
		return this.smsDown;
	}
	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}
	 public String getStoreId() {
		return this.storeId;
	}
	public void setSubCate(Long subCate) {
		this.subCate = subCate;
	}
	 public Long getSubCate() {
		return this.subCate;
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
		return "taobao.koubei.coupon.search";
	}

	public Map<String, String> getTextParams() {		
		textParams.put("city_id", this.cityId);
		textParams.put("order_by", this.orderBy);
		textParams.put("page_no", this.pageNo);
		textParams.put("page_size", this.pageSize);
		textParams.put("peri_range", this.periRange);
		textParams.put("q", this.q);
		textParams.put("sms_down", this.smsDown);
		textParams.put("store_id", this.storeId);
		textParams.put("sub_cate", this.subCate);
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
