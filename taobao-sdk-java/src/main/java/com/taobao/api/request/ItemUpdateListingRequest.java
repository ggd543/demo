package com.taobao.api.request;

import java.util.Map;
import java.util.Date;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.TaobaoRequest;

/**
 * TOP API: taobao.item.update.listing request
 * 
 * @author auto create
 * @since 1.0, 2010-11-12 10:15:01.0
 */
public class ItemUpdateListingRequest implements TaobaoRequest {
	private Long timestamp;	
	private TaobaoHashMap textParams = new TaobaoHashMap();


	
	/** 
	 * 需要上架的商品的数量。取值范围:大于零的整数。如果商品有sku，则上架数量默认为所有sku数量总和，不可修改。否则商品数量根据设置数量调整为num
	 **/
	private Long num;
	
	/** 
	 * 商品数字ID，该参数必须
	 **/
	private Long numIid;

	public void setNum(Long num) {
		this.num = num;
	}
	 public Long getNum() {
		return this.num;
	}
	public void setNumIid(Long numIid) {
		this.numIid = numIid;
	}
	 public Long getNumIid() {
		return this.numIid;
	}
	
	public String getApiMethodName() {
		return "taobao.item.update.listing";
	}

	public Map<String, String> getTextParams() {		
		textParams.put("num", this.num);
		textParams.put("num_iid", this.numIid);
		return textParams;
	}
	
	public Long getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
}
