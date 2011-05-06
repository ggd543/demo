package com.taobao.api.request;
import java.util.Date;

import java.util.Map;
import java.util.Date;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.TaobaoRequest;

/**
 * TOP API: taobao.warehouse.stockout.add request
 * 
 * @author auto create
 * @since 1.0, 2010-10-21 08:47:38.0
 */
public class WarehouseStockoutAddRequest implements TaobaoRequest {
	private Long timestamp;	
	private TaobaoHashMap textParams = new TaobaoHashMap();


	
	/** 
	 * 运输公司联系人身份证号
	 **/
	private String cardId;
	
	/** 
	 * 出库目的地
	 **/
	private String destination;
	
	/** 
	 * 预计出库时间
	 **/
	private Date exceptCrkDate;
	
	/** 
	 * 要出库的商品的商家编码，以逗号隔开，一次最多500个商品
	 **/
	private String outerIds;
	
	/** 
	 * 要出库的商品的计划出库数量，以逗号隔开，数量必须要和outer_ids字段中的outer_id数量一致，并且一一对应。
	 **/
	private String planCount;
	
	/** 
	 * 每个商品的出库备注，以逗号隔开，和outer_ids中每个outer_id对应。值全为空时可不填，若最少有一条备注，则个数必需与outer_id个数对应，用逗号隔开来表示一条记录。
	 **/
	private String remarks;
	
	/** 
	 * 商家联系人
	 **/
	private String sellerContactor;
	
	/** 
	 * 当前入库单卖家名称
	 **/
	private String sellerName;
	
	/** 
	 * 商家联系电话
	 **/
	private String sellerPhone;
	
	/** 
	 * 自定义仓库id，可从taobao.warehouse.sellerstores.get接口得到
	 **/
	private Long sellerStoreId;
	
	/** 
	 * 总箱数
	 **/
	private Long totalPackage;
	
	/** 
	 * 运输公司联系人
	 **/
	private String transportContactor;
	
	/** 
	 * 运输公司联系人联系电话
	 **/
	private String transportContactorPhone;
	
	/** 
	 * 运输公司名称
	 **/
	private String transportName;
	
	/** 
	 * 运输公司运单号
	 **/
	private String transportNo;

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	 public String getCardId() {
		return this.cardId;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	 public String getDestination() {
		return this.destination;
	}
	public void setExceptCrkDate(Date exceptCrkDate) {
		this.exceptCrkDate = exceptCrkDate;
	}
	 public Date getExceptCrkDate() {
		return this.exceptCrkDate;
	}
	public void setOuterIds(String outerIds) {
		this.outerIds = outerIds;
	}
	 public String getOuterIds() {
		return this.outerIds;
	}
	public void setPlanCount(String planCount) {
		this.planCount = planCount;
	}
	 public String getPlanCount() {
		return this.planCount;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	 public String getRemarks() {
		return this.remarks;
	}
	public void setSellerContactor(String sellerContactor) {
		this.sellerContactor = sellerContactor;
	}
	 public String getSellerContactor() {
		return this.sellerContactor;
	}
	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}
	 public String getSellerName() {
		return this.sellerName;
	}
	public void setSellerPhone(String sellerPhone) {
		this.sellerPhone = sellerPhone;
	}
	 public String getSellerPhone() {
		return this.sellerPhone;
	}
	public void setSellerStoreId(Long sellerStoreId) {
		this.sellerStoreId = sellerStoreId;
	}
	 public Long getSellerStoreId() {
		return this.sellerStoreId;
	}
	public void setTotalPackage(Long totalPackage) {
		this.totalPackage = totalPackage;
	}
	 public Long getTotalPackage() {
		return this.totalPackage;
	}
	public void setTransportContactor(String transportContactor) {
		this.transportContactor = transportContactor;
	}
	 public String getTransportContactor() {
		return this.transportContactor;
	}
	public void setTransportContactorPhone(String transportContactorPhone) {
		this.transportContactorPhone = transportContactorPhone;
	}
	 public String getTransportContactorPhone() {
		return this.transportContactorPhone;
	}
	public void setTransportName(String transportName) {
		this.transportName = transportName;
	}
	 public String getTransportName() {
		return this.transportName;
	}
	public void setTransportNo(String transportNo) {
		this.transportNo = transportNo;
	}
	 public String getTransportNo() {
		return this.transportNo;
	}
	
	public String getApiMethodName() {
		return "taobao.warehouse.stockout.add";
	}

	public Map<String, String> getTextParams() {		
		textParams.put("card_id", this.cardId);
		textParams.put("destination", this.destination);
		textParams.put("except_crk_date", this.exceptCrkDate);
		textParams.put("outer_ids", this.outerIds);
		textParams.put("plan_count", this.planCount);
		textParams.put("remarks", this.remarks);
		textParams.put("seller_contactor", this.sellerContactor);
		textParams.put("seller_name", this.sellerName);
		textParams.put("seller_phone", this.sellerPhone);
		textParams.put("seller_store_id", this.sellerStoreId);
		textParams.put("total_package", this.totalPackage);
		textParams.put("transport_contactor", this.transportContactor);
		textParams.put("transport_contactor_phone", this.transportContactorPhone);
		textParams.put("transport_name", this.transportName);
		textParams.put("transport_no", this.transportNo);
		return textParams;
	}
	
	public Long getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
}
