package com.taobao.api.response;

import java.util.List;
import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.internal.mapping.ApiListField;
import com.taobao.api.domain.StoreBill;


import com.taobao.api.TaobaoResponse;

/**
 * TOP API: taobao.warehouse.storebill.page.get response
 * 
 * @author auto create
 * @since 1.0,2010-10-21 08:43:51.0
 */
public class WarehouseStorebillPageGetResponse extends TaobaoResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7342324167882618437L;

	
	/** 
	 * 商家的某个仓库某月的费用。JSON格式的字符串
	 **/
	@ApiListField("store_bill_list")
	@ApiField("store_bill")
	private List<StoreBill> storeBillList;
	
	/** 
	 * 搜索到符合条件的结果总数
	 **/
	@ApiField("total_result")
	private Long totalResult;

	public void setStoreBillList(List<StoreBill> storeBillList) {
		this.storeBillList = storeBillList;
	}

	public List<StoreBill> getStoreBillList( ) {
		return this.storeBillList;
	}
	public void setTotalResult(Long totalResult) {
		this.totalResult = totalResult;
	}

	public Long getTotalResult( ) {
		return this.totalResult;
	}

	public String getApiMethodName() {
		return "taobao.warehouse.storebill.page.get";
	}

}
