package com.taobao.api.domain;

import com.taobao.api.internal.mapping.ApiClass;
import com.taobao.api.internal.mapping.ApiField;


import com.taobao.api.TaobaoObject;

/**
 * Brand Data Structure.
 * 
 * DESC：品牌 
 *
 * @author auto create
 * @since 1.0, 2010-05-13 13:05:27.0
 */
@ApiClass("Brand")
public class Brand extends TaobaoObject {

	private static final long serialVersionUID = 8677872995867432494L;

	
	/** 
	 * vid的值
	 **/
	@ApiField("name")
	private String name;

	
	/** 
	 * 品牌的属性id
	 **/
	@ApiField("pid")
	private Long pid;

	
	/** 
	 * 品牌的属性名
	 **/
	@ApiField("prop_name")
	private String propName;

	
	/** 
	 * 对应属性的 pid:vid 串中的vid
	 **/
	@ApiField("vid")
	private Long vid;

	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Long getPid() {
		return this.pid;
	}
	public void setPid(Long pid) {
		this.pid = pid;
	}

	public String getPropName() {
		return this.propName;
	}
	public void setPropName(String propName) {
		this.propName = propName;
	}

	public Long getVid() {
		return this.vid;
	}
	public void setVid(Long vid) {
		this.vid = vid;
	}

}
