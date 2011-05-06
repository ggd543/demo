package com.taobao.api.domain;

import java.util.Date;
import com.taobao.api.internal.mapping.ApiClass;
import com.taobao.api.internal.mapping.ApiField;


import com.taobao.api.TaobaoObject;

/**
 * RefundRemindTimeout Data Structure.
 * 
 * DESC：退款超时结构 
 *
 * @author auto create
 * @since 1.0, 2010-04-20 20:26:51.0
 */
@ApiClass("RefundRemindTimeout")
public class RefundRemindTimeout extends TaobaoObject {

	private static final long serialVersionUID = 2197571622584617176L;

	
	/** 
	 * 是否存在超时。可选值:true(是),false(否)
	 **/
	@ApiField("exist_timeout")
	private Boolean existTimeout;

	
	/** 
	 * 提醒的类型（退款详情中提示信息的类型）
	 **/
	@ApiField("remind_type")
	private Long remindType;

	
	/** 
	 * 超时时间。格式:yyyy-MM-dd HH:mm:ss
	 **/
	@ApiField("timeout")
	private Date timeout;

	public Boolean getExistTimeout() {
		return this.existTimeout;
	}
	public void setExistTimeout(Boolean existTimeout) {
		this.existTimeout = existTimeout;
	}

	public Long getRemindType() {
		return this.remindType;
	}
	public void setRemindType(Long remindType) {
		this.remindType = remindType;
	}

	public Date getTimeout() {
		return this.timeout;
	}
	public void setTimeout(Date timeout) {
		this.timeout = timeout;
	}

}
