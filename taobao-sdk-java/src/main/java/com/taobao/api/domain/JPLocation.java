package com.taobao.api.domain;

import com.taobao.api.internal.mapping.ApiClass;
import com.taobao.api.internal.mapping.ApiField;


import com.taobao.api.TaobaoObject;

/**
 * JPLocation Data Structure.
 * 
 * DESC：机票测试用户地址信息 
 *
 * @author auto create
 * @since 1.0, 2010-10-28 18:07:53.0
 */
@ApiClass("JPLocation")
public class JPLocation extends TaobaoObject {

	private static final long serialVersionUID = 5269678169612454225L;

	
	/** 
	 * 机票测试数据类型地址信息
	 **/
	@ApiField("city")
	private String city;

	
	/** 
	 * 机票测试数据类型，地址信息邮编
	 **/
	@ApiField("zip")
	private String zip;

	public String getCity() {
		return this.city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	public String getZip() {
		return this.zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}

}
