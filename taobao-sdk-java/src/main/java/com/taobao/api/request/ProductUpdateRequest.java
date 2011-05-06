package com.taobao.api.request;

import java.util.HashMap;
import java.util.Map;
import java.util.Date;
import com.taobao.api.FileItem;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.TaobaoUploadRequest;

/**
 * TOP API: taobao.product.update request
 * 
 * @author auto create
 * @since 1.0, May 11, 2010
 */
public class ProductUpdateRequest implements TaobaoUploadRequest {
	private Long timestamp;	
	TaobaoHashMap textParams = new TaobaoHashMap();
	
	
	/** 
	 * 非关键属性.调用taobao.itemprops.get获取pid,调用taobao.itempropvalues.get获取vid;格式:pid:vid;pid:vid
	 **/
	private String binds;
	
	/** 
	 * 产品描述.最大25000个字节
	 **/
	private String desc;
	
	/** 
	 * 产品主图.最大500K,目前仅支持GIF,JPG
	 **/
	private FileItem image;
	
	/** 
	 * 是否是主图
	 **/
	private Boolean major;
	
	/** 
	 * 产品名称.最大60个字节
	 **/
	private String name;
	
	/** 
	 * 自定义非关键属性
	 **/
	private String nativeUnkeyprops;
	
	/** 
	 * 外部产品ID
	 **/
	private String outerId;
	
	/** 
	 * 产品市场价.精确到2位小数;单位为元.如:200.07
	 **/
	private String price;
	
	/** 
	 * 产品ID
	 **/
	private Long productId;
	
	/** 
	 * 销售属性.调用taobao.itemprops.get获取pid,调用taobao.itempropvalues.get获取vid;格式:pid:vid;pid:vid
	 **/
	private String saleProps;

	public void setBinds(String binds) {
		this.binds = binds;
	}
	 public String getBinds() {
		return this.binds;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	 public String getDesc() {
		return this.desc;
	}
	public void setImage(FileItem image) {
		this.image = image;
	}
	 public FileItem getImage() {
		return this.image;
	}
	public void setMajor(Boolean major) {
		this.major = major;
	}
	 public Boolean getMajor() {
		return this.major;
	}
	public void setName(String name) {
		this.name = name;
	}
	 public String getName() {
		return this.name;
	}
	public void setNativeUnkeyprops(String nativeUnkeyprops) {
		this.nativeUnkeyprops = nativeUnkeyprops;
	}
	 public String getNativeUnkeyprops() {
		return this.nativeUnkeyprops;
	}
	public void setOuterId(String outerId) {
		this.outerId = outerId;
	}
	 public String getOuterId() {
		return this.outerId;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	 public String getPrice() {
		return this.price;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	 public Long getProductId() {
		return this.productId;
	}
	public void setSaleProps(String saleProps) {
		this.saleProps = saleProps;
	}
	 public String getSaleProps() {
		return this.saleProps;
	}

	public String getApiMethodName() {
		return "taobao.product.update";
	}

	public Map<String, String> getTextParams() {
		
		textParams.put("binds", this.binds);
		textParams.put("desc", this.desc);
		textParams.put("major", this.major);
		textParams.put("name", this.name);
		textParams.put("native_unkeyprops", this.nativeUnkeyprops);
		textParams.put("outer_id", this.outerId);
		textParams.put("price", this.price);
		textParams.put("product_id", this.productId);
		textParams.put("sale_props", this.saleProps);
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
