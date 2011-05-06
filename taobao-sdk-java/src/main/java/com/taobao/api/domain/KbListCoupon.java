package com.taobao.api.domain;

import java.util.Date;
import com.taobao.api.internal.mapping.ApiClass;
import com.taobao.api.internal.mapping.ApiField;


import com.taobao.api.TaobaoObject;

/**
 * KbListCoupon Data Structure.
 * 
 * DESC：口碑优惠券的列表对象 
 *
 * @author auto create
 * @since 1.0, 2010-06-30 14:49:17.0
 */
@ApiClass("KbListCoupon")
public class KbListCoupon extends TaobaoObject {

	private static final long serialVersionUID = 5474366834551216356L;

	
	/** 
	 * 商家地址
	 **/
	@ApiField("address")
	private String address;

	
	/** 
	 * 优惠内容，不截字
	 **/
	@ApiField("content")
	private String content;

	
	/** 
	 * 下载量
	 **/
	@ApiField("download_count")
	private String downloadCount;

	
	/** 
	 * 截止日期
	 **/
	@ApiField("end_time")
	private Date endTime;

	
	/** 
	 * 该条优惠卷所拥有的标志，比如：独家，标志与标志间用英文逗号分隔
	 **/
	@ApiField("flag")
	private String flag;

	
	/** 
	 * 按照一定规则产生的数字串
	 **/
	@ApiField("id")
	private String id;

	
	/** 
	 * 优惠list图片地址
	 **/
	@ApiField("image")
	private String image;

	
	/** 
	 * 商圈地址
	 **/
	@ApiField("peri_place")
	private String periPlace;

	
	/** 
	 * 店铺名称
	 **/
	@ApiField("store_name")
	private String storeName;

	
	/** 
	 * 子类目id
	 **/
	@ApiField("sub_cate")
	private Long subCate;

	
	/** 
	 * 分类目名称
	 **/
	@ApiField("sub_cate_name")
	private String subCateName;

	
	/** 
	 * 是否支持短信下载
	 **/
	@ApiField("support_sms")
	private Boolean supportSms;

	
	/** 
	 * 优惠title，不截字
	 **/
	@ApiField("title")
	private String title;

	
	/** 
	 * 优惠类型+"|"+折扣数或抵价金额,如果没有折扣数或金额，则只显示打折类型，例如:折扣券|7,抵价券|10,优惠券
	 **/
	@ApiField("type")
	private String type;

	public String getAddress() {
		return this.address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public String getContent() {
		return this.content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	public String getDownloadCount() {
		return this.downloadCount;
	}
	public void setDownloadCount(String downloadCount) {
		this.downloadCount = downloadCount;
	}

	public Date getEndTime() {
		return this.endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getFlag() {
		return this.flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
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

	public String getPeriPlace() {
		return this.periPlace;
	}
	public void setPeriPlace(String periPlace) {
		this.periPlace = periPlace;
	}

	public String getStoreName() {
		return this.storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public Long getSubCate() {
		return this.subCate;
	}
	public void setSubCate(Long subCate) {
		this.subCate = subCate;
	}

	public String getSubCateName() {
		return this.subCateName;
	}
	public void setSubCateName(String subCateName) {
		this.subCateName = subCateName;
	}

	public Boolean getSupportSms() {
		return this.supportSms;
	}
	public void setSupportSms(Boolean supportSms) {
		this.supportSms = supportSms;
	}

	public String getTitle() {
		return this.title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return this.type;
	}
	public void setType(String type) {
		this.type = type;
	}

}
