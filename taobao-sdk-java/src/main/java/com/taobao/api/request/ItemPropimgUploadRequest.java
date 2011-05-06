package com.taobao.api.request;

import java.util.HashMap;
import java.util.Map;
import java.util.Date;
import com.taobao.api.FileItem;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.TaobaoUploadRequest;

/**
 * TOP API: taobao.item.propimg.upload request
 * 
 * @author auto create
 * @since 1.0, May 11, 2010
 */
public class ItemPropimgUploadRequest implements TaobaoUploadRequest {
	private Long timestamp;	
	TaobaoHashMap textParams = new TaobaoHashMap();
	
	
	/** 
	 * 属性图片ID。如果是新增不需要填写
	 **/
	private Long id;
	
	/** 
	 * 属性图片内容。类型:JPG,GIF;最大长度:500K;图片大小不超过:1M
	 **/
	private FileItem image;
	
	/** 
	 * 商品数字ID，必选
	 **/
	private Long numIid;
	
	/** 
	 * 图片位置
	 **/
	private Long position;
	
	/** 
	 * 属性列表。调用taobao.itemprops.get获取类目属性，属性必须是颜色属性，再用taobao.itempropvalues.get取得vid。格式:pid:vid。
	 **/
	private String properties;

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
	public void setProperties(String properties) {
		this.properties = properties;
	}
	 public String getProperties() {
		return this.properties;
	}

	public String getApiMethodName() {
		return "taobao.item.propimg.upload";
	}

	public Map<String, String> getTextParams() {
		
		textParams.put("id", this.id);
		textParams.put("num_iid", this.numIid);
		textParams.put("position", this.position);
		textParams.put("properties", this.properties);
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
