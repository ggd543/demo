package com.taobao.api.domain;

import com.taobao.api.internal.mapping.ApiClass;
import com.taobao.api.internal.mapping.ApiField;


import com.taobao.api.TaobaoObject;

/**
 * ExtStore Data Structure.
 * 
 * DESC：外部仓库的集合 
 *
 * @author auto create
 * @since 1.0, 2010-11-05 18:12:39.0
 */
@ApiClass("ExtStore")
public class ExtStore extends TaobaoObject {

	private static final long serialVersionUID = 1739452841834767294L;

	
	/** 
	 * 仓库联系地址，最大长度为128个字节
	 **/
	@ApiField("address")
	private String address;

	
	/** 
	 * 仓库所在地
	 **/
	@ApiField("city")
	private String city;

	
	/** 
	 * 仓库所属公司代号,从原来的Number类型变更为String,支持字母。
	 **/
	@ApiField("company_code")
	private String companyCode;

	
	/** 
	 * 仓库所属公司在淘宝网的记录ID
	 **/
	@ApiField("company_id")
	private Long companyId;

	
	/** 
	 * 仓库的传真号，最大长度为32个字节
	 **/
	@ApiField("contact_fax")
	private String contactFax;

	
	/** 
	 * 联系人姓名，最大长度为32个字节
	 **/
	@ApiField("contact_name")
	private String contactName;

	
	/** 
	 * 仓库的联系电话，最大长度为64个字节
	 **/
	@ApiField("contact_phone")
	private String contactPhone;

	
	/** 
	 * 仓库的租赁费介绍，最大长度为1024个字节
	 **/
	@ApiField("price_desc")
	private String priceDesc;

	
	/** 
	 * 仓库面积
	 **/
	@ApiField("square")
	private Long square;

	
	/** 
	 * 仓库代号，最大长度为32个字节
	 **/
	@ApiField("store_code")
	private String storeCode;

	
	/** 
	 * 仓库描述，最大长度为1024个字节
	 **/
	@ApiField("store_desc")
	private String storeDesc;

	
	/** 
	 * 仓库名称，最大长度为64个字节
	 **/
	@ApiField("store_name")
	private String storeName;

	
	/** 
	 * 仓库的租用单价(元/平方米)
	 **/
	@ApiField("unit_price")
	private String unitPrice;

	
	/** 
	 * 邮政编码
	 **/
	@ApiField("zip_code")
	private String zipCode;

	public String getAddress() {
		return this.address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return this.city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	public String getCompanyCode() {
		return this.companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public Long getCompanyId() {
		return this.companyId;
	}
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public String getContactFax() {
		return this.contactFax;
	}
	public void setContactFax(String contactFax) {
		this.contactFax = contactFax;
	}

	public String getContactName() {
		return this.contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactPhone() {
		return this.contactPhone;
	}
	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public String getPriceDesc() {
		return this.priceDesc;
	}
	public void setPriceDesc(String priceDesc) {
		this.priceDesc = priceDesc;
	}

	public Long getSquare() {
		return this.square;
	}
	public void setSquare(Long square) {
		this.square = square;
	}

	public String getStoreCode() {
		return this.storeCode;
	}
	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}

	public String getStoreDesc() {
		return this.storeDesc;
	}
	public void setStoreDesc(String storeDesc) {
		this.storeDesc = storeDesc;
	}

	public String getStoreName() {
		return this.storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getUnitPrice() {
		return this.unitPrice;
	}
	public void setUnitPrice(String unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getZipCode() {
		return this.zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

}
