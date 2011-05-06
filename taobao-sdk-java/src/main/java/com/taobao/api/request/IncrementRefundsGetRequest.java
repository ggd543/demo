package com.taobao.api.request;
import java.util.Date;

import java.util.Map;
import java.util.Date;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.TaobaoRequest;

/**
 * TOP API: taobao.increment.refunds.get request
 * 
 * @author auto create
 * @since 1.0, 2010-09-14 20:58:49.0
 */
public class IncrementRefundsGetRequest implements TaobaoRequest {
	private Long timestamp;	
	private TaobaoHashMap textParams = new TaobaoHashMap();


	
	/** 
	 * 消息所对应的操作时间的最大值。和start_modified搭配使用能过滤消通知消息的时间段。不传时：如果设置了start_modified，默认为与start_modified同一天的23:59:59；否则默认为调用接口当天的23:59:59。（格式：yyyy-MM-dd HH:mm:ss）
	 **/
	private Date endModified;
	
	/** 
	 * 消息所属于的用户的昵称。设置此参数，返回的消息会根据传入nick的进行过滤。自用型appKey的昵称默认为自己的绑定昵称，此参数无效。
	 **/
	private String nick;
	
	/** 
	 * 页码。取值范围:大于零的整数; 默认值:1,即返回第一页数据。
	 **/
	private Long pageNo;
	
	/** 
	 * 每页条数。取值范围:大于零的整数;最大值:200;默认值:40。
	 **/
	private Long pageSize;
	
	/** 
	 * 消息所对应的操作时间的最小值。和end_modified搭配使用能过滤消通知消息的时间段。不传时：如果设置了end_modified，默认为与 end_modified同一天的00:00:00，否则默认为调用接口当天的00:00:00。（格式：yyyy-MM-dd HH:mm:ss）
	 **/
	private Date startModified;
	
	/** 
	 * 退款操作状态，默认查询所有状态的数据，除了默认值外每次只能查询一种状态。具体字段说明请见 退款消息状态
	 **/
	private String status;

	public void setEndModified(Date endModified) {
		this.endModified = endModified;
	}
	 public Date getEndModified() {
		return this.endModified;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	 public String getNick() {
		return this.nick;
	}
	public void setPageNo(Long pageNo) {
		this.pageNo = pageNo;
	}
	 public Long getPageNo() {
		return this.pageNo;
	}
	public void setPageSize(Long pageSize) {
		this.pageSize = pageSize;
	}
	 public Long getPageSize() {
		return this.pageSize;
	}
	public void setStartModified(Date startModified) {
		this.startModified = startModified;
	}
	 public Date getStartModified() {
		return this.startModified;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	 public String getStatus() {
		return this.status;
	}
	
	public String getApiMethodName() {
		return "taobao.increment.refunds.get";
	}

	public Map<String, String> getTextParams() {		
		textParams.put("end_modified", this.endModified);
		textParams.put("nick", this.nick);
		textParams.put("page_no", this.pageNo);
		textParams.put("page_size", this.pageSize);
		textParams.put("start_modified", this.startModified);
		textParams.put("status", this.status);
		return textParams;
	}
	
	public Long getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
}
