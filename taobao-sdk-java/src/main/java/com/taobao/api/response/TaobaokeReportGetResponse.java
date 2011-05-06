package com.taobao.api.response;

import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.domain.TaobaokeReport;


import com.taobao.api.TaobaoResponse;

/**
 * TOP API: taobao.taobaoke.report.get response
 * 
 * @author auto create
 * @since 1.0,2010-08-12 20:52:43.0
 */
public class TaobaokeReportGetResponse extends TaobaoResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3128153592267862351L;

	
	/** 
	 * 淘宝客报表
	 **/
	@ApiField("taobaoke_report")
	private TaobaokeReport taobaokeReport;

	public void setTaobaokeReport(TaobaokeReport taobaokeReport) {
		this.taobaokeReport = taobaokeReport;
	}

	public TaobaokeReport getTaobaokeReport( ) {
		return this.taobaokeReport;
	}

	public String getApiMethodName() {
		return "taobao.taobaoke.report.get";
	}

}
