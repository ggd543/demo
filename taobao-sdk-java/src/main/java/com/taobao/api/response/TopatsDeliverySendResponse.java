package com.taobao.api.response;

import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.domain.Task;


import com.taobao.api.TaobaoResponse;

/**
 * TOP API: taobao.topats.delivery.send response
 * 
 * @author auto create
 * @since 1.0,2010-11-24 15:45:07.0
 */
public class TopatsDeliverySendResponse extends TaobaoResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2468929562647661783L;

	
	/** 
	 * 创建任务信息。里面只包含task_id和created
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
		return "taobao.topats.delivery.send";
	}

}
