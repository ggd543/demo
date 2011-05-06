package com.taobao.api.request;

import java.util.Map;
import java.util.Date;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.TaobaoRequest;

/**
 * TOP API: taobao.item.sku.add request
 * 
 * @author auto create
 * @since 1.0, 2010-11-12 10:28:37.0
 */
public class ItemSkuAddRequest implements TaobaoRequest {
	private Long timestamp;	
	private TaobaoHashMap textParams = new TaobaoHashMap();


	
	/** 
	 * sku所属商品的价格。当用户新增sku，使商品价格不属于sku价格之间的时候，用于修改商品的价格，使sku能够添加成功
	 **/
	private String itemPrice;
	
	/** 
	 * Sku文字的版本。可选值:zh_HK(繁体),zh_CN(简体);默认值:zh_CN
	 **/
	private String lang;
	
	/** 
	 * Sku所属商品数字id，可通过 taobao.item.get 获取。必选
	 **/
	private Long numIid;
	
	/** 
	 * Sku的商家外部id
	 **/
	private String outerId;
	
	/** 
	 * Sku的销售价格。商品的价格要在商品所有的sku的价格之间。精确到2位小数;单位:元。如:200.07，表示:200元7分
	 **/
	private String price;
	
	/** 
	 * Sku属性串。格式:pid:vid;pid:vid,如:1627207:3232483;1630696:3284570,表示:机身颜色:军绿色;手机套餐:一电一充
	 **/
	private String properties;
	
	/** 
	 * Sku的库存数量。sku的总数量应该小于等于商品总数量(Item的NUM)。取值范围:大于零的整数
	 **/
	private Long quantity;

	public void setItemPrice(String itemPrice) {
		this.itemPrice = itemPrice;
	}
	 public String getItemPrice() {
		return this.itemPrice;
	}
	public void setLang(String lang) {
		this.lang = lang;
	}
	 public String getLang() {
		return this.lang;
	}
	public void setNumIid(Long numIid) {
		this.numIid = numIid;
	}
	 public Long getNumIid() {
		return this.numIid;
	}
	public void setOuterId(String outerId) {
		this.outerId = outerId;
	}
	 public String getOuterId() {
		return this.outerId;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	 public String getPrice() {
		return this.price;
	}
	public void setProperties(String properties) {
		this.properties = properties;
	}
	 public String getProperties() {
		return this.properties;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	 public Long getQuantity() {
		return this.quantity;
	}
	
	public String getApiMethodName() {
		return "taobao.item.sku.add";
	}

	public Map<String, String> getTextParams() {		
		textParams.put("item_price", this.itemPrice);
		textParams.put("lang", this.lang);
		textParams.put("num_iid", this.numIid);
		textParams.put("outer_id", this.outerId);
		textParams.put("price", this.price);
		textParams.put("properties", this.properties);
		textParams.put("quantity", this.quantity);
		return textParams;
	}
	
	public Long getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
}
