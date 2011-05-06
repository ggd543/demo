package com.taobao.api.request;
import java.util.Date;

import java.util.Map;
import java.util.Date;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.TaobaoRequest;

/**
 * TOP API: taobao.fenxiao.orders.get request
 * 
 * @author auto create
 * @since 1.0, 2010-08-10 11:56:33.0
 */
public class FenxiaoOrdersGetRequest implements TaobaoRequest {
	private Long timestamp;	
	private TaobaoHashMap textParams = new TaobaoHashMap();


	
	/** 
	 * 结束时间 格式 yyyy-MM-dd 起始时间与结束时间跨度为7天 。
	 **/
	private Date endCreated;
	
	/** 
	 * 页码。（大于0的整数。默认为1）
	 **/
	private Long pageNo;
	
	/** 
	 * 每页条数。（每页条数不超过50条）
	 **/
	private Long pageSize;
	
	/** 
	 * 采购单编号
	 **/
	private Long purchaseOrderId;
	
	/** 
	 * 起始时间 格式 yyyy-MM-dd。
	 **/
	private Date startCreated;
	
	/** 
	 * 交易状态，不传默认查询所有采购单。可选值:

    * WAIT_BUYER_PAY(等待买家付款)
    * WAIT_SELLER_SEND_GOODS(等待卖家发货,即:买家已付款)
    * WAIT_BUYER_CONFIRM_GOODS(等待买家确认收货,即:卖家已发货)
    * TRADE_FINISHED(交易成功)
    * TRADE_CLOSED(交易关闭)
	 **/
	private String status;
	
	/** 
	 * 可选值：trade_time_type(采购单按照成交时间范围查询),update_time_type(采购单按照更新时间范围查询)
	 **/
	private String timeType;

	public void setEndCreated(Date endCreated) {
		this.endCreated = endCreated;
	}
	 public Date getEndCreated() {
		return this.endCreated;
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
	public void setPurchaseOrderId(Long purchaseOrderId) {
		this.purchaseOrderId = purchaseOrderId;
	}
	 public Long getPurchaseOrderId() {
		return this.purchaseOrderId;
	}
	public void setStartCreated(Date startCreated) {
		this.startCreated = startCreated;
	}
	 public Date getStartCreated() {
		return this.startCreated;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	 public String getStatus() {
		return this.status;
	}
	public void setTimeType(String timeType) {
		this.timeType = timeType;
	}
	 public String getTimeType() {
		return this.timeType;
	}
	
	public String getApiMethodName() {
		return "taobao.fenxiao.orders.get";
	}

	public Map<String, String> getTextParams() {		
		textParams.put("end_created", this.endCreated);
		textParams.put("page_no", this.pageNo);
		textParams.put("page_size", this.pageSize);
		textParams.put("purchase_order_id", this.purchaseOrderId);
		textParams.put("start_created", this.startCreated);
		textParams.put("status", this.status);
		textParams.put("time_type", this.timeType);
		return textParams;
	}
	
	public Long getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
}
