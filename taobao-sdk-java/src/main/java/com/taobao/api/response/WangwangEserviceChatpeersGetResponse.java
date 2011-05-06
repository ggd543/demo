package com.taobao.api.response;

import java.util.List;
import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.internal.mapping.ApiListField;
import com.taobao.api.domain.ChatPeer;


import com.taobao.api.TaobaoResponse;

/**
 * TOP API: taobao.wangwang.eservice.chatpeers.get response
 * 
 * @author auto create
 * @since 1.0,2010-06-23 10:27:55.0
 */
public class WangwangEserviceChatpeersGetResponse extends TaobaoResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6131578911337717678L;

	
	/** 
	 * 聊天对象ID列表
	 **/
	@ApiListField("chatpeer")
	@ApiField("chat_peer")
	private List<ChatPeer> chatpeer;
	
	/** 
	 * 成员数目。
	 **/
	@ApiField("count")
	private Long count;
	
	/** 
	 * 返回码： 
10000:成功； 

60000：时间非法，包括1)时间段超过7天,或2)起始时间距今超过30天，或3)时间格式不对； 

50000：聊天用户ID不是该店铺的帐号； 

40000：系统错误，包括必填参数为空。
	 **/
	@ApiField("ret")
	private Long ret;

	public void setChatpeer(List<ChatPeer> chatpeer) {
		this.chatpeer = chatpeer;
	}

	public List<ChatPeer> getChatpeer( ) {
		return this.chatpeer;
	}
	public void setCount(Long count) {
		this.count = count;
	}

	public Long getCount( ) {
		return this.count;
	}
	public void setRet(Long ret) {
		this.ret = ret;
	}

	public Long getRet( ) {
		return this.ret;
	}

	public String getApiMethodName() {
		return "taobao.wangwang.eservice.chatpeers.get";
	}

}
