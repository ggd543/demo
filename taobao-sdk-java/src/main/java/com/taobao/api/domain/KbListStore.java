package com.taobao.api.domain;

import com.taobao.api.internal.mapping.ApiClass;
import com.taobao.api.internal.mapping.ApiField;


import com.taobao.api.TaobaoObject;

/**
 * KbListStore Data Structure.
 * 
 * DESC：口碑的店铺列表对象 
 *
 * @author auto create
 * @since 1.0, 2010-06-30 14:48:00.0
 */
@ApiClass("KbListStore")
public class KbListStore extends TaobaoObject {

	private static final long serialVersionUID = 1164527631355253517L;

	
	/** 
	 * 地址
	 **/
	@ApiField("address")
	private String address;

	
	/** 
	 * 点评的数量
	 **/
	@ApiField("appraisement_count")
	private String appraisementCount;

	
	/** 
	 * 店铺大类
	 **/
	@ApiField("category")
	private String category;

	
	/** 
	 * 城市ID
	 **/
	@ApiField("city_id")
	private Long cityId;

	
	/** 
	 * 城市名称
	 **/
	@ApiField("city_name")
	private String cityName;

	
	/** 
	 * 口碑指数
	 **/
	@ApiField("colligate_exponent")
	private String colligateExponent;

	
	/** 
	 * 精选的某一条评论内容
	 **/
	@ApiField("comment")
	private String comment;

	
	/** 
	 * 折扣 几折
	 **/
	@ApiField("discount")
	private String discount;

	
	/** 
	 * 打折提示信息
	 **/
	@ApiField("discount_notes")
	private String discountNotes;

	
	/** 
	 * 平均价格
	 **/
	@ApiField("per_price")
	private String perPrice;

	
	/** 
	 * 店铺图片的URL
	 **/
	@ApiField("pic_store")
	private String picStore;

	
	/** 
	 * 电话图片的URL
	 **/
	@ApiField("pic_tel_no")
	private String picTelNo;

	
	/** 
	 * UUID随机生成，另外会根据业务加一些前缀
	 **/
	@ApiField("resource_id")
	private String resourceId;

	
	/** 
	 * 回头率
	 **/
	@ApiField("review_rate")
	private Long reviewRate;

	
	/** 
	 * 店铺名称
	 **/
	@ApiField("store_name")
	private String storeName;

	
	/** 
	 * 店铺图片的数量
	 **/
	@ApiField("store_pic_count")
	private Long storePicCount;

	
	/** 
	 * 店铺小类
	 **/
	@ApiField("sub_categories")
	private String subCategories;

	public String getAddress() {
		return this.address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public String getAppraisementCount() {
		return this.appraisementCount;
	}
	public void setAppraisementCount(String appraisementCount) {
		this.appraisementCount = appraisementCount;
	}

	public String getCategory() {
		return this.category;
	}
	public void setCategory(String category) {
		this.category = category;
	}

	public Long getCityId() {
		return this.cityId;
	}
	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return this.cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getColligateExponent() {
		return this.colligateExponent;
	}
	public void setColligateExponent(String colligateExponent) {
		this.colligateExponent = colligateExponent;
	}

	public String getComment() {
		return this.comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getDiscount() {
		return this.discount;
	}
	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public String getDiscountNotes() {
		return this.discountNotes;
	}
	public void setDiscountNotes(String discountNotes) {
		this.discountNotes = discountNotes;
	}

	public String getPerPrice() {
		return this.perPrice;
	}
	public void setPerPrice(String perPrice) {
		this.perPrice = perPrice;
	}

	public String getPicStore() {
		return this.picStore;
	}
	public void setPicStore(String picStore) {
		this.picStore = picStore;
	}

	public String getPicTelNo() {
		return this.picTelNo;
	}
	public void setPicTelNo(String picTelNo) {
		this.picTelNo = picTelNo;
	}

	public String getResourceId() {
		return this.resourceId;
	}
	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}

	public Long getReviewRate() {
		return this.reviewRate;
	}
	public void setReviewRate(Long reviewRate) {
		this.reviewRate = reviewRate;
	}

	public String getStoreName() {
		return this.storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public Long getStorePicCount() {
		return this.storePicCount;
	}
	public void setStorePicCount(Long storePicCount) {
		this.storePicCount = storePicCount;
	}

	public String getSubCategories() {
		return this.subCategories;
	}
	public void setSubCategories(String subCategories) {
		this.subCategories = subCategories;
	}

}
