package com.taobao.api.response;

import java.util.List;
import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.internal.mapping.ApiListField;
import com.taobao.api.domain.KbCity;


import com.taobao.api.TaobaoResponse;

/**
 * TOP API: taobao.koubei.city.subs.get response
 * 
 * @author auto create
 * @since 1.0,2010-12-02 12:56:17.0
 */
public class KoubeiCitySubsGetResponse extends TaobaoResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8143925486538715789L;

	
	/** 
	 * 子集城市
	 **/
	@ApiListField("kb_cities")
	@ApiField("kb_city")
	private List<KbCity> kbCities;

	public void setKbCities(List<KbCity> kbCities) {
		this.kbCities = kbCities;
	}

	public List<KbCity> getKbCities( ) {
		return this.kbCities;
	}

	public String getApiMethodName() {
		return "taobao.koubei.city.subs.get";
	}

}
