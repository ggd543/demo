package com.taobao.api.request;

import java.util.Map;
import java.util.Date;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.TaobaoRequest;

/**
 * TOP API: taobao.marketing.promotion.delete request
 * 
 * @author auto create
 * @since 1.0, 2010-11-18 16:49:57.0
 */
public class MarketingPromotionDeleteRequest implements TaobaoRequest {
	private Long timestamp;	
	private TaobaoHashMap textParams = new TaobaoHashMap();


	
	/** 
	 * 已设置的优惠策略ID
	 **/
	private Long promotionId;

	public void setPromotionId(Long promotionId) {
		this.promotionId = promotionId;
	}
	 public Long getPromotionId() {
		return this.promotionId;
	}
	
	public String getApiMethodName() {
		return "taobao.marketing.promotion.delete";
	}

	public Map<String, String> getTextParams() {		
		textParams.put("promotion_id", this.promotionId);
		return textParams;
	}
	
	public Long getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
}
