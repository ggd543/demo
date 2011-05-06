package com.taobao.api.domain;

import com.taobao.api.internal.mapping.ApiClass;
import com.taobao.api.internal.mapping.ApiField;


import com.taobao.api.TaobaoObject;

/**
 * LogisticsCompany Data Structure.
 * 
 * DESC：物流公司结构 
 *
 * @author auto create
 * @since 1.0, 2010-04-22 19:53:47.0
 */
@ApiClass("LogisticsCompany")
public class LogisticsCompany extends TaobaoObject {

	private static final long serialVersionUID = 3221192497846441511L;

	
	/** 
	 * 物流公司代码
	 **/
	@ApiField("code")
	private String code;

	
	/** 
	 * 物流公司标识
	 **/
	@ApiField("id")
	private Long id;

	
	/** 
	 * 物流公司简称
	 **/
	@ApiField("name")
	private String name;

	public String getCode() {
		return this.code;
	}
	public void setCode(String code) {
		this.code = code;
	}

	public Long getId() {
		return this.id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
