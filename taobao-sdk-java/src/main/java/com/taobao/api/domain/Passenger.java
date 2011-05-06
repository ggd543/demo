package com.taobao.api.domain;

import com.taobao.api.internal.mapping.ApiClass;
import com.taobao.api.internal.mapping.ApiField;


import com.taobao.api.TaobaoObject;

/**
 * Passenger Data Structure.
 * 
 * DESC：乘机人信息 
 *
 * @author auto create
 * @since 1.0, 2010-11-19 18:08:12.0
 */
@ApiClass("Passenger")
public class Passenger extends TaobaoObject {

	private static final long serialVersionUID = 1186651825115429917L;

	
	/** 
	 * 乘机人姓名
	 **/
	@ApiField("passenger_name")
	private String passengerName;

	
	/** 
	 * 乘机人联系电话
	 **/
	@ApiField("passenger_phone")
	private String passengerPhone;

	
	/** 
	 * PNR信息
	 **/
	@ApiField("pnr")
	private String pnr;

	
	/** 
	 * 票号
	 **/
	@ApiField("ticket_no")
	private String ticketNo;

	public String getPassengerName() {
		return this.passengerName;
	}
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public String getPassengerPhone() {
		return this.passengerPhone;
	}
	public void setPassengerPhone(String passengerPhone) {
		this.passengerPhone = passengerPhone;
	}

	public String getPnr() {
		return this.pnr;
	}
	public void setPnr(String pnr) {
		this.pnr = pnr;
	}

	public String getTicketNo() {
		return this.ticketNo;
	}
	public void setTicketNo(String ticketNo) {
		this.ticketNo = ticketNo;
	}

}
