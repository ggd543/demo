package com.taobao.api.domain;

import com.taobao.api.internal.mapping.ApiClass;
import com.taobao.api.internal.mapping.ApiField;


import com.taobao.api.TaobaoObject;

/**
 * KbCity Data Structure.
 * 
 * DESC：口碑的城市体系 
 *
 * @author auto create
 * @since 1.0, 2010-05-17 14:03:04.0
 */
@ApiClass("KbCity")
public class KbCity extends TaobaoObject {

	private static final long serialVersionUID = 8793873425268297261L;

	
	/** 
	 * 自增的字段
	 **/
	@ApiField("id")
	private Long id;

	
	/** 
	 * 文本类型
	 **/
	@ApiField("name")
	private String name;

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
