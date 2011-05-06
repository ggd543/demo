package com.taobao.api.domain;

import com.taobao.api.internal.mapping.ApiClass;
import com.taobao.api.internal.mapping.ApiField;


import com.taobao.api.TaobaoObject;

/**
 * ProductProp Data Structure.
 * 
 * DESC：属性统计结构 
 *
 * @author auto create
 * @since 1.0, 2010-04-26 16:34:46.0
 */
@ApiClass("ProductProp")
public class ProductProp extends TaobaoObject {

	private static final long serialVersionUID = 8775243721558971932L;

	
	/** 
	 * 类目属性ID
	 **/
	@ApiField("cid")
	private String cid;

	
	/** 
	 * 属性ID
	 **/
	@ApiField("pid")
	private String pid;

	
	/** 
	 * 属性名
	 **/
	@ApiField("prop_name")
	private String propName;

	
	/** 
	 * 属性值名称列表
	 **/
	@ApiField("prop_names")
	private String propNames;

	
	/** 
	 * 属性值列表
	 **/
	@ApiField("prop_values")
	private String propValues;

	public String getCid() {
		return this.cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getPid() {
		return this.pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getPropName() {
		return this.propName;
	}
	public void setPropName(String propName) {
		this.propName = propName;
	}

	public String getPropNames() {
		return this.propNames;
	}
	public void setPropNames(String propNames) {
		this.propNames = propNames;
	}

	public String getPropValues() {
		return this.propValues;
	}
	public void setPropValues(String propValues) {
		this.propValues = propValues;
	}

}
