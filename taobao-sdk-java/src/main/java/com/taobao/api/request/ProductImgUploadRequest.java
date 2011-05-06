package com.taobao.api.request;

import java.util.HashMap;
import java.util.Map;
import java.util.Date;
import com.taobao.api.FileItem;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.TaobaoUploadRequest;

/**
 * TOP API: taobao.product.img.upload request
 * 
 * @author auto create
 * @since 1.0, May 11, 2010
 */
public class ProductImgUploadRequest implements TaobaoUploadRequest {
	private Long timestamp;	
	TaobaoHashMap textParams = new TaobaoHashMap();
	
	
	/** 
	 * 产品图片ID.修改图片时需要传入
	 **/
	private Long id;
	
	/** 
	 * 图片内容.图片最大为500K,只支持JPG,GIF格式.
	 **/
	private FileItem image;
	
	/** 
	 * 是否将该图片设为主图.可选值:true,false;默认值:false.
	 **/
	private Boolean isMajor;
	
	/** 
	 * 图片序号
	 **/
	private Long position;
	
	/** 
	 * 产品ID.Product的id
	 **/
	private Long productId;

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
	public void setPosition(Long position) {
		this.position = position;
	}
	 public Long getPosition() {
		return this.position;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	 public Long getProductId() {
		return this.productId;
	}

	public String getApiMethodName() {
		return "taobao.product.img.upload";
	}

	public Map<String, String> getTextParams() {
		
		textParams.put("id", this.id);
		textParams.put("is_major", this.isMajor);
		textParams.put("position", this.position);
		textParams.put("product_id", this.productId);
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
