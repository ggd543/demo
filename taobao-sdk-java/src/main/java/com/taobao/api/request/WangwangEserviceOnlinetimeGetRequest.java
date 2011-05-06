package com.taobao.api.request;
import java.util.Date;

import java.util.Map;
import java.util.Date;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.TaobaoRequest;

/**
 * TOP API: taobao.wangwang.eservice.onlinetime.get request
 * 
 * @author auto create
 * @since 1.0, 2010-09-19 13:10:29.0
 */
public class WangwangEserviceOnlinetimeGetRequest implements TaobaoRequest {
	private Long timestamp;	
	private TaobaoHashMap textParams = new TaobaoHashMap();


	
	/** 
	 * 结束日期
	 **/
	private Date endDate;
	
	/** 
	 * 客服人员id：cntaobao+淘宝nick，例如cntaobaotest
	 **/
	private String serviceStaffId;
	
	/** 
	 * 开始日期
	 **/
	private Date startDate;

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	 public Date getEndDate() {
		return this.endDate;
	}
	public void setServiceStaffId(String serviceStaffId) {
		this.serviceStaffId = serviceStaffId;
	}
	 public String getServiceStaffId() {
		return this.serviceStaffId;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	 public Date getStartDate() {
		return this.startDate;
	}
	
	public String getApiMethodName() {
		return "taobao.wangwang.eservice.onlinetime.get";
	}

	public Map<String, String> getTextParams() {		
		textParams.put("end_date", this.endDate);
		textParams.put("service_staff_id", this.serviceStaffId);
		textParams.put("start_date", this.startDate);
		return textParams;
	}
	
	public Long getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
}
