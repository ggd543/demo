package com.taobao.api.response;

import java.util.List;
import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.internal.mapping.ApiListField;
import com.taobao.api.domain.Picture;


import com.taobao.api.TaobaoResponse;

/**
 * TOP API: taobao.picture.get response
 * 
 * @author auto create
 * @since 1.0,2010-08-12 21:28:12.0
 */
public class PictureGetResponse extends TaobaoResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7567832795525321692L;

	
	/** 
	 * 图片信息列表
	 **/
	@ApiListField("picture")
	@ApiField("picture")
	private List<Picture> picture;
	
	/** 
	 * 总的结果数
	 **/
	@ApiField("totalResults")
	private Long totalResults;

	public void setPicture(List<Picture> picture) {
		this.picture = picture;
	}

	public List<Picture> getPicture( ) {
		return this.picture;
	}
	public void setTotalResults(Long totalResults) {
		this.totalResults = totalResults;
	}

	public Long getTotalResults( ) {
		return this.totalResults;
	}

	public String getApiMethodName() {
		return "taobao.picture.get";
	}

}
