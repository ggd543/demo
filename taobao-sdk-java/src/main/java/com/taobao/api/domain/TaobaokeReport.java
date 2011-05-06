package com.taobao.api.domain;

import java.util.List;
import com.taobao.api.internal.mapping.ApiClass;
import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.internal.mapping.ApiListField;


import com.taobao.api.TaobaoObject;

/**
 * TaobaokeReport Data Structure.
 * 
 * DESC：淘宝客报表 
 *
 * @author auto create
 * @since 1.0, 2010-08-25 09:14:30.0
 */
@ApiClass("TaobaokeReport")
public class TaobaokeReport extends TaobaoObject {

	private static final long serialVersionUID = 3715782992837693392L;

	
	/** 
	 * 淘宝客报表成员列表
	 **/
	@ApiListField("taobaoke_report_members")
	@ApiField("taobaoke_report_member")
	private List<TaobaokeReportMember> taobaokeReportMembers;

	public List<TaobaokeReportMember> getTaobaokeReportMembers() {
		return this.taobaokeReportMembers;
	}
	public void setTaobaokeReportMembers(List<TaobaokeReportMember> taobaokeReportMembers) {
		this.taobaokeReportMembers = taobaokeReportMembers;
	}

}
