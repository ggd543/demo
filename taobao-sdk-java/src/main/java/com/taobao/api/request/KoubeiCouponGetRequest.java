package com.taobao.api.request;

import java.util.Map;
import java.util.Date;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.TaobaoRequest;

/**
 * TOP API: taobao.koubei.coupon.get request
 * 
 * @author auto create
 * @since 1.0, 2010-12-02 12:56:51.0
 */
public class KoubeiCouponGetRequest implements TaobaoRequest {
	private Long timestamp;	
	private TaobaoHashMap textParams = new TaobaoHashMap();


	
	/** 
	 * 优惠券的id
	 **/
	private String couponId;

	public void setCouponId(String couponId) {
		this.couponId = couponId;
	}
	 public String getCouponId() {
		return this.couponId;
	}
	
	public String getApiMethodName() {
		return "taobao.koubei.coupon.get";
	}

	public Map<String, String> getTextParams() {		
		textParams.put("coupon_id", this.couponId);
		return textParams;
	}
	
	public Long getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
}
