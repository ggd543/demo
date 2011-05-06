package com.taobao.api.request;

import java.util.Map;
import java.util.Date;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.TaobaoRequest;

/**
 * TOP API: taobao.huabao.posters.get request
 * 
 * @author auto create
 * @since 1.0, 2010-11-26 09:50:04.0
 */
public class HuabaoPostersGetRequest implements TaobaoRequest {
	private Long timestamp;	
	private TaobaoHashMap textParams = new TaobaoHashMap();


	
	/** 
	 * 频道的Id值
	 **/
	private Long channelId;
	
	/** 
	 * 当前页，默认为1（当输入为负，零，或者超出页数范围时，取默认值）
	 **/
	private Long pageNo;
	
	/** 
	 * 查询返回的记录数
	 **/
	private Long pageSize;

	public void setChannelId(Long channelId) {
		this.channelId = channelId;
	}
	 public Long getChannelId() {
		return this.channelId;
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
		return "taobao.huabao.posters.get";
	}

	public Map<String, String> getTextParams() {		
		textParams.put("channel_id", this.channelId);
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
