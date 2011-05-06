package com.taobao.api.domain;

import java.util.Date;
import com.taobao.api.internal.mapping.ApiClass;
import com.taobao.api.internal.mapping.ApiField;


import com.taobao.api.TaobaoObject;

/**
 * AuthorizeMessage Data Structure.
 * 
 * DESC：用户授权信息 
 *
 * @author auto create
 * @since 1.0, 2010-07-01 14:11:41.0
 */
@ApiClass("AuthorizeMessage")
public class AuthorizeMessage extends TaobaoObject {

	private static final long serialVersionUID = 1852338736189232124L;

	
	/** 
	 * ISV的AppKey
	 **/
	@ApiField("app_key")
	private String appKey;

	
	/** 
	 * 用户创建授权给当前ISV的时间
	 **/
	@ApiField("created")
	private Date created;

	
	/** 
	 * 用户的授权到期时间
	 **/
	@ApiField("end_date")
	private Date endDate;

	
	/** 
	 * 用户的授权信息修改时间
	 **/
	@ApiField("modified")
	private Date modified;

	
	/** 
	 * 授权用户的淘宝昵称
	 **/
	@ApiField("nick")
	private String nick;

	
	/** 
	 * 用户的授权开始时间。授权当天开始计算。start_date是每个授权周期开始的时间，如果这个周期没有结束用户就延长或修改了授权周期，这个开始时间是不会变的，除非这个周期结束以后再重新开始新的周期，这个字段才会被改变
	 **/
	@ApiField("start_date")
	private Date startDate;

	
	/** 
	 * 用户的授权状态：normal（正常），expired（过期）
	 **/
	@ApiField("status")
	private String status;

	
	/** 
	 * 用户的授权是否已经生效（生效表示能够收到变更消息）
	 **/
	@ApiField("valid")
	private Boolean valid;

	public String getAppKey() {
		return this.appKey;
	}
	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}

	public Date getCreated() {
		return this.created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getEndDate() {
		return this.endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getModified() {
		return this.modified;
	}
	public void setModified(Date modified) {
		this.modified = modified;
	}

	public String getNick() {
		return this.nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}

	public Date getStartDate() {
		return this.startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getStatus() {
		return this.status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public Boolean getValid() {
		return this.valid;
	}
	public void setValid(Boolean valid) {
		this.valid = valid;
	}

}
