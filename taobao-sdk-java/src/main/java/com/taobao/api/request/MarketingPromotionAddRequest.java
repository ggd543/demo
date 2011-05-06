package com.taobao.api.request;
import java.util.Date;

import java.util.Map;
import java.util.Date;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.TaobaoRequest;

/**
 * TOP API: taobao.marketing.promotion.add request
 * 
 * @author auto create
 * @since 1.0, 2010-11-18 16:49:17.0
 */
public class MarketingPromotionAddRequest implements TaobaoRequest {
	private Long timestamp;	
	private TaobaoHashMap textParams = new TaobaoHashMap();


	
	/** 
	 * 折扣类型，可选PRICE(优惠价格)和DISCOUNT(折扣)，填写其它值返回错误
	 **/
	private String discountType;
	
	/** 
	 * 优惠额度，若优惠类型为折扣（DISCOUNT），则传入该商品的折扣比例，有效值范围：0.1-9.9，支持小数点后1位。
若优惠类型为优惠价格(PRICE)，传入该商品的优惠价，单位：元，支持小数点后2位
	 **/
	private String discountValue;
	
	/** 
	 * 优惠结束时间
	 **/
	private Date endDate;
	
	/** 
	 * 优惠策略适用的商品数字ID列表，一次最多设置10个商品，以半角','号分割。
	 **/
	private String numIids;
	
	/** 
	 * 显示在宝贝详情页面的优惠图标的tip，不填则默认为活动设置的icon图片说明
	 **/
	private String promotionTitle;
	
	/** 
	 * 优惠开始时间
	 **/
	private Date startDate;
	
	/** 
	 * 标签ID
	 **/
	private Long tagId;

	public void setDiscountType(String discountType) {
		this.discountType = discountType;
	}
	 public String getDiscountType() {
		return this.discountType;
	}
	public void setDiscountValue(String discountValue) {
		this.discountValue = discountValue;
	}
	 public String getDiscountValue() {
		return this.discountValue;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	 public Date getEndDate() {
		return this.endDate;
	}
	public void setNumIids(String numIids) {
		this.numIids = numIids;
	}
	 public String getNumIids() {
		return this.numIids;
	}
	public void setPromotionTitle(String promotionTitle) {
		this.promotionTitle = promotionTitle;
	}
	 public String getPromotionTitle() {
		return this.promotionTitle;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	 public Date getStartDate() {
		return this.startDate;
	}
	public void setTagId(Long tagId) {
		this.tagId = tagId;
	}
	 public Long getTagId() {
		return this.tagId;
	}
	
	public String getApiMethodName() {
		return "taobao.marketing.promotion.add";
	}

	public Map<String, String> getTextParams() {		
		textParams.put("discount_type", this.discountType);
		textParams.put("discount_value", this.discountValue);
		textParams.put("end_date", this.endDate);
		textParams.put("num_iids", this.numIids);
		textParams.put("promotion_title", this.promotionTitle);
		textParams.put("start_date", this.startDate);
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
