package com.taobao.api.request;

import java.util.Map;
import java.util.Date;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.TaobaoRequest;

/**
 * TOP API: taobao.fenxiao.distributors.get request
 * 
 * @author auto create
 * @since 1.0, 2010-10-22 11:20:27.0
 */
public class FenxiaoDistributorsGetRequest implements TaobaoRequest {
	private Long timestamp;	
	private TaobaoHashMap textParams = new TaobaoHashMap();


	
	/** 
	 * 分销商用户名列表。多个之间以“,”分隔;最多支持50个分销商用户名。
	 **/
	private String nicks;

	public void setNicks(String nicks) {
		this.nicks = nicks;
	}
	 public String getNicks() {
		return this.nicks;
	}
	
	public String getApiMethodName() {
		return "taobao.fenxiao.distributors.get";
	}

	public Map<String, String> getTextParams() {		
		textParams.put("nicks", this.nicks);
		return textParams;
	}
	
	public Long getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
}
