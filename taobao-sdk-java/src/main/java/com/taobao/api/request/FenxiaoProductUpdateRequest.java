package com.taobao.api.request;

import java.util.Map;
import java.util.Date;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.TaobaoRequest;

/**
 * TOP API: taobao.fenxiao.product.update request
 * 
 * @author auto create
 * @since 1.0, 2010-08-04 18:40:51.0
 */
public class FenxiaoProductUpdateRequest implements TaobaoRequest {
	private Long timestamp;	
	private TaobaoHashMap textParams = new TaobaoHashMap();


	
	/** 
	 * 警戒库存，不能大于等于产品库存，必须0到30000。
	 **/
	private Long alarmNumber;
	
	/** 
	 * 商品类目ID
	 **/
	private Long categoryId;
	
	/** 
	 * 所在地：市，例：“杭州”
	 **/
	private String city;
	
	/** 
	 * 采购价格，单位：元。例：“10.56”。必须在0.01元到10000000元之间。
	 **/
	private String costPrice;
	
	/** 
	 * 产品描述，长度为5到25000字符。
	 **/
	private String desc;
	
	/** 
	 * 是否有保修，可选值：false（否）、true（是），默认false。
	 **/
	private String haveGuarantee;
	
	/** 
	 * 是否有发票，可选值：false（否）、true（是），默认false。
	 **/
	private String haveInvoice;
	
	/** 
	 * 产品名称，长度不超过60个字节。
	 **/
	private String name;
	
	/** 
	 * 商家编码，长度不能超过60个字节。
	 **/
	private String outerId;
	
	/** 
	 * 产品ID
	 **/
	private Long pid;
	
	/** 
	 * ems费用，单位：元。例：“10.56”。大小为0.01元到1000000元之间。更新时必须指定运费类型为buyer，否则不更新。
	 **/
	private String postageEms;
	
	/** 
	 * 快递费用，单位：元。例：“10.56”。大小为0.01元到1000000元之间。更新时必须指定运费类型为buyer，否则不更新。
	 **/
	private String postageFast;
	
	/** 
	 * 运费模板ID，参考taobao.postages.get。更新时必须指定运费类型为 buyer，否则不更新。
	 **/
	private Long postageId;
	
	/** 
	 * 平邮费用，单位：元。例：“10.56”。大小为0.01元到1000000元之间。更新时必须指定运费类型为buyer，否则不更新。
	 **/
	private String postageOrdinary;
	
	/** 
	 * 运费类型，可选值：seller（供应商承担运费）、buyer（分销商承担运费），默认seller。
	 **/
	private String postageType;
	
	/** 
	 * 产品线ID
	 **/
	private Long productcatId;
	
	/** 
	 * 所在地：省，例：“浙江”
	 **/
	private String prov;
	
	/** 
	 * 产品库存，不能小于等于库存警戒值，必须1到10000000。
	 **/
	private Long quantity;
	
	/** 
	 * 最高零售价，单位：元。例：“10.56”。必须在0.01元到10000000元之间，最高零售价必须大于最低零售价。
	 **/
	private String retailPriceHigh;
	
	/** 
	 * 最低零售价，单位：元。例：“10.56”。必须在0.01元到10000000元之间。
	 **/
	private String retailPriceLow;
	
	/** 
	 * sku采购价格，单位元，例："10.50,11.00,20.50"，字段必须和上面的sku_ids保持一致。
	 **/
	private String skuCostPrices;
	
	/** 
	 * sku id列表，例：1001,1002,1003
	 **/
	private String skuIds;
	
	/** 
	 * sku商家编码 ，单位元，例："S1000,S1002,S1003"，字段必须和上面的id保持一致，如果没有可以写成",,"
	 **/
	private String skuOuterIds;
	
	/** 
	 * sku库存，单位元，例："10,20,30"，字段必须和sku_ids保持一致。
	 **/
	private String skuQuantitys;
	
	/** 
	 * 标准价格，单位：元。例：“10.56”。必须在0.01元到10000000元之间。
	 **/
	private String standardPrice;
	
	/** 
	 * 发布状态，可选值：up（上架）、down（下架）、delete（删除），输入非法字符则忽略。
	 **/
	private String status;

