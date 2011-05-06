package com.taobao.api.domain;

import java.util.Date;
import com.taobao.api.internal.mapping.ApiClass;
import com.taobao.api.internal.mapping.ApiField;


import com.taobao.api.TaobaoObject;

/**
 * SkuExtra Data Structure.
 * 
 * DESC：Sku扩展表的扩展sku记录 
 *
 * @author auto create
 * @since 1.0, 2010-04-21 15:52:25.0
 */
@ApiClass("SkuExtra")
public class SkuExtra extends TaobaoObject {

	private static final long serialVersionUID = 2473223868299177995L;

	
	/** 
	 * sku创建日期
	 **/
	@ApiField("created")
	private Date created;

	
	/** 
	 * 主键
	 **/
	@ApiField("extra_id")
	private Long extraId;

	
	/** 
	 * 备注，不能大于1000个字节
	 **/
	@ApiField("memo")
	private String memo;

	
	/** 
	 * sku最后修改日期
	 **/
	@ApiField("modified")
	private Date modified;

	
	/** 
	 * 属于这个sku的商品的价格 取值范围:0-100000000;精确到2位小数;单位:元。如:200.07，表示:200元7分。
	 **/
	@ApiField("price")
	private String price;

	
	/** 
	 * sku的销售属性组合字符串（颜色，大小，等等）,调用taobao.itemprops.get获取类目属性，如果属性是颜色属性，再用taobao.itempropvalues.get取得vid。格式:pid:vid;pid:vid。
	 **/
	@ApiField("properties")
	private String properties;

	
	/** 
	 * 属于这个sku的商品的数量,取值范围大于0的整数
	 **/
	@ApiField("quantity")
	private Long quantity;

	
	/** 
	 * 扩展sku的id
	 **/
	@ApiField("sku_id")
	private Long skuId;

	public Date getCreated() {
		return this.created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}

	public Long getExtraId() {
		return this.extraId;
	}
	public void setExtraId(Long extraId) {
		this.extraId = extraId;
	}

	public String getMemo() {
		return this.memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}

	public Date getModified() {
		return this.modified;
	}
	public void setModified(Date modified) {
		this.modified = modified;
	}

	public String getPrice() {
		return this.price;
	}
	public void setPrice(String price) {
		this.price = price;
	}

	public String getProperties() {
		return this.properties;
	}
	public void setProperties(String properties) {
		this.properties = properties;
	}

	public Long getQuantity() {
		return this.quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Long getSkuId() {
		return this.skuId;
	}
	public void setSkuId(Long skuId) {
		this.skuId = skuId;
	}

}
