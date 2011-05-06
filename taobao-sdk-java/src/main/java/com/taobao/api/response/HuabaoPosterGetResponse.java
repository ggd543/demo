package com.taobao.api.response;

import java.util.List;
import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.internal.mapping.ApiListField;
import com.taobao.api.domain.PosterPicture;
import com.taobao.api.domain.Poster;


import com.taobao.api.TaobaoResponse;

/**
 * TOP API: taobao.huabao.poster.get response
 * 
 * @author auto create
 * @since 1.0,2010-11-26 09:49:05.0
 */
public class HuabaoPosterGetResponse extends TaobaoResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6645989749591941828L;

	
	/** 
	 * 画报图片
	 **/
	@ApiListField("pics")
	@ApiField("poster_picture")
	private List<PosterPicture> pics;
	
	/** 
	 * 画报信息
	 **/
	@ApiField("poster")
	private Poster poster;

	public void setPics(List<PosterPicture> pics) {
		this.pics = pics;
	}

	public List<PosterPicture> getPics( ) {
		return this.pics;
	}
	public void setPoster(Poster poster) {
		this.poster = poster;
	}

	public Poster getPoster( ) {
		return this.poster;
	}

	public String getApiMethodName() {
		return "taobao.huabao.poster.get";
	}

}
