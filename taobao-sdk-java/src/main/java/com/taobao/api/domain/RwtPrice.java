package com.taobao.api.domain;

import com.taobao.api.internal.mapping.ApiClass;
import com.taobao.api.internal.mapping.ApiField;


import com.taobao.api.TaobaoObject;

/**
 * RwtPrice Data Structure.
 * 
 * DESC：任我淘接口专用Price数据结构 
 *
 * @author auto create
 * @since 1.0, 2010-04-21 19:50:32.0
 */
@ApiClass("RwtPrice")
public class RwtPrice extends TaobaoObject {

	private static final long serialVersionUID = 5675431694253938455L;

	
	/** 
	 * 月租时长，单位月，一个月：1；季度：3；半年；6；一年：12；
	 **/
	@ApiField("duration")
	private Long duration;

	
	/** 
	 * 插件价格的id
	 **/
	@ApiField("id")
	private Long id;

	
	/** 
	 * 是否是默认价格，0 不是 ；1 是
	 **/
	@ApiField("is_default")
	private Long isDefault;

	
	/** 
	 * 价格描述，最大长度64个字符
	 **/
	@ApiField("price_desc")
	private String priceDesc;

	
	/** 
	 * 价格 单位：元
	 **/
	@ApiField("rent_price")
	private String rentPrice;

	
	/** 
	 * 月租单位 如:月、季、半年、年
	 **/
	@ApiField("rent_unit")
	private String rentUnit;

	public Long getDuration() {
		return this.duration;
	}
	public void setDuration(Long duration) {
		this.duration = duration;
	}

	public Long getId() {
		return this.id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public Long getIsDefault() {
		return this.isDefault;
	}
	public void setIsDefault(Long isDefault) {
		this.isDefault = isDefault;
	}

	public String getPriceDesc() {
		return this.priceDesc;
	}
	public void setPriceDesc(String priceDesc) {
		this.priceDesc = priceDesc;
	}

	public String getRentPrice() {
		return this.rentPrice;
	}
	public void setRentPrice(String rentPrice) {
		this.rentPrice = rentPrice;
	}

	public String getRentUnit() {
		return this.rentUnit;
	}
	public void setRentUnit(String rentUnit) {
		this.rentUnit = rentUnit;
	}

}
