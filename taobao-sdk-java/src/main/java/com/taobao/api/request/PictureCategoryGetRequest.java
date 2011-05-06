package com.taobao.api.request;

import java.util.Map;
import java.util.Date;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.TaobaoRequest;

/**
 * TOP API: taobao.picture.category.get request
 * 
 * @author auto create
 * @since 1.0, 2010-11-23 17:07:42.0
 */
public class PictureCategoryGetRequest implements TaobaoRequest {
	private Long timestamp;	
	private TaobaoHashMap textParams = new TaobaoHashMap();


	
	/** 
	 * 需要返回的字段,根据PictureCategory中的以下字段：picture_category_id,picture_category_name,position,type,total,created,modified ,多个字段用“,”分隔。如：type,total,created,modified
	 **/
	private String fields;
	
	/** 
	 * 图片分类ID
	 **/
	private Long pictureCategoryId;
	
	/** 
	 * 图片分类名，不支持模糊查询
	 **/
	private String pictureCategoryName;
	
	/** 
	 * 分类类型,fixed代表店铺装修分类类别，auction代表宝贝分类类别，user-define代表用户自定义分类类别
	 **/
	private String type;

	public void setFields(String fields) {
		this.fields = fields;
	}
	 public String getFields() {
		return this.fields;
	}
	public void setPictureCategoryId(Long pictureCategoryId) {
		this.pictureCategoryId = pictureCategoryId;
	}
	 public Long getPictureCategoryId() {
		return this.pictureCategoryId;
	}
	public void setPictureCategoryName(String pictureCategoryName) {
		this.pictureCategoryName = pictureCategoryName;
	}
	 public String getPictureCategoryName() {
		return this.pictureCategoryName;
	}
	public void setType(String type) {
		this.type = type;
	}
	 public String getType() {
		return this.type;
	}
	
	public String getApiMethodName() {
		return "taobao.picture.category.get";
	}

	public Map<String, String> getTextParams() {		
		textParams.put("fields", this.fields);
		textParams.put("picture_category_id", this.pictureCategoryId);
		textParams.put("picture_category_name", this.pictureCategoryName);
		textParams.put("type", this.type);
		return textParams;
	}
	
	public Long getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
}
