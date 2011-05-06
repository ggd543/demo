package com.taobao.api.domain;

import java.util.Date;
import com.taobao.api.internal.mapping.ApiClass;
import com.taobao.api.internal.mapping.ApiField;


import com.taobao.api.TaobaoObject;

/**
 * Distributor Data Structure.
 * 
 * DESC：分销API返回数据结构 
 *
 * @author auto create
 * @since 1.0, 2010-08-23 19:44:52.0
 */
@ApiClass("Distributor")
public class Distributor extends TaobaoObject {

	private static final long serialVersionUID = 3579368562756926728L;

	
	/** 
	 * 分销商的支付宝帐户
	 **/
	@ApiField("alipay_account")
	private String alipayAccount;

	
	/** 
	 * 联系人
	 **/
	@ApiField("contact_person")
	private String contactPerson;

	
	/** 
	 * 分销商创建时间 时间格式：yyyy-MM-dd HH:mm:ss
	 **/
	@ApiField("created")
	private Date created;

	
	/** 
	 * 分销商Id
	 **/
	@ApiField("distributor_id")
	private String distributorId;

	
	/** 
	 * 分销商姓名
	 **/
	@ApiField("distributor_name")
	private String distributorName;

	
	/** 
	 * 分销商的email
	 **/
	@ApiField("email")
	private String email;

	
	/** 
	 * 分销商的手机号
	 **/
	@ApiField("mobile_phone")
	private String mobilePhone;

	
	/** 
	 * 分销商的电话
	 **/
	@ApiField("phone")
	private String phone;

	
	/** 
	 * 分销商的网店链接
	 **/
	@ApiField("shop_web_link")
	private String shopWebLink;

	
	/** 
	 * 分销商ID
	 **/
	@ApiField("user_id")
	private Long userId;

	public String getAlipayAccount() {
		return this.alipayAccount;
	}
	public void setAlipayAccount(String alipayAccount) {
		this.alipayAccount = alipayAccount;
	}

	public String getContactPerson() {
		return this.contactPerson;
	}
	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public Date getCreated() {
		return this.created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}

	public String getDistributorId() {
		return this.distributorId;
	}
	public void setDistributorId(String distributorId) {
		this.distributorId = distributorId;
	}

	public String getDistributorName() {
		return this.distributorName;
	}
	public void setDistributorName(String distributorName) {
		this.distributorName = distributorName;
	}

	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobilePhone() {
		return this.mobilePhone;
	}
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getPhone() {
		return this.phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getShopWebLink() {
		return this.shopWebLink;
	}
	public void setShopWebLink(String shopWebLink) {
		this.shopWebLink = shopWebLink;
	}

	public Long getUserId() {
		return this.userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}

}
