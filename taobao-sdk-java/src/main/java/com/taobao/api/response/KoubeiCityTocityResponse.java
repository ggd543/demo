package com.taobao.api.response;

import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.domain.KbCity;


import com.taobao.api.TaobaoResponse;

/**
 * TOP API: taobao.koubei.city.tocity response
 * 
 * @author auto create
 * @since 1.0,2010-12-02 12:56:35.0
 */
public class KoubeiCityTocityResponse extends TaobaoResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3352112745369699257L;

	
	/** 
	 * 转换成口碑的城市对象
	 **/
	@ApiField("kb_city")
	private KbCity kbCity;

	public void setKbCity(KbCity kbCity) {
		this.kbCity = kbCity;
	}

	public KbCity getKbCity( ) {
		return this.kbCity;
	}

	public String getApiMethodName() {
		return "taobao.koubei.city.tocity";
	}

}
