package com.taobao.api.request;
import java.util.Date;

import java.util.Map;
import java.util.Date;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.TaobaoRequest;

/**
 * TOP API: taobao.warehouse.crk.search request
 * 
 * @author auto create
 * @since 1.0, 2010-11-24 11:28:26.0
 */
public class WarehouseCrkSearchRequest implements TaobaoRequest {
	private Long timestamp;	
	private TaobaoHashMap textParams = new TaobaoHashMap();


	
	/** 
	 * 出入库单号
	 **/
	private String crkCode;
	
	/** 
	 * 结束入库时间，查出当前时间之前的所有记录数
	 **/
	private Date crkDateEnd;
	
	/** 
	 * 起始入库时间，查出从当前时间起的所有记录
	 **/
	private Date crkDateStart;
	
	/** 
	 * 当前页(默认为1)
	 **/
	private Long pageNo;
	
	/** 
	 * 分页参数,每页所包含的记录条数,正整数，默认20，最大50,超过50默认50.
	 **/
	private Long pageSize;
	
	/** 
	 * 出入库类型：
入库：TYPE_STOCK_IN
出库：TYPE_STOCK_OUT
	 **/
	private String type;

	public void setCrkCode(String crkCode) {
		this.crkCode = crkCode;
	}
	 public String getCrkCode() {
		return this.crkCode;
	}
	public void setCrkDateEnd(Date crkDateEnd) {
		this.crkDateEnd = crkDateEnd;
	}
	 public Date getCrkDateEnd() {
		return this.crkDateEnd;
	}
	public void setCrkDateStart(Date crkDateStart) {
		this.crkDateStart = crkDateStart;
	}
	 public Date getCrkDateStart() {
		return this.crkDateStart;
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
	public void setType(String type) {
		this.type = type;
	}
	 public String getType() {
		return this.type;
	}
	
	public String getApiMethodName() {
		return "taobao.warehouse.crk.search";
	}

	public Map<String, String> getTextParams() {		
		textParams.put("crk_code", this.crkCode);
		textParams.put("crk_date_end", this.crkDateEnd);
		textParams.put("crk_date_start", this.crkDateStart);
		textParams.put("page_no", this.pageNo);
		textParams.put("page_size", this.pageSize);
		textParams.put("type", this.type);
		return textParams;
	}
	
	public Long getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
}
