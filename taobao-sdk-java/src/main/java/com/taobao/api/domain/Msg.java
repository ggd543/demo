package com.taobao.api.domain;

import com.taobao.api.internal.mapping.ApiClass;
import com.taobao.api.internal.mapping.ApiField;


import com.taobao.api.TaobaoObject;

/**
 * Msg Data Structure.
 * 
 * DESC：聊天消息内容 
 *
 * @author auto create
 * @since 1.0, 2010-04-22 17:25:09.0
 */
@ApiClass("Msg")
public class Msg extends TaobaoObject {

	private static final long serialVersionUID = 4397985153935361413L;

	
	/** 
	 * 消息内容
	 **/
	@ApiField("content")
	private String content;

	
	/** 
	 * direction=0为from_id发送消息给to_id，direction=1为to_id发送消息给from_id
	 **/
	@ApiField("direction")
	private Long direction;

	
	/** 
	 * 消息日期
	 **/
	@ApiField("time")
	private String time;

	public String getContent() {
		return this.content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	public Long getDirection() {
		return this.direction;
	}
	public void setDirection(Long direction) {
		this.direction = direction;
	}

	public String getTime() {
		return this.time;
	}
	public void setTime(String time) {
		this.time = time;
	}

}
