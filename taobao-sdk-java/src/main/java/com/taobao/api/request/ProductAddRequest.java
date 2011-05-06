package com.taobao.api.request;

import java.util.HashMap;
import java.util.Map;
import java.util.Date;
import com.taobao.api.FileItem;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.TaobaoUploadRequest;

/**
 * TOP API: taobao.product.add request
 * 
 * @author auto create
 * @since 1.0, May 11, 2010
 */
public class ProductAddRequest implements TaobaoUploadRequest {
	private Long timestamp;	
	TaobaoHashMap textParams = new TaobaoHashMap();
	
	
	/** 
	 * 非关键属性结构:pid:vid;pid:vid.非关键属性不包含关键属性、销售属性、用户自定义属性、商品属性;调用taobao.itemprops.get获取pid,调用taobao.itempropvalues.get获取vid.
	 **/
	private String binds;
	
	/** 
	 * 商品类目ID.调用taobao.itemcats.get获取;注意:必须是叶子类目 id.
	 **/
	private Long cid;
	
	/** 
	 * 用户自定义属性,结构：pid1:value1;pid2:value2 例如：“20000:优衣库”，表示“品牌:优衣库”
	 **/
	private String customerProps;
	
	/** 
	 * 产品描述.最大25000个字节
	 **/
	private String desc;
	
	/** 
	 * 产品主图片.最大1M,目前仅支持GIF,JPG.
	 **/
	private FileItem image;
	
	/** 
	 * 是不是主图
	 **/
	private Boolean major;
	
	/** 
	 * 产品名称,最大60个字节.
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
	 * 产品市场价.精确到2位小数;单位为元.如：200.07
	 **/
	private String price;
	
	/** 
	 * 关键属性 结构:pid:vid;pid:vid.调用taobao.itemprops.get获取pid,调用taobao.itempropvalues.get获取vid;如果碰到用户自定义属性,请用customer_props.
	 **/
	private String props;
	
	/** 
	 * 销售属性结构:pid:vid;pid:vid.调用taobao.itemprops.get获取is_sale_prop＝true的pid,调用taobao.itempropvalues.get获取vid.
	 **/
	private String saleProps;

	public void setBinds(String binds) {
		this.binds = binds;
	}
	 public String getBinds() {
		return this.binds;
	}
	public void setCid(Long cid) {
		this.cid = cid;
	}
	 public Long getCid() {
		return this.cid;
	}
	public void setCustomerProps(String customerProps) {
		this.customerProps = customerProps;
	}
	 public String getCustomerProps() {
		return this.customerProps;
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
	public void setProps(String props) {
		this.props = props;
	}
	 public String getProps() {
		return this.props;
	}
	public void setSaleProps(String saleProps) {
		this.saleProps = saleProps;
	}
	 public String getSaleProps() {
		return this.saleProps;
	}

	public String getApiMethodName() {
		return "taobao.product.add";
	}

	public Map<String, String> getTextParams() {
		
		textParams.put("binds", this.binds);
		textParams.put("cid", this.cid);
		textParams.put("customer_props", this.customerProps);
		textParams.put("desc", this.desc);
		textParams.put("major", this.major);
		textParams.put("name", this.name);
		textParams.put("native_unkeyprops", this.nativeUnkeyprops);
		textParams.put("outer_id", this.outerId);
		textParams.put("price", this.price);
		textParams.put("props", this.props);
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
