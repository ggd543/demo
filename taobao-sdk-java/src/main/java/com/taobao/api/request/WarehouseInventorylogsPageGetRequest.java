package com.taobao.api.request;
import java.util.Date;

import java.util.Map;
import java.util.Date;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.TaobaoRequest;

/**
 * TOP API: taobao.warehouse.inventorylogs.page.get request
 * 
 * @author auto create
 * @since 1.0, 2010-10-21 08:49:08.0
 */
public class WarehouseInventorylogsPageGetRequest implements TaobaoRequest {
	private Long timestamp;	
	private TaobaoHashMap textParams = new TaobaoHashMap();


	
	/** 
	 * 查询结束时间
	 **/
	private Date gmtcreateEnd;
	
	/** 
	 * 查询开始时间
	 **/
	private Date gmtcreateStart;
	
	/** 
	 * 分页参数,当前页码,默认为1
	 **/
	private String pageNo;
	
	/** 
	 * 分页参数,每页所包含的记录条数,正整数，默认20，最大50超过50默认50
	 **/
	private String pageSize;
	
	/** 
	 * 库存变更状态PUT_IN_STOCK(入库),STOCK_TRANSFER(出库) ，STOCKTAKING（盘点）,SELL（正常销售）
	 **/
	private String reason;
	
	/** 
	 * 自定义仓库id 可以根据taobao.warehouse.sellerstores.get接口得到
	 **/
	private String sellerStoreId;
	
	/** 
	 * 库存变更状态UNCONFIRMED(待确认),CONFIRMED(已确认)
	 **/
	private String status;

	public void setGmtcreateEnd(Date gmtcreateEnd) {
		this.gmtcreateEnd = gmtcreateEnd;
	}
	 public Date getGmtcreateEnd() {
		return this.gmtcreateEnd;
	}
	public void setGmtcreateStart(Date gmtcreateStart) {
		this.gmtcreateStart = gmtcreateStart;
	}
	 public Date getGmtcreateStart() {
		return this.gmtcreateStart;
	}
	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}
	 public String getPageNo() {
		return this.pageNo;
	}
	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}
	 public String getPageSize() {
		return this.pageSize;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	 public String getReason() {
		return this.reason;
	}
	public void setSellerStoreId(String sellerStoreId) {
		this.sellerStoreId = sellerStoreId;
	}
	 public String getSellerStoreId() {
		return this.sellerStoreId;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	 public String getStatus() {
		return this.status;
	}
	
	public String getApiMethodName() {
		return "taobao.warehouse.inventorylogs.page.get";
	}

	public Map<String, String> getTextParams() {		
		textParams.put("gmtcreate_end", this.gmtcreateEnd);
		textParams.put("gmtcreate_start", this.gmtcreateStart);
		textParams.put("page_no", this.pageNo);
		textParams.put("page_size", this.pageSize);
		textParams.put("reason", this.reason);
		textParams.put("seller_store_id", this.sellerStoreId);
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
