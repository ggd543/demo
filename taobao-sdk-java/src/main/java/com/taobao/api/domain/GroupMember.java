package com.taobao.api.domain;

import com.taobao.api.internal.mapping.ApiClass;
import com.taobao.api.internal.mapping.ApiField;


import com.taobao.api.TaobaoObject;

/**
 * GroupMember Data Structure.
 * 
 * DESC：组及其成员列表 
 *
 * @author auto create
 * @since 1.0, 2010-07-28 10:20:26.0
 */
@ApiClass("GroupMember")
public class GroupMember extends TaobaoObject {

	private static final long serialVersionUID = 4774128926256155881L;

	
	/** 
	 * 组名称
	 **/
	@ApiField("group_name")
	private String groupName;

	
	/** 
	 * 组成员列表，逗号分隔
	 **/
	@ApiField("member_list")
	private String memberList;

	public String getGroupName() {
		return this.groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getMemberList() {
		return this.memberList;
	}
	public void setMemberList(String memberList) {
		this.memberList = memberList;
	}

}
