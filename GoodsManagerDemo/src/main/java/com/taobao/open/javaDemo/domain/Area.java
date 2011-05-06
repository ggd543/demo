package com.taobao.open.javaDemo.domain;


/**
 * 地址区域信息
 * @author zhudi
 *
 */
public class Area {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2218038376753251584L;
	
	private String id;
	private String type;
	private String name;
	private String parentId;
	private String zip;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}