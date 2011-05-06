package com.taobao.api.response;

import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.domain.Task;


import com.taobao.api.TaobaoResponse;

/**
 * TOP API: taobao.topats.trades.fullinfo.get response
 * 
 * @author auto create
 * @since 1.0,2010-11-24 15:44:50.0
 */
public class TopatsTradesFullinfoGetResponse extends TaobaoResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6435324576628426893L;

	
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
		return "taobao.topats.trades.fullinfo.get";
	}

}
