package com.taobao.api.request;

import java.util.Map;
import java.util.Date;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.TaobaoRequest;

/**
 * TOP API: taobao.warehouse.storebill.page.get request
 * 
 * @author auto create
 * @since 1.0, 2010-10-21 08:43:51.0
 */
public class WarehouseStorebillPageGetRequest implements TaobaoRequest {
	private Long timestamp;	
	private TaobaoHashMap textParams = new TaobaoHashMap();


	
	/** 
	 * 结束月份,格式为年+月,如:201001
	 **/
	private Long monthEnd;
	
	/** 
	 * 起始月份,格式为年+月,如:200912
	 **/
	private Long monthStart;
	
	/** 
	 * 当前页，正整数,默认为1.
	 **/
	private Long pageNo;
	
	/** 
	 * 分页记录个数，正整数,默认为20条,最多为50条，如果用户输入的记录数大于50，则一页显示50条记录
	 **/
	private Long pageSize;
	
	/** 
	 * 自定义仓库id,可以从接口taobao.warehouse.sellerstores.get中得到
	 **/
	private Long sellerStoreId;

	public void setMonthEnd(Long monthEnd) {
		this.monthEnd = monthEnd;
	}
	 public Long getMonthEnd() {
		return this.monthEnd;
	}
	public void setMonthStart(Long monthStart) {
		this.monthStart = monthStart;
	}
	 public Long getMonthStart() {
		return this.monthStart;
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
	public void setSellerStoreId(Long sellerStoreId) {
		this.sellerStoreId = sellerStoreId;
	}
	 public Long getSellerStoreId() {
		return this.sellerStoreId;
	}
	
	public String getApiMethodName() {
		return "taobao.warehouse.storebill.page.get";
	}

	public Map<String, String> getTextParams() {		
		textParams.put("month_end", this.monthEnd);
		textParams.put("month_start", this.monthStart);
		textParams.put("page_no", this.pageNo);
		textParams.put("page_size", this.pageSize);
		textParams.put("seller_store_id", this.sellerStoreId);
		return textParams;
	}
	
	public Long getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
}
