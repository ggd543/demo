package com.taobao.api.response;

import java.util.List;
import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.internal.mapping.ApiListField;
import com.taobao.api.domain.KbStoreCat;


import com.taobao.api.TaobaoResponse;

/**
 * TOP API: taobao.koubei.store.categories.get response
 * 
 * @author auto create
 * @since 1.0,2010-12-02 12:58:01.0
 */
public class KoubeiStoreCategoriesGetResponse extends TaobaoResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6622719485449535784L;

	
	/** 
	 * 返回指定类目id的子类目集，无返回null
	 **/
	@ApiListField("kb_store_cats")
	@ApiField("kb_store_cat")
	private List<KbStoreCat> kbStoreCats;

	public void setKbStoreCats(List<KbStoreCat> kbStoreCats) {
		this.kbStoreCats = kbStoreCats;
	}

	public List<KbStoreCat> getKbStoreCats( ) {
		return this.kbStoreCats;
	}

	public String getApiMethodName() {
		return "taobao.koubei.store.categories.get";
	}

}
