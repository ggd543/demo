package com.taobao.api.response;

import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.domain.PosterChannel;


import com.taobao.api.TaobaoResponse;

/**
 * TOP API: taobao.huabao.channel.get response
 * 
 * @author auto create
 * @since 1.0,2010-11-26 11:03:23.0
 */
public class HuabaoChannelGetResponse extends TaobaoResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3352248258275915839L;

	
	/** 
	 * 频道信息
	 **/
	@ApiField("channel")
	private PosterChannel channel;

	public void setChannel(PosterChannel channel) {
		this.channel = channel;
	}

	public PosterChannel getChannel( ) {
		return this.channel;
	}

	public String getApiMethodName() {
		return "taobao.huabao.channel.get";
	}

}
