package com.taobao.api.response;

import java.util.List;
import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.internal.mapping.ApiListField;
import com.taobao.api.domain.SellerStore;


import com.taobao.api.TaobaoResponse;

/**
 * TOP API: taobao.warehouse.sellerstores.get response
 * 
 * @author auto create
 * @since 1.0,2010-10-21 08:46:27.0
 */
public class WarehouseSellerstoresGetResponse extends TaobaoResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5712813329484665887L;

	
	/** 
	 * 自定义仓库集合
	 **/
	@ApiListField("seller_store_list")
	@ApiField("seller_store")
	private List<SellerStore> sellerStoreList;

	public void setSellerStoreList(List<SellerStore> sellerStoreList) {
		this.sellerStoreList = sellerStoreList;
	}

	public List<SellerStore> getSellerStoreList( ) {
		return this.sellerStoreList;
	}

	public String getApiMethodName() {
		return "taobao.warehouse.sellerstores.get";
	}

}
