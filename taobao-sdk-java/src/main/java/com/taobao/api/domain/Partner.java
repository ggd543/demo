package com.taobao.api.domain;

import com.taobao.api.internal.mapping.ApiClass;
import com.taobao.api.internal.mapping.ApiField;


import com.taobao.api.TaobaoObject;

/**
 * Partner Data Structure.
 * 
 * DESC：物流公司信息 
 *
 * @author auto create
 * @since 1.0, 2010-09-28 13:28:28.0
 */
@ApiClass("Partner")
public class Partner extends TaobaoObject {

	private static final long serialVersionUID = 7742469651732773336L;

	
	/** 
	 * 20881010104159000156
	 **/
	@ApiField("account_no")
	private String accountNo;

	
	/** 
	 * 公司代号
	 **/
	@ApiField("company_code")
	private String companyCode;

	
	/** 
	 * 物流公司Id
	 **/
	@ApiField("company_id")
	private Long companyId;

	
	/** 
	 * 公司简称
	 **/
	@ApiField("company_name")
	private String companyName;

	
	/** 
	 * XX物流公司
	 **/
	@ApiField("full_name")
	private String fullName;

	
	/** 
	 * 旺旺号
	 **/
	@ApiField("wangwang_id")
	private String wangwangId;

	public String getAccountNo() {
		return this.accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
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

	public String getCompanyName() {
		return this.companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getFullName() {
		return this.fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getWangwangId() {
		return this.wangwangId;
	}
	public void setWangwangId(String wangwangId) {
		this.wangwangId = wangwangId;
	}

}
