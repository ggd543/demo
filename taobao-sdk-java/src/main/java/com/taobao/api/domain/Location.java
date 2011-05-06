package com.taobao.api.domain;

import com.taobao.api.internal.mapping.ApiClass;
import com.taobao.api.internal.mapping.ApiField;


import com.taobao.api.TaobaoObject;

/**
 * Location Data Structure.
 * 
 * DESC：用户地址 
 *
 * @author auto create
 * @since 1.0, 2010-07-01 14:12:59.0
 */
@ApiClass("Location")
public class Location extends TaobaoObject {

	private static final long serialVersionUID = 8343387562832124527L;

	
	/** 
	 * 详细地址，最大256个字节（128个中文）
	 **/
	@ApiField("address")
	private String address;

	
	/** 
	 * 所在城市（中文名称）
	 **/
	@ApiField("city")
	private String city;

	
	/** 
	 * 国家名称
	 **/
	@ApiField("country")
	private String country;

	
	/** 
	 * 区/县（只适用于物流API）
	 **/
	@ApiField("district")
	private String district;

	
	/** 
	 * 所在省份（中文名称）
	 **/
	@ApiField("state")
	private String state;

	
	/** 
	 * 邮政编码
	 **/
	@ApiField("zip")
	private String zip;

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

	public String getCountry() {
		return this.country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

	public String getDistrict() {
		return this.district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}

	public String getState() {
		return this.state;
	}
	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return this.zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}

}
