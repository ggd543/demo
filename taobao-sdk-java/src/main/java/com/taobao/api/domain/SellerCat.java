package com.taobao.api.domain;

import java.util.Date;
import com.taobao.api.internal.mapping.ApiClass;
import com.taobao.api.internal.mapping.ApiField;


import com.taobao.api.TaobaoObject;

/**
 * SellerCat Data Structure.
 * 
 * DESC：店铺内卖家自定义类目 
 *
 * @author auto create
 * @since 1.0, 2010-05-11 17:12:20.0
 */
@ApiClass("SellerCat")
public class SellerCat extends TaobaoObject {

	private static final long serialVersionUID = 4716445928337225297L;

	
	/** 
	 * 卖家自定义类目编号
	 **/
	@ApiField("cid")
	private Long cid;

	
	/** 
	 * 创建时间。格式：yyyy-MM-dd HH:mm:ss
	 **/
	@ApiField("created")
	private Date created;

	
	/** 
	 * 修改时间。格式：yyyy-MM-dd HH:mm:ss
	 **/
	@ApiField("modified")
	private Date modified;

	
	/** 
	 * 卖家自定义类目名称
	 **/
	@ApiField("name")
	private String name;

	
	/** 
	 * 父类目编号，值等于0：表示此类目为店铺下的一级类目，值不等于0：表示此类目有父类目
	 **/
	@ApiField("parent_cid")
	private Long parentCid;

	
	/** 
	 * 链接图片地址
	 **/
	@ApiField("pic_url")
	private String picUrl;

	
	/** 
	 * 该类目在页面上的排序位置
	 **/
	@ApiField("sort_order")
	private Long sortOrder;

	public Long getCid() {
		return this.cid;
	}
	public void setCid(Long cid) {
		this.cid = cid;
	}

	public Date getCreated() {
		return this.created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getModified() {
		return this.modified;
	}
	public void setModified(Date modified) {
		this.modified = modified;
	}

	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Long getParentCid() {
		return this.parentCid;
	}
	public void setParentCid(Long parentCid) {
		this.parentCid = parentCid;
	}

	public String getPicUrl() {
		return this.picUrl;
	}
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public Long getSortOrder() {
		return this.sortOrder;
	}
	public void setSortOrder(Long sortOrder) {
		this.sortOrder = sortOrder;
	}

}
