package com.taobao.api.request;

import java.util.Map;
import java.util.Date;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.TaobaoRequest;

/**
 * TOP API: taobao.warehouse.item.add request
 * 
 * @author auto create
 * @since 1.0, 2010-10-21 08:42:27.0
 */
public class WarehouseItemAddRequest implements TaobaoRequest {
	private Long timestamp;	
	private TaobaoHashMap textParams = new TaobaoHashMap();


	
	/** 
	 * 商品名称。最大长度为256字符，一个汉字算两个字符
	 **/
	private String itemName;
	
	/** 
	 * 自定义属性。最大长度为256字符，一个汉字算两个字符
	 **/
	private String memo;
	
	/** 
	 * 商家编码。商家编码唯一，最大长度为64个字符
	 **/
	private String outerId;

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	 public String getItemName() {
		return this.itemName;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	 public String getMemo() {
		return this.memo;
	}
	public void setOuterId(String outerId) {
		this.outerId = outerId;
	}
	 public String getOuterId() {
		return this.outerId;
	}
	
	public String getApiMethodName() {
		return "taobao.warehouse.item.add";
	}

	public Map<String, String> getTextParams() {		
		textParams.put("item_name", this.itemName);
		textParams.put("memo", this.memo);
		textParams.put("outer_id", this.outerId);
		return textParams;
	}
	
	public Long getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
}
