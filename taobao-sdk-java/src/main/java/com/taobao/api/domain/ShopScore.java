package com.taobao.api.domain;

import com.taobao.api.internal.mapping.ApiClass;
import com.taobao.api.internal.mapping.ApiField;


import com.taobao.api.TaobaoObject;

/**
 * ShopScore Data Structure.
 * 
 * DESC：店铺动态评分信息 
 *
 * @author auto create
 * @since 1.0, 2010-08-19 15:33:10.0
 */
@ApiClass("ShopScore")
public class ShopScore extends TaobaoObject {

	private static final long serialVersionUID = 8793488336485455712L;

	
	/** 
	 * 发货速度评分
	 **/
	@ApiField("delivery_score")
	private String deliveryScore;

	
	/** 
	 * 商品描述评分
	 **/
	@ApiField("item_score")
	private String itemScore;

	
	/** 
	 * 服务态度评分
	 **/
	@ApiField("service_score")
	private String serviceScore;

	public String getDeliveryScore() {
		return this.deliveryScore;
	}
	public void setDeliveryScore(String deliveryScore) {
		this.deliveryScore = deliveryScore;
	}

	public String getItemScore() {
		return this.itemScore;
	}
	public void setItemScore(String itemScore) {
		this.itemScore = itemScore;
	}

	public String getServiceScore() {
		return this.serviceScore;
	}
	public void setServiceScore(String serviceScore) {
		this.serviceScore = serviceScore;
	}

}
