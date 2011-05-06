package com.taobao.api.request;

import java.util.HashMap;
import java.util.Map;
import java.util.Date;
import com.taobao.api.FileItem;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.TaobaoUploadRequest;

/**
 * TOP API: taobao.product.propimg.upload request
 * 
 * @author auto create
 * @since 1.0, May 11, 2010
 */
public class ProductPropimgUploadRequest implements TaobaoUploadRequest {
	private Long timestamp;	
	TaobaoHashMap textParams = new TaobaoHashMap();
	
	
	/** 
	 * 产品属性图片ID
	 **/
	private Long id;
	
	/** 
	 * 图片内容.图片最大为2M,只支持JPG,GIF.
	 **/
	private FileItem image;
	
	/** 
	 * 图片序号
	 **/
	private Long position;
	
	/** 
	 * 产品ID.Product的id
	 **/
	private Long productId;
	
	/** 
	 * 属性串.目前仅支持颜色属性.调用taobao.itemprops.get获取类目属性,取得颜色属性pid,再用taobao.itempropvalues.get取得vid;格式:pid:vid,只能传入一个颜色pid:vid串;
	 **/
	private String props;

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
	public void setProps(String props) {
		this.props = props;
	}
	 public String getProps() {
		return this.props;
	}

	public String getApiMethodName() {
		return "taobao.product.propimg.upload";
	}

	public Map<String, String> getTextParams() {
		
		textParams.put("id", this.id);
		textParams.put("position", this.position);
		textParams.put("product_id", this.productId);
		textParams.put("props", this.props);
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
