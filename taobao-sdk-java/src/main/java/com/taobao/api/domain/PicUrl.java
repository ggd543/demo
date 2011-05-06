package com.taobao.api.domain;

import com.taobao.api.internal.mapping.ApiClass;
import com.taobao.api.internal.mapping.ApiField;


import com.taobao.api.TaobaoObject;

/**
 * PicUrl Data Structure.
 * 
 * DESC：图片链接 
 *
 * @author auto create
 * @since 1.0, 2010-08-18 10:37:25.0
 */
@ApiClass("PicUrl")
public class PicUrl extends TaobaoObject {

	private static final long serialVersionUID = 4347273421642678193L;

	
	/** 
	 * 图片链接地址
	 **/
	@ApiField("url")
	private String url;

	public String getUrl() {
		return this.url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

}
