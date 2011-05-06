package com.taobao.api.domain;

import java.util.Date;
import com.taobao.api.internal.mapping.ApiClass;
import com.taobao.api.internal.mapping.ApiField;


import com.taobao.api.TaobaoObject;

/**
 * SubPurchaseOrder Data Structure.
 * 
 * DESC：子采购单详细信息 
 *
 * @author auto create
 * @since 1.0, 2010-10-28 15:40:11.0
 */
@ApiClass("SubPurchaseOrder")
public class SubPurchaseOrder extends TaobaoObject {

	private static final long serialVersionUID = 7389874361977223961L;

	
	/** 
	 * 买家实付金额。（精确到2位小数;单位:元。如:200.07，表示:200元7分）
	 **/
	@ApiField("buyer_payment")
	private String buyerPayment;

	
	/** 
	 * 创建时间。格式 yyyy-MM-dd HH:mm:ss 。
	 **/
	@ApiField("created")
	private Date created;

	
	/** 
	 * 分销商实付金额。（精确到2位小数;单位:元。如:200.07，表示:200元7分）
	 **/
	@ApiField("distributor_payment")
	private String distributorPayment;

	
	/** 
	 * 子采购单id。
	 **/
	@ApiField("id")
	private Long id;

	
	/** 
	 * 分销平台上商品id
	 **/
	@ApiField("item_id")
	private Long itemId;

	
	/** 
	 * 分销平台上商品商家编码。
	 **/
	@ApiField("item_outer_id")
	private String itemOuterId;

	
	/** 
	 * 商品购买数量。取值范围:大于零的整数
	 **/
	@ApiField("num")
	private Long num;

	
	/** 
	 * 单个商品价格。（精确到2位小数;单位:元。如:200.07，表示:200元7分）
	 **/
	@ApiField("price")
	private String price;

	
	/** 
	 * 商品的SKU id。
	 **/
	@ApiField("sku_id")
	private Long skuId;

	
	/** 
	 * SKU商家编码。
	 **/
	@ApiField("sku_outer_id")
	private String skuOuterId;

	
	/** 
	 * SKU属性值。如: 颜色:红色:别名;尺码:L:别名
	 **/
	@ApiField("sku_properties")
	private String skuProperties;

	
	/** 
	 * 快照地址。
	 **/
	@ApiField("snapshot_url")
	private String snapshotUrl;

	
	/** 
	 * 交易状态
	 **/
	@ApiField("status")
	private String status;

	
	/** 
	 * 商品标题。
	 **/
	@ApiField("title")
	private String title;

	
	/** 
	 * 分销商应付金额。（精确到2位小数;单位:元。如:200.07，表示:200元7分）
	 **/
	@ApiField("total_fee")
	private String totalFee;

	public String getBuyerPayment() {
		return this.buyerPayment;
	}
	public void setBuyerPayment(String buyerPayment) {
		this.buyerPayment = buyerPayment;
	}

	public Date getCreated() {
		return this.created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}

	public String getDistributorPayment() {
		return this.distributorPayment;
	}
	public void setDistributorPayment(String distributorPayment) {
		this.distributorPayment = distributorPayment;
	}

	public Long getId() {
		return this.id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public Long getItemId() {
		return this.itemId;
	}
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public String getItemOuterId() {
		return this.itemOuterId;
	}
	public void setItemOuterId(String itemOuterId) {
		this.itemOuterId = itemOuterId;
	}

	public Long getNum() {
		return this.num;
	}
	public void setNum(Long num) {
		this.num = num;
	}

	public String getPrice() {
		return this.price;
	}
	public void setPrice(String price) {
		this.price = price;
	}

	public Long getSkuId() {
		return this.skuId;
	}
	public void setSkuId(Long skuId) {
		this.skuId = skuId;
	}

	public String getSkuOuterId() {
		return this.skuOuterId;
	}
	public void setSkuOuterId(String skuOuterId) {
		this.skuOuterId = skuOuterId;
	}

	public String getSkuProperties() {
		return this.skuProperties;
	}
	public void setSkuProperties(String skuProperties) {
		this.skuProperties = skuProperties;
	}

	public String getSnapshotUrl() {
		return this.snapshotUrl;
	}
	public void setSnapshotUrl(String snapshotUrl) {
		this.snapshotUrl = snapshotUrl;
	}

	public String getStatus() {
		return this.status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public String getTitle() {
		return this.title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public String getTotalFee() {
		return this.totalFee;
	}
	public void setTotalFee(String totalFee) {
		this.totalFee = totalFee;
	}

}
