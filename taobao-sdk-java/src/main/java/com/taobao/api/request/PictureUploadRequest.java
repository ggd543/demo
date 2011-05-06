package com.taobao.api.request;

import java.util.HashMap;
import java.util.Map;
import java.util.Date;
import com.taobao.api.FileItem;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.TaobaoUploadRequest;

/**
 * TOP API: taobao.picture.upload request
 * 
 * @author auto create
 * @since 1.0, May 11, 2010
 */
public class PictureUploadRequest implements TaobaoUploadRequest {
	private Long timestamp;	
	TaobaoHashMap textParams = new TaobaoHashMap();
	
	
	/** 
	 * 包括后缀名的图片标题,不能为空，如Bule.jpg,有些卖家希望图片上传后取图片文件的默认名
	 **/
	private String imageInputTitle;
	
	/** 
	 * 图片二进制文件流,不能为空,允许png、jpg、gif图片格式
	 **/
	private FileItem img;
	
	/** 
	 * 图片分类ID，具体某个分类ID或0上传到未分类下，只能一个分类
	 **/
	private Long pictureCategoryId;
	
	/** 
	 * 图片标题,如果为空,传的图片标题就取去掉后缀名的image_input_title,超过50字符长度会截取50字符,重名会在标题末尾加"(1)";标题末尾已经有"(数字)"了，则数字加1
	 **/
	private String title;

	public void setImageInputTitle(String imageInputTitle) {
		this.imageInputTitle = imageInputTitle;
	}
	 public String getImageInputTitle() {
		return this.imageInputTitle;
	}
	public void setImg(FileItem img) {
		this.img = img;
	}
	 public FileItem getImg() {
		return this.img;
	}
	public void setPictureCategoryId(Long pictureCategoryId) {
		this.pictureCategoryId = pictureCategoryId;
	}
	 public Long getPictureCategoryId() {
		return this.pictureCategoryId;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	 public String getTitle() {
		return this.title;
	}

	public String getApiMethodName() {
		return "taobao.picture.upload";
	}

	public Map<String, String> getTextParams() {
		
		textParams.put("image_input_title", this.imageInputTitle);
		textParams.put("picture_category_id", this.pictureCategoryId);
		textParams.put("title", this.title);
		return textParams;
	}

	public Map<String, FileItem> getFileParams() {
		Map<String, FileItem> params = new HashMap<String, FileItem>();
		params.put("img", this.img);
		return params;
	}
	
	public Long getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
}
