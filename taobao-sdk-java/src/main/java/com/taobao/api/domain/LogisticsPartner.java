package com.taobao.api.domain;

import com.taobao.api.internal.mapping.ApiClass;
import com.taobao.api.internal.mapping.ApiField;


import com.taobao.api.TaobaoObject;

/**
 * LogisticsPartner Data Structure.
 * 
 * DESC：物流公司信息 
 *
 * @author auto create
 * @since 1.0, 2010-09-02 12:00:45.0
 */
@ApiClass("LogisticsPartner")
public class LogisticsPartner extends TaobaoObject {

	private static final long serialVersionUID = 3884126564721187863L;

	
	/** 
	 * 揽收说明信息
	 **/
	@ApiField("cover_remark")
	private String coverRemark;

	
	/** 
	 * 物流公司详细信息
	 **/
	@ApiField("partner")
	private Partner partner;

	
	/** 
	 * 不可送达的说明信息
	 **/
	@ApiField("uncover_remark")
	private String uncoverRemark;

	public String getCoverRemark() {
		return this.coverRemark;
	}
	public void setCoverRemark(String coverRemark) {
		this.coverRemark = coverRemark;
	}

	public Partner getPartner() {
		return this.partner;
	}
	public void setPartner(Partner partner) {
		this.partner = partner;
	}

	public String getUncoverRemark() {
		return this.uncoverRemark;
	}
	public void setUncoverRemark(String uncoverRemark) {
		this.uncoverRemark = uncoverRemark;
	}

}
