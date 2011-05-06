package com.taobao.api.request;

import java.util.Map;
import java.util.Date;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.TaobaoRequest;

/**
 * TOP API: taobao.traderates.get request
 * 
 * @author auto create
 * @since 1.0, 2010-09-27 09:29:39.0
 */
public class TraderatesGetRequest implements TaobaoRequest {
	private Long timestamp;	
	private TaobaoHashMap textParams = new TaobaoHashMap();


	
	/** 
	 * 需返回的字段列表。可选值：TradeRate 结构中的所有字段，多个字段之间用“,”分隔
	 **/
	private String fields;
	
	/** 
	 * 页码。取值范围:大于零的整数; 默认值:1
	 **/
	private Long pageNo;
	
	/** 
	 * 每页条数。取值范围:大于零的整数; 默认值:40;最大值:200
	 **/
	private Long pageSize;
	
	/** 
	 * 评价类型。可选值:get(得到),give(给出)
	 **/
	private String rateType;
	
	/** 
	 * 评价结果。可选值:good(好评),neutral(中评),bad(差评)
	 **/
	private String result;
	
	/** 
	 * 评价者角色。可选值:seller(卖家),buyer(买家)
	 **/
	private String role;

	public void setFields(String fields) {
		this.fields = fields;
	}
	 public String getFields() {
		return this.fields;
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
	public void setRateType(String rateType) {
		this.rateType = rateType;
	}
	 public String getRateType() {
		return this.rateType;
	}
	public void setResult(String result) {
		this.result = result;
	}
	 public String getResult() {
		return this.result;
	}
	public void setRole(String role) {
		this.role = role;
	}
	 public String getRole() {
		return this.role;
	}
	
	public String getApiMethodName() {
		return "taobao.traderates.get";
	}

	public Map<String, String> getTextParams() {		
		textParams.put("fields", this.fields);
		textParams.put("page_no", this.pageNo);
		textParams.put("page_size", this.pageSize);
		textParams.put("rate_type", this.rateType);
		textParams.put("result", this.result);
		textParams.put("role", this.role);
		return textParams;
	}
	
	public Long getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
}
