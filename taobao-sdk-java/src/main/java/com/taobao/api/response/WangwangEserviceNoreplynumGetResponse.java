package com.taobao.api.response;

import java.util.List;
import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.internal.mapping.ApiListField;
import com.taobao.api.domain.NonReplyStatOnDay;


import com.taobao.api.TaobaoResponse;

/**
 * TOP API: taobao.wangwang.eservice.noreplynum.get response
 * 
 * @author auto create
 * @since 1.0,2010-09-19 13:09:54.0
 */
public class WangwangEserviceNoreplynumGetResponse extends TaobaoResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3645473426288621969L;

	
	/** 
	 * 未回复统计列表
	 **/
	@ApiListField("non_reply_stat")
	@ApiField("non_reply_stat_on_day")
	private List<NonReplyStatOnDay> nonReplyStat;

	public void setNonReplyStat(List<NonReplyStatOnDay> nonReplyStat) {
		this.nonReplyStat = nonReplyStat;
	}

	public List<NonReplyStatOnDay> getNonReplyStat( ) {
		return this.nonReplyStat;
	}

	public String getApiMethodName() {
		return "taobao.wangwang.eservice.noreplynum.get";
	}

}
