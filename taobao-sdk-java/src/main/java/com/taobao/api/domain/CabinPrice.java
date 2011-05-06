package com.taobao.api.domain;

import com.taobao.api.internal.mapping.ApiClass;
import com.taobao.api.internal.mapping.ApiField;


import com.taobao.api.TaobaoObject;

/**
 * CabinPrice Data Structure.
 * 
 * DESC：舱位信息 
 *
 * @author auto create
 * @since 1.0, 2010-11-19 18:09:14.0
 */
@ApiClass("CabinPrice")
public class CabinPrice extends TaobaoObject {

	private static final long serialVersionUID = 1673517142722361576L;

	
	/** 
	 * 可以销售当前舱位的代理商id列表
	 **/
	@ApiField("air_supply_ids")
	private String airSupplyIds;

	
	/** 
	 * 舱位等级：
-1，不确定；
0：头等舱；
1：商务舱；
2：经济舱
	 **/
	@ApiField("cabin_class")
	private Long cabinClass;

	
	/** 
	 * 舱位代码：【A-Z】，航空公司的舱位代码
	 **/
	@ApiField("cabin_code")
	private String cabinCode;

	
	/** 
	 * 产品规则说明，特殊产品
	 **/
	@ApiField("cabin_memo")
	private String cabinMemo;

	
	/** 
	 * 剩余可售票数，
0～9，表示剩余0~9张
A，表示大于9张
	 **/
	@ApiField("cabin_num")
	private String cabinNum;

	
	/** 
	 * 实际销售价格，以分为单位
	 **/
	@ApiField("cabin_price")
	private Long cabinPrice;

	
	/** 
	 * 产品类型：
6，普通特价；
8，让利产品；
10，特殊产品
	 **/
	@ApiField("cabin_type")
	private String cabinType;

	
	/** 
	 * 儿童票价格，以分为单位
	 **/
	@ApiField("child_cabin_price")
	private Long childCabinPrice;

	
	/** 
	 * 舱位折扣：10~90
	 **/
	@ApiField("discount")
	private Long discount;

	
	/** 
	 * 航班id
	 **/
	@ApiField("flight_id")
	private Long flightId;

	
	/** 
	 * 舱位id
	 **/
	@ApiField("id")
	private Long id;

	
	/** 
	 * 外部产品类型，即航空公司产品类型，如果存在，下单时必须参数
	 **/
	@ApiField("out_product_id")
	private String outProductId;

	
	/** 
	 * 扣减的钱，以分为单位
	 **/
	@ApiField("return_fee")
	private Long returnFee;

	
	/** 
	 * 特价/让利/特殊产品id；如果为这三类产品之一，下单时必需参数
	 **/
	@ApiField("special_product_id")
	private Long specialProductId;

	
	/** 
	 * 退改签规则
	 **/
	@ApiField("tui_gai_qian")
	private String tuiGaiQian;

	public String getAirSupplyIds() {
		return this.airSupplyIds;
	}
	public void setAirSupplyIds(String airSupplyIds) {
		this.airSupplyIds = airSupplyIds;
	}

	public Long getCabinClass() {
		return this.cabinClass;
	}
	public void setCabinClass(Long cabinClass) {
		this.cabinClass = cabinClass;
	}

	public String getCabinCode() {
		return this.cabinCode;
	}
	public void setCabinCode(String cabinCode) {
		this.cabinCode = cabinCode;
	}

	public String getCabinMemo() {
		return this.cabinMemo;
	}
	public void setCabinMemo(String cabinMemo) {
		this.cabinMemo = cabinMemo;
	}

	public String getCabinNum() {
		return this.cabinNum;
	}
	public void setCabinNum(String cabinNum) {
		this.cabinNum = cabinNum;
	}

	public Long getCabinPrice() {
		return this.cabinPrice;
	}
	public void setCabinPrice(Long cabinPrice) {
		this.cabinPrice = cabinPrice;
	}

	public String getCabinType() {
		return this.cabinType;
	}
	public void setCabinType(String cabinType) {
		this.cabinType = cabinType;
	}

	public Long getChildCabinPrice() {
		return this.childCabinPrice;
	}
	public void setChildCabinPrice(Long childCabinPrice) {
		this.childCabinPrice = childCabinPrice;
	}

	public Long getDiscount() {
		return this.discount;
	}
	public void setDiscount(Long discount) {
		this.discount = discount;
	}

	public Long getFlightId() {
		return this.flightId;
	}
	public void setFlightId(Long flightId) {
		this.flightId = flightId;
	}

	public Long getId() {
		return this.id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getOutProductId() {
		return this.outProductId;
	}
	public void setOutProductId(String outProductId) {
		this.outProductId = outProductId;
	}

	public Long getReturnFee() {
		return this.returnFee;
	}
	public void setReturnFee(Long returnFee) {
		this.returnFee = returnFee;
	}

	public Long getSpecialProductId() {
		return this.specialProductId;
	}
	public void setSpecialProductId(Long specialProductId) {
		this.specialProductId = specialProductId;
	}

	public String getTuiGaiQian() {
		return this.tuiGaiQian;
	}
	public void setTuiGaiQian(String tuiGaiQian) {
		this.tuiGaiQian = tuiGaiQian;
	}

}
