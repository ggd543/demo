package com.taobao.api.request;

import java.util.Map;
import java.util.Date;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.TaobaoRequest;

/**
 * TOP API: taobao.warehouse.items.page.get request
 * 
 * @author auto create
 * @since 1.0, 2010-10-21 08:49:56.0
 */
public class WarehouseItemsPageGetRequest implements TaobaoRequest {
	private Long timestamp;	
	private TaobaoHashMap textParams = new TaobaoHashMap();


	
	/** 
	 * 商品名称。可从taobao.warehouse.items.get处获得
	 **/
	private String itemName;
	
	/** 
	 * 商家编码。可从taobao.warehouse.items.get处获得
	 **/
	private String outerId;
	
	/** 
	 * 当前页，默认为1，最大页数取决于用户拥有的商品数和一页显示的记录数
	 **/
	private String pageNo;
	
	/** 
	 * 一页显示记录数，默认为20。最多为50，如果用户输入的记录数大于50，则按默认一页显示50条记录
	 **/
	private String pageSize;

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	 public String getItemName() {
		return this.itemName;
	}
	public void setOuterId(String outerId) {
		this.outerId = outerId;
	}
	 public String getOuterId() {
		return this.outerId;
	}
	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}
	 public String getPageNo() {
		return this.pageNo;
	}
	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}
	 public String getPageSize() {
		return this.pageSize;
	}
	
	public String getApiMethodName() {
		return "taobao.warehouse.items.page.get";
	}

	public Map<String, String> getTextParams() {		
		textParams.put("item_name", this.itemName);
		textParams.put("outer_id", this.outerId);
		textParams.put("page_no", this.pageNo);
		textParams.put("page_size", this.pageSize);
		return textParams;
	}
	
	public Long getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
}
