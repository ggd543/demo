package com.taobao.api.response;

import java.util.List;
import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.internal.mapping.ApiListField;
import com.taobao.api.domain.ExtStore;


import com.taobao.api.TaobaoResponse;

/**
 * TOP API: taobao.warehouse.extstores.get response
 * 
 * @author auto create
 * @since 1.0,2010-10-21 08:50:48.0
 */
public class WarehouseExtstoresGetResponse extends TaobaoResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6352461931444828475L;

	
	/** 
	 * 外部仓库的集合
	 **/
	@ApiListField("ext_store_list")
	@ApiField("ext_store")
	private List<ExtStore> extStoreList;

	public void setExtStoreList(List<ExtStore> extStoreList) {
		this.extStoreList = extStoreList;
	}

	public List<ExtStore> getExtStoreList( ) {
		return this.extStoreList;
	}

	public String getApiMethodName() {
		return "taobao.warehouse.extstores.get";
	}

}
