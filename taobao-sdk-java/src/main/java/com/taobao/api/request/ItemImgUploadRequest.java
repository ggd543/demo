package com.taobao.api.request;

import java.util.HashMap;
import java.util.Map;
import java.util.Date;
import com.taobao.api.FileItem;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.TaobaoUploadRequest;

/**
 * TOP API: taobao.item.img.upload request
 * 
 * @author auto create
 * @since 1.0, May 11, 2010
 */
public class ItemImgUploadRequest implements TaobaoUploadRequest {
	private Long timestamp;	
	TaobaoHashMap textParams = new TaobaoHashMap();
	
	
	/** 
	 * 商品图片id(如果是更新图片，则需要传该参数)
	 **/
	private Long id;
	
	/** 
	 * 商品图片内容(更新图片其他信息时可以不传)。类型:JPG,GIF;大小不超过:1M
	 **/
	private FileItem image;
	
	/** 
	 * 是否将该图片设为主图,可选值:true,false;默认值:false(非主图)
	 **/
	private Boolean isMajor;
	
	/** 
	 * 商品数字ID，该参数必须
	 **/
	private Long numIid;
	
	/** 
	 * 图片序号
	 **/
	private Long position;

	public void setId(Long id) {
		this.id = id;
	}
	 public Long getId() {
		return this.id;
	}
	public void setImage(FileItem image) {
		this.image = image;
	}
	 public FileItem getImage() {
		return this.image;
	}
	public void setIsMajor(Boolean isMajor) {
		this.isMajor = isMajor;
	}
	 public Boolean getIsMajor() {
		return this.isMajor;
	}
	public void setNumIid(Long numIid) {
		this.numIid = numIid;
	}
	 public Long getNumIid() {
		return this.numIid;
	}
	public void setPosition(Long position) {
		this.position = position;
	}
	 public Long getPosition() {
		return this.position;
	}

	public String getApiMethodName() {
		return "taobao.item.img.upload";
	}

	public Map<String, String> getTextParams() {
		
		textParams.put("id", this.id);
		textParams.put("is_major", this.isMajor);
		textParams.put("num_iid", this.numIid);
		textParams.put("position", this.position);
		return textParams;
	}

	public Map<String, FileItem> getFileParams() {
		Map<String, FileItem> params = new HashMap<String, FileItem>();
		params.put("image", this.image);
		return params;
	}
	
	public Long getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
}
