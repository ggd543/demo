package com.taobao.api.response;

import java.util.List;
import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.internal.mapping.ApiListField;
import com.taobao.api.domain.GroupMember;


import com.taobao.api.TaobaoResponse;

/**
 * TOP API: taobao.wangwang.eservice.groupmember.get response
 * 
 * @author auto create
 * @since 1.0,2010-11-04 16:24:03.0
 */
public class WangwangEserviceGroupmemberGetResponse extends TaobaoResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2565366188393962911L;

	
	/** 
	 * 组及其成员列表
	 **/
	@ApiListField("group_memeber_list")
	@ApiField("group_member")
	private List<GroupMember> groupMemeberList;

	public void setGroupMemeberList(List<GroupMember> groupMemeberList) {
		this.groupMemeberList = groupMemeberList;
	}

	public List<GroupMember> getGroupMemeberList( ) {
		return this.groupMemeberList;
	}

	public String getApiMethodName() {
		return "taobao.wangwang.eservice.groupmember.get";
	}

}
