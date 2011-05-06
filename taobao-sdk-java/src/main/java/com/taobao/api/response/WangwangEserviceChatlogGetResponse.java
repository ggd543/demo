package com.taobao.api.response;

import java.util.List;
import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.internal.mapping.ApiListField;
import com.taobao.api.domain.Msg;


import com.taobao.api.TaobaoResponse;

/**
 * TOP API: taobao.wangwang.eservice.chatlog.get response
 * 
 * @author auto create
 * @since 1.0,2010-06-23 10:29:24.0
 */
public class WangwangEserviceChatlogGetResponse extends TaobaoResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6475792967411616225L;

	
	/** 
	 * 聊天记录数目。
	 **/
	@ApiField("count")
	private Long count;
	
	/** 
	 * 聊天消息列表，即Msg[]，direction=0为from_id发送消息给to_id，direction=1为to_id发送消息给from_id
	 **/
	@ApiListField("msgs")
	@ApiField("msg")
	private List<Msg> msgs;
	
	/** 
	 * 返回码。 
10000:成功； 

50000：时间非法，包括1)时间段超过7天,或2)起始时间距今超过30天，或3)时间格式不对； 

40000：聊天用户ID不是该店铺的帐号或子帐号查询主帐号私密联系人的聊天记录； 

30000：系统错误，包括必填参数为空。
	 **/
	@ApiField("ret")
	private Long ret;

	public void setCount(Long count) {
		this.count = count;
	}

	public Long getCount( ) {
		return this.count;
	}
	public void setMsgs(List<Msg> msgs) {
		this.msgs = msgs;
	}

	public List<Msg> getMsgs( ) {
		return this.msgs;
	}
	public void setRet(Long ret) {
		this.ret = ret;
	}

	public Long getRet( ) {
		return this.ret;
	}

	public String getApiMethodName() {
		return "taobao.wangwang.eservice.chatlog.get";
	}

}
