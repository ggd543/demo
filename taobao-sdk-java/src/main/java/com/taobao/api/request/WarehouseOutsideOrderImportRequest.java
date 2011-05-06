package com.taobao.api.request;

import java.util.Map;
import java.util.Date;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.TaobaoRequest;

/**
 * TOP API: taobao.warehouse.outside.order.import request
 * 
 * @author auto create
 * @since 1.0, 2010-10-21 08:49:31.0
 */
public class WarehouseOutsideOrderImportRequest implements TaobaoRequest {
	private Long timestamp;	
	private TaobaoHashMap textParams = new TaobaoHashMap();


	
	/** 
	 * 自动发货标识,ENABLED(自动检查发货规则，如果满足自动发货，则自动发货)和DISABLED(不采用自动发货),默认为DISABLED
	 **/
	private String autoConsign;
	
	/** 
	 * json格式的货物列表，形式如：{"goods_list":[{"goods_name":"name","single_price":"100","goods_quantity":"10","outer_id":"abcd"},{"goods_name":"name1","single_price":"101","goods_quantity":"11","outer_id":"abcd1"}]}其中只有outer_id是可选的，outer_id可以
根据接口taobao.warehouse.items.get得到
	 **/
	private String goodsListJson;
	
	/** 
	 * 货物备注（长度不大于125字符）
	 **/
	private String memo;
	
	/** 
	 * 收货人详细地址（长度在4-60字符之间）
	 **/
	private String receiverAddress;
	
	/** 
	 * 中国地区编码值(必须为地区叶子节点)如"110101"(北京市市辖区东城区)，获取参见taobao.areas.get
	 **/
	private Long receiverCountryId;
	
	/** 
	 * 收货人手机号
	 **/
	private Long receiverMobilePhone;
	
	/** 
	 * 收货人姓名（长度不大于20字节）
	 **/
	private String receiverName;
	
	/** 
	 * 收货人电话号
	 **/
	private String receiverTelephone;
	
	/** 
	 * 收货人邮编
	 **/
	private Long receiverZipCode;

	public void setAutoConsign(String autoConsign) {
		this.autoConsign = autoConsign;
	}
	 public String getAutoConsign() {
		return this.autoConsign;
	}
	public void setGoodsListJson(String goodsListJson) {
		this.goodsListJson = goodsListJson;
	}
	 public String getGoodsListJson() {
		return this.goodsListJson;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	 public String getMemo() {
		return this.memo;
	}
	public void setReceiverAddress(String receiverAddress) {
		this.receiverAddress = receiverAddress;
	}
	 public String getReceiverAddress() {
		return this.receiverAddress;
	}
	public void setReceiverCountryId(Long receiverCountryId) {
		this.receiverCountryId = receiverCountryId;
	}
	 public Long getReceiverCountryId() {
		return this.receiverCountryId;
	}
	public void setReceiverMobilePhone(Long receiverMobilePhone) {
		this.receiverMobilePhone = receiverMobilePhone;
	}
	 public Long getReceiverMobilePhone() {
		return this.receiverMobilePhone;
	}
	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}
	 public String getReceiverName() {
		return this.receiverName;
	}
	public void setReceiverTelephone(String receiverTelephone) {
		this.receiverTelephone = receiverTelephone;
	}
	 public String getReceiverTelephone() {
		return this.receiverTelephone;
	}
	public void setReceiverZipCode(Long receiverZipCode) {
		this.receiverZipCode = receiverZipCode;
	}
	 public Long getReceiverZipCode() {
		return this.receiverZipCode;
	}
	
	public String getApiMethodName() {
		return "taobao.warehouse.outside.order.import";
	}

	public Map<String, String> getTextParams() {		
		textParams.put("auto_consign", this.autoConsign);
		textParams.put("goods_list_json", this.goodsListJson);
		textParams.put("memo", this.memo);
		textParams.put("receiver_address", this.receiverAddress);
		textParams.put("receiver_country_id", this.receiverCountryId);
		textParams.put("receiver_mobile_phone", this.receiverMobilePhone);
		textParams.put("receiver_name", this.receiverName);
		textParams.put("receiver_telephone", this.receiverTelephone);
		textParams.put("receiver_zip_code", this.receiverZipCode);
		return textParams;
	}
	
	public Long getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
}
