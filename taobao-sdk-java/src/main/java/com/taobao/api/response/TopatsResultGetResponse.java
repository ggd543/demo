package com.taobao.api.response;

import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.domain.Task;


import com.taobao.api.TaobaoResponse;

/**
 * TOP API: taobao.topats.result.get response
 * 
 * @author auto create
 * @since 1.0,2010-11-17 16:38:45.0
 */
public class TopatsResultGetResponse extends TaobaoResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3322228196919479648L;

	
	/** 
	 * 返回任务处理信息
	 **/
	@ApiField("task")
	private Task task;

	public void setTask(Task task) {
		this.task = task;
	}

	public Task getTask( ) {
		return this.task;
	}

	public String getApiMethodName() {
		return "taobao.topats.result.get";
	}

}
