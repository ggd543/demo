package com.taobao.api.response;

import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.domain.KbDetailStore;


import com.taobao.api.TaobaoResponse;

/**
 * TOP API: taobao.koubei.store.get response
 * 
 * @author auto create
 * @since 1.0,2010-12-02 12:57:34.0
 */
public class KoubeiStoreGetResponse extends TaobaoResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5117251736459724811L;

	
	/** 
	 * 店铺detail信息，无则返回null
	 **/
	@ApiField("kb_detail_store")
	private KbDetailStore kbDetailStore;

	public void setKbDetailStore(KbDetailStore kbDetailStore) {
		this.kbDetailStore = kbDetailStore;
	}

	public KbDetailStore getKbDetailStore( ) {
		return this.kbDetailStore;
	}

	public String getApiMethodName() {
		return "taobao.koubei.store.get";
	}

}
