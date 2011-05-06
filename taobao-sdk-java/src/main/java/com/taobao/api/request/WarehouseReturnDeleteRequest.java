package com.taobao.api.request;

import java.util.Map;
import java.util.Date;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.TaobaoRequest;

/**
 * TOP API: taobao.warehouse.return.delete request
 * 
 * @author auto create
 * @since 1.0, 2010-12-01 15:53:23.0
 */
public class WarehouseReturnDeleteRequest implements TaobaoRequest {
	private Long timestamp;	
	private TaobaoHashMap textParams = new TaobaoHashMap();


	
	/** 
	 * 退货单号
	 **/
	private String crkCode;

	public void setCrkCode(String crkCode) {
		this.crkCode = crkCode;
	}
	 public String getCrkCode() {
		return this.crkCode;
	}
	
	public String getApiMethodName() {
		return "taobao.warehouse.return.delete";
	}

	public Map<String, String> getTextParams() {		
		textParams.put("crk_code", this.crkCode);
		return textParams;
	}
	
	public Long getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
}
