package com.taobao.api.request;

import java.util.Map;
import java.util.Date;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.TaobaoRequest;

/**
 * TOP API: taobao.topats.result.get request
 * 
 * @author auto create
 * @since 1.0, 2010-11-17 16:38:45.0
 */
public class TopatsResultGetRequest implements TaobaoRequest {
	private Long timestamp;	
	private TaobaoHashMap textParams = new TaobaoHashMap();


	
	/** 
	 * 任务id号，创建任务时返回的task_id
	 **/
	private Long taskId;

	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}
	 public Long getTaskId() {
		return this.taskId;
	}
	
	public String getApiMethodName() {
		return "taobao.topats.result.get";
	}

	public Map<String, String> getTextParams() {		
		textParams.put("task_id", this.taskId);
		return textParams;
	}
	
	public Long getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
}
