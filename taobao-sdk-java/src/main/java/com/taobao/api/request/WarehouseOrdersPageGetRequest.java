package com.taobao.api.request;
import java.util.Date;

import java.util.Map;
import java.util.Date;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.TaobaoRequest;

/**
 * TOP API: taobao.warehouse.orders.page.get request
 * 
 * @author auto create
 * @since 1.0, 2010-10-21 08:45:01.0
 */
public class WarehouseOrdersPageGetRequest implements TaobaoRequest {
	private Long timestamp;	
	private TaobaoHashMap textParams = new TaobaoHashMap();


	
	/** 
	 * 物流公司ID
	 **/
	private Long companyId;
	
	/** 
	 * 订单创建结束时间
	 **/
	private Date gmtcreateEnd;
	
	/** 
	 * 订单创建开始时间
	 **/
	private Date gmtcreateStart;
	
	/** 
	 * 物流订单状态TO_BE_SENT（待处理）SIGN_IN（已签收）REJECTED_BY_OTHER_SIDE(签收失败)
	 **/
	private String orderStatus;
	
	/** 
	 * 运单号
	 **/
	private String outSid;
	
	/** 
	 * 当前页 (默认为1)
	 **/
	private Long pageNo;
	
	/** 
	 * 分页参数,每页所包含的记录条数,正整数，默认20，最大50超过50默认50
	 **/
	private Long pageSize;
	
	/** 
	 * 收货人名字
	 **/
	private String receiverName;
	
	/** 
	 * 自定义仓库ID
	 **/
	private String sellerStoreId;
	
	/** 
	 * 淘宝交易号
	 **/
	private Long tid;

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
	 public Long getCompanyId() {
		return this.companyId;
	}
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
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	 public String getOrderStatus() {
		return this.orderStatus;
	}
	public void setOutSid(String outSid) {
		this.outSid = outSid;
	}
	 public String getOutSid() {
		return this.outSid;
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
	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}
	 public String getReceiverName() {
		return this.receiverName;
	}
	public void setSellerStoreId(String sellerStoreId) {
		this.sellerStoreId = sellerStoreId;
	}
	 public String getSellerStoreId() {
		return this.sellerStoreId;
	}
	public void setTid(Long tid) {
		this.tid = tid;
	}
	 public Long getTid() {
		return this.tid;
	}
	
	public String getApiMethodName() {
		return "taobao.warehouse.orders.page.get";
	}

	public Map<String, String> getTextParams() {		
		textParams.put("company_id", this.companyId);
		textParams.put("gmtcreate_end", this.gmtcreateEnd);
		textParams.put("gmtcreate_start", this.gmtcreateStart);
		textParams.put("order_status", this.orderStatus);
		textParams.put("out_sid", this.outSid);
		textParams.put("page_no", this.pageNo);
		textParams.put("page_size", this.pageSize);
		textParams.put("receiver_name", this.receiverName);
		textParams.put("seller_store_id", this.sellerStoreId);
		textParams.put("tid", this.tid);
		return textParams;
	}
	
	public Long getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
}
