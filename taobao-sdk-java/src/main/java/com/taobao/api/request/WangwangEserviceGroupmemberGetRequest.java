package com.taobao.api.request;

import java.util.Map;
import java.util.Date;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.TaobaoRequest;

/**
 * TOP API: taobao.wangwang.eservice.groupmember.get request
 * 
 * @author auto create
 * @since 1.0, 2010-11-04 16:24:03.0
 */
public class WangwangEserviceGroupmemberGetRequest implements TaobaoRequest {
	private Long timestamp;	
	private TaobaoHashMap textParams = new TaobaoHashMap();


	
	/** 
	 * 被查询用户组管理员ID：cntaobao+淘宝nick，例如cntaobaotest
	 **/
	private String managerId;

	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}
	 public String getManagerId() {
		return this.managerId;
	}
	
	public String getApiMethodName() {
		return "taobao.wangwang.eservice.groupmember.get";
	}

	public Map<String, String> getTextParams() {		
		textParams.put("manager_id", this.managerId);
		return textParams;
	}
	
	public Long getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
}
