package com.taobao.api.request;

import java.util.Map;
import java.util.Date;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.TaobaoRequest;

/**
 * TOP API: taobao.increment.authorizemessages.get request
 * 
 * @author auto create
 * @since 1.0, 2010-09-14 20:58:59.0
 */
public class IncrementAuthorizemessagesGetRequest implements TaobaoRequest {
	private Long timestamp;	
	private TaobaoHashMap textParams = new TaobaoHashMap();


	
	/** 
	 * 用户授权剩余时间过滤。以天计算，取值范围为0-7之间的整数，0表示当天会过期的用户。例如：传入3，表示查询从当天开始，未来3天内会过期的用户授权信息。
	 **/
	private Long expiredDay;
	
	/** 
	 * 需要返回的字段。具体字段间AuthorizeMessage说明
	 **/
	private String fields;
	
	/** 
	 * 用户昵称列表，每个nick之间以","间隔，一次不超过20个
	 **/
	private String nicks;
	
	/** 
	 * 页码。取值范围:大于零的整数; 默认值:1,即返回第一页数据。
	 **/
	private Long pageNo;
	
	/** 
	 * 每页条数。取值范围:大于零的整数;最大值:200;默认值:40。注：只有不指定nick参数时分页才有作用。
	 **/
	private Long pageSize;

	public void setExpiredDay(Long expiredDay) {
		this.expiredDay = expiredDay;
	}
	 public Long getExpiredDay() {
		return this.expiredDay;
	}
	public void setFields(String fields) {
		this.fields = fields;
	}
	 public String getFields() {
		return this.fields;
	}
	public void setNicks(String nicks) {
		this.nicks = nicks;
	}
	 public String getNicks() {
		return this.nicks;
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
	
	public String getApiMethodName() {
		return "taobao.increment.authorizemessages.get";
	}

	public Map<String, String> getTextParams() {		
		textParams.put("expired_day", this.expiredDay);
		textParams.put("fields", this.fields);
		textParams.put("nicks", this.nicks);
		textParams.put("page_no", this.pageNo);
		textParams.put("page_size", this.pageSize);
		return textParams;
	}
	
	public Long getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
}
