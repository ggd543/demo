package com.taobao.api.domain;

import com.taobao.api.internal.mapping.ApiClass;
import com.taobao.api.internal.mapping.ApiField;


import com.taobao.api.TaobaoObject;

/**
 * TicketPrice Data Structure.
 * 
 * DESC：票价详细内容（包含票价，机建，燃油） 
 *
 * @author auto create
 * @since 1.0, 2010-11-19 18:08:38.0
 */
@ApiClass("TicketPrice")
public class TicketPrice extends TaobaoObject {

	private static final long serialVersionUID = 2211734797217283881L;

	
	/** 
	 * 机场建设费 以分为单位
	 **/
	@ApiField("build_price")
	private Long buildPrice;

	
	/** 
	 * 燃油附加税，以分为单位
	 **/
	@ApiField("oil_price")
	private Long oilPrice;

	
	/** 
	 * 机票价格 以分为单位
	 **/
	@ApiField("tkt_price")
	private Long tktPrice;

	
	/** 
	 * 0:成人价,1:儿童价
	 **/
	@ApiField("type")
	private Long type;

	public Long getBuildPrice() {
		return this.buildPrice;
	}
	public void setBuildPrice(Long buildPrice) {
		this.buildPrice = buildPrice;
	}

	public Long getOilPrice() {
		return this.oilPrice;
	}
	public void setOilPrice(Long oilPrice) {
		this.oilPrice = oilPrice;
	}

	public Long getTktPrice() {
		return this.tktPrice;
	}
	public void setTktPrice(Long tktPrice) {
		this.tktPrice = tktPrice;
	}

	public Long getType() {
		return this.type;
	}
	public void setType(Long type) {
		this.type = type;
	}

}
