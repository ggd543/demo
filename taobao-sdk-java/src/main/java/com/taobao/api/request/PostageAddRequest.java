package com.taobao.api.request;

import java.util.Map;
import java.util.Date;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.TaobaoRequest;

/**
 * TOP API: taobao.postage.add request
 * 
 * @author auto create
 * @since 1.0, 2010-08-03 14:56:20.0
 */
public class PostageAddRequest implements TaobaoRequest {
	private Long timestamp;	
	private TaobaoHashMap textParams = new TaobaoHashMap();


	
	/** 
	 * 默认EMS加价费用.精确到1位小数;单位:元。如:1.5
	 **/
	private String emsIncrease;
	
	/** 
	 * 默认EMS费用. 精确到1位小数;单位:元。如:200.5
	 **/
	private String emsPrice;
	
	/** 
	 * 默认快递加价费用.精确到1位小数;单位:元。如:1.5
	 **/
	private String expressIncrease;
	
	/** 
	 * 默认快递费用. 精确到1位小数;单位:元。如:200.5
	 **/
	private String expressPrice;
	
	/** 
	 * 邮费模板备注,不能超过200个字节
	 **/
	private String memo;
	
	/** 
	 * 邮费模板名称,不能超过50个字节
	 **/
	private String name;
	
	/** 
	 * 默认平邮加价费用. 精确到1位小数;单位:元。如:1.5
	 **/
	private String postIncrease;
	
	/** 
	 * 默认平邮费用. 注意:至少选择一组默认的邮费组,例如:post_price,post_increase . 精确到1位小数;单位:元。如:200.5
	 **/
	private String postPrice;
	
	/** 
	 * 邮费子项涉及的地区.结构: value1;value2;value3 如:110000;310000;320000,330000 就代表邮费子项涉及(北京;上海;江苏,浙江)四个地区. 可以用taobao.areas.get接口获取.或者参考：http://www.stats.gov.cn/tjbz/xzqhdm/t20080215_402462675.htm
	 **/
	private String postageModeDests;
	
	/** 
	 * 运费方式加件费用.结构: value1;value2;value3 如: 1.5;2;4 .精确到1位小数;单位:元。如:1.5
	 **/
	private String postageModeIncreases;
	
	/** 
	 * 运费方式单价. 结构: value1;value2;value3 如: 11.2;14;6 .精确到1位小数;单位:元。如:200.5
	 **/
	private String postageModePrices;
	
	/** 
	 * 运费方式:平邮 (post),快递公司(express),EMS (ems) 结构:value1;value2;value3 如: post;express;ems 注意:在添加多个PostageMode时,字符串中使用 ";" 分号区分.postage_mode.type,postage_mode.dest,postage_mode.price,postage_mode.increase, 数量必须一致.
	 **/
	private String postageModeTypes;

	public void setEmsIncrease(String emsIncrease) {
		this.emsIncrease = emsIncrease;
	}
	 public String getEmsIncrease() {
		return this.emsIncrease;
	}
	public void setEmsPrice(String emsPrice) {
		this.emsPrice = emsPrice;
	}
	 public String getEmsPrice() {
		return this.emsPrice;
	}
	public void setExpressIncrease(String expressIncrease) {
		this.expressIncrease = expressIncrease;
	}
	 public String getExpressIncrease() {
		return this.expressIncrease;
	}
	public void setExpressPrice(String expressPrice) {
		this.expressPrice = expressPrice;
	}
	 public String getExpressPrice() {
		return this.expressPrice;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	 public String getMemo() {
		return this.memo;
	}
	public void setName(String name) {
		this.name = name;
	}
	 public String getName() {
		return this.name;
	}
	public void setPostIncrease(String postIncrease) {
		this.postIncrease = postIncrease;
	}
	 public String getPostIncrease() {
		return this.postIncrease;
	}
	public void setPostPrice(String postPrice) {
		this.postPrice = postPrice;
	}
	 public String getPostPrice() {
		return this.postPrice;
	}
	public void setPostageModeDests(String postageModeDests) {
		this.postageModeDests = postageModeDests;
	}
	 public String getPostageModeDests() {
		return this.postageModeDests;
	}
	public void setPostageModeIncreases(String postageModeIncreases) {
		this.postageModeIncreases = postageModeIncreases;
	}
	 public String getPostageModeIncreases() {
		return this.postageModeIncreases;
	}
	public void setPostageModePrices(String postageModePrices) {
		this.postageModePrices = postageModePrices;
	}
	 public String getPostageModePrices() {
		return this.postageModePrices;
	}
	public void setPostageModeTypes(String postageModeTypes) {
		this.postageModeTypes = postageModeTypes;
	}
	 public String getPostageModeTypes() {
		return this.postageModeTypes;
	}
	
	public String getApiMethodName() {
		return "taobao.postage.add";
	}

	public Map<String, String> getTextParams() {		
		textParams.put("ems_increase", this.emsIncrease);
		textParams.put("ems_price", this.emsPrice);
		textParams.put("express_increase", this.expressIncrease);
		textParams.put("express_price", this.expressPrice);
		textParams.put("memo", this.memo);
		textParams.put("name", this.name);
		textParams.put("post_increase", this.postIncrease);
		textParams.put("post_price", this.postPrice);
		textParams.put("postage_mode_dests", this.postageModeDests);
		textParams.put("postage_mode_increases", this.postageModeIncreases);
		textParams.put("postage_mode_prices", this.postageModePrices);
		textParams.put("postage_mode_types", this.postageModeTypes);
		return textParams;
	}
	
	public Long getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
}
