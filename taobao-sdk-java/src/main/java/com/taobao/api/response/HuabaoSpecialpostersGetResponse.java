package com.taobao.api.response;

import java.util.List;
import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.internal.mapping.ApiListField;
import com.taobao.api.domain.Poster;


import com.taobao.api.TaobaoResponse;

/**
 * TOP API: taobao.huabao.specialposters.get response
 * 
 * @author auto create
 * @since 1.0,2010-11-26 09:44:04.0
 */
public class HuabaoSpecialpostersGetResponse extends TaobaoResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1363326235478536982L;

	
	/** 
	 * 画报信息
	 **/
	@ApiListField("posters")
	@ApiField("poster")
	private List<Poster> posters;

	public void setPosters(List<Poster> posters) {
		this.posters = posters;
	}

	public List<Poster> getPosters( ) {
		return this.posters;
	}

	public String getApiMethodName() {
		return "taobao.huabao.specialposters.get";
	}

}
