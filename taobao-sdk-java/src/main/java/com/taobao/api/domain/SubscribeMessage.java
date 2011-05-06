package com.taobao.api.domain;

import java.util.Date;
import java.util.List;
import com.taobao.api.internal.mapping.ApiClass;
import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.internal.mapping.ApiListField;


import com.taobao.api.TaobaoObject;

/**
 * SubscribeMessage Data Structure.
 * 
 * DESC：ISV订阅信息 
 *
 * @author auto create
 * @since 1.0, 2010-08-30 15:22:36.0
 */
@ApiClass("SubscribeMessage")
public class SubscribeMessage extends TaobaoObject {

	private static final long serialVersionUID = 2246923538885468543L;

	
	/** 
	 * ISV的应用AppKey
	 **/
	@ApiField("app_key")
	private String appKey;

	
	/** 
	 * ISV的订阅到期时间
	 **/
	@ApiField("end_date")
	private Date endDate;

	
	/** 
	 * ISV的订阅信息修改时间
	 **/
	@ApiField("modified")
	private Date modified;

	
	/** 
	 * ISV的主动发送消息列表。表示哪些消息需要主动发送给App。如果需要获取ISV的消息列表，传入notifyInfo即可
	 **/
	@ApiListField("notify_infos")
	@ApiField("notify_info")
	private List<NotifyInfo> notifyInfos;

	
	/** 
	 * App接受消息的地址
	 **/
	@ApiField("notify_url")
	private String notifyUrl;

	
	/** 
	 * ISV的订阅开始时间。订阅当天开始计算
	 **/
	@ApiField("start_date")
	private Date startDate;

	
	/** 
	 * ISV的订阅消息类型列表。如果需要获取ISV的授权列表，传入subscription即可
	 **/
	@ApiListField("subscriptions")
	@ApiField("subscription")
	private List<Subscription> subscriptions;

	public String getAppKey() {
		return this.appKey;
	}
	public void setAppKey(String appKey) {
		this.appKey = appKey;
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

	public List<NotifyInfo> getNotifyInfos() {
		return this.notifyInfos;
	}
	public void setNotifyInfos(List<NotifyInfo> notifyInfos) {
		this.notifyInfos = notifyInfos;
	}

	public String getNotifyUrl() {
		return this.notifyUrl;
	}
	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}

	public Date getStartDate() {
		return this.startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public List<Subscription> getSubscriptions() {
		return this.subscriptions;
	}
	public void setSubscriptions(List<Subscription> subscriptions) {
		this.subscriptions = subscriptions;
	}

}
