package com.taobao.api.domain;

import com.taobao.api.internal.mapping.ApiClass;
import com.taobao.api.internal.mapping.ApiField;


import com.taobao.api.TaobaoObject;

/**
 * WarehouseItem Data Structure.
 * 
 * DESC：仓储商品 
 *
 * @author auto create
 * @since 1.0, 2010-04-22 14:15:29.0
 */
@ApiClass("WarehouseItem")
public class WarehouseItem extends TaobaoObject {

	private static final long serialVersionUID = 8577554973663425276L;

	
	/** 
	 * 条形码/货号。最大长度为64个字符，一个汉字算两个字符
	 **/
	@ApiField("bar_code")
	private String barCode;

	
	/** 
	 * 商品id
	 **/
	@ApiField("item_id")
	private Long itemId;

	
	/** 
	 * 商品名称。最大长度为256字符，一个汉字算两个字符
	 **/
	@ApiField("item_name")
	private String itemName;

	
	/** 
	 * 自定义属性。最大长度为256字符，一个汉字算两个字符
	 **/
	@ApiField("memo")
	private String memo;

	
	/** 
	 * 商家编码。和卖家发布商品的商家编码保持一致，商家编码唯一，最大长度为64个字符
	 **/
	@ApiField("outer_id")
	private String outerId;

	public String getBarCode() {
		return this.barCode;
	}
	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	public Long getItemId() {
		return this.itemId;
	}
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return this.itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getMemo() {
		return this.memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getOuterId() {
		return this.outerId;
	}
	public void setOuterId(String outerId) {
		this.outerId = outerId;
	}

}
