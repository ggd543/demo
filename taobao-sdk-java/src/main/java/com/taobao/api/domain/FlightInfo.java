package com.taobao.api.domain;

import java.util.Date;
import java.util.List;
import com.taobao.api.internal.mapping.ApiClass;
import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.internal.mapping.ApiListField;


import com.taobao.api.TaobaoObject;

/**
 * FlightInfo Data Structure.
 * 
 * DESC：航班信息 
 *
 * @author auto create
 * @since 1.0, 2010-11-25 16:06:39.0
 */
@ApiClass("FlightInfo")
public class FlightInfo extends TaobaoObject {

	private static final long serialVersionUID = 2294596754124223983L;

	
	/** 
	 * 航空公司二字码
	 **/
	@ApiField("airline_code")
	private String airlineCode;

	
	/** 
	 * 航空公司名称
	 **/
	@ApiField("airline_name")
	private String airlineName;

	
	/** 
	 * 到达机场三字吗
	 **/
	@ApiField("arr_airport_code")
	private String arrAirportCode;

	
	/** 
	 * 到达机场名称
	 **/
	@ApiField("arr_airport_name")
	private String arrAirportName;

	
	/** 
	 * 到达日期，根据需要进行格式化
	 **/
	@ApiField("arr_date")
	private Date arrDate;

	
	/** 
	 * 到达时间，根据需要进行格式化
	 **/
	@ApiField("arr_time")
	private Date arrTime;

	
	/** 
	 * 航班信息中的舱位信息列表
	 **/
	@ApiListField("cabin_price_list")
	@ApiField("cabin_price")
	private List<CabinPrice> cabinPriceList;

	
	/** 
	 * 承运航班
	 **/
	@ApiField("carrier")
	private String carrier;

	
	/** 
	 * 出发机场三字吗
	 **/
	@ApiField("dep_airport_code")
	private String depAirportCode;

	
	/** 
	 * 出发机场名称
	 **/
	@ApiField("dep_airport_name")
	private String depAirportName;

	
	/** 
	 * 出发日期，根据需要进行格式化
	 **/
	@ApiField("dep_date")
	private Date depDate;

	
	/** 
	 * 出发时间，根据需要进行格式化
	 **/
	@ApiField("dep_time")
	private Date depTime;

	
	/** 
	 * 机场建设费，以分为单位
	 **/
	@ApiField("fees")
	private Long fees;

	
	/** 
	 * 航班号
	 **/
	@ApiField("flight")
	private String flight;

	
	/** 
	 * 机型
	 **/
	@ApiField("flight_type")
	private String flightType;

	
	/** 
	 * 航班id，tb机票系统特有，方便查问题，下订单时必需字段
	 **/
	@ApiField("id")
	private String id;

	
	/** 
	 * 是否提供餐饮
	 **/
	@ApiField("meals")
	private Long meals;

	
	/** 
	 * 里程
	 **/
	@ApiField("miles")
	private Long miles;

	
	/** 
	 * 标准价格，Y舱价格，以分为单位
	 **/
	@ApiField("stand_price")
	private Long standPrice;

	
	/** 
	 * 转停
	 **/
	@ApiField("stops")
	private Long stops;

	
	/** 
	 * 燃油税，以分为单位
	 **/
	@ApiField("taxes")
	private Long taxes;

	public String getAirlineCode() {
		return this.airlineCode;
	}
	public void setAirlineCode(String airlineCode) {
		this.airlineCode = airlineCode;
	}

	public String getAirlineName() {
		return this.airlineName;
	}
	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}

	public String getArrAirportCode() {
		return this.arrAirportCode;
	}
	public void setArrAirportCode(String arrAirportCode) {
		this.arrAirportCode = arrAirportCode;
	}

	public String getArrAirportName() {
		return this.arrAirportName;
	}
	public void setArrAirportName(String arrAirportName) {
		this.arrAirportName = arrAirportName;
	}

	public Date getArrDate() {
		return this.arrDate;
	}
	public void setArrDate(Date arrDate) {
		this.arrDate = arrDate;
	}

	public Date getArrTime() {
		return this.arrTime;
	}
	public void setArrTime(Date arrTime) {
		this.arrTime = arrTime;
	}

	public List<CabinPrice> getCabinPriceList() {
		return this.cabinPriceList;
	}
	public void setCabinPriceList(List<CabinPrice> cabinPriceList) {
		this.cabinPriceList = cabinPriceList;
	}

	public String getCarrier() {
		return this.carrier;
	}
	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}

	public String getDepAirportCode() {
		return this.depAirportCode;
	}
	public void setDepAirportCode(String depAirportCode) {
		this.depAirportCode = depAirportCode;
	}

	public String getDepAirportName() {
		return this.depAirportName;
	}
	public void setDepAirportName(String depAirportName) {
		this.depAirportName = depAirportName;
	}

	public Date getDepDate() {
		return this.depDate;
	}
	public void setDepDate(Date depDate) {
		this.depDate = depDate;
	}

	public Date getDepTime() {
		return this.depTime;
	}
	public void setDepTime(Date depTime) {
		this.depTime = depTime;
	}

	public Long getFees() {
		return this.fees;
	}
	public void setFees(Long fees) {
		this.fees = fees;
	}

	public String getFlight() {
		return this.flight;
	}
	public void setFlight(String flight) {
		this.flight = flight;
	}

	public String getFlightType() {
		return this.flightType;
	}
	public void setFlightType(String flightType) {
		this.flightType = flightType;
	}

	public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public Long getMeals() {
		return this.meals;
	}
	public void setMeals(Long meals) {
		this.meals = meals;
	}

	public Long getMiles() {
		return this.miles;
	}
	public void setMiles(Long miles) {
		this.miles = miles;
	}

	public Long getStandPrice() {
		return this.standPrice;
	}
	public void setStandPrice(Long standPrice) {
		this.standPrice = standPrice;
	}

	public Long getStops() {
		return this.stops;
	}
	public void setStops(Long stops) {
		this.stops = stops;
	}

	public Long getTaxes() {
		return this.taxes;
	}
	public void setTaxes(Long taxes) {
		this.taxes = taxes;
	}

}
