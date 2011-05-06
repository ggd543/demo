package com.taobao.api.response;

import java.util.Date;
import com.taobao.api.internal.mapping.ApiField;


import com.taobao.api.TaobaoResponse;

/**
 * TOP API: taobao.time.get response
 * 
 * @author auto create
 * @since 1.0,2010-09-27 17:27:40.0
 */
public class TimeGetResponse extends TaobaoResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8184144739239239177L;

	
	/** 
	 * 淘宝系统当前时间。格式:yyyy-MM-dd HH:mm:ss
	 **/
	@ApiField("time")
	private Date time;

	public void setTime(Date time) {
		this.time = time;
	}

	public Date getTime( ) {
		return this.time;
	}

	public String getApiMethodName() {
		return "taobao.time.get";
	}

}
