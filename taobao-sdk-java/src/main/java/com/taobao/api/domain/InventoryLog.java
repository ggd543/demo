package com.taobao.api.domain;

import com.taobao.api.internal.mapping.ApiClass;
import com.taobao.api.internal.mapping.ApiField;


import com.taobao.api.TaobaoObject;

/**
 * InventoryLog Data Structure.
 * 
 * DESC：仓储库存变更结构 
 *
 * @author auto create
 * @since 1.0, 2010-12-01 15:04:14.0
 */
@ApiClass("InventoryLog")
public class InventoryLog extends TaobaoObject {

	private static final long serialVersionUID = 3863426379139651939L;

	
	/** 
	 * 变更正品数量
	 **/
	@ApiField("change_count")
	private Long changeCount;

	
	/** 
	 * 商品出入库标识PUT_IN(入库),OUT(出库)
	 **/
	@ApiField("flag")
	private String flag;

	
	/** 
	 * 库存id
	 **/
	@ApiField("inventory_id")
	private String inventoryId;

	
	/** 
	 * 库存变更记录id
	 **/
	@ApiField("inventory_log_id")
	private String inventoryLogId;

	
	/** 
	 * 商品id
	 **/
	@ApiField("item_id")
	private String itemId;

	
	/** 
	 * 变更废品数量
	 **/
	@ApiField("junk_count")
	private Long junkCount;

	
	/** 
	 * 商家编码
	 **/
	@ApiField("outer_id")
	private String outerId;

	
	/** 
	 * 库存变更原因PUT_IN_STOCK(入库),STOCK_TRANSFER(出库),STOCKTAKING(盘点),SELL(正常销售)
	 **/
	@ApiField("reason")
	private String reason;

	
	/** 
	 * 自定义仓库id
	 **/
	@ApiField("seller_store_id")
	private String sellerStoreId;

	
	/** 
	 * 库存变更状态UNCONFIRMED(待确认),CONFIRMED(已确认)
	 **/
	@ApiField("status")
	private String status;

	public Long getChangeCount() {
		return this.changeCount;
	}
	public void setChangeCount(Long changeCount) {
		this.changeCount = changeCount;
	}

	public String getFlag() {
		return this.flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getInventoryId() {
		return this.inventoryId;
	}
	public void setInventoryId(String inventoryId) {
		this.inventoryId = inventoryId;
	}

	public String getInventoryLogId() {
		return this.inventoryLogId;
	}
	public void setInventoryLogId(String inventoryLogId) {
		this.inventoryLogId = inventoryLogId;
	}

	public String getItemId() {
		return this.itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public Long getJunkCount() {
		return this.junkCount;
	}
	public void setJunkCount(Long junkCount) {
		this.junkCount = junkCount;
	}

	public String getOuterId() {
		return this.outerId;
	}
	public void setOuterId(String outerId) {
		this.outerId = outerId;
	}

	public String getReason() {
		return this.reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getSellerStoreId() {
		return this.sellerStoreId;
	}
	public void setSellerStoreId(String sellerStoreId) {
		this.sellerStoreId = sellerStoreId;
	}

	public String getStatus() {
		return this.status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}
