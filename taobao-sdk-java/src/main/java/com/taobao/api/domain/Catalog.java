package com.taobao.api.domain;

import com.taobao.api.internal.mapping.ApiClass;
import com.taobao.api.internal.mapping.ApiField;


import com.taobao.api.TaobaoObject;

/**
 * Catalog Data Structure.
 * 
 * DESC：类目信息数据结构 
 *
 * @author auto create
 * @since 1.0, 2010-04-21 10:49:32.0
 */
@ApiClass("Catalog")
public class Catalog extends TaobaoObject {

	private static final long serialVersionUID = 6271993511987946212L;

	
	/** 
	 * 类目id
	 **/
	@ApiField("catalog_id")
	private Long catalogId;

	
	/** 
	 * 类目名称
	 **/
	@ApiField("catalog_name")
	private String catalogName;

	public Long getCatalogId() {
		return this.catalogId;
	}
	public void setCatalogId(Long catalogId) {
		this.catalogId = catalogId;
	}

	public String getCatalogName() {
		return this.catalogName;
	}
	public void setCatalogName(String catalogName) {
		this.catalogName = catalogName;
	}

}
