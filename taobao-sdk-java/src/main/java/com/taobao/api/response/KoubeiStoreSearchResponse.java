package com.taobao.api.response;

import java.util.List;
import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.internal.mapping.ApiListField;
import com.taobao.api.domain.KbListStore;


import com.taobao.api.TaobaoResponse;

/**
 * TOP API: taobao.koubei.store.search response
 * 
 * @author auto create
 * @since 1.0,2010-12-02 12:58:19.0
 */
public class KoubeiStoreSearchResponse extends TaobaoResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1566478136596276548L;

	
	/** 
	 * 返回满足查询条件的店铺集，无则返回null
	 **/
	@ApiListField("kb_list_stores")
	@ApiField("kb_list_store")
	private List<KbListStore> kbListStores;
	
	/** 
	 * 总的数量
	 **/
	@ApiField("total_results")
	private Long totalResults;

	public void setKbListStores(List<KbListStore> kbListStores) {
		this.kbListStores = kbListStores;
	}

	public List<KbListStore> getKbListStores( ) {
		return this.kbListStores;
	}
	public void setTotalResults(Long totalResults) {
		this.totalResults = totalResults;
	}

	public Long getTotalResults( ) {
		return this.totalResults;
	}

	public String getApiMethodName() {
		return "taobao.koubei.store.search";
	}

}