	public void setAlarmNumber(Long alarmNumber) {
		this.alarmNumber = alarmNumber;
	}
	 public Long getAlarmNumber() {
		return this.alarmNumber;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	 public Long getCategoryId() {
		return this.categoryId;
	}
	public void setCity(String city) {
		this.city = city;
	}
	 public String getCity() {
		return this.city;
	}
	public void setCostPrice(String costPrice) {
		this.costPrice = costPrice;
	}
	 public String getCostPrice() {
		return this.costPrice;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	 public String getDesc() {
		return this.desc;
	}
	public void setHaveGuarantee(String haveGuarantee) {
		this.haveGuarantee = haveGuarantee;
	}
	 public String getHaveGuarantee() {
		return this.haveGuarantee;
	}
	public void setHaveInvoice(String haveInvoice) {
		this.haveInvoice = haveInvoice;
	}
	 public String getHaveInvoice() {
		return this.haveInvoice;
	}
	public void setName(String name) {
		this.name = name;
	}
	 public String getName() {
		return this.name;
	}
	public void setOuterId(String outerId) {
		this.outerId = outerId;
	}
	 public String getOuterId() {
		return this.outerId;
	}
	public void setPid(Long pid) {
		this.pid = pid;
	}
	 public Long getPid() {
		return this.pid;
	}
	public void setPostageEms(String postageEms) {
		this.postageEms = postageEms;
	}
	 public String getPostageEms() {
		return this.postageEms;
	}
	public void setPostageFast(String postageFast) {
		this.postageFast = postageFast;
	}
	 public String getPostageFast() {
		return this.postageFast;
	}
	public void setPostageId(Long postageId) {
		this.postageId = postageId;
	}
	 public Long getPostageId() {
		return this.postageId;
	}
	public void setPostageOrdinary(String postageOrdinary) {
		this.postageOrdinary = postageOrdinary;
	}
	 public String getPostageOrdinary() {
		return this.postageOrdinary;
	}
	public void setPostageType(String postageType) {
		this.postageType = postageType;
	}
	 public String getPostageType() {
		return this.postageType;
	}
	public void setProductcatId(Long productcatId) {
		this.productcatId = productcatId;
	}
	 public Long getProductcatId() {
		return this.productcatId;
	}
	public void setProv(String prov) {
		this.prov = prov;
	}
	 public String getProv() {
		return this.prov;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	 public Long getQuantity() {
		return this.quantity;
	}
	public void setRetailPriceHigh(String retailPriceHigh) {
		this.retailPriceHigh = retailPriceHigh;
	}
	 public String getRetailPriceHigh() {
		return this.retailPriceHigh;
	}
	public void setRetailPriceLow(String retailPriceLow) {
		this.retailPriceLow = retailPriceLow;
	}
	 public String getRetailPriceLow() {
		return this.retailPriceLow;
	}
	public void setSkuCostPrices(String skuCostPrices) {
		this.skuCostPrices = skuCostPrices;
	}
	 public String getSkuCostPrices() {
		return this.skuCostPrices;
	}
	public void setSkuIds(String skuIds) {
		this.skuIds = skuIds;
	}
	 public String getSkuIds() {
		return this.skuIds;
	}
	public void setSkuOuterIds(String skuOuterIds) {
		this.skuOuterIds = skuOuterIds;
	}
	 public String getSkuOuterIds() {
		return this.skuOuterIds;
	}
	public void setSkuQuantitys(String skuQuantitys) {
		this.skuQuantitys = skuQuantitys;
	}
	 public String getSkuQuantitys() {
		return this.skuQuantitys;
	}
	public void setStandardPrice(String standardPrice) {
		this.standardPrice = standardPrice;
	}
	 public String getStandardPrice() {
		return this.standardPrice;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	 public String getStatus() {
		return this.status;
	}
	
	public String getApiMethodName() {
		return "taobao.fenxiao.product.update";
	}

	public Map<String, String> getTextParams() {		
		textParams.put("alarm_number", this.alarmNumber);
		textParams.put("category_id", this.categoryId);
		textParams.put("city", this.city);
		textParams.put("cost_price", this.costPrice);
		textParams.put("desc", this.desc);
		textParams.put("have_guarantee", this.haveGuarantee);
		textParams.put("have_invoice", this.haveInvoice);
		textParams.put("name", this.name);
		textParams.put("outer_id", this.outerId);
		textParams.put("pid", this.pid);
		textParams.put("postage_ems", this.postageEms);
		textParams.put("postage_fast", this.postageFast);
		textParams.put("postage_id", this.postageId);
		textParams.put("postage_ordinary", this.postageOrdinary);
		textParams.put("postage_type", this.postageType);
		textParams.put("productcat_id", this.productcatId);
		textParams.put("prov", this.prov);
		textParams.put("quantity", this.quantity);
		textParams.put("retail_price_high", this.retailPriceHigh);
		textParams.put("retail_price_low", this.retailPriceLow);
		textParams.put("sku_cost_prices", this.skuCostPrices);
		textParams.put("sku_ids", this.skuIds);
		textParams.put("sku_outer_ids", this.skuOuterIds);
		textParams.put("sku_quantitys", this.skuQuantitys);
		textParams.put("standard_price", this.standardPrice);
		textParams.put("status", this.status);
		return textParams;
	}
	
	public Long getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
}
