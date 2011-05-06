package com.taobao.api.domain;

import java.util.Date;
import com.taobao.api.internal.mapping.ApiClass;
import com.taobao.api.internal.mapping.ApiField;


import com.taobao.api.TaobaoObject;

/**
 * KbDetailCoupon Data Structure.
 * 
 * DESC：口碑优惠券Detail对象 
 *
 * @author auto create
 * @since 1.0, 2010-06-30 14:49:02.0
 */
@ApiClass("KbDetailCoupon")
public class KbDetailCoupon extends TaobaoObject {

	private static final long serialVersionUID = 4539748941226418459L;

	
	/** 
	 * 优惠商家地址
	 **/
	@ApiField("address")
	private String address;

	
	/** 
	 * 老板是否活跃
	 **/
	@ApiField("boss_active")
	private Boolean bossActive;

	
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
	 * 点评数
	 **/
	@ApiField("comment_count")
	private String commentCount;

	
	/** 
	 * 优惠内容
	 **/
	@ApiField("content")
	private String content;

	
	/** 
	 * 是否有活动
	 **/
	@ApiField("has_activity")
	private Boolean hasActivity;

	
	/** 
	 * 是否有优惠
	 **/
	@ApiField("has_discount")
	private Boolean hasDiscount;

	
	/** 
	 * 是否有更多图片
	 **/
	@ApiField("has_img")
	private Boolean hasImg;

	
	/** 
	 * 是否有网友印象
	 **/
	@ApiField("has_impress")
	private Boolean hasImpress;

	
	/** 
	 * 是否有地图
	 **/
	@ApiField("has_map")
	private Boolean hasMap;

	
	/** 
	 * 人气值（也可理解为点击量）
	 **/
	@ApiField("hits")
	private String hits;

	
	/** 
	 * 按照一定规则产生的数字串
	 **/
	@ApiField("id")
	private String id;

	
	/** 
	 * 优惠detail图片地址
	 **/
	@ApiField("image")
	private String image;

	
	/** 
	 * 人均价格，不带单位符号
	 **/
	@ApiField("per_capital")
	private String perCapital;

	
	/** 
	 * 商圈地址
	 **/
	@ApiField("peri_place")
	private String periPlace;

	
	/** 
	 * 商家联系电话
	 **/
	@ApiField("phone")
	private String phone;

	
	/** 
	 * 电话号码的URL图片
	 **/
	@ApiField("phone_url")
	private String phoneUrl;

	
	/** 
	 * 地理坐标的维度
	 **/
	@ApiField("posx")
	private String posx;

	
	/** 
	 * 地理坐标的经度
	 **/
	@ApiField("posy")
	private String posy;

	
	/** 
	 * 打印量
	 **/
	@ApiField("print_count")
	private String printCount;

	
	/** 
	 * 发布时间
	 **/
	@ApiField("publish_time")
	private Date publishTime;

	
	/** 
	 * 推荐菜,多个推荐菜用英文逗号分隔
	 **/
	@ApiField("recommend_food")
	private String recommendFood;

	
	/** 
	 * 短信下载量
	 **/
	@ApiField("sms_count")
	private String smsCount;

	
	/** 
	 * 店铺的ID号
	 **/
	@ApiField("store_id")
	private String storeId;

	
	/** 
	 * 优惠券所在的店铺名称
	 **/
	@ApiField("store_name")
	private String storeName;

	
	/** 
	 * 子类目名称
	 **/
	@ApiField("sub_cate")
	private String subCate;

	
	/** 
	 * 优惠券的标题，格式如：[店铺名]优惠券名
	 **/
	@ApiField("title")
	private String title;

	
	/** 
	 * 回头率，不带单位符号
	 **/
	@ApiField("turn_rate")
	private String turnRate;

	
	/** 
	 * 优惠类型+"|"+折扣数或抵价金额,如果没有折扣数或金额，则只显示打折类型，例如:折扣券|7,抵价券|10,优惠券
	 **/
	@ApiField("type")
	private String type;

	
	/** 
	 * 有效时间
	 **/
	@ApiField("validate_time")
	private String validateTime;

	public String getAddress() {
		return this.address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public Boolean getBossActive() {
		return this.bossActive;
	}
	public void setBossActive(Boolean bossActive) {
		this.bossActive = bossActive;
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

	public String getCommentCount() {
		return this.commentCount;
	}
	public void setCommentCount(String commentCount) {
		this.commentCount = commentCount;
	}

	public String getContent() {
		return this.content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	public Boolean getHasActivity() {
		return this.hasActivity;
	}
	public void setHasActivity(Boolean hasActivity) {
		this.hasActivity = hasActivity;
	}

	public Boolean getHasDiscount() {
		return this.hasDiscount;
	}
	public void setHasDiscount(Boolean hasDiscount) {
		this.hasDiscount = hasDiscount;
	}

	public Boolean getHasImg() {
		return this.hasImg;
	}
	public void setHasImg(Boolean hasImg) {
		this.hasImg = hasImg;
	}

	public Boolean getHasImpress() {
		return this.hasImpress;
	}
	public void setHasImpress(Boolean hasImpress) {
		this.hasImpress = hasImpress;
	}

	public Boolean getHasMap() {
		return this.hasMap;
	}
	public void setHasMap(Boolean hasMap) {
		this.hasMap = hasMap;
	}

	public String getHits() {
		return this.hits;
	}
	public void setHits(String hits) {
		this.hits = hits;
	}

	public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getImage() {
		return this.image;
	}
	public void setImage(String image) {
		this.image = image;
	}

	public String getPerCapital() {
		return this.perCapital;
	}
	public void setPerCapital(String perCapital) {
		this.perCapital = perCapital;
	}

	public String getPeriPlace() {
		return this.periPlace;
	}
	public void setPeriPlace(String periPlace) {
		this.periPlace = periPlace;
	}

	public String getPhone() {
		return this.phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhoneUrl() {
		return this.phoneUrl;
	}
	public void setPhoneUrl(String phoneUrl) {
		this.phoneUrl = phoneUrl;
	}

	public String getPosx() {
		return this.posx;
	}
	public void setPosx(String posx) {
		this.posx = posx;
	}

	public String getPosy() {
		return this.posy;
	}
	public void setPosy(String posy) {
		this.posy = posy;
	}

	public String getPrintCount() {
		return this.printCount;
	}
	public void setPrintCount(String printCount) {
		this.printCount = printCount;
	}

	public Date getPublishTime() {
		return this.publishTime;
	}
	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}

	public String getRecommendFood() {
		return this.recommendFood;
	}
	public void setRecommendFood(String recommendFood) {
		this.recommendFood = recommendFood;
	}

	public String getSmsCount() {
		return this.smsCount;
	}
	public void setSmsCount(String smsCount) {
		this.smsCount = smsCount;
	}

	public String getStoreId() {
		return this.storeId;
	}
	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public String getStoreName() {
		return this.storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getSubCate() {
		return this.subCate;
	}
	public void setSubCate(String subCate) {
		this.subCate = subCate;
	}

	public String getTitle() {
		return this.title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public String getTurnRate() {
		return this.turnRate;
	}
	public void setTurnRate(String turnRate) {
		this.turnRate = turnRate;
	}

	public String getType() {
		return this.type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public String getValidateTime() {
		return this.validateTime;
	}
	public void setValidateTime(String validateTime) {
		this.validateTime = validateTime;
	}

}
