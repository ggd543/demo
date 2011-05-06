package com.taobao.api.domain;

import com.taobao.api.internal.mapping.ApiClass;
import com.taobao.api.internal.mapping.ApiField;


import com.taobao.api.TaobaoObject;

/**
 * Inventory Data Structure.
 * 
 * DESC：仓储库存信息 
 *
 * @author auto create
 * @since 1.0, 2010-08-23 20:54:15.0
 */
@ApiClass("Inventory")
public class Inventory extends TaobaoObject {

	private static final long serialVersionUID = 7685838315388514291L;

	
	/** 
	 * 仓库商品ID，同item_id，目前只有taobao.warehouse.items.page.get返回的是auction_id
	 **/
	@ApiField("auction_id")
	private Long auctionId;

	
	/** 
	 * 库存ID
	 **/
	@ApiField("id")
	private Long id;

	
	/** 
	 * 仓储商品ID
	 **/
	@ApiField("item_id")
	private Long itemId;

	
	/** 
	 * 库存废品数量
	 **/
	@ApiField("junk_count")
	private Long junkCount;

	
	/** 
	 * 商家编码

卖家用来识别淘宝店铺与外部网店之间产品、商品一致性的自定义编码方式，
业务场景如卖家通过此商家编码定时把外部网店的商品销售数量更新到淘宝店铺。
	 **/
	@ApiField("outer_id")
	private String outerId;

	
	/** 
	 * 可销售库存数量
	 **/
	@ApiField("sell_count")
	private Long sellCount;

	
	/** 
	 * 商家标识
	 **/
	@ApiField("seller_code")
	private String sellerCode;

	
	/** 
	 * 自定义仓库标识
	 **/
	@ApiField("seller_store_id")
	private Long sellerStoreId;

	
	/** 
	 * 状态: 数字1代表ASYNCHRONISM(未同步) 数字2代表SYCHRONISM(同步) 数字3代表DELETED(删除)
	 **/
	@ApiField("status")
	private Long status;

	
	/** 
	 * 外部仓库编码
	 **/
	@ApiField("store_code")
	private String storeCode;

	
	/** 
	 * 总库存数量
	 **/
	@ApiField("total_count")
	private Long totalCount;

	
	/** 
	 * 库存警戒值
	 **/
	@ApiField("warn_line")
	private Long warnLine;

	public Long getAuctionId() {
		return this.auctionId;
	}
	public void setAuctionId(Long auctionId) {
		this.auctionId = auctionId;
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

	public Long getSellCount() {
		return this.sellCount;
	}
	public void setSellCount(Long sellCount) {
		this.sellCount = sellCount;
	}

	public String getSellerCode() {
		return this.sellerCode;
	}
	public void setSellerCode(String sellerCode) {
		this.sellerCode = sellerCode;
	}

	public Long getSellerStoreId() {
		return this.sellerStoreId;
	}
	public void setSellerStoreId(Long sellerStoreId) {
		this.sellerStoreId = sellerStoreId;
	}

	public Long getStatus() {
		return this.status;
	}
	public void setStatus(Long status) {
		this.status = status;
	}

	public String getStoreCode() {
		return this.storeCode;
	}
	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}

	public Long getTotalCount() {
		return this.totalCount;
	}
	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}

	public Long getWarnLine() {
		return this.warnLine;
	}
	public void setWarnLine(Long warnLine) {
		this.warnLine = warnLine;
	}

}
