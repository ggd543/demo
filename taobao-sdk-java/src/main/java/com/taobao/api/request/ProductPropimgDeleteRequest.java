package com.taobao.api.request;

import java.util.Map;
import java.util.Date;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.TaobaoRequest;

/**
 * TOP API: taobao.product.propimg.delete request
 * 
 * @author auto create
 * @since 1.0, 2010-08-03 15:54:04.0
 */
public class ProductPropimgDeleteRequest implements TaobaoRequest {
	private Long timestamp;	
	private TaobaoHashMap textParams = new TaobaoHashMap();


	
	/** 
	 * 属性图片ID
	 **/
	private Long id;
	
	/** 
	 * 产品ID.Product的id.
	 **/
	private Long productId;

	public void setId(Long id) {
		this.id = id;
	}
	 public Long getId() {
		return this.id;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	 public Long getProductId() {
		return this.productId;
	}
	
	public String getApiMethodName() {
		return "taobao.product.propimg.delete";
	}

	public Map<String, String> getTextParams() {		
		textParams.put("id", this.id);
		textParams.put("product_id", this.productId);
		return textParams;
	}
	
	public Long getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
}
