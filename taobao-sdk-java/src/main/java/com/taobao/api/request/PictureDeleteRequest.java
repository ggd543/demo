package com.taobao.api.request;

import java.util.Map;
import java.util.Date;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.TaobaoRequest;

/**
 * TOP API: taobao.picture.delete request
 * 
 * @author auto create
 * @since 1.0, 2010-08-12 20:55:27.0
 */
public class PictureDeleteRequest implements TaobaoRequest {
	private Long timestamp;	
	private TaobaoHashMap textParams = new TaobaoHashMap();


	
	/** 
	 * 图片ID字符串,可以一个也可以一组,用英文逗号间隔,如450,120,155
	 **/
	private String pictureIds;

	public void setPictureIds(String pictureIds) {
		this.pictureIds = pictureIds;
	}
	 public String getPictureIds() {
		return this.pictureIds;
	}
	
	public String getApiMethodName() {
		return "taobao.picture.delete";
	}

	public Map<String, String> getTextParams() {		
		textParams.put("picture_ids", this.pictureIds);
		return textParams;
	}
	
	public Long getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
}
