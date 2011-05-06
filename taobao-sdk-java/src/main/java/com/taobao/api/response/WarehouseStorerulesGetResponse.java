package com.taobao.api.response;

import java.util.List;
import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.internal.mapping.ApiListField;
import com.taobao.api.domain.StoreRule;


import com.taobao.api.TaobaoResponse;

/**
 * TOP API: taobao.warehouse.storerules.get response
 * 
 * @author auto create
 * @since 1.0,2010-11-23 17:15:45.0
 */
public class WarehouseStorerulesGetResponse extends TaobaoResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3589367359726624415L;

	
	/** 
	 * 仓储用户所有自定义仓库发货规则
	 **/
	@ApiListField("store_rule_list")
	@ApiField("store_rule")
	private List<StoreRule> storeRuleList;

	public void setStoreRuleList(List<StoreRule> storeRuleList) {
		this.storeRuleList = storeRuleList;
	}

	public List<StoreRule> getStoreRuleList( ) {
		return this.storeRuleList;
	}

	public String getApiMethodName() {
		return "taobao.warehouse.storerules.get";
	}

}
