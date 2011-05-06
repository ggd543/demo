package com.taobao.api.domain;

import java.util.Date;
import com.taobao.api.internal.mapping.ApiClass;
import com.taobao.api.internal.mapping.ApiField;


import com.taobao.api.TaobaoObject;

/**
 * KbDetailStore Data Structure.
 * 
 * DESC：口碑店铺的detail页面展现的对象，字段会相对完整 
 *
 * @author auto create
 * @since 1.0, 2010-06-30 14:48:43.0
 */
@ApiClass("KbDetailStore")
public class KbDetailStore extends TaobaoObject {

	private static final long serialVersionUID = 6259778987163539722L;

	
	/** 
	 * 地址
	 **/
	@ApiField("address")
	private String address;

	
	/** 
	 * 点评总数
	 **/
	@ApiField("appraisement_count")
	private Long appraisementCount;

	
	/** 
	 * 主类目名称
	 **/
	@ApiField("category_name")
	private String categoryName;

	
	/** 
	 * 城市名
	 **/
	@ApiField("city_name")
	private String cityName;

	
	/** 
	 * 是否推荐
	 **/
	@ApiField("commend")
	private Boolean commend;

	
	/** 
	 * 创建时间
	 **/
	@ApiField("create_time")
	private Date createTime;

	
	/** 
	 * 网店的detail网址
	 **/
	@ApiField("detail_url")
	private String detailUrl;

	
	/** 
	 * 区名称
	 **/
	@ApiField("district")
	private String district;

	
	/** 
	 * UUID
	 **/
	@ApiField("id")
	private String id;

	
	/** 
	 * 店铺介绍
	 **/
	@ApiField("introduce")
	private String introduce;

	
	/** 
	 * 手机号码
	 **/
	@ApiField("mobile")
	private String mobile;

	
	/** 
	 * 修改时间
	 **/
	@ApiField("modify_time")
	private Date modifyTime;

	
	/** 
	 * 店名
	 **/
	@ApiField("name")
	private String name;

	
	/** 
	 * 其他联系人信息
	 **/
	@ApiField("other_contact")
	private String otherContact;

	
	/** 
	 * 是否店主
	 **/
	@ApiField("owner")
	private Boolean owner;

	
	/** 
	 * 人均消费价格,浮点
	 **/
	@ApiField("per_consumption_price")
	private String perConsumptionPrice;

	
	/** 
	 * 电话,如果多个就以逗号分隔
	 **/
	@ApiField("phones")
	private String phones;

	
	/** 
	 * 店铺图片,绝对路径,多张已逗号分隔
	 **/
	@ApiField("pictures")
	private String pictures;

	
	/** 
	 * 发布时间
	 **/
	@ApiField("post_time")
	private Date postTime;

	
	/** 
	 * 产品图片,绝对路径,多个图片以逗号分隔
	 **/
	@ApiField("products")
	private String products;

	
	/** 
	 * 推荐排名
	 **/
	@ApiField("recommend_order")
	private Long recommendOrder;

	
	/** 
	 * 分店名
	 **/
	@ApiField("subname")
	private String subname;

	
	/** 
	 * 店铺自己的主页网址
	 **/
	@ApiField("url")
	private String url;

	
	/** 
	 * 用户ID
	 **/
	@ApiField("user_id")
	private String userId;

	
	/** 
	 * 登记人用户名
	 **/
	@ApiField("username")
	private String username;

	
	/** 
	 * 人气
	 **/
	@ApiField("visits")
	private Long visits;

	
	/** 
	 * 编码
	 **/
	@ApiField("zip")
	private String zip;

	public String getAddress() {
		return this.address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public Long getAppraisementCount() {
		return this.appraisementCount;
	}
	public void setAppraisementCount(Long appraisementCount) {
		this.appraisementCount = appraisementCount;
	}

	public String getCategoryName() {
		return this.categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCityName() {
		return this.cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public Boolean getCommend() {
		return this.commend;
	}
	public void setCommend(Boolean commend) {
		this.commend = commend;
	}

	public Date getCreateTime() {
		return this.createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getDetailUrl() {
		return this.detailUrl;
	}
	public void setDetailUrl(String detailUrl) {
		this.detailUrl = detailUrl;
	}

	public String getDistrict() {
		return this.district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}

	public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getIntroduce() {
		return this.introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public String getMobile() {
		return this.mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Date getModifyTime() {
		return this.modifyTime;
	}
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getOtherContact() {
		return this.otherContact;
	}
	public void setOtherContact(String otherContact) {
		this.otherContact = otherContact;
	}

	public Boolean getOwner() {
		return this.owner;
	}
	public void setOwner(Boolean owner) {
		this.owner = owner;
	}

	public String getPerConsumptionPrice() {
		return this.perConsumptionPrice;
	}
	public void setPerConsumptionPrice(String perConsumptionPrice) {
		this.perConsumptionPrice = perConsumptionPrice;
	}

	public String getPhones() {
		return this.phones;
	}
	public void setPhones(String phones) {
		this.phones = phones;
	}

	public String getPictures() {
		return this.pictures;
	}
	public void setPictures(String pictures) {
		this.pictures = pictures;
	}

	public Date getPostTime() {
		return this.postTime;
	}
	public void setPostTime(Date postTime) {
		this.postTime = postTime;
	}

	public String getProducts() {
		return this.products;
	}
	public void setProducts(String products) {
		this.products = products;
	}

	public Long getRecommendOrder() {
		return this.recommendOrder;
	}
	public void setRecommendOrder(Long recommendOrder) {
		this.recommendOrder = recommendOrder;
	}

	public String getSubname() {
		return this.subname;
	}
	public void setSubname(String subname) {
		this.subname = subname;
	}

	public String getUrl() {
		return this.url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public Long getVisits() {
		return this.visits;
	}
	public void setVisits(Long visits) {
		this.visits = visits;
	}

	public String getZip() {
		return this.zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}

}
