package com.taobao.api.domain;

import com.taobao.api.internal.mapping.ApiClass;
import com.taobao.api.internal.mapping.ApiField;


import com.taobao.api.TaobaoObject;

/**
 * Media Data Structure.
 * 
 * DESC：多媒体列表 
 *
 * @author auto create
 * @since 1.0, 2010-04-26 17:20:05.0
 */
@ApiClass("Media")
public class Media extends TaobaoObject {

	private static final long serialVersionUID = 3285486981938589452L;

	
	/** 
	 * media的url
	 **/
	@ApiField("media")
	private String media;

	
	/** 
	 * media_desc描述
	 **/
	@ApiField("media_desc")
	private String mediaDesc;

	
	/** 
	 * media_link
	 **/
	@ApiField("media_link")
	private String mediaLink;

	
	/** 
	 * 多媒体名称
	 **/
	@ApiField("media_name")
	private String mediaName;

	
	/** 
	 * media_type
	 **/
	@ApiField("media_type")
	private Long mediaType;

	public String getMedia() {
		return this.media;
	}
	public void setMedia(String media) {
		this.media = media;
	}

	public String getMediaDesc() {
		return this.mediaDesc;
	}
	public void setMediaDesc(String mediaDesc) {
		this.mediaDesc = mediaDesc;
	}

	public String getMediaLink() {
		return this.mediaLink;
	}
	public void setMediaLink(String mediaLink) {
		this.mediaLink = mediaLink;
	}

	public String getMediaName() {
		return this.mediaName;
	}
	public void setMediaName(String mediaName) {
		this.mediaName = mediaName;
	}

	public Long getMediaType() {
		return this.mediaType;
	}
	public void setMediaType(Long mediaType) {
		this.mediaType = mediaType;
	}

}
