package com.taobao.api.request;

import java.util.Map;
import java.util.Date;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.TaobaoRequest;

/**
 * TOP API: taobao.logistics.partners.get request
 * 
 * @author auto create
 * @since 1.0, 2010-09-02 12:00:45.0
 */
public class LogisticsPartnersGetRequest implements TaobaoRequest {
	private Long timestamp;	
	private TaobaoHashMap textParams = new TaobaoHashMap();


	
	/** 
	 * 货物价格.只有当选择货到付款此参数才会有效
	 **/
	private String goodsValue;
	
	/** 
	 * 服务类型，根据此参数可查出提供相应服务类型的物流公司信息(物流公司状态正常)，可选值：cod(货到付款)、online(在线下单)、 offline(自己联系)、limit(限时物流)。然后再根据source_id,target_id,goods_value这三个条件来过滤物流公司. 目前输入自己联系服务类型将会返回空，因为自己联系并没有具体的服务信息，所以不会有记录。
	 **/
	private String serviceType;
	
	/** 
	 * 物流公司揽货地地区码.参考:http://www.stats.gov.cn/tjbz/xzqhdm/t20080215_402462675.htm  或者调用 taobao.areas.get 获取
	 **/
	private String sourceId;
	
	/** 
	 * 物流公司派送地地区码.参考:http://www.stats.gov.cn/tjbz/xzqhdm/t20080215_402462675.htm  或者调用 taobao.areas.get 获取
	 **/
	private String targetId;

	public void setGoodsValue(String goodsValue) {
		this.goodsValue = goodsValue;
	}
	 public String getGoodsValue() {
		return this.goodsValue;
	}
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	 public String getServiceType() {
		return this.serviceType;
	}
	public void setSourceId(String sourceId) {
		this.sourceId = sourceId;
	}
	 public String getSourceId() {
		return this.sourceId;
	}
	public void setTargetId(String targetId) {
		this.targetId = targetId;
	}
	 public String getTargetId() {
		return this.targetId;
	}
	
	public String getApiMethodName() {
		return "taobao.logistics.partners.get";
	}

	public Map<String, String> getTextParams() {		
		textParams.put("goods_value", this.goodsValue);
		textParams.put("service_type", this.serviceType);
		textParams.put("source_id", this.sourceId);
		textParams.put("target_id", this.targetId);
		return textParams;
	}
	
	public Long getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
}
