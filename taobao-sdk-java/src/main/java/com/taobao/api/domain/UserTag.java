package com.taobao.api.domain;

import java.util.Date;
import com.taobao.api.internal.mapping.ApiClass;
import com.taobao.api.internal.mapping.ApiField;


import com.taobao.api.TaobaoObject;

/**
 * UserTag Data Structure.
 * 
 * DESC：人群标签 
 *
 * @author auto create
 * @since 1.0, 2010-10-19 15:54:39.0
 */
@ApiClass("UserTag")
public class UserTag extends TaobaoObject {

	private static final long serialVersionUID = 2719659495549936555L;

	
	/** 
	 * 创建时间
	 **/
	@ApiField("create_date")
	private Date createDate;

	
	/** 
	 * 标签描述
	 **/
	@ApiField("description")
	private String description;

	
	/** 
	 * 标签ID
	 **/
	@ApiField("tag_id")
	private Long tagId;

	
	/** 
	 * 标签名称
	 **/
	@ApiField("tag_name")
	private String tagName;

	public Date getCreateDate() {
		return this.createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getDescription() {
		return this.description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public Long getTagId() {
		return this.tagId;
	}
	public void setTagId(Long tagId) {
		this.tagId = tagId;
	}

	public String getTagName() {
		return this.tagName;
	}
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

}
