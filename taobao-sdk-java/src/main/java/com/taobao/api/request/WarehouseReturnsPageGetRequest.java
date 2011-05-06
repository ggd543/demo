package com.taobao.api.request;
import java.util.Date;

import java.util.Map;
import java.util.Date;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.TaobaoRequest;

/**
 * TOP API: taobao.warehouse.returns.page.get request
 * 
 * @author auto create
 * @since 1.0, 2010-12-01 15:52:13.0
 */
public class WarehouseReturnsPageGetRequest implements TaobaoRequest {
	private Long timestamp;	
	private TaobaoHashMap textParams = new TaobaoHashMap();


	
	/** 
	 * 退货单号
	 **/
	private String crkCode;
	
	/** 
	 * 原物流订单号
	 **/
	private String orderCode;
	
	/** 
	 * 当前页(默认为1)
	 **/
	private Long pageNo;
	
	/** 
	 * 分页参数,每页所包含的记录条数,正整数，默认20，最大50,超过50默认50.
	 **/
	private Long pageSize;
	
	/** 
	 * 结束退货时间,查出当前时间之前的所有记录数
	 **/
	private Date returnDateEnd;
	
	/** 
	 * 起始退货时间，查出从当前时间起的所有记录
	 **/
	private Date returnDateStart;
	
	/** 
	 * 配送中心
	 **/
	private Long sellerStoreId;
	
	/** 
	 * 原订单编号
	 **/
	private Long taobaoTradeId;

	public void setCrkCode(String crkCode) {
		this.crkCode = crkCode;
	}
	 public String getCrkCode() {
		return this.crkCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	 public String getOrderCode() {
		return this.orderCode;
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
	public void setReturnDateEnd(Date returnDateEnd) {
		this.returnDateEnd = returnDateEnd;
	}
	 public Date getReturnDateEnd() {
		return this.returnDateEnd;
	}
	public void setReturnDateStart(Date returnDateStart) {
		this.returnDateStart = returnDateStart;
	}
	 public Date getReturnDateStart() {
		return this.returnDateStart;
	}
	public void setSellerStoreId(Long sellerStoreId) {
		this.sellerStoreId = sellerStoreId;
	}
	 public Long getSellerStoreId() {
		return this.sellerStoreId;
	}
	public void setTaobaoTradeId(Long taobaoTradeId) {
		this.taobaoTradeId = taobaoTradeId;
	}
	 public Long getTaobaoTradeId() {
		return this.taobaoTradeId;
	}
	
	public String getApiMethodName() {
		return "taobao.warehouse.returns.page.get";
	}

	public Map<String, String> getTextParams() {		
		textParams.put("crk_code", this.crkCode);
		textParams.put("order_code", this.orderCode);
		textParams.put("page_no", this.pageNo);
		textParams.put("page_size", this.pageSize);
		textParams.put("return_date_end", this.returnDateEnd);
		textParams.put("return_date_start", this.returnDateStart);
		textParams.put("seller_store_id", this.sellerStoreId);
		textParams.put("taobao_trade_id", this.taobaoTradeId);
		return textParams;
	}
	
	public Long getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
}
